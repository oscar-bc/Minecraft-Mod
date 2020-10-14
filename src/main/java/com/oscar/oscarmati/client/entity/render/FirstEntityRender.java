package com.oscar.oscarmati.client.entity.render;

import com.oscar.oscarmati.OscarMati;
import com.oscar.oscarmati.client.entity.model.FirstEntityModel;
import com.oscar.oscarmati.entities.FirstEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FirstEntityRender extends MobRenderer<FirstEntity, FirstEntityModel<FirstEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(OscarMati.MOD_ID,
            "textures/entity/first_entity.png");

    public FirstEntityRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FirstEntityModel<FirstEntity>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(FirstEntity entity) {
        return TEXTURE;
    }
}
