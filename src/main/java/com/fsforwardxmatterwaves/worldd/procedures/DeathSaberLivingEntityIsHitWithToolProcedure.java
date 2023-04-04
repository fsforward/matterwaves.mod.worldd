package com.fsforwardxmatterwaves.worldd.procedures;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Random;
import java.util.Map;

import com.fsforwardxmatterwaves.worldd.WorlddMod;

public class DeathSaberLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WorlddMod.LOGGER.warn("Failed to load dependency entity for procedure DeathSaberLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				WorlddMod.LOGGER.warn("Failed to load dependency itemstack for procedure DeathSaberLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) >= 18) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 4);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 20, (int) 1));
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) 10, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) == MathHelper.nextDouble(new Random(), 25, 250)) {
			if (entity.isImmuneToFire()) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 6);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 60, (int) 1));
				entity.setMotionMultiplier(Blocks.AIR.getDefaultState(), new Vector3d(0.25D, (double) 0.05F, 0.25D));
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.attemptDamageItem((int) 20, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
		}
	}
}
