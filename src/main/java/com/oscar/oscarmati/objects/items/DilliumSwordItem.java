package com.oscar.oscarmati.objects.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class DilliumSwordItem extends SwordItem {

    public DilliumSwordItem(IItemTier tier, int integer, float floatyboi, Properties properties) {
        super(tier, integer, floatyboi, properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){
        playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 500, 2));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

}
