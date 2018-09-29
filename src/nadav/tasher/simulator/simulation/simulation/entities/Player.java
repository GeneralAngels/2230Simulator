package nadav.tasher.simulator.simulation.simulation.entities;

import nadav.tasher.simulator.simulation.simulation.Entity;
import nadav.tasher.simulator.simulation.simulation.Mat;
import net.java.games.input.Component;

public class Player extends Entity {
    protected Player(Mat mat) {
        super(mat);
    }

    public void handleComponent(Component component) {
    }

    public static class Motor {
    }
}
