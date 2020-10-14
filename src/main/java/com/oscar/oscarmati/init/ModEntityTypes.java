package com.oscar.oscarmati.init;

import com.oscar.oscarmati.OscarMati;
import com.oscar.oscarmati.entities.FirstEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, OscarMati.MOD_ID);

    public static final RegistryObject<EntityType<FirstEntity>> FIRST_ENTITY = ENTITY_TYPES.register("first_entity", () -> EntityType.Builder.<FirstEntity>create(FirstEntity::new, EntityClassification.CREATURE)
            .size(0.9f, 1.3f)
            .build(new ResourceLocation(OscarMati.MOD_ID, "first_entity").toString()));

}
