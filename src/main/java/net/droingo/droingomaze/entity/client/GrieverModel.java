// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.droingo.droingomaze.entity.client;

import net.droingo.droingomaze.entity.animation.ModAnimations;
import net.droingo.droingomaze.entity.custom.GrieverEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class GrieverModel<T extends GrieverEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Griever;
	private final ModelPart Head;

	public GrieverModel(ModelPart root) {
		this.Griever = root.getChild("Griever");
		this.Head = Griever.getChild("Torso").getChild("Head");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Griever = modelPartData.addChild("Griever", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

		ModelPartData Torso = Griever.addChild("Torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -16.0F, 0.0F));

		ModelPartData cube_r1 = Torso.addChild("cube_r1", ModelPartBuilder.create().uv(62, 200).cuboid(0.0F, -12.0F, -3.0F, 3.0F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, 8.0F, -28.0F, -1.9013F, -0.4294F, 0.0263F));

		ModelPartData cube_r2 = Torso.addChild("cube_r2", ModelPartBuilder.create().uv(114, 150).cuboid(-3.0F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-9.3F, 6.0F, -27.0F, 2.8111F, 0.4294F, -0.0263F));

		ModelPartData cube_r3 = Torso.addChild("cube_r3", ModelPartBuilder.create().uv(112, 199).cuboid(-3.0F, -12.0F, -3.0F, 3.0F, 12.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, 8.0F, -28.0F, -1.9013F, 0.4294F, -0.0263F));

		ModelPartData cube_r4 = Torso.addChild("cube_r4", ModelPartBuilder.create().uv(128, 185).cuboid(-1.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, 12.0F, -16.0F, -0.2164F, 0.0283F, 0.1278F));

		ModelPartData cube_r5 = Torso.addChild("cube_r5", ModelPartBuilder.create().uv(136, 32).cuboid(1.0F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(9.3F, 6.0F, -27.0F, 2.8111F, -0.4294F, 0.0263F));

		ModelPartData cube_r6 = Torso.addChild("cube_r6", ModelPartBuilder.create().uv(182, 184).cuboid(-1.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, 12.0F, -16.0F, -0.2164F, -0.0283F, -0.1278F));

		ModelPartData cube_r7 = Torso.addChild("cube_r7", ModelPartBuilder.create().uv(0, 89).cuboid(-8.0F, -15.0F, -6.0F, 17.0F, 12.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 24.0F, -0.48F, 0.0F, 0.0F));

		ModelPartData cube_r8 = Torso.addChild("cube_r8", ModelPartBuilder.create().uv(0, 46).cuboid(-10.0F, -19.0F, -14.0F, 21.0F, 15.0F, 28.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 10.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData cube_r9 = Torso.addChild("cube_r9", ModelPartBuilder.create().uv(102, 0).cuboid(0.0F, -12.0F, -15.0F, 0.0F, 8.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -15.0F, -8.0F, 0.2528F, -0.1733F, 0.5888F));

		ModelPartData cube_r10 = Torso.addChild("cube_r10", ModelPartBuilder.create().uv(0, 121).cuboid(0.0F, -12.0F, -15.0F, 0.0F, 8.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -13.0F, 16.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData cube_r11 = Torso.addChild("cube_r11", ModelPartBuilder.create().uv(98, 46).cuboid(0.0F, -12.0F, -15.0F, 0.0F, 8.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -15.0F, -8.0F, 0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r12 = Torso.addChild("cube_r12", ModelPartBuilder.create().uv(0, 0).cuboid(-12.0F, -20.0F, -11.0F, 25.0F, 20.0F, 26.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -8.0F, 0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r13 = Torso.addChild("cube_r13", ModelPartBuilder.create().uv(74, 118).cuboid(0.0F, -12.0F, -15.0F, 0.0F, 8.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -15.0F, -8.0F, 0.2528F, 0.1733F, -0.5888F));

		ModelPartData Head = Torso.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, -19.4F));

		ModelPartData cube_r14 = Head.addChild("cube_r14", ModelPartBuilder.create().uv(102, 32).cuboid(-6.0F, -5.0F, -3.0F, 12.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.6F, -7.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData cube_r15 = Head.addChild("cube_r15", ModelPartBuilder.create().uv(74, 89).cuboid(-8.0F, -8.0F, -7.0F, 16.0F, 15.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.6F, 1.0F, 0.1745F, 0.0F, 0.0F));

		ModelPartData Jaw = Head.addChild("Jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, -5.0F));

		ModelPartData cube_r16 = Jaw.addChild("cube_r16", ModelPartBuilder.create().uv(98, 78).cuboid(-5.0F, -1.0F, -5.0F, 10.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -0.2F, 0.1745F, 0.0F, 0.0F));

		ModelPartData Tail = Torso.addChild("Tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 40.0F));

		ModelPartData cube_r17 = Tail.addChild("cube_r17", ModelPartBuilder.create().uv(184, 117).cuboid(-1.0F, -7.0F, -1.0F, 4.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -45.9F, -23.4F, -2.8798F, 0.0F, 0.0F));

		ModelPartData cube_r18 = Tail.addChild("cube_r18", ModelPartBuilder.create().uv(184, 104).cuboid(-1.0F, -7.0F, -1.0F, 4.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -48.9F, -16.0F, -2.7489F, 0.0F, 0.0F));

		ModelPartData cube_r19 = Tail.addChild("cube_r19", ModelPartBuilder.create().uv(184, 89).cuboid(-1.0F, -7.0F, -1.0F, 4.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.2F, -5.4F, -2.8798F, 0.0F, 0.0F));

		ModelPartData cube_r20 = Tail.addChild("cube_r20", ModelPartBuilder.create().uv(184, 74).cuboid(-1.0F, -7.0F, -1.0F, 4.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -52.2F, 6.6F, 3.098F, 0.0F, 0.0F));

		ModelPartData cube_r21 = Tail.addChild("cube_r21", ModelPartBuilder.create().uv(162, 35).cuboid(-2.0F, -7.0F, -1.0F, 5.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -47.2F, 18.5F, 2.6616F, 0.0F, 0.0F));

		ModelPartData cube_r22 = Tail.addChild("cube_r22", ModelPartBuilder.create().uv(162, 18).cuboid(-3.0F, -7.0F, -1.0F, 7.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -37.5F, 27.0F, 2.2253F, 0.0F, 0.0F));

		ModelPartData cube_r23 = Tail.addChild("cube_r23", ModelPartBuilder.create().uv(162, 0).cuboid(-3.0F, -7.0F, -1.0F, 7.0F, 8.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -25.9F, 31.3F, 1.8762F, 0.0F, 0.0F));

		ModelPartData cube_r24 = Tail.addChild("cube_r24", ModelPartBuilder.create().uv(150, 150).cuboid(-4.0F, -7.0F, -1.0F, 9.0F, 9.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -13.5F, 30.7F, 1.4399F, 0.0F, 0.0F));

		ModelPartData cube_r25 = Tail.addChild("cube_r25", ModelPartBuilder.create().uv(150, 131).cuboid(-4.0F, -7.0F, -1.0F, 9.0F, 9.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.9F, 23.7F, 0.9163F, 0.0F, 0.0F));

		ModelPartData cube_r26 = Tail.addChild("cube_r26", ModelPartBuilder.create().uv(198, 194).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.4F, -41.05F, -23.7F, 0.4363F, 0.0F, 0.0F));

		ModelPartData cube_r27 = Tail.addChild("cube_r27", ModelPartBuilder.create().uv(198, 184).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.4F, -43.8F, -16.7F, 0.48F, 0.0F, 0.0F));

		ModelPartData cube_r28 = Tail.addChild("cube_r28", ModelPartBuilder.create().uv(196, 20).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.4F, -48.3F, -5.7F, 0.1309F, 0.0F, 0.0F));

		ModelPartData cube_r29 = Tail.addChild("cube_r29", ModelPartBuilder.create().uv(196, 10).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.4F, -48.9F, 5.3F, -0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r30 = Tail.addChild("cube_r30", ModelPartBuilder.create().uv(196, 0).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -44.8F, 16.3F, -0.6545F, 0.0F, 0.0F));

		ModelPartData cube_r31 = Tail.addChild("cube_r31", ModelPartBuilder.create().uv(0, 177).cuboid(-2.0F, -2.0F, -1.0F, 5.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -37.3F, 23.3F, -1.0036F, 0.0F, 0.0F));

		ModelPartData cube_r32 = Tail.addChild("cube_r32", ModelPartBuilder.create().uv(192, 35).cuboid(-2.0F, -2.0F, 3.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -17.3F, 28.7F, 1.6581F, 0.0F, 0.0F));

		ModelPartData cube_r33 = Tail.addChild("cube_r33", ModelPartBuilder.create().uv(0, 192).cuboid(-2.0F, -2.0F, 1.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.3F, 25.7F, 1.0036F, 0.0F, 0.0F));

		ModelPartData cube_r34 = Tail.addChild("cube_r34", ModelPartBuilder.create().uv(180, 169).cuboid(-2.0F, -2.0F, -1.0F, 5.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.8F, 15.6F, 0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r35 = Tail.addChild("cube_r35", ModelPartBuilder.create().uv(150, 169).cuboid(-2.0F, -2.0F, -1.0F, 5.0F, 5.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.7F, 5.7F, 0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r36 = Tail.addChild("cube_r36", ModelPartBuilder.create().uv(72, 150).cuboid(-5.0F, -7.0F, -1.0F, 11.0F, 9.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.7F, 11.7F, 0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r37 = Tail.addChild("cube_r37", ModelPartBuilder.create().uv(146, 54).cuboid(-5.0F, -7.0F, -1.0F, 11.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -0.9F, -0.1309F, 0.0F, 0.0F));

		ModelPartData Stinger = Tail.addChild("Stinger", ModelPartBuilder.create(), ModelTransform.pivot(0.8F, -39.0F, -30.0F));

		ModelPartData cube_r38 = Stinger.addChild("cube_r38", ModelPartBuilder.create().uv(154, 122).cuboid(-2.0F, -5.0F, -1.0F, 6.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.8F, 1.1F, 0.1F, 0.0873F, 0.0F, 0.0F));

		ModelPartData Arm1 = Stinger.addChild("Arm1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r39 = Arm1.addChild("cube_r39", ModelPartBuilder.create().uv(0, 153).cuboid(1.0F, -9.0F, -14.0F, 0.0F, 9.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(-0.8F, -1.0F, -2.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData Arm2 = Stinger.addChild("Arm2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r40 = Arm2.addChild("cube_r40", ModelPartBuilder.create().uv(154, 74).cuboid(1.0F, -9.0F, -14.0F, 0.0F, 9.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, -0.1F, -2.0F, -0.0295F, -0.0322F, 2.313F));

		ModelPartData Arm3 = Stinger.addChild("Arm3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r41 = Arm3.addChild("cube_r41", ModelPartBuilder.create().uv(154, 98).cuboid(1.0F, -9.0F, -14.0F, 0.0F, 9.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 1.5F, -2.0F, -0.0295F, 0.0322F, -2.313F));

		ModelPartData Legs = Griever.addChild("Legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData FrontLeft = Legs.addChild("FrontLeft", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData HipFR = FrontLeft.addChild("HipFR", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, -13.0F, -10.0F));

		ModelPartData cube_r42 = HipFR.addChild("cube_r42", ModelPartBuilder.create().uv(188, 51).cuboid(-1.0F, -11.0F, 0.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 2.5744F, -0.6545F, 0.0F));

		ModelPartData KneeFR = HipFR.addChild("KneeFR", ModelPartBuilder.create(), ModelTransform.pivot(3.7548F, 10.0F, -4.4135F));

		ModelPartData cube_r43 = KneeFR.addChild("cube_r43", ModelPartBuilder.create().uv(112, 171).cuboid(-1.0F, -24.0F, 0.0F, 4.0F, 24.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.0548F, 1.0F, -1.7865F, 0.829F, -0.3927F, 0.0F));

		ModelPartData AnkleFR = KneeFR.addChild("AnkleFR", ModelPartBuilder.create(), ModelTransform.pivot(-11.7548F, 3.0F, 14.4135F));

		ModelPartData cube_r44 = AnkleFR.addChild("cube_r44", ModelPartBuilder.create().uv(88, 169).cuboid(-1.0F, -31.0F, 0.0F, 3.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(18.3F, -20.0F, -30.5F, 2.9671F, -0.3927F, 0.0F));

		ModelPartData FrontRight = Legs.addChild("FrontRight", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData HipFL = FrontRight.addChild("HipFL", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -16.0F, -10.0F));

		ModelPartData cube_r45 = HipFL.addChild("cube_r45", ModelPartBuilder.create().uv(188, 130).cuboid(-3.0F, -11.0F, 0.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 3.0F, 0.0F, 2.5744F, 0.6545F, 0.0F));

		ModelPartData KneeFL = HipFL.addChild("KneeFL", ModelPartBuilder.create(), ModelTransform.pivot(-5.3643F, 15.0F, -5.2117F));

		ModelPartData cube_r46 = KneeFL.addChild("cube_r46", ModelPartBuilder.create().uv(30, 184).cuboid(-3.0F, -24.0F, 0.0F, 4.0F, 24.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.6643F, -1.0F, -0.9883F, 0.829F, 0.3927F, 0.0F));

		ModelPartData AnkleFL = KneeFL.addChild("AnkleFL", ModelPartBuilder.create(), ModelTransform.pivot(-5.2149F, -18.0F, -18.653F));

		ModelPartData cube_r47 = AnkleFL.addChild("cube_r47", ModelPartBuilder.create().uv(100, 169).cuboid(-2.0F, -31.0F, 0.0F, 3.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.2792F, -1.0F, 3.3646F, 2.9671F, 0.3927F, 0.0F));

		ModelPartData MidRight = Legs.addChild("MidRight", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData HipMR = MidRight.addChild("HipMR", ModelPartBuilder.create(), ModelTransform.pivot(-12.0F, -16.0F, -3.0F));

		ModelPartData cube_r48 = HipMR.addChild("cube_r48", ModelPartBuilder.create().uv(166, 184).cuboid(-3.0F, -16.0F, 0.0F, 4.0F, 16.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -5.0F, 0.0F, 2.5744F, 1.4399F, 0.0F));

		ModelPartData KneeMR = HipMR.addChild("KneeMR", ModelPartBuilder.create(), ModelTransform.pivot(-8.6914F, 7.0F, -0.7236F));

		ModelPartData cube_r49 = KneeMR.addChild("cube_r49", ModelPartBuilder.create().uv(138, 78).cuboid(-3.0F, -49.0F, 0.0F, 4.0F, 49.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.0086F, 1.0F, -1.4764F, 0.3927F, 0.829F, 0.0F));

		ModelPartData AnkleMR = KneeMR.addChild("AnkleMR", ModelPartBuilder.create(), ModelTransform.pivot(20.6914F, 9.0F, 3.7236F));

		ModelPartData cube_r50 = AnkleMR.addChild("cube_r50", ModelPartBuilder.create().uv(48, 121).cuboid(-2.0F, -31.0F, 0.0F, 3.0F, 65.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-37.0F, -20.0F, -19.6F, 2.9671F, 0.829F, 0.0F));

		ModelPartData MidLeft = Legs.addChild("MidLeft", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData HipML = MidLeft.addChild("HipML", ModelPartBuilder.create(), ModelTransform.pivot(13.0F, -17.0F, -2.0F));

		ModelPartData cube_r51 = HipML.addChild("cube_r51", ModelPartBuilder.create().uv(150, 184).cuboid(-1.0F, -16.0F, 0.0F, 4.0F, 16.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -1.0F, 2.5744F, -1.4399F, 0.0F));

		ModelPartData KneeML = HipML.addChild("KneeML", ModelPartBuilder.create(), ModelTransform.pivot(6.9069F, 6.0F, -0.952F));

		ModelPartData cube_r52 = KneeML.addChild("cube_r52", ModelPartBuilder.create().uv(122, 118).cuboid(-1.0F, -49.0F, 0.0F, 4.0F, 49.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.7931F, 3.0F, -2.248F, 0.3927F, -0.829F, 0.0F));

		ModelPartData AnkleML = KneeML.addChild("AnkleML", ModelPartBuilder.create(), ModelTransform.pivot(-19.9069F, 11.0F, 2.952F));

		ModelPartData cube_r53 = AnkleML.addChild("cube_r53", ModelPartBuilder.create().uv(60, 121).cuboid(-1.0F, -31.0F, 0.0F, 3.0F, 65.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(37.0F, -20.0F, -19.6F, 2.9671F, -0.829F, 0.0F));

		ModelPartData BackLeft = Legs.addChild("BackLeft", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData HipBL = BackLeft.addChild("HipBL", ModelPartBuilder.create(), ModelTransform.pivot(12.0F, -18.0F, 4.0F));

		ModelPartData cube_r54 = HipBL.addChild("cube_r54", ModelPartBuilder.create().uv(46, 189).cuboid(-1.0F, -11.0F, 0.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -3.0F, -3.0F, -0.5672F, -0.7854F, 3.1416F));

		ModelPartData KneeBL = HipBL.addChild("KneeBL", ModelPartBuilder.create(), ModelTransform.pivot(2.0328F, 4.0F, 2.0068F));

		ModelPartData cube_r55 = KneeBL.addChild("cube_r55", ModelPartBuilder.create().uv(72, 169).cuboid(-1.0F, -27.0F, 0.0F, 4.0F, 27.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.6672F, 2.0F, 1.5932F, -2.3998F, -0.3491F, 3.1416F));

		ModelPartData AnkleBL = KneeBL.addChild("AnkleBL", ModelPartBuilder.create(), ModelTransform.pivot(-14.0328F, 14.0F, -6.0068F));

		ModelPartData cube_r56 = AnkleBL.addChild("cube_r56", ModelPartBuilder.create().uv(138, 131).cuboid(-1.0F, -41.0F, 0.0F, 3.0F, 51.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(22.0F, -25.0F, 27.4F, -2.0429F, -1.0829F, -1.3258F));

		ModelPartData BackRight = Legs.addChild("BackRight", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData HipBR = BackRight.addChild("HipBR", ModelPartBuilder.create(), ModelTransform.pivot(-11.0F, -17.0F, 3.0F));

		ModelPartData cube_r57 = HipBR.addChild("cube_r57", ModelPartBuilder.create().uv(188, 145).cuboid(-3.0F, -11.0F, 0.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, -2.0F, -0.5672F, 0.7854F, -3.1416F));

		ModelPartData KneeBR = HipBR.addChild("KneeBR", ModelPartBuilder.create(), ModelTransform.pivot(-5.3416F, 2.0F, 5.4232F));

		ModelPartData cube_r58 = KneeBR.addChild("cube_r58", ModelPartBuilder.create().uv(30, 153).cuboid(-3.0F, -27.0F, 0.0F, 4.0F, 27.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.3584F, 3.0F, -0.8232F, -2.3998F, 0.3491F, -3.1416F));

		ModelPartData AnkleBR = KneeBR.addChild("AnkleBR", ModelPartBuilder.create(), ModelTransform.pivot(16.3416F, 15.0F, -8.4232F));

		ModelPartData cube_r59 = AnkleBR.addChild("cube_r59", ModelPartBuilder.create().uv(150, 0).cuboid(-2.0F, -41.0F, 0.0F, 3.0F, 51.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-22.0F, -25.0F, 27.4F, -2.0429F, 1.0829F, 1.3258F));
		return TexturedModelData.of(modelData, 256, 256);
	}


	@Override
	public void setAngles(GrieverEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACK, ageInTicks, 1f);


	}



	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30, 30);
		headPitch = MathHelper.clamp(headPitch, -25, 45);

		this.Head.yaw = headYaw * 0.017453292F;
		this.Head.pitch = headPitch * 0.017453292F;

	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Griever.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Griever;
	}
}