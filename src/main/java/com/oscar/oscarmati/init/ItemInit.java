package com.oscar.oscarmati.init;

import com.oscar.oscarmati.OscarMati;
import com.oscar.oscarmati.objects.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, OscarMati.MOD_ID);

    //minerals
    public static final RegistryObject<Item> DILLIUM = ITEMS.register("dillium", () -> new FuelItem(new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_ORB = ITEMS.register("dillium_orb", () ->new EffectItem(new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> REMITE = ITEMS.register("remite", () -> new Item(new Item.Properties().group(OscarMati.TAB)));
    //ingots
    public static final RegistryObject<Item> DILLIUM_INGOT = ITEMS.register("dillium_ingot", () ->new Item(new Item.Properties().group(OscarMati.TAB)));
    //food
    public static final RegistryObject<Item> STEAK_SANDWICH = ITEMS.register("steak_sandwich", () -> new Item(new Item.Properties().group(OscarMati.TAB).food(new Food.Builder().hunger(8).saturation(1.2f).setAlwaysEdible().build())));
    //dillium tools
    public static final RegistryObject<Item> DILLIUM_SWORD = ITEMS.register("dillium_sword", () -> new DilliumSwordItem(DilliumTier.DILLIUM, 1, 1.3f, new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_PICKAXE = ITEMS.register("dillium_pickaxe", () -> new PickaxeItem(DilliumTier.DILLIUM, -2, 1.3f, new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_SHOVEL = ITEMS.register("dillium_shovel", () -> new ShovelItem(DilliumTier.DILLIUM, -3, 1.3f, new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_AXE = ITEMS.register("dillium_axe", () -> new AxeItem(DilliumTier.DILLIUM, 0, 1.3f, new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_HOE = ITEMS.register("dillium_hoe", () -> new HoeItem(DilliumTier.DILLIUM, 1.3f, new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_STAFF = ITEMS.register("dillium_staff", () -> new DilliumStaffItem(DilliumTier.DILLIUM, -5,  1.3f, new Item.Properties().group(OscarMati.TAB)));
    //dillium armor
    public static final RegistryObject<Item> DILLIUM_HELMET = ITEMS.register("dillium_helmet", () -> new DilliumArmorItem(DilliumMaterial.DILLIUM, EquipmentSlotType.HEAD, new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_CHESTPLATE = ITEMS.register("dillium_chestplate", () -> new DilliumArmorItem(DilliumMaterial.DILLIUM, EquipmentSlotType.CHEST, new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_LEGGINGS = ITEMS.register("dillium_leggings", () -> new DilliumArmorItem(DilliumMaterial.DILLIUM, EquipmentSlotType.LEGS, new Item.Properties().group(OscarMati.TAB)));
    public static final RegistryObject<Item> DILLIUM_BOOTS = ITEMS.register("dillium_boots", () -> new DilliumArmorItem(DilliumMaterial.DILLIUM, EquipmentSlotType.FEET, new Item.Properties().group(OscarMati.TAB)));


    public enum DilliumTier implements IItemTier {
        DILLIUM(4, 1200, 14.0f, 7.0f, 16, () -> {
            return Ingredient.fromItems(DILLIUM_INGOT.get());
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        DilliumTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }

    public enum DilliumMaterial implements IArmorMaterial {
        DILLIUM(OscarMati.MOD_ID + ":dillium", 10, new int[] {5,8,10,5}, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0f, () ->{
            return Ingredient.fromItems(DILLIUM_INGOT.get());
        });

        private static final int[] MAX_DAMAGE = new int[] {16,16,16,16};
        private final String armorName;
        private final int maxDamageFactor;
        private final int[] damageReductionAmount;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        DilliumMaterial(String armorNameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn){
            this.armorName = armorNameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmount = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType equipmentSlotType) {
            return MAX_DAMAGE[equipmentSlotType.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
            return this.damageReductionAmount[equipmentSlotType.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return armorName;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }

}
