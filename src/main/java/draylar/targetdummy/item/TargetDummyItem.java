package draylar.targetdummy.item;

import draylar.targetdummy.TargetDummy;
import draylar.targetdummy.entity.TargetDummyEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class TargetDummyItem extends Item {

    public TargetDummyItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            PlayerEntity playerEntity = context.getPlayer();
            BlockPos blockPos = context.getBlockPos();

            // set entity settings
            TargetDummyEntity targetDummy = TargetDummy.TARGET_DUMMY.create(context.getWorld());
            targetDummy.setPos(Math.floor(blockPos.getX()) + .5, Math.floor(blockPos.getY()) + 1, Math.floor(blockPos.getZ()) + .5);
            targetDummy.setHeadYaw(playerEntity.getHeadYaw() + 180);
            if (targetDummy.getHeadYaw() > 180)
                targetDummy.setHeadYaw(targetDummy.getHeadYaw() - 360);

            // spawn entity
            context.getWorld().spawnEntity(targetDummy);

            // remove item
            int index = playerEntity.inventory.selectedSlot;
            ItemStack currentStack = context.getStack();
            currentStack.setCount(currentStack.getCount() - 1);
            playerEntity.inventory.main.set(index, currentStack);
        }

        return super.useOnBlock(context);
    }
}