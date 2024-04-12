package com.viergewinnt;

public class ViergewinntReverseConverter {
    ViergewinntDataObjectPopulatorInterface[] populators;

    public ViergewinntReverseConverter(ViergewinntDataObjectPopulatorInterface[] populators) {
        this.populators = populators;
    }

    public void convert(ViergewinntDataObject viergewinntDataObject, Viergewinnt viergewinnt) {
        for (ViergewinntDataObjectPopulatorInterface populator : populators) {
            viergewinnt = populator.populate(viergewinntDataObject, viergewinnt);
        }
    }
}
