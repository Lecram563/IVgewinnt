package com.viergewinnt;

public class ReversePlayingFieldPopulator implements ReverseBoardPopulatorInterface {
    @Override
    public Board populate(BoardDataObject boardDataObject, Board board) {
        board.setPlayingfield(boardDataObject.playingField);
        return board;
    }
}
