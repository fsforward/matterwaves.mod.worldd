package com.fsforwardxmatterwaves.worldd.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.Collection;

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
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 20) {
			entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 6);
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) 10, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		} else if (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.REGENERATION)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 4);
		}
	}
}
