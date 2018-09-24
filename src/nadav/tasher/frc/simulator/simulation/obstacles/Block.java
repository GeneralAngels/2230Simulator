package nadav.tasher.frc.simulator.simulation.obstacles;

import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;
import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;

import java.awt.*;

public class Block extends Obstacle {
    public Block(Mat.Coordinates matCoordinates) {
        setMatCoordinates(matCoordinates);
        setColor(new Color(200, 100, 0));
        setSizeX(5);
        setSizeY(5);
        setSizeZ(5);
    }

    @Override
    protected Mat.Coordinates collision(Entity collision, Mat.Coordinates requested) {
        if (collision instanceof DynamicRobot) {
//            System.out.println(collision.getName()+" Collided With "+getName());
            setColor(Color.BLUE);
        }
        return super.collision(collision, requested);
    }
}
