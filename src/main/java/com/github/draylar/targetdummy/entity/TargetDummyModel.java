package com.github.draylar.targetdummy.entity;

//Paste this code into your mod.

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class TargetDummyModel extends EntityModel<TargetDummyEntity>
{
    private final Cuboid bone;

    public TargetDummyModel() {
        textureWidth = 64;
        textureHeight = 64;

        bone = new Cuboid(this);
        bone.y = -.3f;
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);

        bone.addBox("bone1", -4, -10, -1, 2, 9, 2, 0, 8, 31);
        bone.addBox("bone2", 2, -10, -1, 2, 9, 2, 0, 0, 31);
        bone.addBox("bone3", -4, -23, -1.5f, 8, 13, 3, 0, 0, 15);
        bone.addBox("bone4", -3, -29, -2, 6, 6, 4, 0, 22, 15);
        bone.addBox("bone5", -7, -21, -1, 3, 2, 2, 0, 16, 35);
        bone.addBox("bone6", 4, -21, -1, 3, 2, 2, 0, 16, 31);
        bone.addBox("bone7", -7, -1, -7, 14, 1, 14, 0, 0, 0);
    }

    @Override
    public void render(TargetDummyEntity entity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6)
    {
        bone.render(.075f);
    }
}
