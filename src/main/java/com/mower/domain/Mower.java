package com.mower.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.mower.domain.Orientation.*;

@Getter
@Builder
@AllArgsConstructor
public class Mower {

    private int xPosition;

    private int yPosition;

    private Orientation orientation;

    @Setter
    private Area area;

    @Setter
    private List<Instruction> instructions;

    public Mower(int xPosition, int yPosition, Orientation orientation) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.orientation = orientation;
    }

    public String execute() {
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
        return this.toString();
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

    public boolean forward() {
        boolean forward = false;

        if (N.equals(orientation)
                && area.isEmptyPosition(this.xPosition, this.yPosition +1)) {
            yPosition++;
            forward = true;
        } else if (S.equals(orientation)
                && area.isEmptyPosition(this.xPosition, this.yPosition -1)) {
            yPosition--;
            forward = true;
        } else if (E.equals(orientation)
                && area.isEmptyPosition(this.xPosition+1, this.yPosition)) {
            xPosition++;
            forward = true;
        } else if (W.equals(orientation)
                && area.isEmptyPosition(this.xPosition-1, this.yPosition)) {
            xPosition--;
            forward = true;
        }

        return forward;
    }

    @Override
    public String toString() {
        return xPosition + " "
                + yPosition + " "
                + orientation;
    }
}