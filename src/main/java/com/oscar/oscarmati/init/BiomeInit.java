package com.oscar.oscarmati.init;

import com.oscar.oscarmati.OscarMati;
import com.oscar.oscarmati.world.biomes.BrotherhoodBiome;
import com.oscar.oscarmati.world.biomes.BrotherhoodBiomeSurfaceBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.BiomeDictionary.Type;


public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, OscarMati.MOD_ID);

    public static final RegistryObject<Biome> BROTHERHOOD_BIOME = BIOMES.register("brotherhood_biome", () -> new BrotherhoodBiome(new Biome.Builder()
            .scale(1.2f).temperature(0.2f).waterColor(6745061).waterFogColor(12648447)
            .surfaceBuilder(
                    new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
                            register("example_surface",
                                    new BrotherhoodBiomeSurfaceBuilder(
                                            SurfaceBuilderConfig::deserialize)),
                            new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
                                    Blocks.DIRT.getDefaultState(),
                                    Blocks.DIRT.getDefaultState())))
            .category(Biome.Category.PLAINS).downfall(0.5f).precipitation(Biome.RainType.RAIN).temperature(0.6f).depth(0.12f).parent(null)));

    public static void registerBiomes(){
        registerBiome(BROTHERHOOD_BIOME.get(), Type.PLAINS, Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, Type... types){
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 1000000000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    @SuppressWarnings("deprecation")
    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
    }
}
