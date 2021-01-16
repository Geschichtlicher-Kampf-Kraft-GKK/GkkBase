package gkk.gkkbase.item;

import gkk.gkkbase.GkkBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMaterialBase extends ItemBase {
    public ItemMaterialBase(String name, String[] subtypes) {
        super(true, name, name, true, GkkBase.MOD_ID, subtypes);
        setCreativeTab(GkkBase.CREATIVE_TAB);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            for (int i = 0; i < getSubtypeList().size(); i++) {
                items.add(new ItemStack(this, i));
            }
        }
    }
}
