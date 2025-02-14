package net.droingo.droingomaze.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
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
    private int stillnessTimer = 0; // To track how long the player is still and sneaking

    private PlayerEntity targetPlayer = null;

    public GrieverEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 20;
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
        this.goalSelector.add(1, new WanderAroundGoal(this, 0.5)); // Wanders when not chasing
        this.goalSelector.add(2, new AttackGoal()); // Chases noisy players
    }

    // Method to check if the player is standing on tall grass
    public boolean isHidingInTallGrass(World world, BlockPos pos) {
        return world.getBlockState(pos).isOf(Blocks.TALL_GRASS);
    }

    private class AttackGoal extends Goal {
        private int memoryTimer = 100;
        private int attackCooldown = 20;

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
        public boolean shouldContinue() { // Change from "canContinueToUse()" to "shouldContinue()"
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
            if (targetPlayer == null || targetPlayer.isDead() || targetPlayer.isCreative() || targetPlayer.isSpectator()) {
                // Look for a new target if the current one is gone
                List<PlayerEntity> players = GrieverEntity.this.getWorld().getEntitiesByClass(PlayerEntity.class,
                        new Box(getBlockPos()).expand(16),
                        player -> (player.isSprinting() || !player.isSneaky()) && !player.isCreative() && !player.isSpectator());

                if (!players.isEmpty()) {
                    players.sort((p1, p2) -> Double.compare(GrieverEntity.this.squaredDistanceTo(p1), GrieverEntity.this.squaredDistanceTo(p2)));
                    targetPlayer = players.get(0);
                    angerLevel = 1;
                    memoryTimer = 100;
                } else {
                    // If no players found, stop attacking
                    targetPlayer = null;
                    angerLevel = 0;
                    memoryTimer = 0;
                    return;
                }
            }

            boolean playerMakingNoise = targetPlayer.isSprinting() || !targetPlayer.isSneaky();

            if (playerMakingNoise) {
                memoryTimer = 100;
                angerLevel = Math.min(angerLevel + 1, 5);
            } else {
                memoryTimer--;
            }

            // New logic: Check if the player is holding shift and staying still
            if (targetPlayer.isSneaky() && targetPlayer.getVelocity().lengthSquared() < 0.01) {  // Allow small movement
                if (stillnessTimer < 40) {  // 2 seconds (40 ticks)
                    stillnessTimer++;
                } else {
                    // After 2 seconds of staying still, lose track of the player
                    targetPlayer = null;
                    angerLevel = 0;
                    memoryTimer = 0;
                    stillnessTimer = 0; // Reset the timer
                }
            } else {
                stillnessTimer = 0; // Reset timer if player is moving
            }

            // Check if the player is standing in tall grass (only if targetPlayer is not null)
            if (targetPlayer != null) {
                BlockPos playerPos = targetPlayer.getBlockPos().down();  // Get block below the player
                if (GrieverEntity.this.getWorld().getBlockState(playerPos).getBlock() == Blocks.MOSS_BLOCK) {
                    if (stillnessTimer >= 20) { // If the player has been still for 1 second
                        // If in tall grass, stop the hunt and reset
                        targetPlayer = null;
                        angerLevel = 0;
                        memoryTimer = 0;
                    }
                }
            }

            if (memoryTimer > 0) {
                double speedBoost = Math.min(0.4 + (angerLevel * 0.15), 1.5);
                getNavigation().startMovingTo(targetPlayer, speedBoost);

                if (distanceTo(targetPlayer) < 2.5 && attackCooldown <= 0) {
                    targetPlayer.damage(getDamageSources().mobAttack(GrieverEntity.this), 12.0F);
                    angerLevel = Math.max(angerLevel - 1, 0);
                    attackCooldown = 20;
                    setAttacking(true);
                } else {
                    setAttacking(false);
                }
            } else {
                targetPlayer = null;
                angerLevel = 0;
                memoryTimer = 0;
            }

            if (attackCooldown > 0) {
                attackCooldown--;
            }
        }



    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }

}
