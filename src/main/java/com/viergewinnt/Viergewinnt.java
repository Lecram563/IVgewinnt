package com.viergewinnt;

import java.util.Objects;

public class Viergewinnt {
    private Board board;
    private final BoardFactory boardFactory;
    private final GameService gameService;
    private String player = "X";

    private String winner = "None";

    public Viergewinnt(BoardFactory boardFactory, GameService gameService) {
        this.boardFactory = boardFactory;
        this.gameService = gameService;
    }

    public void execute() {
        board = this.boardFactory.create();
    }

    public Board getBoard() {
        return board;
    }

    public void move(int column) throws FullColumnException {
        Boolean winstatus = board.placeToken(column - 1, player);
        if(winstatus) {
            this.winner = player;
        }
        switchPlayers();
    }

    private void switchPlayers() {
        if (Objects.equals(player, "X")) {
            player = "O";
        } else {
            player = "X";
        }
    }

    public String getWinner() {
        return winner;
    }

    public void saveGame(String gameName) {
        gameService.saveGame(gameName, this);
    }

    public String getPlayer() {
        return player;
    }
}