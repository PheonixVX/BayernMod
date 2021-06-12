package io.github.pheonixvx.bayernmod;

import io.github.pheonixvx.bayernmod.init.ModBlocks;
import io.github.pheonixvx.bayernmod.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BayernMod implements ModInitializer {

    public static final String MOD_ID = "bayernmod";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(ModItems.BEER))
            .build();

    @Override
    public void onInitialize() {
        ModItems items = new ModItems();
        ModBlocks blocks = new ModBlocks();
    }
}
