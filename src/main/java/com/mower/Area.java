package com.mower;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Area {

    @Getter
    private final int width;

    @Getter
    private final int height;

    private final List<Mower> mowers = new ArrayList<>();

    private int[][] mowersPositions;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
        this.mowersPositions = new int[width+1][height+1];
    }

    public void addMower(Mower mower){
        mower.setArea(this);
        this.mowers.add(mower);
    }

    public String execute(){
        List<String> mowersFinishPositions = new ArrayList();
        this.mowers.forEach(mower -> {
            mower.execute();
            mowersPositions[mower.getXPosition()][mower.getYPosition()] = 1;
            mowersFinishPositions.add(mower.toString());
        });
        return mowersFinishPositions.stream().collect(Collectors.joining("\n"));
    }

    public boolean isEmptyPosition(int xPosition, int yPosition) {
        return xPosition >= 0
                && xPosition <= width
                && yPosition >= 0
                && yPosition <= height
                && mowersPositions[xPosition][yPosition] == 0;
    }
}
