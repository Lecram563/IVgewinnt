package com.viergewinnt;

public class ViergewinntConverter {
    ViergewinntDataObjectFactory viergewinntDataObjectFactory;
    ViergewinntPopulatorInterface[] populators;

    public ViergewinntConverter(ViergewinntDataObjectFactory viergewinntDataObjectFactory, ViergewinntPopulatorInterface[] populators) {
        this.viergewinntDataObjectFactory = viergewinntDataObjectFactory;
        this.populators = populators;
    }

    public ViergewinntDataObject convert(Viergewinnt viergewinnt) {
        ViergewinntDataObject viergewinntDataObject = viergewinntDataObjectFactory.create();
        for (ViergewinntPopulatorInterface populator : populators) {
            viergewinntDataObject = populator.populate(viergewinnt, viergewinntDataObject);
        }
        return viergewinntDataObject;
    }
}
