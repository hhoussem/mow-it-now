import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MowerTest {

    private Mower mower;

    @Before
    public void init(){
        mower = Mower.builder()
                .xPosition(0)
                .yPosition(0)
                .orientation(Orientation.N)
                .build();
    }

    @Ignore
    @Test
    public void turnRight_Test() {
        mower.turnRight();
        Assert.assertEquals(Orientation.E,mower.getOrientation());

    }
}
