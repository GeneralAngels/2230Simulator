package nadav.tasher.frc.simulator.simulation;

public class Coordinates {
    private double x, y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X: " + (int) getX() + ", Y: " + (int) getY();
    }

    public String toLongString() {
        return "X: " + getX() + ", Y: " + getY();
    }
}
