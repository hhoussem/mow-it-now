package com.mower;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.mower.Instruction.*;
import static com.mower.Orientation.*;


public class MowerTest {

    @Test
    public void turnRight_Test() {
        Mower mower = createMower(N);
        mower.turnRight();
        Assert.assertEquals(E,mower.getOrientation());
        mower.turnRight();
        Assert.assertEquals(S,mower.getOrientation());
        mower.turnRight();
        Assert.assertEquals(W,mower.getOrientation());
        mower.turnRight();
        Assert.assertEquals(N,mower.getOrientation());

    }

    @Test
    public void turnLeft_Test() {
        Mower mower = createMower(N);
        mower.turnLeft();
        Assert.assertEquals(W,mower.getOrientation());
        mower.turnLeft();
        Assert.assertEquals(S,mower.getOrientation());
        mower.turnLeft();
        Assert.assertEquals(E,mower.getOrientation());
        mower.turnLeft();
        Assert.assertEquals(N,mower.getOrientation());

    }

    @Test
    public void forward_north_initialized_Test() {
        Mower mower = createMower(N);
        mower.forward();
        Assert.assertEquals(1,mower.getYPosition());

        mower = createMower(5,5,N);
        mower.forward();
        Assert.assertEquals(5,mower.getYPosition());

    }


    @Test
    public void forward_south_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3,2,S);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(1,mower.getYPosition());

        //GIVEN
        mower = createMower(S);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(0,mower.getYPosition());

    }

    @Test
    public void forward_east_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3,2,E);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(4,mower.getXPosition());

        //GIVEN
        mower = createMower(E);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(1,mower.getXPosition());

    }

    @Test
    public void forward_west_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3,2,W);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(2,mower.getXPosition());

        //GIVEN
        mower = createMower(W);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(0,mower.getXPosition());

    }

    @Test
    public void execute_Test() {
        //GIVEN
        Mower mower = createMower(1,2, N, Arrays.asList(G,A,G,A,G,A,G,A,A));
        //WEN
        mower.execute();
        //THEN
        Assert.assertEquals(1,mower.getXPosition());
        Assert.assertEquals(3,mower.getYPosition());
        Assert.assertEquals(N,mower.getOrientation());

    }


    private Mower createMower(Orientation orientation){
        Mower mower = Mower.builder()
                .xPosition(0)
                .yPosition(0)
                .orientation(orientation)
                .area(Area.builder()
                        .height(5)
                        .width(5)
                        .build())
                .build();
        return mower;
    }

    private Mower createMower(int xPosition, int yPosition, Orientation orientation){
        Mower mower = Mower.builder()
                .xPosition(xPosition)
                .yPosition(yPosition)
                .orientation(orientation)
                .area(Area.builder()
                        .height(5)
                        .width(5)
                        .build())
                .build();
        return mower;
    }

    private Mower createMower(int xPosition, int yPosition, Orientation orientation, List<Instruction> instructions) {
        Mower mower = Mower.builder()
                .xPosition(xPosition)
                .yPosition(yPosition)
                .orientation(orientation)
                .area(Area.builder()
                        .height(5)
                        .width(5)
                        .build())
                .instructions(instructions)
                .build();
        return mower;
    }
}
