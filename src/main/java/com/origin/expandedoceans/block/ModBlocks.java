package com.origin.expandedoceans.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import com.origin.expandedoceans.ExpandedOceans;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SLUDGE_BLOCK = registerBlock("sludge_block",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD).sounds(BlockSoundGroup.MUD)));
    
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ExpandedOceans.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(ExpandedOceans.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ExpandedOceans.LOGGER.info("Registering ModBlocks for " + ExpandedOceans.MOD_ID);
    }
}