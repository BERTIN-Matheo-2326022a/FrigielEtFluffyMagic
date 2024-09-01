package net.navaha.frigieletfluffymagic.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.navaha.frigieletfluffymagic.FrigielEtFluffyMagic;
import net.navaha.frigieletfluffymagic.item.essences.EarthEssenceItem;
import net.navaha.frigieletfluffymagic.item.essences.FireEssenceItem;
import net.navaha.frigieletfluffymagic.item.essences.PlantEssenceItem;
import net.navaha.frigieletfluffymagic.item.essences.WaterEssenceItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrigielEtFluffyMagic.MOD_ID);

    public static final RegistryObject<Item> FIRE_ESSENCE = ITEMS.register("fire_essence", () -> new FireEssenceItem(new Item.Properties()));

    public static final RegistryObject<Item> WATER_ESSENCE = ITEMS.register("water_essence", () -> new WaterEssenceItem(new Item.Properties()));

    public static final RegistryObject<Item> EARTH_ESSENCE = ITEMS.register("earth_essence", () -> new EarthEssenceItem(new Item.Properties()));

    public static final RegistryObject<Item> PLANT_ESSENCE = ITEMS.register("plant_essence", () -> new PlantEssenceItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
