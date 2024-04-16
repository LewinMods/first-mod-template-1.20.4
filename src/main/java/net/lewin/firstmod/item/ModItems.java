package net.lewin.firstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lewin.firstmod.FirstMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings().fireproof()));
    //public static final Item RUBY_BLOCK = registerItem("ruby_block", new Item(new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        //entries.add(RUBY_BLOCK);

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),item);
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Mod Items for " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
