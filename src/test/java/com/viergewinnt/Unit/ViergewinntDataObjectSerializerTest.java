package com.viergewinnt.Unit;

import com.viergewinnt.BoardDataObject;
import com.viergewinnt.ViergewinntDataObject;
import com.viergewinnt.ViergewinntDataObjectSerializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViergewinntDataObjectSerializerTest {
    @Test
    public void serializeShouldSerializeViergewinntDataObjectIntoJsonObject() {
        ViergewinntDataObject viergewinntDataObject = new ViergewinntDataObject();
        viergewinntDataObject.winner = "none";
        viergewinntDataObject.spieler = "X";
        BoardDataObject boardDataObject = new BoardDataObject();
        boardDataObject.playingField = new String[5][6];
        viergewinntDataObject.board = boardDataObject;

        ViergewinntDataObjectSerializer serializer = new ViergewinntDataObjectSerializer();
        assertEquals(
                "",
                serializer.serialize(viergewinntDataObject)
        );
    }
}