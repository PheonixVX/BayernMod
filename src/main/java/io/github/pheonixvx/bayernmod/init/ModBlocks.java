package io.github.pheonixvx.bayernmod.init;

import io.github.pheonixvx.bayernmod.BayernMod;
import io.github.pheonixvx.bayernmod.block.BraukesselBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    //public static final Block FLEISCHWOLF = registerBlock("fleischwolf", Material.METAL);
    public static final Block BRAUKESSEL = registerBlock("braukessel", new BraukesselBlock(AbstractBlock.Settings.of(Material.METAL).nonOpaque()), new Item.Settings().group(BayernMod.ITEM_GROUP));

    public static final Block SALZ_BLOCK = registerBlock("salz_block", Material.STONE);
    public static final Block SALZ_ORE = registerBlock("salz_ore", Material.STONE);

    public static Block registerBlock(String name, Material material) {
        Block block = Registry.register(Registry.BLOCK, new Identifier(BayernMod.MOD_ID, name), new Block(AbstractBlock.Settings.of(material)));
        Registry.register(Registry.ITEM, new Identifier(BayernMod.MOD_ID, name), new BlockItem(block, new Item.Settings().group(BayernMod.ITEM_GROUP)));

        return block;
    }

    public static <T extends Block> T registerBlock(String name, T block, Item.Settings itemSettings) {
        T registeredBlock = Registry.register(Registry.BLOCK, new Identifier(BayernMod.MOD_ID, name), block);
        Registry.register(Registry.ITEM, new Identifier(BayernMod.MOD_ID, name), new BlockItem(block, itemSettings));

        return registeredBlock;
    }
}
