package net.droingo.droingomaze.entity.client;

import net.droingo.droingomaze.DroingoMaze;
import net.droingo.droingomaze.entity.custom.GrieverEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GrieverRenderer extends MobEntityRenderer<GrieverEntity, GrieverModel<GrieverEntity>> {
    private static final Identifier TEXTURE = new Identifier(DroingoMaze.MOD_ID, "textures/entity/griever.png");



    public GrieverRenderer(EntityRendererFactory.Context context) {
        super(context, new GrieverModel<>(context.getPart(ModModelLayers.GRIEVER)), 1.5f);
    }

    @Override
    public Identifier getTexture(GrieverEntity entity) {
        return TEXTURE;
    }


}
