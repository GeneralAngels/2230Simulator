package nadav.tasher.frc.simulator.simulation.challenges;

import nadav.tasher.frc.simulator.Utils;
import nadav.tasher.frc.simulator.simulation.obstacles.Block;
import nadav.tasher.frc.simulator.simulation.obstacles.DoBlock;
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
            Block b1 = new Block(this, 30, 2, new Coordinates(0, 0));
            b1.setColor(Color.ORANGE);
            Block b2 = new Block(this, 6, 10, new Coordinates(0, 5));
            b2.setColor(Color.ORANGE);
            Block b3 = new Block(this, 3, 6, new Coordinates(8, 2));
            b3.setColor(Color.ORANGE);
            Block b4 = new Block(this, 7, 5, new Coordinates(6, 10));
            b4.setColor(Color.ORANGE);
            Block b5 = new Block(this, 4, 11, new Coordinates(13, 4));
            b5.setColor(Color.ORANGE);
            Block b6 = new Block(this, 11, 10, new Coordinates(19, 2));
            b6.setColor(Color.ORANGE);
            Block b7 = new Block(this, 25, 6, new Coordinates(5, 14));
            b7.setColor(Color.ORANGE);
            addObstacle(b1);
            addObstacle(b2);
            addObstacle(b3);
            addObstacle(b4);
            addObstacle(b5);
            addObstacle(b6);
            addObstacle(b7);
            Portal portal = new Portal(this, 1, 1, new Coordinates(28.5, 12.5), new Coordinates(2, 17));
            portal.setColor(Color.MAGENTA);
            DoBlock doBlock = new DoBlock(this, 5, 5, new Coordinates(0, 15), new DoBlock.Do() {
                @Override
                public Mat.Coordinates todo() {
                    Utils.tellUser("Kol Ha Kavod");
                    return new Coordinates(1, 3);
                }
            });
            addObstacle(portal);
            addObstacle(doBlock);
        }
    }
}
