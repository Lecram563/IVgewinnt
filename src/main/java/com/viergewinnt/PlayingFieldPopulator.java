package com.viergewinnt;

public class PlayingFieldPopulator implements BoardPopulatorInterface {
    @Override
    public BoardDataObject populate(Board board, BoardDataObject boardDataObject) {
        boardDataObject.playingField = board.getPlayingfield();
        return boardDataObject;
    }
}
