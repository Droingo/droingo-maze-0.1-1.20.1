package net.droingo.droingomaze;

import net.droingo.droingomaze.entity.ModEntities;
import net.droingo.droingomaze.entity.custom.GrieverEntity;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroingoMaze implements ModInitializer {
	public static final String MOD_ID = "droingomaze";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModEntities.registerModEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.GRIEVER, GrieverEntity.createGrieverAttributes());
	}
}