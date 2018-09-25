package nadav.tasher.frc.simulator.simulation.obstacles;

import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;

import java.awt.*;

public class Tracker extends Obstacle {
    public Tracker(Mat mat) {
        super(mat);
        setColor(Color.GRAY);
        setSizeX(1);
        setSizeY(1);
    }

    @Override
    public void setMatCoordinates(Mat.Coordinates matCoordinates) {
        super.setMatCoordinates(matCoordinates);
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
        for (Entity entity : getMat().getAllEntities()) {
            track(entity, graphics, getColor());
        }
    }

    @Override
    protected Mat.Coordinates collision(Entity collision, Mat.Coordinates requested) {
        return null;
    }
}
