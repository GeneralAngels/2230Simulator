package nadav.tasher.simulator.simulation.challenges.maze.robots;

import nadav.tasher.simulator.simulation.simulation.Coordinates;
import nadav.tasher.simulator.simulation.simulation.Mat;
import nadav.tasher.simulator.simulation.simulation.entities.players.DynamicPlayer;

import java.awt.*;

public class Maxim extends DynamicPlayer {
    public Maxim(Mat mat, Coordinates initial) {
        super(mat);
        setColor(Color.PINK);
        setCoordinates(initial);
    }
}
