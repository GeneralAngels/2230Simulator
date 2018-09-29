package nadav.tasher.simulator.simulation.challenges.challenge2018.obstacles;

import nadav.tasher.simulator.simulation.challenges.challenge2018.Robot;
import nadav.tasher.simulator.simulation.simulation.Coordinates;
import nadav.tasher.simulator.simulation.simulation.Entity;
import nadav.tasher.simulator.simulation.simulation.Mat;
import nadav.tasher.simulator.simulation.simulation.entities.Obstacle;

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
