
package com.fsforwardxmatterwaves.worldd.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.fsforwardxmatterwaves.worldd.item.ArtificialLensItem;
import com.fsforwardxmatterwaves.worldd.WorlddModElements;

@WorlddModElements.ModElement.Tag
public class WorldDItemGroup extends WorlddModElements.ModElement {
	public WorldDItemGroup(WorlddModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabworld_d") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ArtificialLensItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
