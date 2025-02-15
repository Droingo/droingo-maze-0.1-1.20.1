package net.droingo.droingomaze.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GrieverEntity extends HostileEntity {
    private int angerLevel = 0;
    private int stillnessTimer = 0;
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(GrieverEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public int attackAnimationTimeout = 0;
    public int attackAnimationTimer = 0;

    private PlayerEntity targetPlayer = null;

    public GrieverEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 20;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    public static DefaultAttributeContainer.Builder createGrieverAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new WanderAroundGoal(this, 0.5));
        this.goalSelector.add(2, new AttackGoal());
    }

    private class AttackGoal extends Goal {
        private int memoryTimer = 100;
        private int attackCooldown = 20;
        private int stillnessTimer = 0; // To track how long the player is still

        @Override
        public boolean canStart() {
            List<PlayerEntity> players = GrieverEntity.this.getWorld().getEntitiesByClass(PlayerEntity.class,
                    new Box(getBlockPos()).expand(25),
                    player -> (player.isSprinting() || !player.isSneaky()) && !player.isCreative() && !player.isSpectator());

            if (!players.isEmpty()) {
                players.sort((p1, p2) -> Double.compare(GrieverEntity.this.squaredDistanceTo(p1), GrieverEntity.this.squaredDistanceTo(p2)));
                targetPlayer = players.get(0);
                if (targetPlayer != null) {
                    angerLevel = Math.min(angerLevel + 1, 5);
                    memoryTimer = 100;
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean shouldContinue() {
            return targetPlayer != null && memoryTimer > 0 && !targetPlayer.isCreative() && !targetPlayer.isSpectator();
        }

        @Override
        public void start() {
            if (targetPlayer != null) {
                playSound(SoundEvents.ENTITY_WARDEN_AGITATED, 1.0F, 1.0F);
            }
        }


        @Override
        public void tick() {
            if (targetPlayer == null || targetPlayer.isDead()) {
                resetTarget();
                return;
            }

            boolean playerMakingNoise = targetPlayer.isSprinting() || !targetPlayer.isSneaky();

            if (playerMakingNoise) {
                memoryTimer = 100;
                angerLevel = Math.min(angerLevel + 1, 5);
            } else {
                memoryTimer--;
            }

            // **Lose Griever if crouching and staying still for 2 seconds**
            if (targetPlayer.isSneaky() && targetPlayer.getVelocity().lengthSquared() < 0.01) {
                if (stillnessTimer < 40) { // 2 seconds (40 ticks)
                    stillnessTimer++;
                } else {
                    resetTarget();
                    return;
                }
            } else {
                stillnessTimer = 0;
            }

            // **Lose Griever if standing still on moss block for 1 second**
            BlockPos playerPos = targetPlayer.getBlockPos().down();
            if (GrieverEntity.this.getWorld().getBlockState(playerPos).getBlock() == Blocks.MOSS_BLOCK) {
                if (stillnessTimer >= 20) {
                    resetTarget();
                    return;
                }
            }

            // **Move Toward Target**
            double speedBoost = Math.min(0.4 + (angerLevel * 0.15), 1.5);
            GrieverEntity.this.getNavigation().startMovingTo(targetPlayer, speedBoost);

            // **Attack if close enough**
            if (GrieverEntity.this.distanceTo(targetPlayer) < 2.5 && attackCooldown <= 0) {
                attackAnimationState.start(GrieverEntity.this.age);
                targetPlayer.damage(getDamageSources().mobAttack(GrieverEntity.this), 12.0F);
                angerLevel = Math.max(angerLevel - 1, 0);
                attackCooldown = 20;
                setAttacking(true);
            } else {
                setAttacking(false);
            }

            if (attackAnimationTimer > 0) {
                attackAnimationTimer--;
            } else {
                setAttacking(false);
            }



            if (attackCooldown > 0) {
                attackCooldown--;
            }
        }

        private void resetTarget() {
            targetPlayer = null;
            angerLevel = 0;
            memoryTimer = 0;
            stillnessTimer = 0;
            attackAnimationState.stop(); // **Stops attack animation when target is lost**
            setAttacking(false);
        }
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }
}
