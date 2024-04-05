package com.viergewinnt;

public class WinnerPopulator implements ViergewinntPopulatorInterface {
    @Override
    public ViergewinntDataObject populate(Viergewinnt viergewinnt, ViergewinntDataObject viergewinntDataObject) {
        viergewinntDataObject.winner = viergewinnt.getWinner();
        return viergewinntDataObject;
    }
}
