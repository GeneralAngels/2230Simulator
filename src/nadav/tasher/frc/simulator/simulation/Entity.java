package nadav.tasher.frc.simulator.simulation;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class Entity extends Nameable {
    private double width = 1, height = 1, depth = 1, mass = 10;
    private double angle = 0;
    private Coordinates coordinates = new Coordinates(0, 0);
    private Mat mat;
    private Color color = Color.WHITE;

    protected Entity(Mat mat) {
        this.mat = mat;
    }

    public double getMass() {
        return mass;
    }

    protected void setMass(double mass) {
        this.mass = mass;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    protected void setCoordinates(Coordinates coordinates) {
        if (mat != null) {
            this.coordinates = mat.bound(this, coordinates);
        } else {
            forceCoordinates(coordinates);
        }
    }

    protected void forceCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
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

    public void simulate(long elapsedTime) {
    }

    public Mat getMat() {
        return mat;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(color);
        Coordinates coordinates = matToPixels(graphics, getCoordinates());
        Coordinates actualSize = matToPixels(graphics, new Coordinates(getWidth(), getHeight()));
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

    protected Coordinates collision(Entity collision, Coordinates requested) {
        double nX = requested.getX();
        double nY = requested.getY();
        double startX = getCoordinates().getX() - collision.getWidth(), endX = startX + getWidth() + collision.getWidth();
        double startY = getCoordinates().getY() - collision.getHeight(), endY = startY + getHeight() + collision.getHeight();
//        nY = (nX >= startX && nX <= endX) ? find(nY, startY, endY) : nY;
//        nX = (nY >= startY && nY <= endY) ? find(nX, startX, endX) : nX;
        boolean l = nX < startX + collision.getWidth() / 2;
        boolean r = nX >= endX - collision.getWidth() / 2;
        boolean t = nY < startY + collision.getHeight() / 2;
        boolean b = nY >= endY - collision.getHeight() / 2;
        if (r) return new Coordinates(endX, nY);
        if (l) return new Coordinates(startX, nY);
        if (t) return new Coordinates(nX, startY);
        if (b) return new Coordinates(nX, endY);
        return null;
    }

    protected Coordinates matToPixels(Graphics2D graphics, Coordinates coordinates) {
        double gX = graphics.getClip().getBounds().getWidth();
        double gY = graphics.getClip().getBounds().getHeight();
        double mX = mat.getWidth();
        double mY = mat.getHeight();
        double cX = coordinates.getX();
        double cY = coordinates.getY();
        double rX, rY;
        rX = (gX / mX) * cX;
        rY = (gY / mY) * cY;
        return new Coordinates(rX, rY);
    }

    protected void track(Entity entity, Graphics2D graphics, Color color) {
        Coordinates centerSelf = getCenter();
        Coordinates centerEntity = entity.getCenter();
        Coordinates tracking1 = matToPixels(graphics, centerSelf);
        Coordinates tracking2 = matToPixels(graphics, centerEntity);
        graphics.setColor(color);
        graphics.drawLine(
                (int) (tracking1.getX()),
                (int) (tracking1.getY()),
                (int) (tracking2.getX()),
                (int) (tracking2.getY())
        );
    }

    public Coordinates getCenter() {
        double x = getCoordinates().getX() + getWidth() / 2;
        double y = getCoordinates().getY() + getHeight() / 2;
        return new Coordinates(x, y);
    }

    public double getDepth() {
        return depth;
    }

    protected void setDepth(double depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    public static class OpenEntity extends Entity {
        protected OpenEntity(Mat mat) {
            super(mat);
        }

        @Override
        public void setColor(Color color) {
            super.setColor(color);
        }

        @Override
        public void setAngle(double angle) {
            super.setAngle(angle);
        }

        @Override
        public void setCoordinates(Coordinates coordinates) {
            super.setCoordinates(coordinates);
        }

        @Override
        public void forceCoordinates(Coordinates coordinates) {
            super.forceCoordinates(coordinates);
        }

        @Override
        public void setMass(double mass) {
            super.setMass(mass);
        }

        @Override
        public void setDepth(double depth) {
            super.setDepth(depth);
        }

        @Override
        public void setHeight(double height) {
            super.setHeight(height);
        }

        @Override
        public void setWidth(double width) {
            super.setWidth(width);
        }

        @Override
        public void track(Entity entity, Graphics2D graphics, Color color) {
            super.track(entity, graphics, color);
        }
    }
}
