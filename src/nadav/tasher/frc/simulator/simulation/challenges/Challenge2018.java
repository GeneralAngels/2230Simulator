package nadav.tasher.frc.simulator.simulation.challenges;

import nadav.tasher.frc.simulator.simulation.obstacles.Block;
import nadav.tasher.frc.simulator.simulation.obstacles.Portal;
import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;

import java.awt.*;

public class Challenge2018 {
    public static class Robot extends DynamicRobot {
        protected Robot(nadav.tasher.frc.simulator.simulation.Mat mat) {
            super(mat);
        }
    }

    public static class Mat extends nadav.tasher.frc.simulator.simulation.Mat {
        public Mat() {
            super(30, 20);
            addObstacle(new Block(this, new Coordinates(5, 5)));
            addObstacle(new Block(this, new Coordinates(12, 4)));
            Portal portal = new Portal(this, 1, 1, new Coordinates(9, 15), new Coordinates(25, 16));
            portal.setColor(Color.MAGENTA);
            addObstacle(portal);
        }
    }
}
