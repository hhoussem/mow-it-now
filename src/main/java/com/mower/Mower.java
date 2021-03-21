package com.mower;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.mower.Orientation.*;

@Getter
@Builder
@AllArgsConstructor
public class Mower {

    private int xPosition;

    private int yPosition;

    private Orientation orientation;

    @Setter
    private Area area;

    private List<Instruction> instructions;

    public void execute() {
        instructions.forEach(instruction -> {
            switch (instruction) {
                case A:
                    forward();
                    break;
                case D:
                    turnRight();
                    break;
                case G:
                    turnLeft();
                    break;
            }
        });
    }

    public void turnRight() {
        switch (this.orientation) {
            case N:
                this.orientation = E;
                break;
            case E:
                this.orientation = S;
                break;
            case S:
                this.orientation = W;
                break;
            case W:
                this.orientation = N;
                break;
        }
    }

    public void turnLeft() {
        switch (this.orientation) {
            case N:
                this.orientation = W;
                break;
            case W:
                this.orientation = S;
                break;
            case S:
                this.orientation = E;
                break;
            case E:
                this.orientation = N;
                break;
        }

    }

    public void forward() {
        if (N.equals(orientation) && yPosition < area.getHeight()) {
            yPosition++;
        }
        if (S.equals(orientation) && yPosition > 0) {
            yPosition--;
        }
        if (E.equals(orientation) && xPosition < area.getWidth()) {
            xPosition++;
        }
        if (W.equals(orientation) && xPosition > 0) {
            xPosition--;
        }
    }
}