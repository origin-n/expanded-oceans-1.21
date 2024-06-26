package com.origin.expandedoceans.world.biome.customfeatures;

import com.mojang.serialization.Codec;
import com.origin.expandedoceans.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class RedSeagrassFeature extends Feature<DefaultFeatureConfig> {
    public RedSeagrassFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {

        BlockPos pos = context.getOrigin();
        ServerWorldAccess world = context.getWorld();
        Random random = context.getRandom();

        if (world.getFluidState(pos).isIn(FluidTags.WATER)) {
            BlockPos plantPos = pos.down();
            if (world.getBlockState(plantPos).isOf(Blocks.WATER)) {
                world.setBlockState(plantPos, ModBlocks.RED_SEAGRASS.getDefaultState(), 3);
                return true;
            }
        }
        return false;
    }
}

