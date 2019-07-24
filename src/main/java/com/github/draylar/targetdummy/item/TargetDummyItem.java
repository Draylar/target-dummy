package com.github.draylar.targetdummy.item;

import com.github.draylar.targetdummy.TargetDummy;
import com.github.draylar.targetdummy.entity.TargetDummyEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class TargetDummyItem extends Item
{
    public TargetDummyItem(Settings item$Settings_1)
    {
        super(item$Settings_1);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1)
    {
        if(!itemUsageContext_1.getWorld().isClient)
        {
            PlayerEntity playerEntity = itemUsageContext_1.getPlayer();
            BlockPos blockPos = itemUsageContext_1.getBlockPos();


            // set entity settings
            TargetDummyEntity targetDummyEntity = TargetDummy.TARGET_DUMMY.create(itemUsageContext_1.getWorld());
            targetDummyEntity.setPosition(Math.floor(blockPos.getX()) + .5, Math.floor(blockPos.getY()) + 1, Math.floor(blockPos.getZ()) + .5);
            targetDummyEntity.setHeadYaw(playerEntity.getHeadYaw() + 180);
            if(targetDummyEntity.getHeadYaw() > 180) targetDummyEntity.setHeadYaw(targetDummyEntity.getHeadYaw() - 360);


            // spawn entity
            itemUsageContext_1.getWorld().spawnEntity(targetDummyEntity);


            // remove item
            int index = playerEntity.inventory.selectedSlot;
            ItemStack currentStack = itemUsageContext_1.getStack();
            currentStack.setCount(currentStack.getCount() - 1);
            playerEntity.inventory.main.set(index, currentStack);
        }

        return super.useOnBlock(itemUsageContext_1);
    }
}
