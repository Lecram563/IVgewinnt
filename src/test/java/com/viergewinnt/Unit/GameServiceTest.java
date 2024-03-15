package com.viergewinnt.Unit;

import com.viergewinnt.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameServiceTest {
    @Test
    void saveGameShouldPutGameDataIntoRepository(){
        GameRepository gameRepository = mock(GameRepository.class);
        ViergewinntConverter viergewinntConverter = mock(ViergewinntConverter.class);
        Viergewinnt viergewinnt = mock(Viergewinnt.class);
        ViergewinntDataObject viergewinntDataObject = mock(ViergewinntDataObject.class);

        when(viergewinntConverter.convert(viergewinnt)).thenReturn(viergewinntDataObject);
        when(gameRepository.save(viergewinntDataObject)).thenReturn(true);

        GameService gameService = new GameService(gameRepository, viergewinntConverter);
        gameService.saveGame("Spielname", viergewinnt);
    }
}