package com.viergewinnt;

public class GameRepository {
    public boolean save(ViergewinntDataObject viergewinntDataObject) {
        return true;
    }

    public ViergewinntDataObject load(String gameName) {
        return new ViergewinntDataObject();
    }
}
