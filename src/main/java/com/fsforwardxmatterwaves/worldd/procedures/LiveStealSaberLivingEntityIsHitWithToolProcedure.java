package com.fsforwardxmatterwaves.worldd.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import com.fsforwardxmatterwaves.worldd.WorlddMod;

public class LiveStealSaberLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WorlddMod.LOGGER.warn("Failed to load dependency entity for procedure LiveStealSaberLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				WorlddMod.LOGGER.warn("Failed to load dependency itemstack for procedure LiveStealSaberLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 8) {
			entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 8);
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) 10, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 60, (int) 1, (false), (true)));
		}
	}
}