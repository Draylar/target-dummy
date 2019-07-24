package com.github.draylar.targetdummy.entity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TargetDummyRender extends MobEntityRenderer<TargetDummyEntity, TargetDummyModel>
{
    public TargetDummyRender(EntityRenderDispatcher entityRenderDispatcher_1)
    {
        super(entityRenderDispatcher_1, new TargetDummyModel(), .5f);
    }

    @Override
    protected Identifier getTexture(TargetDummyEntity targetDummyEntity)
    {
        return new Identifier("target-dummy:textures/entity/target_dummy/target-dummy.png");
    }
}
