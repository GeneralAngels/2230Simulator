package nadav.tasher.frc.simulator.simulation;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class Entity extends Nameable {
    private double sizeX = 1, sizeY = 1, sizeZ = 1, mass = 10;
    private double angle = 0;
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
        Coordinates coordinates = matToPixels(graphics, mat, matCoordinates);
        Coordinates actualSize = matToPixels(graphics, mat, new Mat.Coordinates((int) (sizeX), (int) (sizeY)));
//        System.out.println(getName()+ " PXCORD:"+gfxCoordinates.getX()+","+gfxCoordinates.getY()+" PXSZ: "+actualSize.getX()+","+actualSize.getY());
        Rectangle entity = new Rectangle(
                (int) coordinates.getX(),
                (int) coordinates.getY(),
                (int) actualSize.getX(),
                (int) actualSize.getY()
        );
        Path2D.Double path = new Path2D.Double();
        path.append(entity, false);
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(angle * 360), entity.getX() + entity.getWidth() / 2, entity.getY() + entity.getHeight() / 2);
        path.transform(transform);
        graphics.draw(path);
        graphics.fill(path);
    }

    private Coordinates matToPixels(Graphics2D graphics, Mat mat, Mat.Coordinates coordinates) {
        double gX = graphics.getClip().getBounds().getWidth();
        double gY = graphics.getClip().getBounds().getHeight();
        double mX = mat.getSizeX();
        double mY = mat.getSizeY();
        double cX = coordinates.getX();
        double cY = coordinates.getY();
        double rX, rY;
        rX = (gX / mX) * cX;
        rY = (gY / mY) * cY;
        return new Coordinates(rX, rY);
    }
}
