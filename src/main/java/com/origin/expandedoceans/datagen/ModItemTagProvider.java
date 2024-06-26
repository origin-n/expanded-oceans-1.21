package com.origin.expandedoceans.datagen;

import com.origin.expandedoceans.block.ModBlocks;
import com.origin.expandedoceans.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.FabricTagKey;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> SAPPHIRE = TagKey.of(RegistryKeys.ITEM, Identifier.of("c:sapphire"));
    public static final TagKey<Item> GEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c:gems"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(SAPPHIRE)
                .add(ModItems.SAPPHIRE)
        ;

        getOrCreateTagBuilder(GEMS)
                .add(ModItems.SAPPHIRE)
        ;

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.WATER_MAPLE_PLANKS.asItem())
                .add(ModBlocks.OCEAN_WILLOW_PLANKS.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.WATER_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_WATER_MAPLE_LOG.asItem())
                .add(ModBlocks.WATER_MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_WATER_MAPLE_WOOD.asItem())

                .add(ModBlocks.OCEAN_WILLOW_LOG.asItem())
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG.asItem())
                .add(ModBlocks.OCEAN_WILLOW_WOOD.asItem())
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD.asItem())
        ;

    }
}
