package nadav.tasher.frc.simulator.simulation.robot;

import java.awt.*;

public class Robot {

    /*
    Mass is in KG,
    Size is in Meters
     */
    private int sizeX = 1, sizeY = 1, sizeZ = 1, mass = 10;
    private double angle = 0.0;
    private Color color;
    private String name;

    public Robot() {
        name = getClass().getName();
    }

    public String getName() {
        return name;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeZ() {
        return sizeZ;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getMass() {
        return mass;
    }

    /*
    For changing mass robot (that pick up things)
     */
    public void setMass(int mass) {
        this.mass = mass;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
