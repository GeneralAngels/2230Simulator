package nadav.tasher.simulator.simulation.challenges.challenge2018.robots;

import nadav.tasher.simulator.simulation.challenges.challenge2018.Mat;
import nadav.tasher.simulator.simulation.challenges.challenge2018.Robot;
import nadav.tasher.simulator.simulation.simulation.Coordinates;

import java.awt.*;

public class Drako extends Robot {
    public Drako(Mat mat, Color teamColor) {
        super(mat, teamColor);
    }

    public Drako(Mat mat, Color teamColor, Coordinates initial, double angle) {
        super(mat, teamColor, initial, angle);
    }
}
