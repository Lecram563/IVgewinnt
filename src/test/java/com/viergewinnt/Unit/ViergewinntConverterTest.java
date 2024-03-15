package com.viergewinnt.Unit;

import com.viergewinnt.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ViergewinntConverterTest {
    @Test
    void convertShouldConvertViergewinntToViergewinntDataObject(){
        Viergewinnt viergewinnt = mock(Viergewinnt.class);
        ViergewinntDataObject viergewinntDataObject = mock(ViergewinntDataObject.class);
        ViergewinntDataObject viergewinntDataObject2 = mock(ViergewinntDataObject.class);
        ViergewinntDataObjectFactory viergewinntDataObjectFactory = mock(ViergewinntDataObjectFactory.class);
        when(viergewinntDataObjectFactory.create()).thenReturn(viergewinntDataObject);
        ViergewinntPopulatorInterface populator = mock(ViergewinntPopulatorInterface.class);
        when(populator.populate(viergewinnt, viergewinntDataObject)).thenReturn(viergewinntDataObject2);

        ViergewinntPopulatorInterface[] populators = new ViergewinntPopulatorInterface[1];
        populators[0] = populator;

        ViergewinntConverter viergewinntConverter = new ViergewinntConverter(viergewinntDataObjectFactory, populators);

        assertEquals(viergewinntDataObject2, viergewinntConverter.convert(viergewinnt));
    }
}