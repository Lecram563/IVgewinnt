package com.viergewinnt;

public class Viergewinnt {
    private Board board;
    private final BoardFactory boardFactory;

    public Viergewinnt(BoardFactory boardFactory) {
        this.boardFactory = boardFactory;
    }

    public void execute() {
        this.board = this.boardFactory.create();
    }

    public Board getBoard() {
        return this.board;
    }
}