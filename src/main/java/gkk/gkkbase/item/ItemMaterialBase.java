package gkk.gkkbase.item;

import gkk.gkkbase.GkkBase;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class ItemMaterialBase extends ItemBase {
    public ItemMaterialBase(String name, String[] subtypes) {
        super(true, name, name, true, GkkBase.MOD_ID, subtypes);
    }


}
