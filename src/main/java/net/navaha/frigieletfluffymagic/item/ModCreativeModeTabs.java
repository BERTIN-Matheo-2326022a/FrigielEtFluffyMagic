package net.navaha.frigieletfluffymagic.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.navaha.frigieletfluffymagic.FrigielEtFluffyMagic;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FrigielEtFluffyMagic.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAGIC_TAB = CREATIVE_MODE_TABS.register("magic_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WATER_ESSENCE.get()))
                    .title(Component.translatable("creativetab.magic_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.WATER_ESSENCE.get());
                        output.accept(ModItems.FIRE_ESSENCE.get());
                        output.accept(ModItems.EARTH_ESSENCE.get());
                        output.accept(ModItems.PLANT_ESSENCE.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
