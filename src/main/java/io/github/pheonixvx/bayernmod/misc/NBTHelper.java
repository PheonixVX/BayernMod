package io.github.pheonixvx.bayernmod.misc;

import io.github.pheonixvx.bayernmod.block.BraukesselBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

public class NBTHelper {

    public static NbtCompound toNBT(Object o) {
        if(o instanceof ItemStack) {
            return writeItemStack((ItemStack)o);
        }

        if(o instanceof BraukesselBlockEntity) {
            return writeBraukessel((BraukesselBlockEntity)o);
        }

        return null;
    }

    private static NbtCompound writeBraukessel(BraukesselBlockEntity o) {
        NbtCompound compound = new NbtCompound();
        compound.putInt("x", o.x);
        compound.putInt("y", o.y);
        compound.putInt("z", o.z);
        return compound;
    }

    private static NbtCompound writeItemStack(ItemStack i) {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("count", i.getCount());
        nbt.putString("item", Registry.ITEM.getId(i.getItem()).toString());
        nbt.putByte("type", (byte)0);
        return nbt;
    }

    @Nullable
    public static Object fromNBT(NbtCompound compound) {
        if (compound.getByte("type") == 0) {
            return readItemStack(compound);
        }
        return null;
    }

    private static ItemStack readItemStack(NbtCompound compound) {
        Item item = Registry.ITEM.get(new Identifier(compound.getString("item")));
        int count = compound.getInt("count");
        return new ItemStack(item, count);
    }
}
