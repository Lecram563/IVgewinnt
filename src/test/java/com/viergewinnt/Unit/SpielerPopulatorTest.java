package com.viergewinnt.Unit;

import com.viergewinnt.SpielerPopulator;
import com.viergewinnt.Viergewinnt;
import com.viergewinnt.ViergewinntDataObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SpielerPopulatorTest {
    @Test
    public void populateShouldPopulateSpieler() {
        Viergewinnt viergewinnt = mock(Viergewinnt.class);
        ViergewinntDataObject viergewinntDataObject = new ViergewinntDataObject();
        SpielerPopulator spielerPopulator = new SpielerPopulator();

        when(viergewinnt.getPlayer()).thenReturn("X");
        assertEquals("X", spielerPopulator.populate(viergewinnt, viergewinntDataObject).spieler);
    }

}