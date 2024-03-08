package com.viergewinnt.Integration;

import com.viergewinnt.Board;
import com.viergewinnt.BoardFactory;
import com.viergewinnt.Viergewinnt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViergewinntTest {
    @Test
    void testExecute() {
        Viergewinnt viergewinnt = new Viergewinnt(new BoardFactory());
        viergewinnt.execute();
        assertEquals(Board.class, viergewinnt.getBoard().getClass());
    }
}