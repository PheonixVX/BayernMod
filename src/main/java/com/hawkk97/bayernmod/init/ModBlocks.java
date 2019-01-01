package com.hawkk97.bayernmod.init;

import java.util.ArrayList;
import java.util.List;

import com.hawkk97.bayernmod.blocks.BlockBase;
import com.hawkk97.bayernmod.blocks.Metalmachines;
import com.hawkk97.bayernmod.blocks.StoneBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block FLEISCHWOLF = new Metalmachines(Material.IRON, "fleischwolf");
	public static final Block BRAUKESSEL = new Metalmachines(Material.IRON, "braukessel");
	
	public static final Block SALZ_BLOCK = new StoneBlocks(Material.ROCK, "salz_block");
	public static final Block SALZ_ORE = new StoneBlocks(Material.ROCK, "salz_ore");
	
}
