
package com.fsforwardxmatterwaves.worldd.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import com.fsforwardxmatterwaves.worldd.WorlddModElements;

@WorlddModElements.ModElement.Tag
public class ArtificialSaberItem extends WorlddModElements.ModElement {
	@ObjectHolder("worldd:artificial_saber")
	public static final Item block = null;

	public ArtificialSaberItem(WorlddModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 420;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -1.5f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("artificial_saber"));
	}
}
