package com.origin.expandedoceans.item;

import com.origin.expandedoceans.ExpandedOceans;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public  static final Item SLUDGE = registerItem("sludge", new Item(new Item.Settings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(SLUDGE);
    }


    private  static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExpandedOceans.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ExpandedOceans.LOGGER.info("Registering Mod Items for " + ExpandedOceans.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
