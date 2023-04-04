package com.fsforwardxmatterwaves.worldd.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;
import java.util.Calendar;

import com.fsforwardxmatterwaves.worldd.WorlddMod;

public class ArtificialSaberEntitySwingsItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WorlddMod.LOGGER.warn("Failed to load dependency entity for procedure ArtificialSaberEntitySwingsItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (Calendar.getInstance().get(Calendar.SECOND) >= 20) {
			if (!(new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.SPEED)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 40, (int) 2));
			}
		}
	}
}
