package com.viergewinnt;

public class GameService {
    GameRepository gameRepository;
    ViergewinntConverter viergewinntConverter;

    public GameService(GameRepository gameRepository, ViergewinntConverter viergewinntConverter) {
        this.gameRepository = gameRepository;
        this.viergewinntConverter = viergewinntConverter;
    }

    public void saveGame(String gameName, Viergewinnt viergewinnt) {
    }

    public void loadGame(String gameName, Viergewinnt viergewinnt) {
    }
}
