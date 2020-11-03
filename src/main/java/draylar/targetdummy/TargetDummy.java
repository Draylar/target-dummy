package draylar.targetdummy;

import draylar.targetdummy.entity.TargetDummyEntity;
import draylar.targetdummy.item.TargetDummyItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class TargetDummy implements ModInitializer {

	public static final EntityType<TargetDummyEntity> TARGET_DUMMY = FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, (EntityType.EntityFactory<TargetDummyEntity>) TargetDummyEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();
	public static Item targetDummyItem = Registry.register(Registry.ITEM, "target-dummy:target_dummy", new TargetDummyItem(new Item.Settings().group(ItemGroup.TOOLS)));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ENTITY_TYPE, "target-dummy:target_dummy", TARGET_DUMMY);

		FabricDefaultAttributeRegistry.register(TARGET_DUMMY, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1));
	}
}
