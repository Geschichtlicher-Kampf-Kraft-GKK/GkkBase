package gkk.gkkbase.block;

import gkk.gkkbase.GkkBase;
import gkk.gkkbase.materials.Blocks;
import gkk.gkkbase.materials.Items;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class MaterialBlock extends BlockBase {
    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 15);
    private final float resistanceMultiplier;
    private final float hardnessMultiplier;

    public MaterialBlock(String name, float hardnessBase, float resistanceBase, float hardnessMultiplier, float resistanceMultiplier) {
        super(Material.IRON, name, name, GkkBase.MOD_ID, hardnessBase, resistanceBase);
        this.hardnessMultiplier = hardnessMultiplier;
        this.resistanceMultiplier = resistanceMultiplier;
        Blocks.BLOCKS.put(name, this);
        Items.ITEMS.put(name, new ItemBlock(this).setRegistryName(this.getRegistryName()));
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL,0));
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        return this.blockHardness + blockState.getValue(LEVEL) * hardnessMultiplier;
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, @Nullable Entity exploder, Explosion explosion) {
        return this.blockResistance + world.getBlockState(pos).getValue(LEVEL) * resistanceMultiplier;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LEVEL);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(LEVEL);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(LEVEL, meta);
    }

    @Override
    public void registerModels() {

    }
}
