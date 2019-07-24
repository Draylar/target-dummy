package com.github.draylar.targetdummy.entity;

import com.github.draylar.targetdummy.TargetDummy;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TargetDummyEntity extends MobEntity
{
    public TargetDummyEntity(EntityType type, World world_1)
    {
        super(TargetDummy.TARGET_DUMMY, world_1);
        setAiDisabled(true);
        setCanPickUpLoot(false);
    }

    public TargetDummyEntity(World world_1)
    {
        super(TargetDummy.TARGET_DUMMY, world_1);
        setAiDisabled(true);
        setCanPickUpLoot(false);
    }

    @Override
    protected void initAttributes()
    {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1);
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    protected void applyDamage(DamageSource damageSource_1, float float_1)
    {
        String newName = String.format("%.0f", float_1);
        this.setCustomName(new LiteralText(newName));
    }

    @Override
    protected boolean interactMob(PlayerEntity playerEntity_1, Hand hand_1)
    {
        // kill entity & drop summon item
        if(playerEntity_1.isSneaking())
        {
            ItemEntity itemEntity = new ItemEntity(world, this.getPos().getX() + .5, this.getPos().getY() + .5, this.getPos().getZ() + .5);
            itemEntity.setStack(new ItemStack(TargetDummy.targetDummyItem));
            itemEntity.setVelocity(new Vec3d(0, 0, 0));
            world.spawnEntity(itemEntity);

            this.kill();
        }

        return super.interactMob(playerEntity_1, hand_1);
    }

    @Override
    public void kill()
    {
        this.setPosition(this.getPos().getX(), -50, this.getPos().getZ());
        this.damage(DamageSource.GENERIC, 3.4028235E38F);
    }

    @Override
    protected void mobTick()
    {
        super.mobTick();
    }
}
