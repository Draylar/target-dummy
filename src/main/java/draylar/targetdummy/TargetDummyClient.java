package draylar.targetdummy;

import draylar.targetdummy.entity.TargetDummyRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class TargetDummyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(TargetDummy.TARGET_DUMMY, ((entityRenderDispatcher, context) -> new TargetDummyRender(entityRenderDispatcher)));
    }
}