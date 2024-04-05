package com.viergewinnt.Integration;

import com.viergewinnt.GameRepository;
import com.viergewinnt.ViergewinntDataObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {
    @Test
    void loadShouldLoadViergewinntDataObjectByName() {
        GameRepository gameRepository = new GameRepository();
        ViergewinntDataObject viergewinntDataObject = gameRepository.load("Test Game");
        //todo
    }
}