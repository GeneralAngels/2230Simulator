package nadav.tasher.frc.simulator.simulation.entities.obstacles;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;

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
