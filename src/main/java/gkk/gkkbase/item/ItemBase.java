package gkk.gkkbase.item;

import gkk.gkkbase.materials.Items;
import gkk.gkkbase.utils.IHasModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemBase extends Item implements IHasModel {
    private final String MODID;
    private ArrayList<String> subtypeList = new ArrayList<>();

    public ItemBase(boolean registryInBase, String registryName, String itemName, boolean subType, String modId, String... itemNameSuffix) {
        MODID = modId;
        setRegistryName(registryName);
        setTranslationKey(itemName);
        setHasSubtypes(subType);
        subtypeList.addAll(Arrays.asList(itemNameSuffix));
        if (registryInBase) {
            Items.ITEMS.put(registryName, this);
        }
    }

    public ArrayList<String> getSubtypeList() {
        return subtypeList;
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        if (!hasSubtypes) {
            return super.getTranslationKey(stack);
        } else {
            return getTranslationKey() + "." + subtypeList.get(stack.getMetadata());
        }
    }

    @Override
    public void registerModels() {
        if (this.getHasSubtypes()) {
            int size = subtypeList.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(new ResourceLocation(this.MODID, this.getRegistryName().getPath() + "/" + subtypeList.get(i)), "inventory"));
            }
        } else {
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(new ResourceLocation(this.MODID, this.getRegistryName().getPath()), "inventory"));
        }
    }
}
