package nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles;

import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.Robot;
import nadav.tasher.frc.simulator.simulation.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.simulation.entities.Obstacle;

import java.awt.*;

public class CubeDropoff extends Obstacle {
    public CubeDropoff(Mat mat) {
        super(mat);
    }

    @Override
    protected Coordinates collision(Entity collision, Coordinates requested) {
        if (collision instanceof Robot) {
            Robot robot = (Robot) collision;
            if (robot.getTeamColor().equals(Color.RED)) {
                ((Mat) getMat()).addRed(robot.unloadCube());
            } else {
                ((Mat) getMat()).addBlue(robot.unloadCube());
            }
            return CubeDropoff.super.collision(collision, requested);
        }
        return null;
    }
}
