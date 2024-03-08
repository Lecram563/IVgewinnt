package com.viergewinnt.Integration;

import com.viergewinnt.Board;
import com.viergewinnt.BoardFactory;
import com.viergewinnt.FullColumnException;
import com.viergewinnt.Viergewinnt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViergewinntTest {
    private Viergewinnt viergewinnt;

    @BeforeEach
    void setUp() {
        viergewinnt = new Viergewinnt(new BoardFactory());
    }

    @Test
    void testExecute() {
        viergewinnt.execute();
        assertEquals(Board.class, viergewinnt.getBoard().getClass());
    }

    @Test
    void testMove() throws FullColumnException {
        viergewinnt.execute();
        viergewinnt.move(1);
        viergewinnt.move(1);
        assertEquals("X", viergewinnt.getBoard().getPlayingfield()[0][0]);
        assertEquals("O", viergewinnt.getBoard().getPlayingfield()[0][1]);
    }

    @Test
    void horizontalWin() throws FullColumnException {
        viergewinnt.execute();
        viergewinnt.move(1);
        viergewinnt.move(2);
        viergewinnt.move(1);
        viergewinnt.move(3);

        assertEquals("None", viergewinnt.getWinner());

        viergewinnt.move(1);
        viergewinnt.move(4);
        viergewinnt.move(1);
        viergewinnt.move(5);
        assertEquals("O", viergewinnt.getWinner());
    }

    @Test
    void verticalWin() throws FullColumnException {
        viergewinnt.execute();
        viergewinnt.move(2);
        viergewinnt.move(1);
        viergewinnt.move(2);
        viergewinnt.move(1);
        viergewinnt.move(2);
        viergewinnt.move(1);
        viergewinnt.move(2);
        assertEquals("X", viergewinnt.getWinner());
    }
}