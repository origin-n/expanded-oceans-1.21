package com.origin.expandedoceans.datagen;

import com.origin.expandedoceans.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.WATER_MAPLE_PLANKS.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.WATER_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_WATER_MAPLE_LOG.asItem())
                .add(ModBlocks.WATER_MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_WATER_MAPLE_WOOD.asItem())
        ;

    }
}
