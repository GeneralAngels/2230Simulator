package nadav.tasher.frc.simulator.simulation.entities.obstacles;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.Mat;

import java.awt.*;

public class Portal extends DoBlock {
    public Portal(Mat mat, Coordinates teleport) {
        super(mat);
        setColor(Color.MAGENTA);
        setTodo((collision, requestedCoordinates) -> teleport);
    }
}
