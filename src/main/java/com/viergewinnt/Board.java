package com.viergewinnt;

import java.util.Objects;

public class Board {
    String[][] playingfield;

    public Board() {
        playingfield = new String[7][6];
    }

    public String[][] getPlayingfield() {
        return playingfield;
    }

    public Boolean placeToken(int column, String playerToken) throws FullColumnException {
        int height = getNextPosition(playingfield[column]);
        playingfield[column][height] = playerToken;
        return checkForWinner(playingfield, column, height);
    }

    private Boolean checkForWinner(String[][] playingfield, int column, int height) {
        return checkHorizontal(playingfield, height) || checkVertical(playingfield[column]) || checkDiagonal(playingfield, column, height);
    }

    private boolean checkDiagonal(String[][] playingfield, int column, int height) {
        return false;
    }

    private boolean checkVertical(String[] row) {
        return fourInOrder(row);
    }

    private Boolean checkHorizontal(String[][] playingfield, int height) {
        String[] row = new String[7];
        for (int column = 0; column < 7; column++) {
            row[column] = playingfield[column][height];
        }
        return fourInOrder(row);
    }

    private Boolean fourInOrder(String[] row) {
        for (int i = 3; i < row.length; i++) {
            if (tokensAreEqual(row[i - 3], row[i - 2], row[i - 1], row[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean tokensAreEqual(String s, String s1, String s2, String s3) {
        return !Objects.equals(null, s) && Objects.equals(s, s1) && Objects.equals(s, s2) && Objects.equals(s, s3);
    }

    private int getNextPosition(String[] column) throws FullColumnException {
        for (int key = 0; key < 7; key++) {
            if (null == column[key]) {
                return key;
            }
        }
        throw new FullColumnException();
    }
}
