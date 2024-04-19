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
        String token = playingfield[column][height];
        if (token == null) return false;
        int[] directions = {-1, 1}; // Richtungen für die Diagonalprüfung: -1 für aufwärts, 1 für abwärts

        for (int hDir : directions) {
            for (int vDir : directions) {
                int count = 1;
                int h = height;
                int v = column;

                // Überprüfung in einer Richtung
                while (true) {
                    h += hDir;
                    v += vDir;
                    if (h < 0 || h >= playingfield[0].length || v < 0 || v >= playingfield.length || !Objects.equals(playingfield[v][h], token)) {
                        break;
                    }
                    count++;
                }

                h = height;
                v = column;

                // Überprüfung in der entgegengesetzten Richtung
                while (true) {
                    h -= hDir;
                    v -= vDir;
                    if (h < 0 || h >= playingfield[0].length || v < 0 || v >= playingfield.length || !Objects.equals(playingfield[v][h], token)) {
                        break;
                    }
                    count++;
                }

                // Mindestens vier Tokens in einer Reihe
                if (count >= 4) {
                    return true;
                }
            }
        }
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

    public void setPlayingfield(String[][] playingField) {
        this.playingfield = playingField;
    }
}
