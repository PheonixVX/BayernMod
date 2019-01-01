package com.hawkk97.bayernmod.items;

import com.hawkk97.bayernmod.BayernMod;
import com.hawkk97.bayernmod.init.ModItems;
import com.hawkk97.bayernmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

	public ItemBase(String name)
	
	{
		
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(BayernMod.creativeTab);
		//setCreativeTab(CreativeTabs.FOOD);
		
		ModItems.ITEMS.add(this);
		
	}

	@Override
	public void registerModels() 
	{
		BayernMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}