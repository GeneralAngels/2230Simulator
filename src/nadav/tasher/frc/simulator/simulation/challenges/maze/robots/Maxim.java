package nadav.tasher.frc.simulator.simulation.challenges.maze.robots;

import nadav.tasher.frc.simulator.simulation.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.simulation.entities.robots.DynamicRobot;

import java.awt.*;

public class Maxim extends DynamicRobot {
    public Maxim(Mat mat, Coordinates initial) {
        super(mat);
        setColor(Color.PINK);
        setCoordinates(initial);
    }
}
