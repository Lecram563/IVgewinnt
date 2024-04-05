package com.viergewinnt;

public class BoardPopulator implements ViergewinntPopulatorInterface {
    private final BoardConverter boardConverter;

    public BoardPopulator(BoardConverter boardConverter) {
        this.boardConverter = boardConverter;
    }

    @Override
    public ViergewinntDataObject populate(Viergewinnt viergewinnt, ViergewinntDataObject viergewinntDataObject) {
        viergewinntDataObject.board = boardConverter.convert(viergewinnt.getBoard());
        return viergewinntDataObject;
    }
}
