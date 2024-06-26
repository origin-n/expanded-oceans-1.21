package com.origin.expandedoceans;

import com.origin.expandedoceans.block.ModBlocks;
import com.origin.expandedoceans.item.ModItems;
import com.origin.expandedoceans.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandedOceans implements ModInitializer {
	public static final String MOD_ID = "expandedoceans";
    public static final Logger LOGGER = LoggerFactory.getLogger("expandedoceans");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Ocean world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		StrippableBlockRegistry.register(ModBlocks.WATER_MAPLE_LOG, ModBlocks.STRIPPED_WATER_MAPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.WATER_MAPLE_WOOD, ModBlocks.STRIPPED_WATER_MAPLE_WOOD);

		ModWorldGeneration.generateModWorldGen();

	}
}