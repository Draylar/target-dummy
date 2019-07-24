package com.github.draylar.targetdummy;

import com.github.draylar.targetdummy.entity.TargetDummyEntity;
import com.github.draylar.targetdummy.entity.TargetDummyRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;

public class TargetDummyClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.INSTANCE.register(TargetDummyEntity.class, ((entityRenderDispatcher, context) -> new TargetDummyRender(entityRenderDispatcher)));
    }
}
