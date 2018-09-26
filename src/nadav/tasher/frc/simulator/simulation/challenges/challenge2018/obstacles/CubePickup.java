package nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles;

import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.Robot;
import nadav.tasher.frc.simulator.simulation.entities.obstacles.DoBlock;

import java.awt.*;

public class CubePickup extends DoBlock {
    public CubePickup(Mat mat, Color teamColor) {
        super(mat);
        setTodo((collision, requestedCoordinates) -> {
            if (collision instanceof Robot) {
                Robot robot = (Robot) collision;
                if (robot.getTeamColor().equals(teamColor)) robot.loadCube();
                return CubePickup.super.collision(collision, requestedCoordinates);
            }
            return null;
        });
    }
}
