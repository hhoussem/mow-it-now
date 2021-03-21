package com.mower;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.mower.Instruction.*;
import static com.mower.Orientation.*;
import static java.util.Collections.emptyList;


public class MowerTest {

    private Area area = Area.builder()
            .height(5)
            .width(5)
            .build();

    @Test
    public void turnRight_Test() {
        //GIVEN
        Mower mower = createMower(N);
        //WHEN
        mower.turnRight();
        //THEN
        Assert.assertEquals(E, mower.getOrientation());

        //WHEN
        mower.turnRight();
        //THEN
        Assert.assertEquals(S, mower.getOrientation());

        //WHEN
        mower.turnRight();
        //THEN
        Assert.assertEquals(W, mower.getOrientation());

        //WHEN
        mower.turnRight();
        //THEN
        Assert.assertEquals(N, mower.getOrientation());

    }

    @Test
    public void turnLeft_Test() {
        //GIVEN
        Mower mower = createMower(N);
        //WHEN
        mower.turnLeft();
        //THEN
        Assert.assertEquals(W, mower.getOrientation());

        //WHEN
        mower.turnLeft();
        //THEN
        Assert.assertEquals(S, mower.getOrientation());

        //WHEN
        mower.turnLeft();
        //THEN
        Assert.assertEquals(E, mower.getOrientation());

        //WHEN
        mower.turnLeft();
        //THEN
        Assert.assertEquals(N, mower.getOrientation());

    }

    @Test
    public void forward_north_initialized_Test() {
        //GIVEN
        Mower mower = createMower(N);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(1, mower.getYPosition());

        //GIVEN
        mower = createMower(5, 5, N);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(5, mower.getYPosition());

    }


    @Test
    public void forward_south_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3, 2, S);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(1, mower.getYPosition());

        //GIVEN
        mower = createMower(S);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(0, mower.getYPosition());

    }

    @Test
    public void forward_east_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3, 2, E);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(4, mower.getXPosition());

        //GIVEN
        mower = createMower(E);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(1, mower.getXPosition());

    }

    @Test
    public void forward_west_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3, 2, W);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(2, mower.getXPosition());

        //GIVEN
        mower = createMower(W);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(0, mower.getXPosition());

    }

    @Test
    public void execute_Test() {
        //GIVEN
        Mower mower = createMower(1, 2, N, Arrays.asList(G, A, G, A, G, A, G, A, A));
        //WEN
        mower.execute();
        //THEN
        Assert.assertEquals(1, mower.getXPosition());
        Assert.assertEquals(3, mower.getYPosition());
        Assert.assertEquals(N, mower.getOrientation());
    }


    private Mower createMower(Orientation orientation) {
        return createMower(0, 0, orientation);
    }

    private Mower createMower(int xPosition, int yPosition, Orientation orientation) {
        return createMower(xPosition,yPosition,orientation, emptyList());
    }

    private Mower createMower(int xPosition, int yPosition, Orientation orientation, List<Instruction> instructions) {
        Mower mower = Mower.builder()
                .xPosition(xPosition)
                .yPosition(yPosition)
                .orientation(orientation)
                .area(area)
                .instructions(instructions)
                .build();
        return mower;
    }
}
