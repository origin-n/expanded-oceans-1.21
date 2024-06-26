package com.origin.expandedoceans.block.custom;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.util.math.random.Random;

import static net.minecraft.state.property.Properties.WATERLOGGED;

public class WaterMapleSaplingBlock extends SaplingBlock {
    public WaterMapleSaplingBlock(SaplingGenerator generator) {
        super(generator, AbstractBlock.Settings.create()
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .ticksRandomly());
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (world.getBlockState(pos).isOf(Blocks.WATER)) {
            super.grow(world, random, pos, state);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isIn(BlockTags.SAND) || blockState.isOf(Blocks.GRAVEL) || blockState.isOf(Blocks.WATER);

    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidState = context.getWorld().getFluidState(context.getBlockPos());
        return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }
}
