package com.viergewinnt.Integration;

import com.viergewinnt.GameRepository;
import com.viergewinnt.ViergewinntDataObject;
import com.viergewinnt.ViergewinntDataObjectSerializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {
    @Test
    void loadShouldLoadViergewinntDataObjectByName() {
        GameRepository gameRepository = new GameRepository(new ViergewinntDataObjectSerializer());
        ViergewinntDataObject viergewinntDataObject = gameRepository.load("Test Game");
        assertEquals(viergewinntDataObject.spieler, "X");
        assertEquals(viergewinntDataObject.winner, "none");
    }
}