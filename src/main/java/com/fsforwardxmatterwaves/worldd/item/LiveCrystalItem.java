
package com.fsforwardxmatterwaves.worldd.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import com.fsforwardxmatterwaves.worldd.itemgroup.WorldDItemGroup;
import com.fsforwardxmatterwaves.worldd.WorlddModElements;

@WorlddModElements.ModElement.Tag
public class LiveCrystalItem extends WorlddModElements.ModElement {
	@ObjectHolder("worldd:live_crystal")
	public static final Item block = null;

	public LiveCrystalItem(WorlddModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(WorldDItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("live_crystal");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
