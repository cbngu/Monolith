package gg.warcraft.monolith.api.world.block;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * BlockType serves as an abstraction layer between Monolith plugin code and the eventual server implementation the
 * plugin is run on. It is identical to part of Spigot's {@code Material} and the server adapter will substitute its
 * values with the correct implementation during runtime.
 */
public enum BlockType {
    AIR("minecraft:air", 0),
    STONE("minecraft:stone", 1),
    GRANITE("minecraft:stone", 1, 1),
    POLISHED_GRANITE("minecraft:stone", 1, 2),
    DIORITE("minecraft:stone", 1, 3),
    POLISHED_DIORITE("minecraft:stone", 1, 4),
    ANDESITE("minecraft:stone", 1, 5),
    POLISHED_ANDESITE("minecraft:stone", 1, 6),
    GRASS("minecraft:grass", 2),
    DIRT("minecraft:dirt", 3),
    COARSE_DIRT("minecraft:dirt", 3, 1),
    PODZOL("minecraft:dirt", 3, 2),
    COBBLESTONE("minecraft:dirt", 4),
    OAK_WOOD_PLANK("minecraft:planks", 5),
    SPRUCE_WOOD_PLANK("minecraft:planks", 5, 1),
    BIRCH_WOOD_PLANK("minecraft:planks", 5, 2),
    JUNGLE_WOOD_PLANK("minecraft:planks", 5, 3),
    ACACIA_WOOD_PLANK("minecraft:planks", 5, 4),
    DARK_OAK_WOOD_PLANK("minecraft:planks", 5, 5),
    OAK_SAPLING("minecraft:sapling", 6),
    SPRUCE_SAPLING("minecraft:sapling", 6, 1),
    BIRCH_SAPLING("minecraft:sapling", 6, 2),
    JUNGLE_SAPLING("minecraft:sapling", 6, 3),
    ACACIA_SAPLING("minecraft:sapling", 6, 4),
    DARK_OAK_SAPLING("minecraft:sapling", 6, 5),
    BEDROCK("minecraft:bedrock", 7),
    FLOWING_WATER("minecraft:flowing_water", 8),
    STILL_WATER("minecraft:water", 9),
    FLOWING_LAVA("minecraft:flowing_lava", 10),
    STILL_LAVA("minecraft:lava", 11),
    SAND("minecraft:sand", 12),
    RED_SAND("minecraft:sand", 12, 1),
    GRAVEL("minecraft:gravel", 13),
    GOLD_ORE("minecraft:gold_ore", 14),
    IRON_ORE("minecraft:iron_ore", 15),
    COAL_ORE("minecraft:coal_ore", 16),
    OAK_WOOD("minecraft:log", 17),
    SPRUCE_WOOD("minecraft:log", 17, 1),
    BIRCH_WOOD("minecraft:log", 17, 2),
    JUNGLE_WOOD("minecraft:log", 17, 3),
    OAK_LEAVES("minecraft:leaves", 18),
    SPRUCE_LEAVES("minecraft:leaves", 18, 1),
    BIRCH_LEAVES("minecraft:leaves", 18, 2),
    JUNGLE_LEAVES("minecraft:leaves", 18, 3),
    SPONGE("minecraft:sponge", 19),
    WET_SPONGE("minecraft:sponge", 19, 1),
    GLASS("minecraft:glass", 20),
    LAPIS_LAZULI_ORE("minecraft:lapis_ore", 21),
    LAPIS_LAZULI_BLOCK("minecraft:lapis_block", 22),
    DISPENSER("minecraft:dispenser", 23),
    SANDSTONE("minecraft:sandstone", 24),
    CHISELED_SANDSTONE("minecraft:sandstone", 24, 1),
    SMOOTH_SANDSTONE("minecraft:sandstone", 24, 2),
    NOTE_BLOCK("minecraft:noteblock", 25),
    BED("minecraft:bed", 26),
    POWERED_RAIL("minecraft:golden_rail", 27),
    DETECTOR_RAIL("minecraft:detector_rail", 28),
    STICKY_PISTON("minecraft:sticky_piston", 29),
    COBWEB("minecraft:web", 30),
    DEAD_SHRUB("minecraft:tallgrass", 31),
    TALL_GRASS("minecraft:tallgrass", 31, 1),
    FERN("minecraft:tallgrass", 31, 2),
    DEAD_BUSH("minecraft:deadbush", 32),
    PISTON("minecraft:piston", 33),
    PISTON_HEAD("minecraft:piston_head", 34),
    WHITE_WOOL("minecraft:wool", 35),
    ORANGE_WOOL("minecraft:wool", 35, 1),
    MAGENTA_WOOL("minecraft:wool", 35, 2),
    LIGHT_BLUE_WOOL("minecraft:wool", 35, 3),
    YELLOW_WOOL("minecraft:wool", 35, 4),
    LIME_WOOL("minecraft:wool", 35, 5),
    PINK_WOOL("minecraft:wool", 35, 6),
    GRAY_WOOL("minecraft:wool", 35, 7),
    LIGHT_GRAY_WOOL("minecraft:wool", 35, 8),
    CYAN_WOOL("minecraft:wool", 35, 9),
    PURPLE_WOOL("minecraft:wool", 35, 10),
    BLUE_WOOL("minecraft:wool", 35, 11),
    BROWN_WOOL("minecraft:wool", 35, 12),
    GREEN_WOOL("minecraft:wool", 35, 13),
    RED_WOOL("minecraft:wool", 35, 14),
    BLACK_WOOL("minecraft:wool", 35, 15),
    DANDELION("minecraft:yellow_flower", 37),
    POPPY("minecraft:red_flower", 38),
    BLUE_ORCHID("minecraft:red_flower", 38, 1),
    ALLIUM("minecraft:red_flower", 38, 2),
    AZURE_BLUET("minecraft:red_flower", 38, 3),
    RED_TULIP("minecraft:red_flower", 38, 4),
    ORANGE_TULIP("minecraft:red_flower", 38, 5),
    WHITE_TULIP("minecraft:red_flower", 38, 6),
    PINK_TULIP("minecraft:red_flower", 38, 7),
    OXEYE_DAISY("minecraft:red_flower", 38, 8),
    BROWN_MUSHROOM("minecraft:brown_mushroom", 39),
    RED_MUSHROOM("minecraft:red_mushroom", 40),
    GOLD_BLOCK("minecraft:gold_block", 41),
    IRON_BLOCK("minecraft:iron_block", 42),
    DOUBLE_STONE_SLAB("minecraft:double_stone_slab", 43),
    DOUBLE_SANDSTONE_SLAB("minecraft:double_stone_slab", 43, 1),
    DOUBLE_WOODEN_SLAB("minecraft:double_stone_slab", 43, 2),
    DOUBLE_COBBLESTONE_SLAB("minecraft:double_stone_slab", 43, 3),
    DOUBLE_BRICK_SLAB("minecraft:double_stone_slab", 43, 4),
    DOUBLE_STONE_BRICK_SLAB("minecraft:double_stone_slab", 43, 5),
    DOUBLE_NETHER_BRICK_SLAB("minecraft:double_stone_slab", 43, 6),
    DOUBLE_QUARTZ_SLAB("minecraft:double_stone_slab", 43, 7),
    STONE_SLAB("minecraft:stone_slab", 44),
    SANDSTONE_SLAB("minecraft:stone_slab", 44, 1),
    WOODEN_SLAB("minecraft:stone_slab", 44, 2),
    COBBLESTONE_SLAB("minecraft:stone_slab", 44, 3),
    BRICK_SLAB("minecraft:stone_slab", 44, 4),
    STONE_BRICK_SLAB("minecraft:stone_slab", 44, 5),
    NETHER_BRICK_SLAB("minecraft:stone_slab", 44, 6),
    QUARTZ_SLAB("minecraft:stone_slab", 44, 7),
    BRICKS("minecraft:brick_block", 45),
    TNT("minecraft:tnt", 46),
    BOOKSHELF("minecraft:bookshelf", 47),
    MOSS_STONE("minecraft:mossy_cobblestone", 48),
    OBSIDIAN("minecraft:obsidian", 49),
    TORCH("minecraft:torch", 50),
    FIRE("minecraft:fire", 51),
    MONSTER_SPAWNER("minecraft:mob_spawner", 52),
    OAK_WOOD_STAIRS("minecraft:oak_stairs", 53),
    CHEST("minecraft:chest", 54),
    REDSTONE_WIRE("minecraft:redstone_wire", 55),
    DIAMOND_ORE("minecraft:diamond_ore", 56),
    DIAMOND_BLOCK("minecraft:diamond_block", 57),
    CRAFTING_TABLE("minecraft:crafting_table", 58),
    SEEDED_WHEAT_CROPS("minecraft:wheat", 59),
    GERMINATED_WHEAT_CROPS("minecraft:wheat", 59, 1),
    VERY_SMALL_WHEAT_CROPS("minecraft:wheat", 59, 2),
    SMALL_WHEAT_CROPS("minecraft:wheat", 59, 3),
    MEDIUM_WHEAT_CROPS("minecraft:wheat", 59, 4),
    TALL_WHEAT_CROPS("minecraft:wheat", 59, 5),
    VERY_TALL_WHEAT_CROPS("minecraft:wheat", 59, 6),
    RIPE_WHEAT_CROPS("minecraft:wheat", 59, 7),
    FARMLAND("minecraft:farmland", 60),
    FURNACE("minecraft:furnace", 61),
    BURNING_FURNACE("minecraft:lit_furnace", 62),
    STANDING_SIGN_BLOCK("minecraft:standing_sign", 63),
    OAK_DOOR_BLOCK("minecraft:wooden_door", 64),
    LADDER("minecraft:ladder", 65),
    RAIL("minecraft:rail", 66),
    COBBLESTONE_STAIRS("minecraft:stone_stairs", 67),
    WALL_MOUNTED_SIGN_BLOCK("minecraft:wall_sign", 68),
    LEVER("minecraft:lever", 69),
    STONE_PRESSURE_PLATE("minecraft:stone_pressure_plate", 70),
    IRON_DOOR_BLOCK("minecraft:iron_door", 71),
    WOODEN_PRESSURE_PLATE("minecraft:wooden_pressure_plate", 72),
    REDSTONE_ORE("minecraft:redstone_ore", 73),
    GLOWING_REDSTONE_ORE("minecraft:lit_redstone_ore", 74),
    REDSTONE_TORCH_OFF("minecraft:unlit_redstone_torch", 75),
    REDSTONE_TORCH_ON("minecraft:redstone_torch", 76),
    STONE_BUTTON("minecraft:stone_button", 77),
    SNOW("minecraft:snow_layer", 78),
    ICE("minecraft:ice", 79),
    SNOW_BLOCK("minecraft:snow", 80),
    CACTUS("minecraft:cactus", 81),
    CLAY("minecraft:clay", 82),
    SUGAR_CANES("minecraft:reeds", 83),
    JUKEBOX("minecraft:jukebox", 84),
    OAK_FENCE("minecraft:fence", 85),
    PUMPKIN("minecraft:pumpkin", 86),
    NETHERRACK("minecraft:netherrack", 87),
    SOUL_SAND("minecraft:soul_sand", 88),
    GLOWSTONE("minecraft:glowstone", 89),
    NETHER_PORTAL("minecraft:portal", 90),
    JACK_OLANTERN("minecraft:lit_pumpkin", 91),
    CAKE_BLOCK("minecraft:cake", 92),
    REDSTONE_REPEATER_BLOCK_OFF("minecraft:unpowered_repeater", 93),
    REDSTONE_REPEATER_BLOCK_ON("minecraft:powered_repeater", 94),
    WHITE_STAINED_GLASS("minecraft:stained_glass", 95),
    ORANGE_STAINED_GLASS("minecraft:stained_glass", 95, 1),
    MAGENTA_STAINED_GLASS("minecraft:stained_glass", 95, 2),
    LIGHT_BLUE_STAINED_GLASS("minecraft:stained_glass", 95, 3),
    YELLOW_STAINED_GLASS("minecraft:stained_glass", 95, 4),
    LIME_STAINED_GLASS("minecraft:stained_glass", 95, 5),
    PINK_STAINED_GLASS("minecraft:stained_glass", 95, 6),
    GRAY_STAINED_GLASS("minecraft:stained_glass", 95, 7),
    LIGHT_GRAY_STAINED_GLASS("minecraft:stained_glass", 95, 8),
    CYAN_STAINED_GLASS("minecraft:stained_glass", 95, 9),
    PURPLE_STAINED_GLASS("minecraft:stained_glass", 95, 10),
    BLUE_STAINED_GLASS("minecraft:stained_glass", 95, 11),
    BROWN_STAINED_GLASS("minecraft:stained_glass", 95, 12),
    GREEN_STAINED_GLASS("minecraft:stained_glass", 95, 13),
    RED_STAINED_GLASS("minecraft:stained_glass", 95, 14),
    BLACK_STAINED_GLASS("minecraft:stained_glass", 95, 15),
    WOODEN_TRAPDOOR("minecraft:trapdoor", 96),
    STONE_MONSTER_EGG("minecraft:monster_egg", 97),
    COBBLESTONE_MONSTER_EGG("minecraft:monster_egg", 97, 1),
    STONE_BRICK_MONSTER_EGG("minecraft:monster_egg", 97, 2),
    MOSSY_STONE_BRICK_MONSTER_EGG("minecraft:monster_egg", 97, 3),
    CRACKED_STONE_BRICK_MONSTER_EGG("minecraft:monster_egg", 97, 5),
    CHISELED_STONE_BRICK_MONSTER_EGG("minecraft:monster_egg", 97, 5),
    STONE_BRICKS("minecraft:stonebrick", 98),
    MOSSY_STONE_BRICKS("minecraft:stonebrick", 98, 1),
    CRACKED_STONE_BRICKS("minecraft:stonebrick", 98, 2),
    CHISELED_STONE_BRICKS("minecraft:stonebrick", 98, 3),
    BROWN_MUSHROOM_BLOCK("minecraft:brown_mushroom_block", 99),
    RED_MUSHROOM_BLOCK("minecraft:red_mushroom_block", 100),
    IRON_BARS("minecraft:iron_bars", 101),
    GLASS_PANE("minecraft:glass_pane", 102),
    MELON_BLOCK("minecraft:melon_block", 103),
    PUMPKIN_STEM("minecraft:pumpkin_stem", 104),
    MELON_STEM("minecraft:melon_stem", 105),
    VINES("minecraft:vine", 106),
    OAK_FENCE_GATE("minecraft:fence_gate", 107),
    BRICK_STAIRS("minecraft:brick_stairs", 108),
    STONE_BRICK_STAIRS("minecraft:stone_brick_stairs", 109),
    MYCELIUM("minecraft:mycelium", 110),
    LILY_PAD("minecraft:waterlily", 111),
    NETHER_BRICK("minecraft:nether_brick", 112),
    NETHER_BRICK_FENCE("minecraft:nether_brick_fence", 113),
    NETHER_BRICK_STAIRS("minecraft:nether_brick_stairs", 114),
    NETHER_WART("minecraft:nether_wart", 115),
    ENCHANTMENT_TABLE("minecraft:enchanting_table", 116),
    BREWING_STAND("minecraft:brewing_stand", 117),
    CAULDRON("minecraft:cauldron", 118),
    END_PORTAL("minecraft:end_portal", 119),
    END_PORTAL_FRAME("minecraft:end_portal_frame", 120),
    END_STONE("minecraft:end_stone", 121),
    DRAGON_EGG("minecraft:dragon_egg", 122),
    REDSTONE_LAMP_INACTIVE("minecraft:redstone_lamp", 123),
    REDSTONE_LAMP_ACTIVE("minecraft:lit_redstone_lamp", 124),
    DOUBLE_OAK_WOOD_SLAB("minecraft:double_wooden_slab", 125),
    DOUBLE_SPRUCE_WOOD_SLAB("minecraft:double_wooden_slab", 125, 1),
    DOUBLE_BIRCH_WOOD_SLAB("minecraft:double_wooden_slab", 125, 2),
    DOUBLE_JUNGLE_WOOD_SLAB("minecraft:double_wooden_slab", 125, 3),
    DOUBLE_ACACIA_WOOD_SLAB("minecraft:double_wooden_slab", 125, 4),
    DOUBLE_DARK_OAK_WOOD_SLAB("minecraft:double_wooden_slab", 125, 5),
    OAK_WOOD_SLAB("minecraft:wooden_slab", 126),
    SPRUCE_WOOD_SLAB("minecraft:wooden_slab", 126, 1),
    BIRCH_WOOD_SLAB("minecraft:wooden_slab", 126, 2),
    JUNGLE_WOOD_SLAB("minecraft:wooden_slab", 126, 3),
    ACACIA_WOOD_SLAB("minecraft:wooden_slab", 126, 4),
    DARK_OAK_WOOD_SLAB("minecraft:wooden_slab", 126, 5),
    COCOA("minecraft:cocoa", 127),
    SANDSTONE_STAIRS("minecraft:sandstone_stairs", 128),
    EMERALD_ORE("minecraft:emerald_ore", 129),
    ENDER_CHEST("minecraft:ender_chest", 130),
    TRIPWIRE_HOOK("minecraft:tripwire_hook", 131),
    TRIPWIRE("minecraft:tripwire_hook", 132),
    EMERALD_BLOCK("minecraft:emerald_block", 133),
    SPRUCE_WOOD_STAIRS("minecraft:spruce_stairs", 134),
    BIRCH_WOOD_STAIRS("minecraft:birch_stairs", 135),
    JUNGLE_WOOD_STAIRS("minecraft:jungle_stairs", 136),
    COMMAND_BLOCK("minecraft:command_block", 137),
    BEACON("minecraft:beacon", 138),
    COBBLESTONE_WALL("minecraft:cobblestone_wall", 139),
    MOSSY_COBBLESTONE_WALL("minecraft:cobblestone_wall", 139, 1),
    FLOWER_POT("minecraft:flower_pot", 140),
    CARROTS("minecraft:carrots", 141),
    POTATOES("minecraft:potatoes", 142),
    WOODEN_BUTTON("minecraft:wooden_button", 143),
    MOB_HEAD("minecraft:skull", 144),
    ANVIL("minecraft:anvil", 145),
    TRAPPED_CHEST("minecraft:trapped_chest", 146),
    WEIGHTED_PRESSURE_PLATE_LIGHT("minecraft:light_weighted_pressure_plate", 147),
    WEIGHTED_PRESSURE_PLATE_HEAVY("minecraft:heavy_weighted_pressure_plate", 148),
    REDSTONE_COMPARATOR_INACTIVE("minecraft:unpowered_comparator", 149),
    REDSTONE_COMPARATOR_ACTIVE("minecraft:powered_comparator", 150),
    DAYLIGHT_SENSOR("minecraft:daylight_detector", 151),
    REDSTONE_BLOCK("minecraft:redstone_block", 152),
    NETHER_QUARTZ_ORE("minecraft:quartz_ore", 153),
    HOPPER("minecraft:hopper", 154),
    QUARTZ_BLOCK("minecraft:quartz_block", 155),
    CHISELED_QUARTZ_BLOCK("minecraft:quartz_block", 155, 1),
    PILLAR_QUARTZ_BLOCK("minecraft:quartz_block", 155, 2),
    QUARTZ_STAIRS("minecraft:quartz_stairs", 156),
    ACTIVATOR_RAIL("minecraft:activator_rail", 157),
    DROPPER("minecraft:dropper", 158),
    WHITE_HARDENED_CLAY("minecraft:stained_hardened_clay", 159),
    ORANGE_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 1),
    MAGENTA_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 2),
    LIGHT_BLUE_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 3),
    YELLOW_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 4),
    LIME_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 5),
    PINK_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 6),
    GRAY_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 7),
    LIGHT_GRAY_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 8),
    CYAN_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 9),
    PURPLE_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 10),
    BLUE_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 11),
    BROWN_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 12),
    GREEN_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 13),
    RED_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 14),
    BLACK_HARDENED_CLAY("minecraft:stained_hardened_clay", 159, 15),
    WHITE_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160),
    ORANGE_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 1),
    MAGENTA_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 2),
    LIGHT_BLUE_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 3),
    YELLOW_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 4),
    LIME_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 5),
    PINK_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 6),
    GRAY_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 7),
    LIGHT_GRAY_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 8),
    CYAN_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 9),
    PURPLE_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 10),
    BLUE_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 11),
    BROWN_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 12),
    GREEN_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 13),
    RED_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 14),
    BLACK_STAINED_GLASS_PANE("minecraft:stained_glass_pane", 160, 15),
    ACACIA_LEAVES("minecraft:leaves2", 161),
    DARK_OAK_LEAVES("minecraft:leaves2", 161, 1),
    ACACIA_WOOD("minecraft:log2", 162),
    DARK_OAK_WOOD("minecraft:log2", 162, 1),
    ACACIA_WOOD_STAIRS("minecraft:acacia_stairs", 163),
    DARK_OAK_WOOD_STAIRS("minecraft:dark_oak_stairs", 164),
    SLIME_BLOCK("minecraft:slime", 165),
    BARRIER("minecraft:barrier", 166),
    IRON_TRAPDOOR("minecraft:iron_trapdoor", 167),
    PRISMARINE("minecraft:prismarine", 168),
    PRISMARINE_BRICKS("minecraft:prismarine", 168, 1),
    DARK_PRISMARINE("minecraft:prismarine", 168, 2),
    SEA_LANTERN("minecraft:sea_lantern", 169),
    HAY_BALE("minecraft:hay_block", 170),
    WHITE_CARPET("minecraft:carpet", 171),
    ORANGE_CARPET("minecraft:carpet", 171, 1),
    MAGENTA_CARPET("minecraft:carpet", 171, 2),
    LIGHT_BLUE_CARPET("minecraft:carpet", 171, 3),
    YELLOW_CARPET("minecraft:carpet", 171, 4),
    LIME_CARPET("minecraft:carpet", 171, 5),
    PINK_CARPET("minecraft:carpet", 171, 6),
    GRAY_CARPET("minecraft:carpet", 171, 7),
    LIGHT_GRAY_CARPET("minecraft:carpet", 171, 8),
    CYAN_CARPET("minecraft:carpet", 171, 9),
    PURPLE_CARPET("minecraft:carpet", 171, 10),
    BLUE_CARPET("minecraft:carpet", 171, 11),
    BROWN_CARPET("minecraft:carpet", 171, 12),
    GREEN_CARPET("minecraft:carpet", 171, 13),
    RED_CARPET("minecraft:carpet", 171, 14),
    BLACK_CARPET("minecraft:carpet", 171, 15),
    HARDENED_CLAY("minecraft:hardened_clay", 172),
    BLOCK_OF_COAL("minecraft:coal_block", 173),
    PACKED_ICE("minecraft:packed_ice", 174),
    SUNFLOWER("minecraft:double_plant", 175),
    LILAC("minecraft:double_plant", 175, 1),
    DOUBLE_TALLGRASS("minecraft:double_plant", 175, 2),
    LARGE_FERN("minecraft:double_plant", 175, 3),
    ROSE_BUSH("minecraft:double_plant", 175, 4),
    PEONY("minecraft:double_plant", 175, 5),
    FREE_STANDING_BANNER("minecraft:standing_banner", 176),
    WALL_MOUNTED_BANNER("minecraft:wall_banner", 177),
    INVERTED_DAYLIGHT_SENSOR("minecraft:daylight_detector_inverted", 178),
    RED_SANDSTONE("minecraft:red_sandstone", 179),
    CHISELED_RED_SANDSTONE("minecraft:red_sandstone", 179, 1),
    SMOOTH_RED_SANDSTONE("minecraft:red_sandstone", 179, 2),
    RED_SANDSTONE_STAIRS("minecraft:red_sandstone_stairs", 180),
    DOUBLE_RED_SANDSTONE_SLAB("minecraft:double_stone_slab2", 181),
    RED_SANDSTONE_SLAB("minecraft:stone_slab2", 182),
    SPRUCE_FENCE_GATE("minecraft:spruce_fence_gate", 183),
    BIRCH_FENCE_GATE("minecraft:birch_fence_gate", 184),
    JUNGLE_FENCE_GATE("minecraft:jungle_fence_gate", 185),
    DARK_OAK_FENCE_GATE("minecraft:dark_oak_fence_gate", 186),
    ACACIA_FENCE_GATE("minecraft:acacia_fence_gate", 187),
    SPRUCE_FENCE("minecraft:spruce_fence", 188),
    BIRCH_FENCE("minecraft:birch_fence", 189),
    JUNGLE_FENCE("minecraft:jungle_fence", 190),
    DARK_OAK_FENCE("minecraft:dark_oak_fence", 191),
    ACACIA_FENCE("minecraft:acacia_fence", 192),
    SPRUCE_DOOR_BLOCK("minecraft:spruce_door", 193),
    BIRCH_DOOR_BLOCK("minecraft:birch_door", 194),
    JUNGLE_DOOR_BLOCK("minecraft:jungle_door", 195),
    ACACIA_DOOR_BLOCK("minecraft:acacia_door", 196),
    DARK_OAK_DOOR_BLOCK("minecraft:dark_oak_door", 197),
    END_ROD("minecraft:end_rod", 198),
    CHORUS_PLANT("minecraft:chorus_plant", 199),
    CHORUS_FLOWER("minecraft:chorus_flower", 200),
    PURPUR_BLOCK("minecraft:purpur_block", 201),
    PURPUR_PILLAR("minecraft:purpur_pillar", 202),
    PURPUR_STAIRS("minecraft:purpur_stairs", 203),
    PURPUR_DOUBLE_SLAB("minecraft:purpur_double_slab", 204),
    PURPUR_SLAB("minecraft:purpur_slab", 205),
    END_STONE_BRICKS("minecraft:end_bricks", 206),
    BEETROOT_BLOCK("minecraft:beetroots", 207),
    GRASS_PATH("minecraft:grass_path", 208),
    END_GATEWAY("minecraft:end_gateway", 209),
    REPEATING_COMMAND_BLOCK("minecraft:repeating_command_block", 210),
    CHAIN_COMMAND_BLOCK("minecraft:chain_command_block", 211),
    FROSTED_ICE("minecraft:frosted_ice", 212),
    MAGMA_BLOCK("minecraft:magma", 213),
    NETHER_WART_BLOCK("minecraft:nether_wart_block", 214),
    RED_NETHER_BRICK("minecraft:red_nether_brick", 215),
    BONE_BLOCK("minecraft:bone_block", 216),
    STRUCTURE_VOID("minecraft:structure_void", 217),
    OBSERVER("minecraft:observer", 218),
    WHITE_SHULKER_BOX("minecraft:white_shulker_box", 219),
    ORANGE_SHULKER_BOX("minecraft:orange_shulker_box", 220),
    MAGENTA_SHULKER_BOX("minecraft:magenta_shulker_box", 221),
    LIGHT_BLUE_SHULKER_BOX("minecraft:light_blue_shulker_box", 222),
    YELLOW_SHULKER_BOX("minecraft:yellow_shulker_box", 223),
    LIME_SHULKER_BOX("minecraft:lime_shulker_box", 224),
    PINK_SHULKER_BOX("minecraft:pink_shulker_box", 225),
    GRAY_SHULKER_BOX("minecraft:gray_shulker_box", 226),
    LIGHT_GRAY_SHULKER_BOX("minecraft:silver_shulker_box", 227),
    CYAN_SHULKER_BOX("minecraft:cyan_shulker_box", 228),
    PURPLE_SHULKER_BOX("minecraft:purple_shulker_box", 229),
    BLUE_SHULKER_BOX("minecraft:blue_shulker_box", 230),
    BROWN_SHULKER_BOX("minecraft:brown_shulker_box", 231),
    GREEN_SHULKER_BOX("minecraft:green_shulker_box", 232),
    RED_SHULKER_BOX("minecraft:red_shulker_box", 233),
    BLACK_SHULKER_BOX("minecraft:black_shulker_box", 234),
    WHITE_GLAZED_TERRACOTTA("minecraft:white_glazed_terracotta", 235),
    ORANGE_GLAZED_TERRACOTTA("minecraft:orange_glazed_terracotta", 236),
    MAGENTA_GLAZED_TERRACOTTA("minecraft:magenta_glazed_terracotta", 237),
    LIGHT_BLUE_GLAZED_TERRACOTTA("minecraft:light_blue_glazed_terracotta", 238),
    YELLOW_GLAZED_TERRACOTTA("minecraft:yellow_glazed_terracotta", 239),
    LIME_GLAZED_TERRACOTTA("minecraft:lime_glazed_terracotta", 240),
    PINK_GLAZED_TERRACOTTA("minecraft:pink_glazed_terracotta", 241),
    GRAY_GLAZED_TERRACOTTA("minecraft:gray_glazed_terracotta", 242),
    LIGHT_GRAY_GLAZED_TERRACOTTA("minecraft:light_gray_glazed_terracotta", 243),
    CYAN_GLAZED_TERRACOTTA("minecraft:cyan_glazed_terracotta", 244),
    PURPLE_GLAZED_TERRACOTTA("minecraft:purple_glazed_terracotta", 245),
    BLUE_GLAZED_TERRACOTTA("minecraft:blue_glazed_terracotta", 246),
    BROWN_GLAZED_TERRACOTTA("minecraft:brown_glazed_terracotta", 247),
    GREEN_GLAZED_TERRACOTTA("minecraft:green_glazed_terracotta", 248),
    RED_GLAZED_TERRACOTTA("minecraft:red_glazed_terracotta", 249),
    BLACK_GLAZED_TERRACOTTA("minecraft:black_glazed_terracotta", 250),
    WHITE_CONCRETE("minecraft:concrete", 251),
    ORANGE_CONCRETE("minecraft:concrete", 251, 1),
    MAGENTA_CONCRETE("minecraft:concrete", 251, 2),
    LIGHT_BLUE_CONCRETE("minecraft:concrete", 251, 3),
    YELLOW_CONCRETE("minecraft:concrete", 251, 4),
    LIME_CONCRETE("minecraft:concrete", 251, 5),
    PINK_CONCRETE("minecraft:concrete", 251, 6),
    GRAY_CONCRETE("minecraft:concrete", 251, 7),
    LIGHT_GRAY_CONCRETE("minecraft:concrete", 251, 8),
    CYAN_CONCRETE("minecraft:concrete", 251, 9),
    PURPLE_CONCRETE("minecraft:concrete", 251, 10),
    BLUE_CONCRETE("minecraft:concrete", 251, 11),
    BROWN_CONCRETE("minecraft:concrete", 251, 12),
    GREEN_CONCRETE("minecraft:concrete", 251, 13),
    RED_CONCRETE("minecraft:concrete", 251, 14),
    BLACK_CONCRETE("minecraft:concrete", 251, 15),
    WHITE_CONCRETE_POWDER("minecraft:concrete_powder", 252),
    ORANGE_CONCRETE_POWDER("minecraft:concrete_powder", 252, 1),
    MAGENTA_CONCRETE_POWDER("minecraft:concrete_powder", 252, 2),
    LIGHT_BLUE_CONCRETE_POWDER("minecraft:concrete_powder", 252, 3),
    YELLOW_CONCRETE_POWDER("minecraft:concrete_powder", 252, 4),
    LIME_CONCRETE_POWDER("minecraft:concrete_powder", 252, 5),
    PINK_CONCRETE_POWDER("minecraft:concrete_powder", 252, 6),
    GRAY_CONCRETE_POWDER("minecraft:concrete_powder", 252, 7),
    LIGHT_GRAY_CONCRETE_POWDER("minecraft:concrete_powder", 252, 8),
    CYAN_CONCRETE_POWDER("minecraft:concrete_powder", 252, 9),
    PURPLE_CONCRETE_POWDER("minecraft:concrete_powder", 252, 10),
    BLUE_CONCRETE_POWDER("minecraft:concrete_powder", 252, 11),
    BROWN_CONCRETE_POWDER("minecraft:concrete_powder", 252, 12),
    GREEN_CONCRETE_POWDER("minecraft:concrete_powder", 252, 13),
    RED_CONCRETE_POWDER("minecraft:concrete_powder", 252, 14),
    BLACK_CONCRETE_POWDER("minecraft:concrete_powder", 252, 15),
    STRUCTURE_BLOCK("minecraft:structure_block", 255);

    private static final Map<String, BlockType> types = new HashMap<>();

    public static final Set<BlockType> NON_SOLIDS = new HashSet<>();

    static {
        for (BlockType type : BlockType.values()) {
            String typeKey = type.getId() + ":" + type.getData();
            types.put(typeKey, type);
        }

        NON_SOLIDS.add(BlockType.AIR);
        NON_SOLIDS.add(BlockType.FLOWING_WATER);
        NON_SOLIDS.add(BlockType.STILL_WATER);
        NON_SOLIDS.add(BlockType.DEAD_SHRUB);
        NON_SOLIDS.add(BlockType.TALL_GRASS);
        NON_SOLIDS.add(BlockType.FERN);
        NON_SOLIDS.add(BlockType.DEAD_BUSH);
    }

    /**
     * Returns the block type with the given id.
     *
     * @param id The id.
     * @return The block type with the given id. Can be null.
     */
    public static BlockType get(int id) {
        return get(id, 0);
    }

    /**
     * Returns the block type with the given id and data.
     * <p>
     * TODO: some blocks hold directional data, look into a way to preserve or store without flooding the enum
     *
     * @param id   The id.
     * @param data The data.
     * @return The block type with the given id and data. Can be null.
     */
    public static BlockType get(int id, int data) {
        int adjustedData = data & 0x3;
        return types.get(id + ":" + adjustedData);
    }

    /**
     * @param type The type.
     * @return True if the type is a door, false otherwise.
     */
    public static boolean isDoor(BlockType type) {
        switch (type) {
            case ACACIA_DOOR_BLOCK:
            case BIRCH_DOOR_BLOCK:
            case DARK_OAK_DOOR_BLOCK:
            case IRON_DOOR_BLOCK:
            case JUNGLE_DOOR_BLOCK:
            case OAK_DOOR_BLOCK:
            case SPRUCE_DOOR_BLOCK:
                return true;
            default:
                return false;
        }
    }

    private final String type;
    private final int id;
    private final byte data;

    BlockType(String type, int id) {
        this(type, id, 0);
    }

    BlockType(String type, int id, int data) {
        this.type = type;
        this.id = id;
        this.data = (byte) data;
    }

    /**
     * @return The Minecraft type of the block type.
     */
    public String getType() {
        return type;
    }

    /**
     * @return The Minecraft id of the block type.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The Minecraft data of the block type.
     */
    public int getData() {
        return data;
    }
}
