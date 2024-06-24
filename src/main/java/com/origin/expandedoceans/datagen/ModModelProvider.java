package com.origin.expandedoceans.datagen;

import com.origin.expandedoceans.block.ModBlocks;
import com.origin.expandedoceans.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SLUDGE_BLOCK);

        blockStateModelGenerator.registerSingleton(ModBlocks.RED_SEAGRASS, TexturedModel.TEMPLATE_SEAGRASS);

        blockStateModelGenerator.registerLog(ModBlocks.WATER_MAPLE_LOG).log(ModBlocks.WATER_MAPLE_LOG).wood(ModBlocks.WATER_MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_WATER_MAPLE_LOG).log(ModBlocks.STRIPPED_WATER_MAPLE_LOG).wood(ModBlocks.STRIPPED_WATER_MAPLE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WATER_MAPLE_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WATER_MAPLE_PLANKS);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SLUDGE, Models.GENERATED);


    }
}
