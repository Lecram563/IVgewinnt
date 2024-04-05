package com.viergewinnt.Unit;

import com.viergewinnt.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BoardPopulatorTest {
    @Test
    void populateShouldCallBoardConverterWithBoardAndReturnConverterBoard() {
        BoardConverter boardConverter = mock(BoardConverter.class);
        BoardPopulator boardPopulator = new BoardPopulator(boardConverter);
        Viergewinnt viergewinnt = mock(Viergewinnt.class);
        ViergewinntDataObject viergewinntDataObject = new ViergewinntDataObject();
        Board board = mock(Board.class);
        when(board.getPlayingfield()).thenReturn(new String[1][1]);
        when(viergewinnt.getBoard()).thenReturn(board);
        BoardDataObject boardDataObject = new BoardDataObject();
        when(boardConverter.convert(board)).thenReturn(boardDataObject);

        assertEquals(boardDataObject, boardPopulator.populate(viergewinnt, viergewinntDataObject).board);
    }
}