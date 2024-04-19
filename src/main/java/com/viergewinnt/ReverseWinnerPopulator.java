package com.viergewinnt;

public class ReverseWinnerPopulator implements ViergewinntDataObjectPopulatorInterface {
    @Override
    public Viergewinnt populate(ViergewinntDataObject viergewinntDataObject, Viergewinnt viergewinnt) {
        viergewinnt.setWinner(viergewinntDataObject.winner);
        return viergewinnt;
    }
}
