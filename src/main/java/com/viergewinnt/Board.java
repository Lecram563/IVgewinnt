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
        return checkHorizontal(playingfield, height);
    }

    private Boolean checkHorizontal(String[][] playingfield, int height) {
        String[] row = new String[7];
        for (int column = 0; column < 7; column++) {
            row[column] = playingfield[column][height];
        }
        return fourInOrder(row);
    }

    private Boolean fourInOrder(String[] row) {
        return tokensAreEqual(row[0], row[1], row[2], row[3]) ||
                tokensAreEqual(row[1], row[2], row[3], row[4]) ||
                tokensAreEqual(row[2], row[3], row[4], row[5]) ||
                tokensAreEqual(row[3], row[4], row[5], row[6]);
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
