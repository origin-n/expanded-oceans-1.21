package com.origin.expandedoceans;

import com.origin.expandedoceans.block.ModBlocks;
import com.origin.expandedoceans.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandedOceans implements ModInitializer {
	public static final String MOD_ID = "expandedoceans";
    public static final Logger LOGGER = LoggerFactory.getLogger("expandedoceans");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}