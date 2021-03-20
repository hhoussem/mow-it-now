import org.junit.Assert;
import org.junit.Test;

public class MowerTest {

    @Test
    public void turnRight_Test() {
        Mower mower = createMower(Orientation.N);
        mower.turnRight();
        Assert.assertEquals(Orientation.E,mower.getOrientation());
        mower.turnRight();
        Assert.assertEquals(Orientation.S,mower.getOrientation());
        mower.turnRight();
        Assert.assertEquals(Orientation.W,mower.getOrientation());
        mower.turnRight();
        Assert.assertEquals(Orientation.N,mower.getOrientation());

    }

    @Test
    public void turnLeft_Test() {
        Mower mower = createMower(Orientation.N);
        mower.turnLeft();
        Assert.assertEquals(Orientation.W,mower.getOrientation());
        mower.turnLeft();
        Assert.assertEquals(Orientation.S,mower.getOrientation());
        mower.turnLeft();
        Assert.assertEquals(Orientation.E,mower.getOrientation());
        mower.turnLeft();
        Assert.assertEquals(Orientation.N,mower.getOrientation());

    }

    @Test
    public void forward_north_initialized_Test() {
        Mower mower = createMower(Orientation.N);
        mower.forward();
        Assert.assertEquals(1,mower.getYPosition());

        mower = createMower(5,5,Orientation.N);
        mower.forward();
        Assert.assertEquals(5,mower.getYPosition());

    }


    @Test
    public void forward_south_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3,2,Orientation.S);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(1,mower.getYPosition());

        //GIVEN
        mower = createMower(Orientation.S);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(0,mower.getYPosition());

    }

    @Test
    public void forward_east_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3,2,Orientation.E);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(4,mower.getXPosition());

        //GIVEN
        mower = createMower(Orientation.E);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(1,mower.getXPosition());

    }

    @Test
    public void forward_west_initialized_Test() {
        //GIVEN
        Mower mower = createMower(3,2,Orientation.W);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(2,mower.getXPosition());

        //GIVEN
        mower = createMower(Orientation.W);
        //WHEN
        mower.forward();
        //THEN
        Assert.assertEquals(0,mower.getXPosition());

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
}
