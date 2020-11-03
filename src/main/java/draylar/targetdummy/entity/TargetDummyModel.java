package draylar.targetdummy.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class TargetDummyModel extends EntityModel<TargetDummyEntity> {

    private final ModelPart bone;

    public TargetDummyModel() {
        textureWidth = 64;
        textureHeight = 64;

        bone = new ModelPart(this);
        bone.pivotY = -.3f;
        bone.setPivot(0.0F, 24.0F, 0.0F);

        bone.addCuboid("bone1", -4, -10, -1, 2, 9, 2, 0, 8, 31);
        bone.addCuboid("bone2", 2, -10, -1, 2, 9, 2, 0, 0, 31);
        bone.addCuboid("bone3", -4, -23, -1.5f, 8, 13, 3, 0, 0, 15);
        bone.addCuboid("bone4", -3, -29, -2, 6, 6, 4, 0, 22, 15);
        bone.addCuboid("bone5", -7, -21, -1, 3, 2, 2, 0, 16, 35);
        bone.addCuboid("bone6", 4, -21, -1, 3, 2, 2, 0, 16, 31);
        bone.addCuboid("bone7", -7, -1, -7, 14, 1, 14, 0, 0, 0);
    }

    @Override
    public void setAngles(TargetDummyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        bone.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
