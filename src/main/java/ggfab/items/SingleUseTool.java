package ggfab.items;

import static ggfab.GGItemList.SingleUseCrowbar;
import static ggfab.GGItemList.SingleUseFile;
import static ggfab.GGItemList.SingleUseHardHammer;
import static ggfab.GGItemList.SingleUseSaw;
import static ggfab.GGItemList.SingleUseScrewdriver;
import static ggfab.GGItemList.SingleUseSoftMallet;
import static ggfab.GGItemList.SingleUseWireCutter;
import static ggfab.GGItemList.SingleUseWrench;
import static gregtech.api.enums.ItemList.Shape_Mold_Crowbar;
import static gregtech.api.enums.ItemList.Shape_Mold_File;
import static gregtech.api.enums.ItemList.Shape_Mold_Hammer;
import static gregtech.api.enums.ItemList.Shape_Mold_Mallet;
import static gregtech.api.enums.ItemList.Shape_Mold_Saw;
import static gregtech.api.enums.ItemList.Shape_Mold_Screwdriver;
import static gregtech.api.enums.ItemList.Shape_Mold_Wirecutter;
import static gregtech.api.enums.ItemList.Shape_Mold_Wrench;
import static gregtech.api.enums.ToolDictNames.craftingToolCrowbar;
import static gregtech.api.enums.ToolDictNames.craftingToolFile;
import static gregtech.api.enums.ToolDictNames.craftingToolHardHammer;
import static gregtech.api.enums.ToolDictNames.craftingToolSaw;
import static gregtech.api.enums.ToolDictNames.craftingToolScrewdriver;
import static gregtech.api.enums.ToolDictNames.craftingToolSoftMallet;
import static gregtech.api.enums.ToolDictNames.craftingToolWireCutter;
import static gregtech.api.enums.ToolDictNames.craftingToolWrench;

import java.util.List;

import com.google.common.collect.ImmutableList;

import ggfab.GGItemList;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.ToolDictNames;

public enum SingleUseTool {

    // Hard tools
    File(SingleUseFile, 0, Shape_Mold_File, 30, craftingToolFile),
    Wrench(SingleUseWrench, 1, Shape_Mold_Wrench, 31, craftingToolWrench),
    Crowbar(SingleUseCrowbar, 2, Shape_Mold_Crowbar, 32, craftingToolCrowbar),
    WireCutter(SingleUseWireCutter, 3, Shape_Mold_Wirecutter, 33, craftingToolWireCutter),
    HardHammer(SingleUseHardHammer, 4, Shape_Mold_Hammer, 34, craftingToolHardHammer),
    Screwdriver(SingleUseScrewdriver, 6, Shape_Mold_Screwdriver, 36, craftingToolScrewdriver),
    Saw(SingleUseSaw, 7, Shape_Mold_Saw, 37, craftingToolSaw),

    // Soft tools
    SoftMallet(SingleUseSoftMallet, 5, Shape_Mold_Mallet, 35, craftingToolSoftMallet);

    public static final List<SingleUseTool> HARD_TOOLS = ImmutableList
        .of(File, Wrench, Crowbar, WireCutter, HardHammer, Screwdriver, Saw);

    public static final List<SingleUseTool> SOFT_TOOLS = ImmutableList.of(SoftMallet);

    public final GGItemList tool;
    public final int toolID;
    public final ItemList mold;
    public final int moldID;
    public final ToolDictNames toolDictName;

    SingleUseTool(GGItemList tool, int toolID, ItemList mold, int moldID, ToolDictNames toolDictName) {
        this.tool = tool;
        this.toolID = toolID;
        this.mold = mold;
        this.moldID = moldID;
        this.toolDictName = toolDictName;
    }
}
