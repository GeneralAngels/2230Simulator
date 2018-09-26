package nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.Robot;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;

import java.awt.*;

public class CubePickup extends Obstacle {
    private Color teamColor;

    public CubePickup(Mat mat, Color teamColor) {
        super(mat);
        setColor(teamColor);
        this.teamColor = teamColor;
    }

    @Override
    protected Coordinates collision(Entity collision, Coordinates requested) {
        if (collision instanceof Robot) {
            Robot robot = (Robot) collision;
            if (robot.getTeamColor().equals(teamColor)) robot.loadCube();
        }
        return null;
    }
}
