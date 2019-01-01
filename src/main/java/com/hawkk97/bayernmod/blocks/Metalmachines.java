package com.hawkk97.bayernmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Metalmachines extends BlockBase 
{

	public Metalmachines(Material material, String name) 
	{
		super(material, name);
	
		setSoundType(SoundType.METAL);
		setResistance(50.0F);
		setLightOpacity(1);
		
	}
	
}
