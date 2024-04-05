package com.viergewinnt.Unit;

import com.viergewinnt.Board;
import com.viergewinnt.FullColumnException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void placeTokenShouldPlaceTokenAtTheBottomOfTheColumn() throws FullColumnException {
        board.placeToken(0, "X");
        assertEquals("X", board.getPlayingfield()[0][0]);
    }

    @Test
    void placeTokenShouldPlaceTokenAboveAlreadySetTokens() throws FullColumnException {
        board.placeToken(0, "X");
        board.placeToken(0, "O");
        assertEquals("X", board.getPlayingfield()[0][0]);
        assertEquals("O", board.getPlayingfield()[0][1]);
    }

    @Test
    void placeTokenShouldReturnTrueWhenAPlayerWinsHorizontal() throws FullColumnException {
        board.placeToken(0, "X");
        board.placeToken(1, "X");
        board.placeToken(2, "X");
        assertTrue(board.placeToken(3, "X"));
    }

    @Test
    void placeTokenShouldReturnFalseOnRepeatingNulls() throws FullColumnException {
        assertFalse(board.placeToken(0, "X"));
    }

    @Test
    void placeTokenShouldReturnTrueWhenAPlayerWinsVertical() throws FullColumnException {
        board.placeToken(0, "X");
        board.placeToken(0, "X");
        board.placeToken(0, "X");
        assertTrue(board.placeToken(0, "X"));
    }

    @Test
    void placeTokenShouldReturnTrueWhenPlayerWinsDiagonal() throws FullColumnException {
        board.placeToken(0, "X");
        board.placeToken(1, "X");
        board.placeToken(1, "X");
        board.placeToken(2, "X");
        board.placeToken(2, "X");
        board.placeToken(2, "X");
        board.placeToken(3, "O");
        board.placeToken(3, "O");
        board.placeToken(3, "O");
        assertTrue(board.placeToken(3, "X"));
    }

}