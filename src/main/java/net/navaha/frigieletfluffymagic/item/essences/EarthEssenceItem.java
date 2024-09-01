package net.navaha.frigieletfluffymagic.item.essences;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.injection.struct.InjectorGroupInfo;

import java.util.*;

public class EarthEssenceItem extends Item {

    protected List<Block> earthEssenceBreakableBlocks = Arrays.asList(
            Blocks.AMETHYST_CLUSTER,
            Blocks.AMETHYST_BLOCK,
            Blocks.ANCIENT_DEBRIS,
            Blocks.ANDESITE,
            Blocks.ANDESITE_SLAB,
            Blocks.ANDESITE_STAIRS,
            Blocks.ANDESITE_WALL,
            Blocks.ANVIL,
            Blocks.BASALT,
            Blocks.BEACON,
            Blocks.BLACK_CONCRETE,
            Blocks.BLACK_CONCRETE_POWDER,
            Blocks.BLACK_GLAZED_TERRACOTTA,
            Blocks.BLACK_STAINED_GLASS,
            Blocks.BLACK_STAINED_GLASS_PANE,
            Blocks.BLACK_TERRACOTTA,
            Blocks.BLACKSTONE,
            Blocks.BLACKSTONE_SLAB,
            Blocks.BLACKSTONE_STAIRS,
            Blocks.BLACKSTONE_WALL,
            Blocks.BLAST_FURNACE,
            Blocks.BLUE_CONCRETE,
            Blocks.BLUE_CONCRETE_POWDER,
            Blocks.BLUE_GLAZED_TERRACOTTA,
            Blocks.BLUE_STAINED_GLASS,
            Blocks.BLUE_STAINED_GLASS_PANE,
            Blocks.BLUE_TERRACOTTA,
            Blocks.BONE_BLOCK,
            Blocks.BRICK_SLAB,
            Blocks.BRICK_STAIRS,
            Blocks.BRICK_WALL,
            Blocks.BRICKS,
            Blocks.BROWN_CONCRETE,
            Blocks.BROWN_CONCRETE_POWDER,
            Blocks.BROWN_GLAZED_TERRACOTTA,
            Blocks.BROWN_STAINED_GLASS,
            Blocks.BROWN_STAINED_GLASS_PANE,
            Blocks.BROWN_TERRACOTTA,
            Blocks.BUDDING_AMETHYST,
            Blocks.CALCITE,
            Blocks.CAULDRON,
            Blocks.CHAIN,
            Blocks.CHIPPED_ANVIL,
            Blocks.CHISELED_COPPER,
            Blocks.CHISELED_DEEPSLATE,
            Blocks.CHISELED_NETHER_BRICKS,
            Blocks.CHISELED_POLISHED_BLACKSTONE,
            Blocks.CHISELED_QUARTZ_BLOCK,
            Blocks.CHISELED_RED_SANDSTONE,
            Blocks.CHISELED_SANDSTONE,
            Blocks.CHISELED_STONE_BRICKS,
            Blocks.CHISELED_TUFF,
            Blocks.CHISELED_TUFF_BRICKS,
            Blocks.CLAY,
            Blocks.COAL_BLOCK,
            Blocks.COAL_ORE,
            Blocks.COARSE_DIRT,
            Blocks.COBBLED_DEEPSLATE,
            Blocks.COBBLED_DEEPSLATE_SLAB,
            Blocks.COBBLED_DEEPSLATE_STAIRS,
            Blocks.COBBLED_DEEPSLATE_WALL,
            Blocks.COBBLESTONE,
            Blocks.COBBLESTONE_SLAB,
            Blocks.COBBLESTONE_STAIRS,
            Blocks.COBBLESTONE_WALL,
            Blocks.COMPARATOR,
            Blocks.CONDUIT,
            Blocks.COPPER_BLOCK,
            Blocks.COPPER_BULB,
            Blocks.COPPER_DOOR,
            Blocks.COPPER_GRATE,
            Blocks.COPPER_ORE,
            Blocks.COPPER_TRAPDOOR,
            Blocks.CRACKED_DEEPSLATE_BRICKS,
            Blocks.CRACKED_DEEPSLATE_TILES,
            Blocks.CRACKED_NETHER_BRICKS,
            Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS,
            Blocks.CRACKED_STONE_BRICKS,
            Blocks.CRYING_OBSIDIAN,
            Blocks.CUT_COPPER,
            Blocks.CUT_COPPER_SLAB,
            Blocks.CUT_COPPER_STAIRS,
            Blocks.CUT_RED_SANDSTONE,
            Blocks.CUT_RED_SANDSTONE_SLAB,
            Blocks.CUT_SANDSTONE,
            Blocks.CUT_SANDSTONE_SLAB,
            Blocks.CYAN_CONCRETE,
            Blocks.CYAN_CONCRETE_POWDER,
            Blocks.CYAN_GLAZED_TERRACOTTA,
            Blocks.CYAN_STAINED_GLASS,
            Blocks.CYAN_STAINED_GLASS_PANE,
            Blocks.CYAN_TERRACOTTA,
            Blocks.DAMAGED_ANVIL,
            Blocks.DARK_PRISMARINE,
            Blocks.DARK_PRISMARINE_SLAB,
            Blocks.DARK_PRISMARINE_STAIRS,
            Blocks.DECORATED_POT,
            Blocks.DEEPSLATE,
            Blocks.DEEPSLATE_BRICKS,
            Blocks.DEEPSLATE_BRICK_SLAB,
            Blocks.DEEPSLATE_BRICK_STAIRS,
            Blocks.DEEPSLATE_BRICK_WALL,
            Blocks.DEEPSLATE_COAL_ORE,
            Blocks.DEEPSLATE_COPPER_ORE,
            Blocks.DEEPSLATE_DIAMOND_ORE,
            Blocks.DEEPSLATE_EMERALD_ORE,
            Blocks.DEEPSLATE_GOLD_ORE,
            Blocks.DEEPSLATE_IRON_ORE,
            Blocks.DEEPSLATE_LAPIS_ORE,
            Blocks.DEEPSLATE_REDSTONE_ORE,
            Blocks.DEEPSLATE_TILES,
            Blocks.DEEPSLATE_TILE_SLAB,
            Blocks.DEEPSLATE_TILE_STAIRS,
            Blocks.DEEPSLATE_TILE_WALL,
            Blocks.DIAMOND_BLOCK,
            Blocks.DIAMOND_ORE,
            Blocks.DIORITE,
            Blocks.DIORITE_SLAB,
            Blocks.DIORITE_STAIRS,
            Blocks.DIORITE_WALL,
            Blocks.DIRT,
            Blocks.DIRT_PATH,
            Blocks.DISPENSER,
            Blocks.DRIPSTONE_BLOCK,
            Blocks.DROPPER,
            Blocks.EMERALD_BLOCK,
            Blocks.EMERALD_ORE,
            Blocks.ENCHANTING_TABLE,
            Blocks.END_ROD,
            Blocks.END_STONE,
            Blocks.END_STONE_BRICK_SLAB,
            Blocks.END_STONE_BRICK_STAIRS,
            Blocks.END_STONE_BRICK_WALL,
            Blocks.END_STONE_BRICKS,
            Blocks.ENDER_CHEST,
            Blocks.EXPOSED_CHISELED_COPPER,
            Blocks.EXPOSED_COPPER,
            Blocks.EXPOSED_COPPER_BULB,
            Blocks.EXPOSED_COPPER_DOOR,
            Blocks.EXPOSED_COPPER_GRATE,
            Blocks.EXPOSED_COPPER_TRAPDOOR,
            Blocks.EXPOSED_CUT_COPPER,
            Blocks.EXPOSED_CUT_COPPER_SLAB,
            Blocks.EXPOSED_CUT_COPPER_STAIRS,
            Blocks.FARMLAND,
            Blocks.FURNACE,
            Blocks.GILDED_BLACKSTONE,
            Blocks.GLASS,
            Blocks.GLASS_PANE,
            Blocks.GLOWSTONE,
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_ORE,
            Blocks.GRANITE,
            Blocks.GRANITE_SLAB,
            Blocks.GRANITE_STAIRS,
            Blocks.GRANITE_WALL,
            Blocks.GRASS_BLOCK,
            Blocks.GRAVEL,
            Blocks.GRAY_CONCRETE,
            Blocks.GRAY_CONCRETE_POWDER,
            Blocks.GRAY_GLAZED_TERRACOTTA,
            Blocks.GRAY_STAINED_GLASS,
            Blocks.GRAY_STAINED_GLASS_PANE,
            Blocks.GRAY_TERRACOTTA,
            Blocks.GREEN_CONCRETE,
            Blocks.GREEN_CONCRETE_POWDER,
            Blocks.GREEN_GLAZED_TERRACOTTA,
            Blocks.GREEN_STAINED_GLASS,
            Blocks.GREEN_STAINED_GLASS_PANE,
            Blocks.GRINDSTONE,
            Blocks.HOPPER,
            Blocks.INFESTED_CHISELED_STONE_BRICKS,
            Blocks.INFESTED_COBBLESTONE,
            Blocks.INFESTED_CRACKED_STONE_BRICKS,
            Blocks.INFESTED_DEEPSLATE,
            Blocks.INFESTED_MOSSY_STONE_BRICKS,
            Blocks.INFESTED_STONE,
            Blocks.INFESTED_STONE_BRICKS,
            Blocks.IRON_BARS,
            Blocks.IRON_BLOCK,
            Blocks.IRON_DOOR,
            Blocks.IRON_ORE,
            Blocks.IRON_TRAPDOOR,
            Blocks.LAPIS_BLOCK,
            Blocks.LAPIS_ORE,
            Blocks.LARGE_AMETHYST_BUD,
            Blocks.LAVA_CAULDRON,
            Blocks.LIGHT_BLUE_CONCRETE,
            Blocks.LIGHT_BLUE_CONCRETE_POWDER,
            Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA,
            Blocks.LIGHT_BLUE_STAINED_GLASS,
            Blocks.LIGHT_BLUE_STAINED_GLASS_PANE,
            Blocks.LIGHT_BLUE_TERRACOTTA,
            Blocks.LIGHT_GRAY_CONCRETE,
            Blocks.LIGHT_GRAY_CONCRETE_POWDER,
            Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
            Blocks.LIGHT_GRAY_STAINED_GLASS,
            Blocks.LIGHT_GRAY_STAINED_GLASS_PANE,
            Blocks.LIGHT_GRAY_TERRACOTTA,
            Blocks.LIME_CONCRETE,
            Blocks.LIME_CONCRETE_POWDER,
            Blocks.LIME_GLAZED_TERRACOTTA,
            Blocks.LIME_STAINED_GLASS,
            Blocks.LIME_STAINED_GLASS_PANE,
            Blocks.LIME_TERRACOTTA,
            Blocks.LODESTONE,
            Blocks.MAGENTA_CONCRETE,
            Blocks.MAGENTA_CONCRETE_POWDER,
            Blocks.MAGENTA_GLAZED_TERRACOTTA,
            Blocks.MAGENTA_STAINED_GLASS,
            Blocks.MAGENTA_STAINED_GLASS_PANE,
            Blocks.MAGENTA_TERRACOTTA,
            Blocks.MAGMA_BLOCK,
            Blocks.MEDIUM_AMETHYST_BUD,
            Blocks.SPAWNER,
            Blocks.MOSSY_COBBLESTONE,
            Blocks.MOSSY_COBBLESTONE_SLAB,
            Blocks.MOSSY_COBBLESTONE_STAIRS,
            Blocks.MOSSY_COBBLESTONE_WALL,
            Blocks.MOSSY_STONE_BRICK_SLAB,
            Blocks.MOSSY_STONE_BRICK_STAIRS,
            Blocks.MOSSY_STONE_BRICK_WALL,
            Blocks.MOSSY_STONE_BRICKS,
            Blocks.MUD,
            Blocks.MUD_BRICK_SLAB,
            Blocks.MUD_BRICK_STAIRS,
            Blocks.MUD_BRICK_WALL,
            Blocks.MUD_BRICKS,
            Blocks.MYCELIUM,
            Blocks.NETHER_BRICK_FENCE,
            Blocks.NETHER_BRICK_SLAB,
            Blocks.NETHER_BRICK_STAIRS,
            Blocks.NETHER_BRICK_WALL,
            Blocks.NETHER_BRICKS,
            Blocks.NETHER_GOLD_ORE,
            Blocks.NETHER_QUARTZ_ORE,
            Blocks.NETHERRACK,
            Blocks.OBSERVER,
            Blocks.OBSIDIAN,
            Blocks.OCHRE_FROGLIGHT,
            Blocks.ORANGE_CONCRETE,
            Blocks.ORANGE_CONCRETE_POWDER,
            Blocks.ORANGE_GLAZED_TERRACOTTA,
            Blocks.ORANGE_STAINED_GLASS,
            Blocks.ORANGE_STAINED_GLASS_PANE,
            Blocks.ORANGE_TERRACOTTA,
            Blocks.OXIDIZED_CHISELED_COPPER,
            Blocks.OXIDIZED_COPPER,
            Blocks.OXIDIZED_COPPER_BULB,
            Blocks.OXIDIZED_COPPER_DOOR,
            Blocks.OXIDIZED_COPPER_GRATE,
            Blocks.OXIDIZED_COPPER_TRAPDOOR,
            Blocks.OXIDIZED_CUT_COPPER,
            Blocks.OXIDIZED_CUT_COPPER_SLAB,
            Blocks.OXIDIZED_CUT_COPPER_STAIRS,
            Blocks.PACKED_MUD,
            Blocks.PEARLESCENT_FROGLIGHT,
            Blocks.PINK_CONCRETE,
            Blocks.PINK_CONCRETE_POWDER,
            Blocks.PINK_GLAZED_TERRACOTTA,
            Blocks.PINK_STAINED_GLASS,
            Blocks.PINK_STAINED_GLASS_PANE,
            Blocks.PINK_TERRACOTTA,
            Blocks.PISTON,
            Blocks.PODZOL,
            Blocks.POINTED_DRIPSTONE,
            Blocks.POLISHED_ANDESITE,
            Blocks.POLISHED_ANDESITE_SLAB,
            Blocks.POLISHED_ANDESITE_STAIRS,
            Blocks.POLISHED_BASALT,
            Blocks.POLISHED_BLACKSTONE,
            Blocks.POLISHED_BLACKSTONE_BRICK_SLAB,
            Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS,
            Blocks.POLISHED_BLACKSTONE_BRICK_WALL,
            Blocks.POLISHED_BLACKSTONE_BRICKS,
            Blocks.POLISHED_BLACKSTONE_BUTTON,
            Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE,
            Blocks.POLISHED_DIORITE,
            Blocks.POLISHED_DIORITE_SLAB,
            Blocks.POLISHED_DIORITE_STAIRS,
            Blocks.POLISHED_GRANITE,
            Blocks.POLISHED_GRANITE_SLAB,
            Blocks.POLISHED_GRANITE_STAIRS,
            Blocks.POLISHED_DEEPSLATE,
            Blocks.POLISHED_DEEPSLATE_SLAB,
            Blocks.POLISHED_DEEPSLATE_STAIRS,
            Blocks.POLISHED_DEEPSLATE_WALL,
            Blocks.POLISHED_TUFF_SLAB,
            Blocks.POLISHED_TUFF_STAIRS,
            Blocks.POLISHED_TUFF_WALL,
            Blocks.POWDER_SNOW_CAULDRON,
            Blocks.PRISMARINE,
            Blocks.PRISMARINE_BRICK_SLAB,
            Blocks.PRISMARINE_BRICK_STAIRS,
            Blocks.PRISMARINE_BRICKS,
            Blocks.PRISMARINE_SLAB,
            Blocks.PRISMARINE_STAIRS,
            Blocks.PURPLE_CONCRETE,
            Blocks.PURPLE_CONCRETE_POWDER,
            Blocks.PURPLE_GLAZED_TERRACOTTA,
            Blocks.PURPLE_STAINED_GLASS,
            Blocks.PURPLE_STAINED_GLASS_PANE,
            Blocks.PURPLE_TERRACOTTA,
            Blocks.PURPUR_BLOCK,
            Blocks.PURPUR_PILLAR,
            Blocks.PURPUR_SLAB,
            Blocks.PURPUR_STAIRS,
            Blocks.QUARTZ_BLOCK,
            Blocks.QUARTZ_BRICKS,
            Blocks.QUARTZ_PILLAR,
            Blocks.QUARTZ_SLAB,
            Blocks.QUARTZ_STAIRS,
            Blocks.RED_CONCRETE,
            Blocks.RED_CONCRETE_POWDER,
            Blocks.RED_GLAZED_TERRACOTTA,
            Blocks.RED_NETHER_BRICK_SLAB,
            Blocks.RED_NETHER_BRICK_STAIRS,
            Blocks.RED_NETHER_BRICK_WALL,
            Blocks.RED_NETHER_BRICKS,
            Blocks.RED_SAND,
            Blocks.RED_SANDSTONE,
            Blocks.RED_SANDSTONE_SLAB,
            Blocks.RED_SANDSTONE_STAIRS,
            Blocks.RED_SANDSTONE_WALL,
            Blocks.RED_STAINED_GLASS,
            Blocks.RED_STAINED_GLASS_PANE,
            Blocks.RED_TERRACOTTA,
            Blocks.REDSTONE_BLOCK,
            Blocks.REDSTONE_LAMP,
            Blocks.REDSTONE_ORE,
            Blocks.REDSTONE_TORCH,
            Blocks.REDSTONE_WIRE,
            Blocks.REINFORCED_DEEPSLATE,
            Blocks.RESPAWN_ANCHOR,
            Blocks.ROOTED_DIRT,
            Blocks.SAND,
            Blocks.SANDSTONE,
            Blocks.SANDSTONE_SLAB,
            Blocks.SANDSTONE_STAIRS,
            Blocks.SANDSTONE_WALL,
            Blocks.SEA_LANTERN,
            Blocks.SKELETON_SKULL,
            Blocks.SKELETON_WALL_SKULL,
            Blocks.SMITHING_TABLE,
            Blocks.SMOKER,
            Blocks.SMOOTH_BASALT,
            Blocks.SMOOTH_QUARTZ,
            Blocks.SMOOTH_QUARTZ_SLAB,
            Blocks.SMOOTH_QUARTZ_STAIRS,
            Blocks.SMOOTH_RED_SANDSTONE,
            Blocks.SMOOTH_RED_SANDSTONE_SLAB,
            Blocks.SMOOTH_RED_SANDSTONE_STAIRS,
            Blocks.SMOOTH_SANDSTONE,
            Blocks.SMOOTH_SANDSTONE_SLAB,
            Blocks.SMOOTH_SANDSTONE_STAIRS,
            Blocks.SMOOTH_STONE,
            Blocks.SMOOTH_STONE_SLAB,
            Blocks.SOUL_SAND,
            Blocks.SOUL_SOIL,
            Blocks.STICKY_PISTON,
            Blocks.STONE,
            Blocks.STONE_BRICK_SLAB,
            Blocks.STONE_BRICK_STAIRS,
            Blocks.STONE_BRICK_WALL,
            Blocks.STONE_BRICKS,
            Blocks.STONE_BUTTON,
            Blocks.STONE_PRESSURE_PLATE,
            Blocks.STONE_SLAB,
            Blocks.STONE_STAIRS,
            Blocks.STONECUTTER,
            Blocks.SUSPICIOUS_GRAVEL,
            Blocks.SUSPICIOUS_SAND,
            Blocks.TERRACOTTA,
            Blocks.TINTED_GLASS,
            Blocks.TUFF,
            Blocks.TUFF_BRICK_SLAB,
            Blocks.TUFF_BRICK_STAIRS,
            Blocks.TUFF_BRICK_WALL,
            Blocks.TUFF_BRICKS,
            Blocks.TUFF_SLAB,
            Blocks.TUFF_STAIRS,
            Blocks.TUFF_WALL,
            Blocks.VERDANT_FROGLIGHT,
            Blocks.WATER_CAULDRON,
            Blocks.WAXED_COPPER_BLOCK,
            Blocks.WAXED_CHISELED_COPPER,
            Blocks.WAXED_COPPER_BULB,
            Blocks.WAXED_COPPER_GRATE,
            Blocks.WAXED_COPPER_TRAPDOOR,
            Blocks.WAXED_CUT_COPPER,
            Blocks.WAXED_CUT_COPPER_SLAB,
            Blocks.WAXED_CUT_COPPER_STAIRS,
            Blocks.WAXED_EXPOSED_CHISELED_COPPER,
            Blocks.WAXED_EXPOSED_COPPER,
            Blocks.WAXED_EXPOSED_COPPER_BULB,
            Blocks.WAXED_EXPOSED_COPPER_DOOR,
            Blocks.WAXED_EXPOSED_COPPER_GRATE,
            Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
            Blocks.WAXED_EXPOSED_CUT_COPPER,
            Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB,
            Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS,
            Blocks.WAXED_WEATHERED_COPPER,
            Blocks.WAXED_WEATHERED_CHISELED_COPPER,
            Blocks.WAXED_WEATHERED_COPPER_BULB,
            Blocks.WAXED_WEATHERED_COPPER_GRATE,
            Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR,
            Blocks.WAXED_WEATHERED_CUT_COPPER,
            Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB,
            Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS,
            Blocks.WEATHERED_COPPER,
            Blocks.WEATHERED_CHISELED_COPPER,
            Blocks.WEATHERED_COPPER_BULB,
            Blocks.WEATHERED_COPPER_GRATE,
            Blocks.WEATHERED_COPPER_TRAPDOOR,
            Blocks.WEATHERED_CUT_COPPER,
            Blocks.WEATHERED_CUT_COPPER_SLAB,
            Blocks.WEATHERED_CUT_COPPER_STAIRS,
            Blocks.WHITE_CONCRETE,
            Blocks.WHITE_CONCRETE_POWDER,
            Blocks.WHITE_GLAZED_TERRACOTTA,
            Blocks.WHITE_STAINED_GLASS,
            Blocks.WHITE_STAINED_GLASS_PANE,
            Blocks.WHITE_TERRACOTTA,
            Blocks.WITHER_SKELETON_SKULL,
            Blocks.WITHER_SKELETON_WALL_SKULL,
            Blocks.YELLOW_CONCRETE,
            Blocks.YELLOW_CONCRETE_POWDER,
            Blocks.YELLOW_GLAZED_TERRACOTTA,
            Blocks.YELLOW_STAINED_GLASS,
            Blocks.YELLOW_STAINED_GLASS_PANE,
            Blocks.YELLOW_TERRACOTTA);

    public List<Block> getEarthEssenceBreakableBlocks() {
        return earthEssenceBreakableBlocks;
    }

    public EarthEssenceItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        Level level = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        Block block = level.getBlockState(blockPos).getBlock();
        if (!level.isClientSide) {
            ItemStack itemstack = pContext.getItemInHand();
            boolean res;
            if (earthEssenceBreakableBlocks.contains(block)) {
                level.destroyBlock(blockPos, true);
                blockPos = blockPos.relative(pContext.getHorizontalDirection());
                block = level.getBlockState(blockPos).getBlock();
                itemstack.shrink(1);
                return InteractionResult.SUCCESS;
            }

        }
        return InteractionResult.PASS;
    }
}
