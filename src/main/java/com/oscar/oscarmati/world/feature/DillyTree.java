package com.oscar.oscarmati.world.feature;

import com.oscar.oscarmati.init.BlockInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.sql.Blob;
import java.util.Random;

public class DillyTree extends Tree {

    public static final TreeFeatureConfig DILLY_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.DILLY_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.DILLY_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2,1))).baseHeight(7).heightRandA(5).foliageHeight(5)
            .ignoreVines().setSapling((IPlantable)BlockInit.DILLY_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random rand, boolean bool){
        return Feature.NORMAL_TREE.withConfiguration(DILLY_TREE_CONFIG);
    }

}
