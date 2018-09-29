package nadav.tasher.simulator.simulation.simulation.entities.obstacles;

import nadav.tasher.simulator.simulation.simulation.Coordinates;
import nadav.tasher.simulator.simulation.simulation.Entity;
import nadav.tasher.simulator.simulation.simulation.Mat;
import nadav.tasher.simulator.simulation.simulation.entities.Obstacle;

import java.awt.*;

public class Tracker extends Obstacle {
    public Tracker(Mat mat) {
        super(mat);
        setColor(Color.GRAY);
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
        for (Entity entity : getMat().getAllEntities()) {
            track(entity, graphics, getColor());
        }
    }

    @Override
    protected Coordinates collision(Entity collision, Coordinates requested) {
        return null;
    }
}
