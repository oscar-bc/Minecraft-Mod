package com.oscar.oscarmati.objects.items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class DilliumArmorItem extends ArmorItem{

    public DilliumArmorItem(IArmorMaterial material, EquipmentSlotType esq, Properties properties) {
        super(material, esq, properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack){
        return 6000;
    }
}
