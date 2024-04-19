package com.viergewinnt.Integration;

import com.viergewinnt.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViergewinntTest {
    private Viergewinnt viergewinnt;

    @BeforeEach
    void setUp() {
        BoardPopulatorInterface[] boardPopulatorInterfaces = new BoardPopulatorInterface[1];
        boardPopulatorInterfaces[0] = new PlayingFieldPopulator();
        ViergewinntPopulatorInterface[] viergewinntPopulatorInterfaces = new ViergewinntPopulatorInterface[3];
        viergewinntPopulatorInterfaces[0] = new SpielerPopulator();
        viergewinntPopulatorInterfaces[1] = new WinnerPopulator();
        viergewinntPopulatorInterfaces[2] = new BoardPopulator(new BoardConverter(new BoardDataObjectFactory(), boardPopulatorInterfaces));
        ViergewinntDataObjectPopulatorInterface[] viergewinntDataObjectPopulatorInterfaces = new ViergewinntDataObjectPopulatorInterface[3];
        viergewinntDataObjectPopulatorInterfaces[0] = new ReverseSpielerPopulator();
        viergewinntDataObjectPopulatorInterfaces[1] = new ReverseWinnerPopulator();
        ReverseBoardPopulatorInterface[] reverseBoardPopulatorInterfaces = new ReverseBoardPopulatorInterface[1];
        reverseBoardPopulatorInterfaces[0] = new ReversePlayingFieldPopulator();
        viergewinntDataObjectPopulatorInterfaces[2] = new reverseBoardPopulator(new ReverseBoardConverter(new BoardFactory(), reverseBoardPopulatorInterfaces));
        viergewinnt = new Viergewinnt(new BoardFactory(), new GameService(new GameRepository(), new ViergewinntConverter(new ViergewinntDataObjectFactory(), viergewinntPopulatorInterfaces), new ViergewinntReverseConverter(viergewinntDataObjectPopulatorInterfaces)));
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


    @Test
    void diagonalWin() throws FullColumnException {
        viergewinnt.execute();
        viergewinnt.move(1);
        viergewinnt.move(2);
        viergewinnt.move(2);
        viergewinnt.move(3);
        viergewinnt.move(3);
        viergewinnt.move(4);
        viergewinnt.move(3);
        viergewinnt.move(4);
        viergewinnt.move(4);
        viergewinnt.move(1);
        viergewinnt.move(4);
        assertEquals("X", viergewinnt.getWinner());
    }


    @Test
    void saveAndLoadGame() throws FullColumnException {
        viergewinnt.execute();
        viergewinnt.move(1);
        viergewinnt.saveGame("Neues Spiel");
        viergewinnt.execute();
        assertNull(viergewinnt.getBoard().getPlayingfield()[0][0]);
        viergewinnt.loadGame("Neues Spiel");
        assertEquals("X", viergewinnt.getBoard().getPlayingfield()[0][0]);
    }
}