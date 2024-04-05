package com.viergewinnt.Unit;

import com.viergewinnt.Board;
import com.viergewinnt.BoardDataObject;
import com.viergewinnt.PlayingFieldPopulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayingFieldPopulatorTest {
    @Test
    void populateShouldPopulateBoardDataObject() {
        String[][] playingField = new String[1][1];
        Board board = mock(Board.class);
        when(board.getPlayingfield()).thenReturn(playingField);

        PlayingFieldPopulator populator = new PlayingFieldPopulator();
        assertEquals(playingField, populator.populate(board, new BoardDataObject()).playingField);
    }

}