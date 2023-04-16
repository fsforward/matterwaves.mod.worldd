package com.fsforwardxmatterwaves.worldd.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import com.fsforwardxmatterwaves.worldd.WorlddMod;

public class EnhancedLiveCrystalEntitySwingsItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WorlddMod.LOGGER.warn("Failed to load dependency entity for procedure EnhancedLiveCrystalEntitySwingsItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.DIAMOND_BLOCK)) : false) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 60, (int) 1));
		}
	}
}
