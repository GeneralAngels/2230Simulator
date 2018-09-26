package nadav.tasher.frc.simulator.simulation.challenges.challenge2018;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles.CubeDropoff;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles.CubePickup;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.obstacles.GateChecker;
import nadav.tasher.frc.simulator.simulation.challenges.challenge2018.robots.Drako;

import java.awt.*;

public class Mat extends nadav.tasher.frc.simulator.simulation.Mat {
    private int scoreRed = 0;
    private int scoreBlue = 0;

    public Mat() {
        super(30, 20);
        GateChecker blueChecker = new GateChecker(this, Color.BLUE);
        blueChecker.setHeight(getHeight());
        blueChecker.setWidth(1);
        blueChecker.setCoordinates(new Coordinates(3, 0));
        GateChecker redChecker = new GateChecker(this, Color.RED);
        redChecker.setHeight(getHeight());
        redChecker.setWidth(1);
        redChecker.setCoordinates(new Coordinates(26, 0));
        CubeDropoff dropoff = new CubeDropoff(this);
        dropoff.setHeight(5);
        dropoff.setWidth(5);
        dropoff.setColor(Color.PINK);
        dropoff.setCoordinates(new Coordinates(getWidth() / 2 - dropoff.getWidth() / 2, getHeight() / 2 - dropoff.getHeight() / 2));
        CubePickup redPickup = new CubePickup(this, Color.RED);
        redPickup.setWidth(2);
        redPickup.setHeight(2);
        redPickup.setCoordinates(new Coordinates(5, 0));
        CubePickup bluePickup = new CubePickup(this, Color.BLUE);
        bluePickup.setWidth(2);
        bluePickup.setHeight(2);
        bluePickup.setCoordinates(new Coordinates(23, 18));
        addObstacle(blueChecker);
        addObstacle(redChecker);
        addObstacle(redPickup);
        addObstacle(bluePickup);
        addObstacle(dropoff);
        addRobot(new Drako(this, Color.BLUE));
    }

    public void addRed(int toAdd) {
        scoreRed += toAdd;
    }

    public void addBlue(int toAdd) {
        scoreBlue += toAdd;
    }

    @Override
    public String getStatus() {
        return "Blue " + scoreBlue + ":" + scoreRed + " Red";
    }
}
