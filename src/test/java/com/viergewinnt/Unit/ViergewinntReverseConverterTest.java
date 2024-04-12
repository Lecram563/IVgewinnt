package com.viergewinnt.Unit;

import com.viergewinnt.BoardDataObject;
import com.viergewinnt.Viergewinnt;
import com.viergewinnt.ViergewinntDataObject;
import com.viergewinnt.ViergewinntReverseConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ViergewinntReverseConverterTest {
    @Test
    void convertShouldConvertViergewinntDataObjectIntoViergewinnt() {
        BoardDataObject boardDataObject = mock(BoardDataObject.class);
        ViergewinntDataObject viergewinntDataObject = new ViergewinntDataObject();
        viergewinntDataObject.board = boardDataObject;
        viergewinntDataObject.spieler = "X";
        viergewinntDataObject.winner = "None";
        Viergewinnt viergewinnt = mock(Viergewinnt.class);

        ViergewinntReverseConverter converter = new ViergewinntReverseConverter();
        converter.convert(viergewinntDataObject, viergewinnt);


    }

}