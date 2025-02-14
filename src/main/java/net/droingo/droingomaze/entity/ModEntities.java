package net.droingo.droingomaze.entity;

import net.droingo.droingomaze.DroingoMaze;
import net.droingo.droingomaze.entity.custom.GrieverEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<GrieverEntity> GRIEVER  = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(DroingoMaze.MOD_ID, "griever"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GrieverEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f))
                    .trackRangeBlocks(64)
                    .build()
    );

    public static void registerModEntities() {
        DroingoMaze.LOGGER.info("Registering entities for"+DroingoMaze.MOD_ID);
    }
}
