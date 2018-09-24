package nadav.tasher.frc.simulator.simulation.obstacles;

import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;

public class Block extends Obstacle {
    public Block(Mat.Coordinates matCoordinates) {
        setMatCoordinates(matCoordinates);
        setSizeX(5);
        setSizeY(5);
        setSizeZ(5);
    }
}
