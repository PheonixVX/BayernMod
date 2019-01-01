package com.hawkk97.bayernmod.init;

import com.hawkk97.bayernmod.BayernMod;
import com.hawkk97.bayernmod.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BayernModTab extends CreativeTabs 
{
	public BayernModTab() {
		super(Reference.MOD_ID);
	}

	@Override
	public ItemStack createIcon() 
		{
		return new ItemStack(ModItems.BEER);
		}
	}