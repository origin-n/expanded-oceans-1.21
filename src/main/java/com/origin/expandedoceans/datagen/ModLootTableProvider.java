package com.origin.expandedoceans.datagen;

import com.origin.expandedoceans.block.ModBlocks;
import com.origin.expandedoceans.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SLUDGE_BLOCK);

        addDrop(ModBlocks.WATER_MAPLE_LOG);
        addDrop(ModBlocks.WATER_MAPLE_WOOD);
        addDrop(ModBlocks.STRIPPED_WATER_MAPLE_LOG);
        addDrop(ModBlocks.STRIPPED_WATER_MAPLE_WOOD);
        addDrop(ModBlocks.WATER_MAPLE_PLANKS);
        addDrop(ModBlocks.WATER_MAPLE_SAPLING);

        addDrop(ModBlocks.WATER_MAPLE_LEAVES, leavesDrops(ModBlocks.WATER_MAPLE_LEAVES, ModBlocks.WATER_MAPLE_SAPLING, 0.05f));
        addDrop(ModBlocks.WATER_MAPLE_LEAVES, leavesDrops(ModBlocks.WATER_MAPLE_LEAVES, ModBlocks.RED_SEAGRASS, 0.05f));

        addDrop(ModBlocks.OCEAN_WILLOW_LOG);
        addDrop(ModBlocks.OCEAN_WILLOW_WOOD);
        addDrop(ModBlocks.STRIPPED_OCEAN_WILLOW_LOG);
        addDrop(ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD);
        addDrop(ModBlocks.OCEAN_WILLOW_PLANKS);
        addDrop(ModBlocks.OCEAN_WILLOW_SAPLING);

        addDrop(ModBlocks.OCEAN_WILLOW_LEAVES, leavesDrops(ModBlocks.OCEAN_WILLOW_LEAVES, ModBlocks.OCEAN_WILLOW_SAPLING, 0.05f));

        addDrop(ModBlocks.SAPPHIRE_ORE, oreDrops(ModBlocks.SAPPHIRE_ORE, ModItems.SAPPHIRE));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, oreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.SAPPHIRE));
        //addDrop(ModBlocks.block, copperLikeOreDrops(ModBlocks.block, ModItems.item drop));

    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

}
