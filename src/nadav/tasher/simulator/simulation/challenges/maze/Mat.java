package nadav.tasher.simulator.simulation.challenges.maze;

import nadav.tasher.simulator.simulation.challenges.maze.robots.Maxim;
import nadav.tasher.simulator.simulation.simulation.Challenge;
import nadav.tasher.simulator.simulation.simulation.Coordinates;
import nadav.tasher.simulator.simulation.simulation.entities.obstacles.Block;
import nadav.tasher.simulator.simulation.simulation.entities.obstacles.DoBlock;
import nadav.tasher.simulator.simulation.simulation.entities.obstacles.Portal;
import nadav.tasher.simulator.utils.Utils;

import java.awt.*;

@Challenge(name = "Maze #1")
public class Mat extends nadav.tasher.simulator.simulation.simulation.Mat {
    public Mat() {
        super(30, 20);
        Block b1 = new Block(this);
        b1.setWidth(30);
        b1.setHeight(2);
        b1.setCoordinates(new Coordinates(0, 0));
        b1.setColor(Color.ORANGE);
        Block b2 = new Block(this);
        b2.setWidth(6);
        b2.setHeight(10);
        b2.setCoordinates(new Coordinates(0, 5));
        b2.setColor(Color.ORANGE);
        Block b3 = new Block(this);
        b3.setWidth(3);
        b3.setHeight(6);
        b3.setCoordinates(new Coordinates(8, 2));
        b3.setColor(Color.ORANGE);
        Block b4 = new Block(this);
        b4.setWidth(7);
        b4.setHeight(5);
        b4.setCoordinates(new Coordinates(6, 10));
        b4.setColor(Color.ORANGE);
        Block b5 = new Block(this);
        b5.setWidth(4);
        b5.setHeight(11);
        b5.setCoordinates(new Coordinates(13, 4));
        b5.setColor(Color.ORANGE);
        Block b6 = new Block(this);
        b6.setWidth(11);
        b6.setHeight(10);
        b6.setCoordinates(new Coordinates(19, 2));
        b6.setColor(Color.ORANGE);
        Block b7 = new Block(this);
        b7.setWidth(25);
        b7.setHeight(6);
        b7.setCoordinates(new Coordinates(5, 14));
        b7.setColor(Color.ORANGE);
        addObstacle(b1);
        addObstacle(b2);
        addObstacle(b3);
        addObstacle(b4);
        addObstacle(b5);
        addObstacle(b6);
        addObstacle(b7);
        Portal portal = new Portal(this, new Coordinates(2, 17));
        portal.setCoordinates(new Coordinates(28.5, 12.5));
        DoBlock notifyAndReset = new DoBlock(this);
        notifyAndReset.setWidth(5);
        notifyAndReset.setHeight(5);
        notifyAndReset.setCoordinates(new Coordinates(0, 15));
        notifyAndReset.setTodo((collision, requested) -> {
            Utils.tellUser("Finished!");
            return new Coordinates(1, 3);
        });
        addObstacle(portal);
        addObstacle(notifyAndReset);
        addRobot(new Maxim(this, new Coordinates(1, 3)));
    }
}