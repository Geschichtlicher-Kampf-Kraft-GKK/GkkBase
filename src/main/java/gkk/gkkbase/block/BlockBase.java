package gkk.gkkbase.block;

import gkk.gkkbase.GkkBase;
import gkk.gkkbase.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BlockBase extends Block implements IHasModel {

    public BlockBase(Material materialIn,String blockName,String registryName,String modId,float hardness,float resistance) {
        super(materialIn);
        setRegistryName(modId,registryName);
        setTranslationKey(blockName);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(GkkBase.CREATIVE_TAB);
    }

    @Override
    public abstract void registerModels();
}
