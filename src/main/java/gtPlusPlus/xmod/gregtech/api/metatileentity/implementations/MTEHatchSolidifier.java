package gtPlusPlus.xmod.gregtech.api.metatileentity.implementations;

import static com.gtnewhorizon.gtnhlib.util.numberformatting.NumberFormatUtil.formatNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.cleanroommc.modularui.factory.PosGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.screen.UISettings;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

import gregtech.api.interfaces.IConfigurationCircuitSupport;
import gregtech.api.interfaces.INonConsumedItemDisplay;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.items.ItemShapeMold;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEHatchInput;
import gregtech.api.util.GTSplit;
import gregtech.api.util.GTUtility;
import gregtech.common.gui.modularui.hatch.MTEHatchSolidifierGui;

@IMetaTileEntity.SkipGenerateDescription
@IMetaTileEntity.SkipGenerateName
public class MTEHatchSolidifier extends MTEHatchInput implements IConfigurationCircuitSupport, INonConsumedItemDisplay {

    public static final int moldSlot = 2;
    public static final int circuitSlot = 3;

    public static final List<ItemStack> solidifierMolds = ItemShapeMold.getSolidifierMolds()
        .stream()
        .map(mold -> new ItemStack(mold, 1))
        .collect(Collectors.toList());

    public MTEHatchSolidifier(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier);
    }

    public MTEHatchSolidifier(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, getSlots(aTier), aTier, aDescription, aTextures);
    }

    @Override
    public String getLocalName() {
        if (!hasOwnLocalName()) return super.getLocalName();
        return StatCollector
            .translateToLocalFormatted("gt.blockmachines.hatch.solidifier.name", GTUtility.getRomanNumeral(mTier - 4));
    }

    @Override
    public String[] getDescription() {
        return GTSplit
            .splitLocalizedFormatted("gt.blockmachines.input_hatch_solidifier.desc", formatNumber(getCapacity()));
    }

    public static ItemStack findMatchingMold(ItemStack stack) {
        if (stack == null) return null;
        for (ItemStack mold : solidifierMolds) {
            if (GTUtility.areStacksEqual(mold, stack, true)) return mold.copy();
        }
        return null;
    }

    @Override
    public boolean isItemValidForSlot(int aIndex, ItemStack aStack) {
        if (aIndex == moldSlot) return findMatchingMold(aStack) != null;
        return super.isItemValidForSlot(aIndex, aStack);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEHatchSolidifier(mName, mTier, mDescriptionArray, mTextures);
    }

    @Override
    public List<ItemStack> getNonConsumedInputDisplayItems() {
        // the circuit is already shown by the ghost circuit suffix
        ItemStack mold = getStackInSlot(moldSlot);
        return INonConsumedItemDisplay.isDisplayableItem(mRecipeMap, mold) ? Collections.singletonList(mold)
            : Collections.emptyList();
    }

    public List<ItemStack> getNonConsumableItems() {
        List<ItemStack> items = new ArrayList<>();
        if (getStackInSlot(moldSlot) != null) items.add(getStackInSlot(moldSlot));
        if (getStackInSlot(circuitSlot) != null) items.add(getStackInSlot(circuitSlot));
        return items;
    }

    public void setMold(ItemStack selected) {
        ItemStack phantom = findMatchingMold(selected);
        if (inventoryHandler != null) {
            inventoryHandler.setStackInSlot(moldSlot, phantom);
        }
        try {
            this.setInventorySlotContents(moldSlot, phantom);
        } catch (Exception ignored) {}
        markDirty();
    }

    public int findMatchingMoldIndex(ItemStack stack) {
        for (int i = 0; i < solidifierMolds.size(); i++) {
            if (GTUtility.areStacksEqual(solidifierMolds.get(i), stack, true)) return i;
        }
        return -1;
    }

    @Override
    public void onBlockDestroyed() {
        inventoryHandler.setStackInSlot(moldSlot, null);
        super.onBlockDestroyed();
    }

    @Override
    public boolean isValidSlot(int aIndex) {
        // the mold is a ghost item and the circuit is a configuration slot, neither may be dropped or picked up
        return aIndex != moldSlot && aIndex != circuitSlot && super.isValidSlot(aIndex);
    }

    @Override
    public int getCircuitSlot() {
        return circuitSlot;
    }

    @Override
    public boolean allowSelectCircuit() {
        return true;
    }

    @Override
    public int getCircuitSlotX() {
        return 153;
    }

    @Override
    public int getCircuitSlotY() {
        return 63;
    }

    @Override
    public ModularPanel buildUI(PosGuiData guiData, PanelSyncManager syncManager, UISettings uiSettings) {
        return new MTEHatchSolidifierGui(this).build(guiData, syncManager, uiSettings);
    }
}
