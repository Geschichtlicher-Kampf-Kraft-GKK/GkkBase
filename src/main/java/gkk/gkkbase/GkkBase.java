package gkk.gkkbase;

import gkk.gkkbase.materials.Blocks;
import gkk.gkkbase.materials.Items;
import gkk.gkkbase.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
        modid = GkkBase.MOD_ID,
        name = GkkBase.MOD_NAME,
        version = GkkBase.VERSION
)
public class GkkBase {

    public static final String MOD_ID = "gkk_base";
    public static final String MOD_NAME = "GkkBase";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static final CreativeTabs CREATIVE_TAB = new CreativeTabs(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(net.minecraft.init.Items.BEEF);
        }
    };

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static GkkBase INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            Items.init();
            for (Item value : Items.ITEMS.values()) {
                event.getRegistry().register(value);
            }
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
            Blocks.init();
            for (Block value : Blocks.BLOCKS.values()) {
                event.getRegistry().register(value);
            }
        }

        @SubscribeEvent
        public static void onModelRegister(ModelRegistryEvent event) {
//            OBJLoader.INSTANCE.addDomain(MOD_ID); //registry obj model

            for (Item value : Items.ITEMS.values()) {
                if (value instanceof IHasModel) {
                    ((IHasModel) value).registerModels();
                }
            }

            for (Block block : Blocks.BLOCKS.values()) {
                if (block instanceof IHasModel) {
                    ((IHasModel) block).registerModels();
                }
            }

        }
    }

}
