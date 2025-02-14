package net.droingo.droingomaze;

import net.droingo.droingomaze.entity.ModEntities;
import net.droingo.droingomaze.entity.client.GrieverModel;
import net.droingo.droingomaze.entity.client.GrieverRenderer;
import net.droingo.droingomaze.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DroingoMazeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.GRIEVER, GrieverRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GRIEVER, GrieverModel::getTexturedModelData);


    }
}
