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
    public void forward_Test() {
        Mower mower = createMower(Orientation.N);
        mower.forward();
        Assert.assertEquals(1,mower.getYPosition());

        mower.forward();  mower.forward();  mower.forward();mower.forward();  mower.forward();
        Assert.assertEquals(5,mower.getYPosition());

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
}
