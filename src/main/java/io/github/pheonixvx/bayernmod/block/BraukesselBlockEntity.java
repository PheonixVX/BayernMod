package io.github.pheonixvx.bayernmod.block;

import io.github.pheonixvx.bayernmod.BayernMod;
import io.github.pheonixvx.bayernmod.init.BraukesselScreenHandler;
import io.github.pheonixvx.bayernmod.misc.ImplementedInventory;
import io.github.pheonixvx.bayernmod.misc.NBTHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class BraukesselBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {
    private DefaultedList<ItemStack> items = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public int x, y, z, tick;
    boolean initialized = false;

    public int combinedBurnTime;
    public int currentCombinedBurnTime;
    public int combinedCookTime;
    private static final int[] slots_top = new int[]{0};
    private static final int[] slots_bottom = new int[]{2, 1};

    public BraukesselBlockEntity(BlockPos pos, BlockState state) {
        super(BayernMod.BRAUKESSEL_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    private int getItemBurnTime(ItemStack stack) {
        return 500;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        NbtCompound initValues = nbt.getCompound("initvalues");
        if(initValues != null) {
            this.x = initValues.getInt("x");
            this.y = initValues.getInt("y");
            this.z = initValues.getInt("z");
            this.tick = 0;
            initialized = true;
        }
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.put("initvalues", NBTHelper.toNBT(this));
        return super.writeNbt(nbt);
    }

    @Environment(EnvType.CLIENT)
    public int getCookProgressScaled(int time) {
        return this.combinedCookTime * time / 1800;
    }

    public boolean isBurning() {
        return this.combinedBurnTime > 0;
    }

    public int getDamage(ItemStack stack) {
        return stack.getDamage();
    }

    private boolean canRun() {
        if (this.items.get(0).isEmpty()) {
            return false;
        } else {
            ItemStack itemstack = null; // TODO: KesselRecipes.smelting().getSmeltingResult(this.items.get(0));
            if (itemstack == null) {
                return false;
            } else if (this.items.get(1).isEmpty()) {
                return true;
            } else if (!this.items.get(1).isItemEqualIgnoreDamage(itemstack)) {
                return false;
            } else {
                int result = this.items.get(1).getCount() + itemstack.getCount();
                return result <= this.getMaxCountPerStack() && result <= this.items.get(1).getMaxCount();
            }
        }
    }

    public void pressComb() {
        if (this.canRun()) {
            ItemStack itemstack = null; // TODO: KesselRecipes.smelting().getSmeltingResult(this.items.get(0));
            if (this.items.get(1).isEmpty()) {
                this.items.set(1, itemstack.copy());
            } else if (this.items.get(1).getItem() == itemstack.getItem()) {
                ItemStack var10000 = this.items.get(1);
                int stackCount = var10000.getCount();
                int count = stackCount + itemstack.getCount();
                var10000.setCount(count);
            }

            int decrementedCount = this.items.get(0).getCount();
            this.items.get(0).setCount(--decrementedCount);
            if (this.items.get(0).getCount() <= 0) {
                this.items.set(0, null);
            }
        }
    }

    /*
    public boolean func_70300_a(EntityPlayer par1EntityPlayer) {
        return super.field_145850_b.func_147438_o(super.field_145851_c, super.field_145848_d, super.field_145849_e) != this ? false : par1EntityPlayer.func_70092_e((double)super.field_145851_c + 0.5D, (double)super.field_145848_d + 0.5D, (double)super.field_145849_e + 0.5D) <= 64.0D;
    }
    */

    @Override
    public void onOpen(PlayerEntity player) {}

    @Override
    public void onClose(PlayerEntity player) {}

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        return true;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Braukessel");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new BraukesselScreenHandler(syncId, inv);
    }

    /*@Nullable
    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        NbtCompound tag = new NbtCompound();
        return new BlockEntityUpdateS2CPacket(this.)
    }

    public Packet func_145844_m() {
        NBTTagCompound tag = new NBTTagCompound();
        return new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, tag);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        this.func_145839_a(packet.func_148857_g());
    }*/
}
