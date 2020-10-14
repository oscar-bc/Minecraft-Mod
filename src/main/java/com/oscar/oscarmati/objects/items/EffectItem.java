package com.oscar.oscarmati.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EffectItem extends Item {

    public EffectItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack){
        return true;
    }
}
