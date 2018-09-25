package nadav.tasher.frc.simulator.simulation.obstacles;

import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;
import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;

import java.awt.*;

public class Block extends Obstacle {
    public Block(Mat mat, double sizeX, double sizeY, Mat.Coordinates matCoordinates) {
        super(mat);
        setMatCoordinates(matCoordinates);
        setSizeX(sizeX);
        setSizeY(sizeY);
    }

    @Override
    protected Mat.Coordinates collision(Entity collision, Mat.Coordinates requested) {
        if (collision instanceof DynamicRobot) {
            return super.collision(collision, requested);
        }
        return null;
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }
}
