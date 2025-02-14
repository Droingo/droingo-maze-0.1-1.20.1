package net.droingo.droingomaze.entity.client;

import net.droingo.droingomaze.DroingoMaze;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer GRIEVER =
            new EntityModelLayer(new Identifier(DroingoMaze.MOD_ID, "griever"), "main");

    public static void registerModelLayers (){

    }

}
