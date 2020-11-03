package draylar.targetdummy.entity;

import draylar.targetdummy.TargetDummy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TargetDummyEntity extends MobEntity {

    public TargetDummyEntity(EntityType type, World world) {
        super(TargetDummy.TARGET_DUMMY, world);
        setAiDisabled(true);
        setCanPickUpLoot(false);
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    public void pushAwayFrom(Entity entity) {

    }

    @Override
    public void pushAway(Entity entity) {

    }

    @Override
    public void applyDamage(DamageSource damageSource_1, float float_1) {
        String newName = String.format("%.0f", float_1);
        this.setCustomName(new LiteralText(newName));
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        // kill entity & drop summon item
        if (player.isSneaking()) {
            ItemEntity itemEntity = new ItemEntity(world, this.getPos().getX() + .5, this.getPos().getY() + .5, this.getPos().getZ() + .5);
            itemEntity.setStack(new ItemStack(TargetDummy.targetDummyItem));
            itemEntity.setVelocity(new Vec3d(0, 0, 0));
            world.spawnEntity(itemEntity);

            this.kill();
        }

        return super.interactMob(player, hand);
    }

    @Override
    public void kill() {
        this.setPos(this.getPos().getX(), -50, this.getPos().getZ());
        this.damage(DamageSource.GENERIC, 3.4028235E38F);
    }

    @Override
    public void mobTick() {
        super.mobTick();
    }
}
