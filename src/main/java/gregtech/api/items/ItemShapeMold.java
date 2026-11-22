package gregtech.api.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemShapeMold extends GTGenericItem {

    private static final List<ItemShapeMold> allMolds = new ArrayList<>();
    private static final List<ItemShapeMold> solidifierMolds = new ArrayList<>();

    public static final List<ItemShapeMold> getAllMolds() {
        return Collections.unmodifiableList(allMolds);
    }

    public static final List<ItemShapeMold> getSolidifierMolds() {
        return Collections.unmodifiableList(solidifierMolds);
    }

    public ItemShapeMold(String aUnlocalizedOutput, boolean isSolidifierMold) {
        super(
            "shape_mold." + aUnlocalizedOutput,
            "shape_mold." + aUnlocalizedOutput + ".name",
            "shape_mold." + aUnlocalizedOutput + ".tooltip");
        allMolds.add(this);
        if (isSolidifierMold) solidifierMolds.add(this);
    }
}
