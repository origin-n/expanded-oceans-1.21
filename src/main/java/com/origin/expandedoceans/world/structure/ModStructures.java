package com.origin.expandedoceans.world.structure;

import com.origin.expandedoceans.ExpandedOceans;
import com.origin.expandedoceans.world.structure.structures.SkyStructures;
import com.origin.expandedoceans.world.structure.structures.TreeStructures;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;

public class ModStructures {

    public static StructureType<TreeStructures> TREE_STRUCTURES;
    public static StructureType<SkyStructures> SKY_STRUCTURES;

    public static void registerStructureFeatures(){
        TREE_STRUCTURES = Registry.register(Registries.STRUCTURE_TYPE, Identifier.of(ExpandedOceans.MOD_ID, "tree_structures"), () -> TreeStructures.CODEC);
        SKY_STRUCTURES = Registry.register(Registries.STRUCTURE_TYPE, Identifier.of(ExpandedOceans.MOD_ID, "sky_structures"), () -> SkyStructures.CODEC);
    }


}
