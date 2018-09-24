package nadav.tasher.frc.simulator.simulation.challenges;

import nadav.tasher.frc.simulator.simulation.obstacles.Block;
import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;

public class Challenge2018 {
    public static class Robot extends DynamicRobot {
    }

    public static class Mat extends nadav.tasher.frc.simulator.simulation.Mat {
        public Mat() {
            super(20, 20);
            addObstacle(new Block(new Coordinates(5, 5)));
        }
    }
}
