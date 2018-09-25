package nadav.tasher.frc.simulator.simulation.challenges;

import nadav.tasher.frc.simulator.simulation.obstacles.Block;
import nadav.tasher.frc.simulator.simulation.obstacles.Portal;
import nadav.tasher.frc.simulator.simulation.obstacles.Tracker;
import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;

import java.awt.*;
import java.util.Random;

public class Challenge2018 {
    public static class Robot extends DynamicRobot {
        protected Robot(nadav.tasher.frc.simulator.simulation.Mat mat) {
            super(mat);
        }
    }

    public static class Mat extends nadav.tasher.frc.simulator.simulation.Mat {
        public Mat() {
            super(30, 20);
            Tracker tracker1 = new Tracker(this);
            Tracker tracker2 = new Tracker(this);
            Tracker tracker3 = new Tracker(this);
            tracker1.setMatCoordinates(new Coordinates(10, 10));
            tracker2.setMatCoordinates(new Coordinates(20, 20));
            tracker3.setMatCoordinates(new Coordinates(new Random().nextInt(getSizeX()), new Random().nextInt(getSizeY())));
            addObstacle(new Block(this, new Coordinates(5, 5)));
//            addObstacle(new Block(this, new Coordinates(12, 4)));
            addObstacle(tracker1);
//            addObstacle(tracker2);
//            addObstacle(tracker3);
//            addObstacle(new Jail(this,3,3,new Mat.Coordinates(22,17)));
            Portal portal = new Portal(this, 1, 1, new Coordinates(9, 15), new Coordinates(25, 16));
            portal.setColor(Color.MAGENTA);
            addObstacle(portal);
        }
    }
}
