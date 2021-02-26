package gkk.gkkbase.materials;

import gkk.gkkbase.block.MaterialBlock;
import gkk.gkkbase.interfaces.BlockConstructor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;

public class Blocks {
    public static final HashMap<String, Block> BLOCKS = new HashMap<>();
    /**
     * this map is used to storage Constructor of different BlockTypes
     * need to initialize before use
     * oh... I thought it's useless...
     */
    public static final HashMap<String, BlockConstructor> BLOCK_CONSTRUCTOR_HASH_MAP = new HashMap<>();

    public static void init() {

    }

    @Deprecated
    public static void defineMaterialBlocks(String materialName, float hardnessBase, float resistanceBase, float hardnessMultiplier, float resistanceMultiplier, String... prefix) {
        for (String s : prefix) {
            String name = s + materialName;
            MaterialBlock materialBlock = new MaterialBlock(name, hardnessBase, resistanceBase, hardnessMultiplier, resistanceMultiplier);
        }
    }

    public static void defineMaterialBlocks(String materialName, String modId, float hardnessBase, float resistanceBase, float hardnessMultiplier, float resistanceMultiplier, String... prefix) {
        for (String s : prefix) {
            defineBlocks(materialName, modId, s, hardnessBase, resistanceBase, hardnessMultiplier, resistanceMultiplier);
        }
    }

    public static void defineBlocks(String materialName, String modId, String prefix, float hardnessBase, float resistanceBase, float hardnessMultiplier, float resistanceMultiplier) {
        BLOCK_CONSTRUCTOR_HASH_MAP.get(prefix).Construct(materialName, modId, hardnessBase, resistanceBase, hardnessMultiplier, resistanceMultiplier);
    }

    public static void defineBlockTypes(String type, BlockConstructor constructor) {
        BLOCK_CONSTRUCTOR_HASH_MAP.put(type, constructor);
    }
}
