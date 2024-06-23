package com.origin.expandedoceans.datagen;

import com.origin.expandedoceans.block.ModBlocks;
import com.origin.expandedoceans.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    //private static List<ItemConvertible> X_SMELTABLE = List.of(ModItems.raw_item, ModBlocks.raw_ore)
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //offerSmelting(exporter,X_SMELTABLE, RecipeCategory.MISC, ModItems.processedItem, exp, time, group"X_Result");
        //offerBlasting(exporter,X_SMELTABLE, RecipeCategory.MISC, ModItems.processedItem, exp, time, group"X_Result");

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.diamond, RecipeCategory.DECORATIONS, ModBlocks.diamond_block);
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SLUDGE, ModBlocks.SLUDGE_BLOCK);


    }

}
