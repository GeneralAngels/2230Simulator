package nadav.tasher.frc.simulator.simulation;

import java.awt.*;

public class Entity extends Nameable {
    private double sizeX = 1, sizeY = 1, sizeZ = 1, mass = 10;
    private double angle = 0.0;
    private Mat.Coordinates matCoordinates = new Mat.Coordinates(0, 0);
    private Color color = Color.WHITE;

    public double getSizeX() {
        return sizeX;
    }

    protected void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    public double getSizeZ() {
        return sizeZ;
    }

    protected void setSizeZ(double sizeZ) {
        this.sizeZ = sizeZ;
    }

    public double getSizeY() {
        return sizeY;
    }

    protected void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    public double getMass() {
        return mass;
    }

    protected void setMass(double mass) {
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

    public void draw(Graphics2D graphics, Mat mat) {
        graphics.setColor(color);
        Coordinates gfxCoordinates = coordinatesToPixels(graphics, mat, matCoordinates);
        Coordinates actualSize = coordinatesToPixels(graphics, mat, new Mat.Coordinates((int) (sizeX * 10), (int) (sizeY * 10)));
        Rectangle entity = new Rectangle(
                gfxCoordinates.getX() - actualSize.getX() / 2,
                gfxCoordinates.getY() - actualSize.getY() / 2,
                actualSize.getX(),
                actualSize.getY()
        );
        graphics.rotate(Math.toDegrees(angle * 360));
        graphics.draw(entity);
        graphics.fill(entity);
    }

    private Coordinates coordinatesToPixels(Graphics2D graphics, Mat mat, Mat.Coordinates coordinates) {
        int gX = graphics.getClipBounds().x;
        int gY = graphics.getClipBounds().y;
        int mX = mat.getSizeX();
        int mY = mat.getSizeY();
        int cX = coordinates.getX();
        int cY = coordinates.getY();
        int rX, rY;
        rX = (gX / mX) * cX;
        rY = (gY / mY) * cY;
        return new Coordinates(rX, rY);
    }
}
