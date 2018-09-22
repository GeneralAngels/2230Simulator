package nadav.tasher.frc.simulator.simulation;

import java.awt.*;

public class Entity extends Nameable {
    private int sizeX = 1, sizeY = 1, sizeZ = 1, mass = 10;
    private double angle = 0.0;
    private Mat.Coordinates matCoordinates = new Mat.Coordinates(0, 0);
    private Color color;

    public int getSizeX() {
        return sizeX;
    }

    protected void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeZ() {
        return sizeZ;
    }

    protected void setSizeZ(int sizeZ) {
        this.sizeZ = sizeZ;
    }

    public int getSizeY() {
        return sizeY;
    }

    protected void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getMass() {
        return mass;
    }

    protected void setMass(int mass) {
        this.mass = mass;
    }

    public Mat.Coordinates getMatCoordinates() {
        return matCoordinates;
    }

    protected void setMatCoordinates(Mat.Coordinates matCoordinates) {
        this.matCoordinates = matCoordinates;
    }

    public double getAngle() {
        return angle;
    }

    protected void setAngle(double angle) {
        this.angle = angle;
    }

    public Color getColor() {
        return color;
    }

    protected void setColor(Color color) {
        this.color = color;
    }
}
