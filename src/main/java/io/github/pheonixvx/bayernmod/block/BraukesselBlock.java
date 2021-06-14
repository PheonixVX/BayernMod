package io.github.pheonixvx.bayernmod.block;

import io.github.pheonixvx.bayernmod.init.BraukesselScreenHandler;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.ArrayVoxelShape;
import net.minecraft.util.shape.BitSetVoxelSet;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BraukesselBlock extends BlockWithEntity {
    public BraukesselBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BraukesselBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    /* TODO: Drops are now done in loot tables
    public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.func_150898_a(BayernMod.blockBierKessel);
    }
    */

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity != null && !player.isSneaking()) {
            // TODO: Open kettle screen
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
        }

        return ActionResult.CONSUME;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // TODO: Implement proper outline shape
        return super.getOutlineShape(state, world, pos, context);
    }

    /*public static void updateBlockState(boolean par0, World par1World, int par2, int par3, int par4) {
        int var5 = par1World.func_72805_g(par2, par3, par4);
        TileEntity var6TileEntity = par1World.func_147438_o(par2, par3, par4);
        if (var6TileEntity != null) {
            if (par0) {
                par1World.func_147449_b(par2, par3, par4, BayernMod.blockBierKessel);
            } else {
                par1World.func_147449_b(par2, par3, par4, BayernMod.blockBierKessel);
            }

            par1World.func_72921_c(par2, par3, par4, var5, 2);
            var6TileEntity.func_145829_t();
            par1World.func_147455_a(par2, par3, par4, var6TileEntity);
        }

    }

    @Environment(EnvType.CLIENT)
    public void func_149651_a(IIconRegister par1IconRegister) {
        this.middle = par1IconRegister.func_94245_a("bm:kesselside");
        this.front = par1IconRegister.func_94245_a("bm:kesselfront");
        this.top = par1IconRegister.func_94245_a("bm:kesseltop");
        this.bottom = par1IconRegister.func_94245_a("bm:kesselbottom_0");
    }

    @Environment(EnvType.CLIENT)
    public IIcon func_149691_a(int par1, int par2) {
        return par1 == 1 ? this.top : (par1 == 0 ? this.bottom : (par1 != par2 ? this.middle : this.front));
    }*/


    /* TODO: Fix ticking
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return BraukesselBlockEntity::tick;
    }*/
}
