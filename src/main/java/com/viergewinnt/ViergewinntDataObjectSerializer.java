package com.viergewinnt;

import com.google.gson.Gson;

import java.util.List;

public class ViergewinntDataObjectSerializer {
    public String serialize(ViergewinntDataObject viergewinntDataObject) {
        Gson gson = new Gson();
        return gson.toJson(viergewinntDataObject);
    }
}
