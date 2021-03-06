package gkk.gkkbase.materials;

import gkk.gkkbase.interfaces.BlockConstructor;
import gkk.gkkbase.item.ItemMaterialBase;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.util.*;

public class Items {
    public static final HashMap<String, Item> ITEMS = new HashMap<>();
    private static final List<String> RESOURCE_TYPES = Arrays.asList("ingot,stick,powder,plate,string,bar,screw".split(","));
    //we need to consider the essential about different level of material;

    public static void init() {
        defineResources("Silver,Copper,Aluminum,Brass,Bronze,Lead,Zinc,Antimony,Chrome,Iridium,Magnesium,Platinum,Steel,Tin,Titanium,Tungsten,Uranium,Stainless_steel,Invar".split(","));
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

    public static void defineResources(String... materialNames) {
        for (String materialName : materialNames) {
            defineMaterials(materialName, RESOURCE_TYPES, "0");
        }
    }

}
