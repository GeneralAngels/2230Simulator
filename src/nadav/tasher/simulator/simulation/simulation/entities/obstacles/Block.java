package nadav.tasher.simulator.simulation.simulation.entities.obstacles;

import nadav.tasher.simulator.simulation.simulation.Coordinates;
import nadav.tasher.simulator.simulation.simulation.Entity;
import nadav.tasher.simulator.simulation.simulation.Mat;
import nadav.tasher.simulator.simulation.simulation.entities.Obstacle;

import java.awt.*;

public class Block extends Obstacle {
    public Block(Mat mat) {
        super(mat);
    }

    @Override
    protected Coordinates collision(Entity collision, Coordinates requested) {
        if (!(collision instanceof Obstacle)) {
            return super.collision(collision, requested);
        }
        return null;
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }
}
