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
    private static final List<ItemConvertible> SAPPHIRE_SMELTABLE = List.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter,SAPPHIRE_SMELTABLE, RecipeCategory.MISC, ModItems.SAPPHIRE, 200, 200, "SAPPHIRE");
        offerBlasting(exporter,SAPPHIRE_SMELTABLE, RecipeCategory.MISC, ModItems.SAPPHIRE, 200, 100, "SAPPHIRE");

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.diamond, RecipeCategory.DECORATIONS, ModBlocks.diamond_block);
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SLUDGE, ModBlocks.SLUDGE_BLOCK);

        offerShapelessRecipe(exporter, ModBlocks.WATER_MAPLE_PLANKS, ModBlocks.WATER_MAPLE_LOG, "water_maple", 4);
        offerShapelessRecipe(exporter, ModBlocks.WATER_MAPLE_PLANKS, ModBlocks.WATER_MAPLE_WOOD, "water_maple", 4);
        offerShapelessRecipe(exporter, ModBlocks.WATER_MAPLE_PLANKS, ModBlocks.STRIPPED_WATER_MAPLE_LOG, "water_maple", 4);
        offerShapelessRecipe(exporter, ModBlocks.WATER_MAPLE_PLANKS, ModBlocks.STRIPPED_WATER_MAPLE_WOOD, "water_maple", 4);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WATER_MAPLE_WOOD, 3)
                .pattern("SS")
                .pattern("SS")
                .input('S', ModBlocks.WATER_MAPLE_LOG)
                .criterion(hasItem(ModBlocks.WATER_MAPLE_LOG), conditionsFromItem(ModBlocks.WATER_MAPLE_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.WATER_MAPLE_WOOD)));

        offerShapelessRecipe(exporter, ModBlocks.OCEAN_WILLOW_PLANKS, ModBlocks.OCEAN_WILLOW_LOG, "ocean_willow", 4);
        offerShapelessRecipe(exporter, ModBlocks.OCEAN_WILLOW_PLANKS, ModBlocks.OCEAN_WILLOW_WOOD, "ocean_willow", 4);
        offerShapelessRecipe(exporter, ModBlocks.OCEAN_WILLOW_PLANKS, ModBlocks.STRIPPED_OCEAN_WILLOW_LOG, "ocean_willow", 4);
        offerShapelessRecipe(exporter, ModBlocks.OCEAN_WILLOW_PLANKS, ModBlocks.STRIPPED_OCEAN_WILLOW_WOOD, "ocean_willow", 4);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.OCEAN_WILLOW_WOOD, 3)
                .pattern("SS")
                .pattern("SS")
                .input('S', ModBlocks.OCEAN_WILLOW_LOG)
                .criterion(hasItem(ModBlocks.OCEAN_WILLOW_LOG), conditionsFromItem(ModBlocks.OCEAN_WILLOW_LOG))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.OCEAN_WILLOW_WOOD)));


    }

}
