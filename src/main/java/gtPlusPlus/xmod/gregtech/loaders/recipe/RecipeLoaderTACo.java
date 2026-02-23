package gtPlusPlus.xmod.gregtech.loaders.recipe;

import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.TACoRecipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.common.tileentities.machines.multi.MTEThaumoArborealConverter;

public class RecipeLoaderTACo {
    /*MTETreeFarm.registerTreeProducts( // Golden Oak
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "goldenOakSapling", 1, 0),
        new ItemStack(Blocks.endstone, 1, 0),
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "genLeaves", 1, 0),
        GTModHandler.getModItem(Mods.Thaumcraft.ID, "blockMagicalLeaves", 1, 0),
        null);

    MTETreeFarm.registerTreeProducts( // Peaceful
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "goldenOakSapling", 1, 1),
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "genLogs", 1, 0),
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "genLeaves", 1, 1),
        null);*/

    // TODO
    // Peaceful meat and animal drops

    // Nether
    MTEThaumoArborealConverter.registerTreeProducts(
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "goldenOakSapling", 1, 2),
        new ItemStack(Blocks.netherrack, 1),
        70
    );
    MTEThaumoArborealConverter.registerTreeProducts(
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "goldenOakSapling", 1, 2),
        new ItemStack(Blocks.soul_sand, 1),
        20
    );
    MTEThaumoArborealConverter.registerTreeProducts(
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "goldenOakSapling", 1, 2),
        GTOreDictUnificator.get(OrePrefixes.ore, Materials.NetherQuartz, 1L)
        10
    );

    // Ender
    MTEThaumoArborealConverter.registerTreeProducts(
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "goldenOakSapling", 1, 3),
        new ItemStack(Blocks.endstone, 1),
        90
    );
    MTEThaumoArborealConverter.registerTreeProducts(
        GTModHandler.getModItem(Mods.ThaumicBases.ID, "goldenOakSapling", 1, 3),
        new ItemStack(Blocks.obsidian, 1),
        10
    );
}