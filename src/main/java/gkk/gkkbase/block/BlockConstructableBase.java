package gkk.gkkbase.block;

import gkk.gkkbase.materials.Blocks;

public abstract class BlockConstructableBase extends MaterialBlock {

    public BlockConstructableBase(String name, String modId, float hardnessBase, float resistanceBase, float hardnessMultiplier, float resistanceMultiplier) {
        super(name, modId, hardnessBase, resistanceBase, hardnessMultiplier, resistanceMultiplier);
   }

}
