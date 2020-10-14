package com.oscar.oscarmati.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.oscar.oscarmati.OscarMati;
import com.oscar.oscarmati.entities.FirstEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class FirstEntityModel<T extends FirstEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer legs;
	private final ModelRenderer back;
	private final ModelRenderer rightBack;
	private final ModelRenderer leftBack;
	private final ModelRenderer front;
	private final ModelRenderer rightFront;
	private final ModelRenderer leftFront;
	private final ModelRenderer head;
	private final ModelRenderer leftEar;
	private final ModelRenderer rightEar;
	private final ModelRenderer snout;

	public FirstEntityModel() {
		textureWidth = 16;
		textureHeight = 16;

		body = new ModelRenderer(this);
		body.setRotationPoint(1.0F, 16.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-8.0F, -6.0F, -6.0F, 14.0F, 8.0F, 14.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 8.0F, 0.0F);
		body.addChild(legs);


		back = new ModelRenderer(this);
		back.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(back);


		rightBack = new ModelRenderer(this);
		rightBack.setRotationPoint(0.0F, -8.0F, 0.0F);
		back.addChild(rightBack);
		rightBack.setTextureOffset(32, 32).addBox(4.0F, -3.0F, -5.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		leftBack = new ModelRenderer(this);
		leftBack.setRotationPoint(0.0F, -8.0F, 0.0F);
		back.addChild(leftBack);
		leftBack.setTextureOffset(26, 26).addBox(4.0F, -3.0F, 5.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		front = new ModelRenderer(this);
		front.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(front);


		rightFront = new ModelRenderer(this);
		rightFront.setRotationPoint(0.0F, -8.0F, 0.0F);
		front.addChild(rightFront);
		rightFront.setTextureOffset(6, 6).addBox(-8.0F, -3.0F, -5.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		leftFront = new ModelRenderer(this);
		leftFront.setRotationPoint(0.0F, -8.0F, 0.0F);
		front.addChild(leftFront);
		leftFront.setTextureOffset(0, 0).addBox(-8.0F, -3.0F, 5.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 8.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 22).addBox(-4.0F, -19.0F, -11.0F, 6.0F, 8.0F, 8.0F, 0.0F, false);

		leftEar = new ModelRenderer(this);
		leftEar.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(leftEar);
		leftEar.setTextureOffset(0, 0).addBox(0.0F, -25.0F, -4.0F, 2.0F, 14.0F, 1.0F, 0.0F, false);

		rightEar = new ModelRenderer(this);
		rightEar.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(rightEar);
		rightEar.setTextureOffset(0, 0).addBox(-4.0F, -25.0F, -4.0F, 2.0F, 14.0F, 1.0F, 0.0F, false);

		snout = new ModelRenderer(this);
		snout.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(snout);
		snout.setTextureOffset(0, 0).addBox(-3.0F, -15.0F, -14.0F, 4.0F, 3.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
								  float netHeadYaw, float headPitch) {
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		//this.Body.rotateAngleZ = ((float)Math.PI / 2F);
		this.rightBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
		this.leftBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount;
		this.rightFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount;
		this.leftFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

    public ModelRenderer getBack() {
        return back;
    }

    public ModelRenderer getBody() {
        return body;
    }

    public ModelRenderer getFront() {
        return front;
    }

    public ModelRenderer getHead() {
        return head;
    }

    public ModelRenderer getLeftBack() {
        return leftBack;
    }

    public ModelRenderer getLeftFront() {
        return leftFront;
    }

    public ModelRenderer getLegs() {
        return legs;
    }

    public ModelRenderer getRightBack() {
        return rightBack;
    }

    public ModelRenderer getRightFront() {
        return rightFront;
    }
}