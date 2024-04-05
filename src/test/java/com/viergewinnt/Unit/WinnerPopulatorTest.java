package com.viergewinnt.Unit;

import com.viergewinnt.SpielerPopulator;
import com.viergewinnt.Viergewinnt;
import com.viergewinnt.ViergewinntDataObject;
import com.viergewinnt.WinnerPopulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WinnerPopulatorTest {

    @Test
    public void populateShouldPopulateWinner() {
        Viergewinnt viergewinnt = mock(Viergewinnt.class);
        ViergewinntDataObject viergewinntDataObject = new ViergewinntDataObject();
        WinnerPopulator spielerPopulator = new WinnerPopulator();

        when(viergewinnt.getWinner()).thenReturn("X");
        assertEquals("X", spielerPopulator.populate(viergewinnt, viergewinntDataObject).winner);

    }

}