package com.origin.expandedoceans.world.biome.customfeatures;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class WaterTreeFeature extends TreeFeature {
    public WaterTreeFeature(Codec<TreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public static boolean canReplace(TestableWorld world, BlockPos pos) {
        return world.testBlockState(pos, (state) -> {
            return state.isAir() || state.isOf(Blocks.WATER);
        });
    }
}
