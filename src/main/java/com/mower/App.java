package com.mower;

import com.mower.domain.Area;
import com.mower.domain.Instruction;
import com.mower.domain.Mower;
import com.mower.domain.Orientation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        System.out.println(App.read("5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA"));
    }

    public static String read(String input) {
        String[] lines = input.split("\n");
        //TODO if(lines.length < 3 || lines.length % 2  == 0)
        Area area = mapToArea(lines[0]);
        Mower mower = null;
        for (int i = 1; i < lines.length; i++) {
            if (i % 2 == 1) {
                mower = mapToMower(lines[i]);
            } else {
                mower.setInstructions(mapToInstructions(lines[i]));
                area.addMower(mower);
            }
        }
        return area.execute();
    }

    private static List<Instruction> mapToInstructions(String line) {
        return Arrays.stream(line.split(""))
                .map(Instruction::valueOf)
                .collect(Collectors.toList());
    }

    private static Mower mapToMower(String line) {
        String[] mowerProperties = line.split(" ");
        //TODO  if(areaDimensions.length != 3)
        int xPosition = Integer.valueOf(mowerProperties[0]);
        int yPosition = Integer.valueOf(mowerProperties[1]);
        Orientation orientation = Orientation.valueOf(mowerProperties[2]);
        return new Mower(xPosition, yPosition, orientation);
    }

    private static Area mapToArea(String line) {
        String[] areaDimensions = line.split(" ");
        //TODO  if(areaDimensions.length != 2)
        int width = Integer.valueOf(areaDimensions[0]);
        int height = Integer.valueOf(areaDimensions[1]);
        return new Area(width, height);
    }
}
