package com.viergewinnt.Unit;

import com.viergewinnt.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ViergewinntReverseConverterTest {
    @Test
    void convertShouldConvertViergewinntDataObjectIntoViergewinnt() {
        BoardDataObject boardDataObject = mock(BoardDataObject.class);
        ViergewinntDataObject viergewinntDataObject = new ViergewinntDataObject();
        viergewinntDataObject.board = boardDataObject;
        viergewinntDataObject.spieler = "X";
        viergewinntDataObject.winner = "None";
        Viergewinnt viergewinnt = mock(Viergewinnt.class);
        ViergewinntDataObjectPopulatorInterface populator = mock(ViergewinntDataObjectPopulatorInterface.class);
        when(populator.populate(viergewinntDataObject, viergewinnt)).thenReturn(viergewinnt);
        ViergewinntDataObjectPopulatorInterface[] populators = new ViergewinntDataObjectPopulatorInterface[1];
        populators[0] = populator;
        ViergewinntReverseConverter converter = new ViergewinntReverseConverter(populators);
        converter.convert(viergewinntDataObject, viergewinnt);
    }

}