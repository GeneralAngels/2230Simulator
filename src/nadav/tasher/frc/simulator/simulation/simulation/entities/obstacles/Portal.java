package nadav.tasher.frc.simulator.simulation.simulation.entities.obstacles;

import nadav.tasher.frc.simulator.simulation.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.simulation.Mat;

import java.awt.*;

public class Portal extends DoBlock {
    public Portal(Mat mat, Coordinates teleport) {
        super(mat);
        setColor(Color.MAGENTA);
        setTodo((collision, requestedCoordinates) -> teleport);
    }
}
