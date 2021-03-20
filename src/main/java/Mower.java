import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Mower {

    private int xPosition;

    private int yPosition;

    private Orientation orientation;

    public void turnRight() {

    }

}