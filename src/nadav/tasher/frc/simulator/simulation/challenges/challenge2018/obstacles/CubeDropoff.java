package nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles;

import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.Robot;
import nadav.tasher.frc.simulator.simulation.entities.obstacles.DoBlock;

import java.awt.*;

public class CubeDropoff extends DoBlock {
    public CubeDropoff(Mat mat) {
        super(mat);
        setTodo((collision, requestedCoordinates) -> {
            if (collision instanceof Robot) {
                Robot robot = (Robot) collision;
                if (robot.getTeamColor().equals(Color.RED)) {
                    mat.addRed(robot.unloadCube());
                } else {
                    mat.addBlue(robot.unloadCube());
                }
                return CubeDropoff.super.collision(collision, requestedCoordinates);
            }
            return null;
        });
    }
}
