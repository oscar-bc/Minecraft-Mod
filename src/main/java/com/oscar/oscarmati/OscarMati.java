package com.oscar.oscarmati;

import com.oscar.oscarmati.init.BiomeInit;
import com.oscar.oscarmati.init.BlockInit;
import com.oscar.oscarmati.init.ItemInit;
import com.oscar.oscarmati.init.ModEntityTypes;
import com.oscar.oscarmati.world.biomes.BrotherhoodBiome;
import com.oscar.oscarmati.world.gen.ModOreGen;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.rmi.registry.Registry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("oscarmati")
@Mod.EventBusSubscriber(modid = OscarMati.MOD_ID, bus = Bus.MOD)
public class OscarMati
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "oscarmati";
    public static OscarMati instance;

    public OscarMati() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        //register tile entity here
        BiomeInit.BIOMES.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(OscarMati.TAB);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("BlockItems are now registered");
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event){
        BiomeInit.registerBiomes();
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event){
        ModOreGen.generateOres();
    }

    public static final ItemGroup TAB = new ItemGroup("oscarmatiTab"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.DILLIUM_STAFF.get());
        }
    };
}
