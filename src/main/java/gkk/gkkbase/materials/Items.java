package gkk.gkkbase.materials;

import gkk.gkkbase.interfaces.BlockConstructor;
import gkk.gkkbase.item.ItemMaterialBase;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Items {
    public static final HashMap<String, Item> ITEMS = new HashMap<>();

    public static void init() {
        defineMaterials("Steel", Arrays.asList("ingot,stick,powder,plate,string,bar".split(",")), "0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16".split(","));
    }


    /**
     * @param materialName name of the material
     * @param prefix       prefix of oreDict
     * @param suffix       max = 16
     */
    public static void defineMaterials(String materialName, Collection<String> prefix, String... suffix) {

        for (String s : prefix) {
            String name = s + materialName;
            ItemMaterialBase itemMaterialBase = new ItemMaterialBase(name, suffix);
//            OreDictionary.registerOre(name, itemMaterialBase);
            //todo fix it
        }
    }

    public static void defineMaterialItems(String materialName, String modId, String... suffix) {

    }
}
