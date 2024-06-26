package com.origin.expandedoceans.datagen;

import com.origin.expandedoceans.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        getOrCreateTagBuilder(ModTags.Block.tag)
//                .add(ModBlocks.block);
//                .forceAddTag(BlockTags.GOLD_ORES)
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.WATER_MAPLE_PLANKS)
                .add(ModBlocks.WATER_MAPLE_LOG)
                .add(ModBlocks.WATER_MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_WATER_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_WATER_MAPLE_WOOD)

                .add(ModBlocks.OCEAN_WILLOW_PLANKS)
                .add(ModBlocks.OCEAN_WILLOW_LOG)
                .add(ModBlocks.OCEAN_WILLOW_WOOD)
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG)
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD)
        ;

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);
        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.WATER_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_WATER_MAPLE_LOG)
                .add(ModBlocks.WATER_MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_WATER_MAPLE_WOOD)

                .add(ModBlocks.OCEAN_WILLOW_LOG)
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG)
                .add(ModBlocks.OCEAN_WILLOW_WOOD)
                .add(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD)
        ;

    }
}
