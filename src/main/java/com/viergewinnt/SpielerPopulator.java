package com.viergewinnt;

public class SpielerPopulator implements ViergewinntPopulatorInterface {
    @Override
    public ViergewinntDataObject populate(Viergewinnt viergewinnt, ViergewinntDataObject viergewinntDataObject) {
        viergewinntDataObject.spieler = viergewinnt.getPlayer();
        return viergewinntDataObject;
    }
}
