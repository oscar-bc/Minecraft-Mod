package com.oscar.oscarmati.world.biomes;

import com.google.common.collect.ImmutableList;
import com.oscar.oscarmati.init.BlockInit;
import com.oscar.oscarmati.world.feature.DillyTree;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GrassColors;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.MineshaftStructure.Type;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

public class BrotherhoodBiome extends Biome {
    private static final BlockClusterFeatureConfig GRASS_CONFIG = (new net.minecraft.world.gen.feature.BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.GRASS.getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
    private static final BlockClusterFeatureConfig LILAC_CONFIG = (new net.minecraft.world.gen.feature.BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.LILAC.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    private static final BlockClusterFeatureConfig ROSE_BUSH_CONFIG = (new net.minecraft.world.gen.feature.BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.ROSE_BUSH.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    private static final BlockClusterFeatureConfig PEONY_CONFIG = (new net.minecraft.world.gen.feature.BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.PEONY.getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    private static final BlockClusterFeatureConfig LILY_OF_THE_VALLEY_CONFIG = (new net.minecraft.world.gen.feature.BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.LILY_OF_THE_VALLEY.getDefaultState()), new SimpleBlockPlacer())).tries(64).build();

    public BrotherhoodBiome(Builder builder) {
        super(builder);
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 120, 1, 4));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 200, 1, 4));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 80, 1, 2));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 200, 2, 7));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COD, 200, 5, 10));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 50, 3, 5));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PUFFERFISH, 80, 1, 2));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 80, 1, 2));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 80, 3, 5));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 200, 1, 5));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SALMON, 200, 3, 8));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SQUID, 100, 1, 4));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 150, 3, 7));

        addFeatures(this);

        //custom features
        addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004000000189989805D, MineshaftStructure.Type.NORMAL)).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.VILLAGE.withConfiguration(new VillageConfig("village/plains/town_centers", 6)).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(DillyTree.DILLY_TREE_CONFIG).withPlacement(Placement
                .COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1f, 1))));
        addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                BlockInit.DILLIUM_ORE_BLOCK.get().getDefaultState(), 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 5, 15, 50))));

        addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.REMITE_ORE_BLOCK.get().getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16))));

        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_RANDOM_SELECTOR.withConfiguration(new MultipleWithChanceRandomFeatureConfig(ImmutableList.of(Feature.RANDOM_PATCH.withConfiguration(LILAC_CONFIG), Feature.RANDOM_PATCH.withConfiguration(ROSE_BUSH_CONFIG), Feature.RANDOM_PATCH.withConfiguration(PEONY_CONFIG), Feature.FLOWER.withConfiguration(LILY_OF_THE_VALLEY_CONFIG)), 0)).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(14))));
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));
    }

    public void addFeatures(Biome biome){
        DefaultBiomeFeatures.addDefaultFlowers(biome);
        DefaultBiomeFeatures.addSeagrass(biome);
        DefaultBiomeFeatures.addKelp(biome);
        DefaultBiomeFeatures.addOres(biome);
        DefaultBiomeFeatures.addCarvers(biome);
    }
}
