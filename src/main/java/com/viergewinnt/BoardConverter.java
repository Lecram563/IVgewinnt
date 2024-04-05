package com.viergewinnt;

public class BoardConverter {
    BoardDataObjectFactory boardDataObjectFactory;
    BoardPopulatorInterface[] populators;

    public BoardConverter(BoardDataObjectFactory boardDataObjectFactory, BoardPopulatorInterface[] populators) {
        this.boardDataObjectFactory = boardDataObjectFactory;
        this.populators = populators;
    }

    public BoardDataObject convert(Board board) {
        BoardDataObject boardDataObject = boardDataObjectFactory.create();
        for (BoardPopulatorInterface populator : populators) {
            boardDataObject = populator.populate(board, boardDataObject);
        }
        return boardDataObject;
    }
}
