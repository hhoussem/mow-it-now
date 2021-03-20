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
        switch (this.orientation) {
            case N:
                this.orientation =  Orientation.E;
                break;
            case E:
                this.orientation =  Orientation.S;
                break;
            case S:
                this.orientation =  Orientation.W;
                break;
            case W:
                break;
        }

    }

}