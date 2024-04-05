package com.viergewinnt.Unit;

import com.viergewinnt.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameServiceTest {
    private GameRepository gameRepository;
    private ViergewinntConverter viergewinntConverter;
    private Viergewinnt viergewinnt;
    private ViergewinntDataObject viergewinntDataObject;
    private ViergewinntReverseConverter viergewinntReverseConverter;

    @BeforeEach
    void setUp() {
        this.gameRepository = mock(GameRepository.class);
        this.viergewinntConverter = mock(ViergewinntConverter.class);
        this.viergewinnt = mock(Viergewinnt.class);
        this.viergewinntDataObject = mock(ViergewinntDataObject.class);
        this.viergewinntReverseConverter = mock(ViergewinntReverseConverter.class);
    }

    @Test
    void saveGameShouldPutGameDataIntoRepository() {
        when(viergewinntConverter.convert(viergewinnt)).thenReturn(viergewinntDataObject);
        when(gameRepository.save(viergewinntDataObject)).thenReturn(true);

        GameService gameService = new GameService(gameRepository, viergewinntConverter, viergewinntReverseConverter);
        gameService.saveGame("Spielname", viergewinnt);
    }

    @Test
    void loadGameShouldGetGameDataFromRepositoryAndWriteItIntoViergewinnt() {
        when(viergewinntConverter.convert(viergewinnt)).thenReturn(viergewinntDataObject);
        when(gameRepository.load(viergewinntDataObject)).thenReturn(true);

        GameService gameService = new GameService(gameRepository, viergewinntConverter, viergewinntReverseConverter);
        gameService.loadGame("Spielname", viergewinnt);

        when(gameRepository.load("Spielname")).thenReturn(viergewinntDataObject);

        gameService.loadGame("Spielname", viergewinnt);
    }
}