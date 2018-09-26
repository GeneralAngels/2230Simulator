package nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles;

import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.Robot;
import nadav.tasher.frc.simulator.simulation.entities.obstacles.DoBlock;

import java.awt.*;

public class GateChecker extends DoBlock {
    public GateChecker(Mat mat, Color teamColor) {
        super(mat);
        setColor(teamColor);
        setTodo((collision, requestedCoordinates) -> {
            if (collision instanceof Robot) {
                Robot robot = (Robot) collision;
                if (robot.getHeight() <= 2 && robot.getWidth() <= 2 && robot.getTeamColor().equals(teamColor)) {
                    return null;
                } else {
                    return GateChecker.super.collision(collision, requestedCoordinates);
                }
            }
            return null;
        });
    }
}
