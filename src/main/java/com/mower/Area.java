package com.mower;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Area {

    @Getter
    private final int width;

    @Getter
    private final int height;

    private final List<Mower> mowers = new ArrayList<>();

    public int[][] mowersPositions;

    public Area(int width, int height) {
        this.width = width;
        this.height = height;
        this.mowersPositions = new int[width][height];
    }

    public void addMower(Mower mower){
        mower.setArea(this);
        this.mowers.add(mower);
    }

    public void execute(){
        this.mowers.forEach(mower -> {
            mower.execute();
            mowersPositions[mower.getXPosition()][mower.getYPosition()] = 1;
        });
    }

}
