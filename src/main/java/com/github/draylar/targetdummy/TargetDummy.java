package com.github.draylar.targetdummy;

import com.github.draylar.targetdummy.entity.TargetDummyEntity;
import com.github.draylar.targetdummy.item.TargetDummyItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class TargetDummy implements ModInitializer
{
	public static final EntityType<TargetDummyEntity> TARGET_DUMMY = FabricEntityTypeBuilder.create(EntityCategory.AMBIENT, (EntityType.EntityFactory<TargetDummyEntity>) TargetDummyEntity::new).size(EntityDimensions.fixed(1, 2)).build();
	public static Item targetDummyItem;

	@Override
	public void onInitialize() {
		Registry.register(Registry.ENTITY_TYPE, "target-dummy:target_dummy", TARGET_DUMMY);
		targetDummyItem = Registry.register(Registry.ITEM, "target-dummy:target_dummy", new TargetDummyItem(new Item.Settings().group(ItemGroup.TOOLS)));
	}
}
