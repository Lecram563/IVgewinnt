package com.viergewinnt;

import java.util.Objects;

public class Viergewinnt {
    private Board board;
    private final BoardFactory boardFactory;
    private String player = "X";

    private String winner = "None";

    public Viergewinnt(BoardFactory boardFactory) {
        this.boardFactory = boardFactory;
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
}