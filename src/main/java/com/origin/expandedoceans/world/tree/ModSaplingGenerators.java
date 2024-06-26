package com.origin.expandedoceans.world.tree;

import com.origin.expandedoceans.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator WATER_MAPLE =
            new SaplingGenerator("water_maple", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.WATER_MAPLE_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

    public static final SaplingGenerator OCEAN_WILLOW =
            new SaplingGenerator("water_maple", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.OCEAN_WILLOW_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

}