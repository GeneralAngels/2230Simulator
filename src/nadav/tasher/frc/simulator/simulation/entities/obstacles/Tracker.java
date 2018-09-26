package nadav.tasher.frc.simulator.simulation.entities.obstacles;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;

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
