package com.oscar.oscarmati.objects.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class DilliumStaffItem extends SwordItem {

    public DilliumStaffItem(IItemTier tier, int integer, float floatyboi, Properties properties) {
        super(tier, integer, floatyboi, properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        LightningBoltEntity entity = new LightningBoltEntity(worldIn, raytraceresult.getHitVec().x, raytraceresult.getHitVec().y, raytraceresult.getHitVec().z, false);
        worldIn.addEntity(entity);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean hasEffect(ItemStack stack){
        return true;
    }
}
