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

    private Area area;

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
                this.orientation =  Orientation.N;
                break;
        }
    }

    public void turnLeft() {
        switch (this.orientation) {
            case N:
                this.orientation = Orientation.W;
                break;
            case W:
                this.orientation = Orientation.S;
                break;
            case S:
                this.orientation = Orientation.E;
                break;
            case E:
                this.orientation = Orientation.N;
                break;
        }

    }

    public void forward() {
        if(Orientation.N.equals(orientation) && yPosition < area.getHeight()){
            yPosition++;
        }
        if(Orientation.S.equals(orientation) && yPosition > 0 ){
            yPosition--;
        }
        if(Orientation.E.equals(orientation) && xPosition < area.getWidth()){
            xPosition++;
        }
    }
}