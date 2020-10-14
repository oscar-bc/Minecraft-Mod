package com.oscar.oscarmati.init;

import com.oscar.oscarmati.OscarMati;
import com.oscar.oscarmati.objects.blocks.DillySaplingBlock;
import com.oscar.oscarmati.world.feature.DillyTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, OscarMati.MOD_ID);

    //dillium
    public static final RegistryObject<Block> DILLIUM_BLOCK = BLOCKS.register("dillium_block", () -> new Block(Block.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> DILLIUM_ORE_BLOCK = BLOCKS.register("dillium_ore_block", () ->new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 10.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> DILLIUM_INGOT_BLOCK = BLOCKS.register("dillium_ingot_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 10.0f).sound(SoundType.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE)));

    //dilly wood
    public static final RegistryObject<Block> DILLY_PLANKS = BLOCKS.register("dilly_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> DILLY_LOG = BLOCKS.register("dilly_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> DILLY_LEAVES = BLOCKS.register("dilly_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> DILLY_SAPLING = BLOCKS.register("dilly_sapling", () -> new DillySaplingBlock(() -> new DillyTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> PSMUM_GRASS = BLOCKS.register("psmum_grass", () -> new GrassBlock(Block.Properties.from(Blocks.GRASS_BLOCK)));

    //remite
    public static final RegistryObject<Block> REMITE_ORE_BLOCK = BLOCKS.register("remite_ore_block", () ->new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 10.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
}
