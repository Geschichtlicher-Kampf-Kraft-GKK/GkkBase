package gkk.gkkbase.block;

import gkk.gkkbase.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(Material materialIn,String blockName,String registryName,String modId,float hardness,float resistance) {
        super(materialIn);
    }

    @Override
    public void registerModels() {

    }
}
