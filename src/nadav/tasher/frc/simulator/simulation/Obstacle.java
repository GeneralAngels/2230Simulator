package nadav.tasher.frc.simulator.simulation;

public class Obstacle extends Nameable {
    /*
    Breaking-Force is in Newtons.
     */
    private int sizeX = 1, sizeY = 1, sizeZ = 1;
    private Coordinates location = new Coordinates(0, 0);
    private int breakingForce = 100;
    private boolean isBroken = false;

    public void applyForce(int force) {
        if (force >= breakingForce) isBroken = true;
    }

    public int getSizeZ() {
        return sizeZ;
    }

    public void setSizeZ(int sizeZ) {
        this.sizeZ = sizeZ;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public Coordinates getLocation() {
        return location;
    }

    public boolean isBroken() {
        return isBroken;
    }
}
