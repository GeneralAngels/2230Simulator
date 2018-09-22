package nadav.tasher.frc.simulator.simulation;

import java.awt.*;

public class Robot extends Nameable {

    /*
    Mass is in KG,
    Size is in Meters
     */
    private int sizeX = 1, sizeY = 1, sizeZ = 1, mass = 10;
    private double angle = 0.0;
    private Color color;

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
    For changing mass robot (that picks up things)
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

    public static class Motor {
    }
}
