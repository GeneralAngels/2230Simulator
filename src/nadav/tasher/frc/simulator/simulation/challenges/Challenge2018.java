package nadav.tasher.frc.simulator.simulation.challenges;

import nadav.tasher.frc.simulator.simulation.obstacles.Block;
import nadav.tasher.frc.simulator.simulation.obstacles.Portal;
import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;

public class Challenge2018 {
    public static class Robot extends DynamicRobot {
    }

    public static class Mat extends nadav.tasher.frc.simulator.simulation.Mat {
        public Mat() {
            super(20, 20);
            addObstacle(new Block(new Coordinates(5, 5)));
            addObstacle(new Block(new Coordinates(13, 5)));
            addObstacle(new Portal(3, 3, new Coordinates(8, 15), new Coordinates(1, 19)));
        }
    }
}
