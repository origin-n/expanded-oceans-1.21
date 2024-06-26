package com.origin.expandedoceans.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import com.origin.expandedoceans.ExpandedOceans;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SLUDGE_BLOCK = registerBlock("sludge_block",
            new Block(FabricBlockSettings.copyOf(Blocks.MUD).sounds(BlockSoundGroup.MUD)));

    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE)));

    public static final Block RED_SEAGRASS = registerBlock("red_seagrass",
            new SeagrassBlock(FabricBlockSettings.create().nonOpaque().sounds(BlockSoundGroup.GRASS).notSolid().noCollision()));
    public static final Block RED_SEAGRASS_TOP = registerBlock("red_seagrass_top",
            new SeagrassBlock(FabricBlockSettings.copyOf(Blocks.SEAGRASS).nonOpaque()));
    public static final Block RED_SEAGRASS_BOTTOM = registerBlock("red_seagrass_bottom",
            new SeagrassBlock(FabricBlockSettings.copyOf(Blocks.SEAGRASS).nonOpaque()));

    public static final Block WATER_MAPLE_LOG = registerBlock("water_maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD)));
    public static final Block WATER_MAPLE_WOOD = registerBlock("water_maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_WATER_MAPLE_LOG = registerBlock("stripped_water_maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_WATER_MAPLE_WOOD = registerBlock("stripped_water_maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).sounds(BlockSoundGroup.WOOD)));

    public static final Block WATER_MAPLE_PLANKS = registerBlock("water_maple_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD)));
    public static final Block WATER_MAPLE_LEAVES = registerBlock("water_maple_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()));

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