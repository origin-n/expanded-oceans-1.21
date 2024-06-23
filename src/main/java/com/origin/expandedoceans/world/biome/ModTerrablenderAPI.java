package com.origin.expandedoceans.world.biome;

import com.origin.expandedoceans.ExpandedOceans;
import com.origin.expandedoceans.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(ExpandedOceans.MOD_ID, "overworld"), RegionType.OVERWORLD , 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ExpandedOceans.MOD_ID, ModMaterialRules.makeRules());

    }
}
