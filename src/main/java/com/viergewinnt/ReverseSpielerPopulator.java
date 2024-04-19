package com.viergewinnt;

public class ReverseSpielerPopulator implements ViergewinntDataObjectPopulatorInterface {
    @Override
    public Viergewinnt populate(ViergewinntDataObject viergewinntDataObject, Viergewinnt viergewinnt) {
        viergewinnt.setPlayer(viergewinntDataObject.spieler);
        return viergewinnt;
    }
}
