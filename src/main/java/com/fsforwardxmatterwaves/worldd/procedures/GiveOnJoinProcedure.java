package com.fsforwardxmatterwaves.worldd.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.fsforwardxmatterwaves.worldd.item.EnhancedVoidCrystalItem;
import com.fsforwardxmatterwaves.worldd.item.EnhancedLiveCrystalItem;
import com.fsforwardxmatterwaves.worldd.item.EnhancedDeathCrystalItem;
import com.fsforwardxmatterwaves.worldd.WorlddModVariables;
import com.fsforwardxmatterwaves.worldd.WorlddMod;

public class GiveOnJoinProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WorlddMod.LOGGER.warn("Failed to load dependency entity for procedure GiveOnJoin!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(entity.getCapability(WorlddModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WorlddModVariables.PlayerVariables())).OnGrant) {
			{
				double _setval = (MathHelper.nextInt(new Random(), 1, 3));
				entity.getCapability(WorlddModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RandomInt = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(WorlddModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new WorlddModVariables.PlayerVariables())).RandomInt == 1) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EnhancedLiveCrystalItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if ((entity.getCapability(WorlddModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new WorlddModVariables.PlayerVariables())).RandomInt == 2) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EnhancedDeathCrystalItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if ((entity.getCapability(WorlddModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new WorlddModVariables.PlayerVariables())).RandomInt == 3) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EnhancedVoidCrystalItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			{
				boolean _setval = (true);
				entity.getCapability(WorlddModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.OnGrant = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
