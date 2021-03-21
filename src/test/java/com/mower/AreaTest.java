package com.mower;

import org.junit.Test;

import java.util.Collections;
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
        assertEquals(N, mower1.getOrientation());

    }

    @Test
    public void execute_when__there_is_another_barrier_mower_Test() {
        //GIVEN
        Area area = new Area(5, 5);
        Mower fixedMower = createMower(1, 3, E, Collections.emptyList());
        area.addMower(fixedMower);
        Mower mower = createMower(1, 2, N, asList(A));
        area.addMower(mower);


        //WHEN
        area.execute();

        //THEN
        // mower should not move because fixedMower is in the next move position of it
        assertEquals(1, mower.getXPosition());
        assertEquals(2, mower.getYPosition());
        assertEquals(N, mower.getOrientation());

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