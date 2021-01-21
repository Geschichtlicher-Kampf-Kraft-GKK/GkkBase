package gkk.gkkbase.materials;

import gkk.gkkbase.block.MaterialBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;

public class Blocks {
    public static final HashMap<String, Block> BLOCKS = new HashMap<>();

    public static void init() {
        defineMaterialBlocks("Steel",16,16,1.5f,1.5f,"stair,block,ore".split(","));
    }

    public static void defineMaterialBlocks(String materialName, float hardnessBase, float resistanceBase, float hardnessMultiplier, float resistanceMultiplier, String... prefix) {
        for (String s : prefix) {
            String name = s + materialName;
            MaterialBlock materialBlock = new MaterialBlock(name, hardnessBase, resistanceBase, hardnessMultiplier, resistanceMultiplier);
//            OreDictionary.registerOre(name, Items.ITEMS.get(name));
            //todo fix it
        }
    }
}
