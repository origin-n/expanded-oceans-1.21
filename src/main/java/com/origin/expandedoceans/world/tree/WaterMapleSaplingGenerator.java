package com.origin.expandedoceans.world.tree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class WaterMapleSaplingGenerator extends SaplingBlock {
    public WaterMapleSaplingGenerator(Block.Settings settings){
        super(new WaterMapleSaplingGenerator(), settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random){
        if (!world.isClient) {
            super.randomTick(state, world, pos, random);
            if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(7) == 0) {
                this.generate(world, pos, state, random);
            }
        }
    }

    private void generate(WorldAccess world, BlockPos pos, BlockState state, Random random){

    }
}
