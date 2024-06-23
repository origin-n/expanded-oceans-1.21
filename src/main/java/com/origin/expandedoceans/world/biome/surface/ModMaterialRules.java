package com.origin.expandedoceans.world.biome.surface;

import com.origin.expandedoceans.block.ModBlocks;
import com.origin.expandedoceans.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule MUD = makeStateRule(Blocks.MUD);
    private static final MaterialRules.MaterialRule SLUDGE_BLOCK = makeStateRule(ModBlocks.SLUDGE_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.MUDDY_BEACH),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, MUD)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, SLUDGE_BLOCK)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
