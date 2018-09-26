package nadav.tasher.frc.simulator.simulation.challenges.challenge2018;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.entities.robots.DynamicRobot;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class Robot extends DynamicRobot {
    private boolean hasCube = false;
    private Color teamColor = Color.BLUE;

    protected Robot(Mat mat, Color teamColor) {
        super(mat);
        setTeamColor(teamColor);
    }

    public Color getTeamColor() {
        return teamColor;
    }

    private void setTeamColor(Color color) {
        this.teamColor = color;
    }

    public void loadCube() {
        hasCube = true;
    }

    public int unloadCube() {
        int value = (hasCube) ? 1 : 0;
        hasCube = false;
        return value;
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
        graphics.setColor(teamColor);
        Coordinates forMove = new Coordinates(getCoordinates().getX() + getWidth() / 4, getCoordinates().getY() + getHeight() / 4);
        Coordinates coordinates = matToPixels(graphics, forMove);
        Coordinates actualSize = matToPixels(graphics, new Coordinates(getWidth() / 2, getHeight() / 2));
        Rectangle entity = new Rectangle(
                (int) coordinates.getX(),
                (int) coordinates.getY(),
                (int) actualSize.getX(),
                (int) actualSize.getY()
        );
        Path2D.Double path = new Path2D.Double();
        path.append(entity, false);
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(getAngle() * 360), entity.getX() + entity.getWidth() / 2, entity.getY() + entity.getHeight() / 2);
        path.transform(transform);
        graphics.draw(path);
        graphics.fill(path);
    }

    @Override
    public String getStatus() {
        return super.getStatus() + "\nHas Cube: " + hasCube;
    }
}

