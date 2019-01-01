package com.hawkk97.bayernmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class StoneBlocks extends BlockBase 
{

	public StoneBlocks(Material material, String name) 
	{
		super(material, name);
	
		setSoundType(SoundType.STONE);
		setResistance(15.0F);
		setHardness(1.5F);
		setHarvestLevel("pickaxe", 1);
		
	}
	
}
