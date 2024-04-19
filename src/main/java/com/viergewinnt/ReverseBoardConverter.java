package com.viergewinnt;

public class ReverseBoardConverter {
    private final ReverseBoardPopulatorInterface[] populators;
    private final BoardFactory boardFactory;

    public ReverseBoardConverter(BoardFactory boardFactory, ReverseBoardPopulatorInterface[] populators) {
        this.boardFactory = boardFactory;
        this.populators = populators;
    }

    public Board convert(BoardDataObject boardDataObject){
        Board board = boardFactory.create();
        for (ReverseBoardPopulatorInterface populator : populators) {
            board = populator.populate(boardDataObject, board);
        }
        return board;
    }
}
