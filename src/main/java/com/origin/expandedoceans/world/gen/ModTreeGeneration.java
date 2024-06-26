package com.origin.expandedoceans.world.gen;

import com.origin.expandedoceans.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_COLD_OCEAN),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OCEAN_WILLOW_PLACED_KEY);
    }
}
