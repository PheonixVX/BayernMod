package io.github.pheonixvx.bayernmod;

import io.github.pheonixvx.bayernmod.block.BraukesselBlockEntity;
import io.github.pheonixvx.bayernmod.init.ModBlocks;
import io.github.pheonixvx.bayernmod.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BayernMod implements ModInitializer {

    public static final String MOD_ID = "bayernmod";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(ModItems.BEER))
            .build();

    public static BlockEntityType<BraukesselBlockEntity> BRAUKESSEL_BLOCK_ENTITY_TYPE = null;

    @Override
    public void onInitialize() {
        BRAUKESSEL_BLOCK_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "braukeseel_block_entity"), FabricBlockEntityTypeBuilder.create(BraukesselBlockEntity::new, ModBlocks.BRAUKESSEL).build());

        ModItems items = new ModItems();
    }
}
