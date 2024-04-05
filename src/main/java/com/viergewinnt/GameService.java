package com.viergewinnt;

public class GameService {
    GameRepository gameRepository;
    ViergewinntConverter viergewinntConverter;
    ViergewinntReverseConverter viergewinntReverseConverter;

    public GameService(GameRepository gameRepository, ViergewinntConverter viergewinntConverter, ViergewinntReverseConverter viergewinntReverseConverter) {
        this.gameRepository = gameRepository;
        this.viergewinntConverter = viergewinntConverter;
        this.viergewinntReverseConverter = viergewinntReverseConverter;
    }

    public void saveGame(String gameName, Viergewinnt viergewinnt) {
        gameRepository.save(viergewinntConverter.convert(viergewinnt));
    }

    public void loadGame(String gameName, Viergewinnt viergewinnt) {
        ViergewinntDataObject viergewinntDataObject = gameRepository.load(gameName);
        viergewinntReverseConverter.convert(viergewinntDataObject, viergewinnt);
    }
}
