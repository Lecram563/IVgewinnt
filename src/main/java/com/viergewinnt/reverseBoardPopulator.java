package com.viergewinnt;

public class reverseBoardPopulator implements ViergewinntDataObjectPopulatorInterface {
    private final ReverseBoardConverter reverseBoardConverter;

    public reverseBoardPopulator(ReverseBoardConverter reverseBoardConverter) {
        this.reverseBoardConverter = reverseBoardConverter;
    }

    @Override
    public Viergewinnt populate(ViergewinntDataObject viergewinntDataObject, Viergewinnt viergewinnt) {
        viergewinnt.setBoard(reverseBoardConverter.convert(viergewinntDataObject.board));
        return viergewinnt;
    }
}
