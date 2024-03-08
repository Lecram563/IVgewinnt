package com.viergewinnt.Unit;

import com.viergewinnt.Board;
import com.viergewinnt.BoardFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardFactoryTest {
    @Test
    void createShouldReturnNewBoard() {
        BoardFactory boardFactory = new BoardFactory();
        assertEquals(Board.class, boardFactory.create().getClass());
    }
}