package nadav.tasher.frc.simulator.simulation.obstacles;

import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;

import java.awt.*;

public class Portal extends Obstacle {
    private Mat.Coordinates teleport;

    public Portal(Mat mat, double sizeX, double sizeY, Mat.Coordinates gate, Mat.Coordinates teleport) {
        super(mat);
        setSizeX(sizeX);
        setSizeY(sizeY);
        setColor(new Color(0, 0, 0, Color.TRANSLUCENT));
        setMatCoordinates(gate);
        this.teleport = teleport;
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }

    @Override
    protected Mat.Coordinates collision(Entity entity, Mat.Coordinates requested) {
        return teleport;
    }
}
