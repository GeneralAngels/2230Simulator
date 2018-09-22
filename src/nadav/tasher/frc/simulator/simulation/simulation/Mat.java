package nadav.tasher.frc.simulator.simulation.simulation;

import nadav.tasher.frc.simulator.simulation.robot.Robot;

import java.awt.*;
import java.util.ArrayList;

public class Mat {
    private int sizeX = 100, sizeY = 100;
    private ArrayList<Obstacle> obstacle = new ArrayList<>();
    private ArrayList<Robot> robots = new ArrayList<>();

    public Mat() {
    }

    public Mat(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void draw(Canvas canvas) {
    }
}
