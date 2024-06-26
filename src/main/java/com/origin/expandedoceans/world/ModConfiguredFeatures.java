package com.origin.expandedoceans.world;

import com.origin.expandedoceans.ExpandedOceans;
import com.origin.expandedoceans.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> WATER_MAPLE_KEY = registerKey("water_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OCEAN_WILLOW_KEY = registerKey("ocean_willow");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSapphireOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState()));

        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 4));

        register(context, WATER_MAPLE_KEY, TreeFeature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.WATER_MAPLE_LOG),
                new StraightTrunkPlacer(3, 1, 2),

                BlockStateProvider.of(ModBlocks.WATER_MAPLE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1),2),

                new TwoLayersFeatureSize(1, 0, 1))
                .dirtProvider(BlockStateProvider.of(Blocks.GRAVEL))
                .build());

        register(context, OCEAN_WILLOW_KEY, TreeFeature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.OCEAN_WILLOW_LOG),
                new StraightTrunkPlacer(3, 1, 2),

                BlockStateProvider.of(ModBlocks.OCEAN_WILLOW_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1),2),

                new TwoLayersFeatureSize(1, 0, 1))
                .dirtProvider(BlockStateProvider.of(Blocks.GRAVEL))
                .build());

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ExpandedOceans.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }



}
