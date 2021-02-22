package gkk.gkkbase.interfaces;

import gkk.gkkbase.block.BlockBase;
import gkk.gkkbase.block.MaterialBlock;

@FunctionalInterface
public interface BlockConstructor{
    MaterialBlock Construct(String materialName, String modId, float hardnessBase, float resistanceBase, float hardnessMultiplier, float resistanceMultiplier);
}
