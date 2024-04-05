package com.viergewinnt.Unit;

import com.viergewinnt.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BoardConverterTest {
    @Test
    void convertShouldReturnConvertedBoardDataObject() {
        Board board = mock(Board.class);
        BoardDataObjectFactory boardDataObjectFactory = new BoardDataObjectFactory();
        BoardConverter boardConverter = new BoardConverter(boardDataObjectFactory, new BoardPopulatorInterface[]{});
        assertEquals(BoardDataObject.class, boardConverter.convert(board).getClass());

    }
}