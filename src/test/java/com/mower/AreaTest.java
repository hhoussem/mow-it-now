package com.mower;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.mower.Instruction.*;
import static com.mower.Orientation.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class AreaTest {

    @Test
    public void execute_Test() {
        //GIVEN
        Area area = new Area(5, 5);
        Mower mower1 = createMower(1, 2, N, asList(G, A, G, A, G, A, G, A, A));
        area.addMower(mower1);

        //WHEN
        area.execute();

        //THEN
        assertEquals(1, mower1.getXPosition());
        assertEquals(3, mower1.getYPosition());
        assertTrue(area.mowersPositions[1][3] == 1);
        assertEquals(N, mower1.getOrientation());

    }

    private Mower createMower(int xPosition, int yPosition, Orientation orientation, List<Instruction> instructions) {
        Mower mower = Mower.builder()
                .xPosition(xPosition)
                .yPosition(yPosition)
                .orientation(orientation)
                .instructions(instructions)
                .build();
        return mower;
    }
}