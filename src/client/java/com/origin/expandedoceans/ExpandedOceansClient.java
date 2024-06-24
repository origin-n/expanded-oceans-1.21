package com.origin.expandedoceans;

import com.origin.expandedoceans.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ExpandedOceansClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_SEAGRASS, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WATER_MAPLE_LEAVES, RenderLayer.getTranslucent());
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}

}