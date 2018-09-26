package nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.Robot;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;

import java.awt.*;

public class GateChecker extends Obstacle {
    private Color teamColor;
    public GateChecker(Mat mat, Color teamColor) {
        super(mat);
        this.teamColor = teamColor;
        setColor(teamColor);
    }

    @Override
    protected Coordinates collision(Entity collision, Coordinates requested) {
        if (collision instanceof Robot) {
            Robot robot = (Robot) collision;
            if (robot.getHeight() <= 2 && robot.getWidth() <= 2 && robot.getTeamColor().equals(teamColor)) {
                return null;
            } else {
                return super.collision(collision, requested);
            }
        }
        return null;
    }
}
