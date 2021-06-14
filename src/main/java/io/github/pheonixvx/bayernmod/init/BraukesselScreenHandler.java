package io.github.pheonixvx.bayernmod.init;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class BraukesselScreenHandler extends ScreenHandler {
    private final PropertyDelegate propertyDelegate;
    private final Inventory inventory;

    public BraukesselScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3), new ArrayPropertyDelegate(7));
    }

    public BraukesselScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.BRAUKESSEL_HANDLER, syncId);
        checkSize(inventory, 3);
        checkDataCount(propertyDelegate, 3);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);

        this.addSlot(new FuelSlot(inventory, 1, 40, 18)); // fuel slot

        int m, l;
        for (m = 0; m < 3; ++m)
            for (l = 0; l < 9; ++l)
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
        for (m = 0; m < 9; ++m) this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
    }

    static class FuelSlot extends Slot {
        public FuelSlot(Inventory inventory, int i, int j, int k) { super(inventory, i, j, k); }

        public boolean canInsert(ItemStack stack) { return matches(stack); }

        public static boolean matches(ItemStack stack) {
            Item item = stack.getItem();
            return item == Items.BROWN_MUSHROOM || item == Items.RED_MUSHROOM;
        }

        public int getMaxItemCount() { return 64; }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
