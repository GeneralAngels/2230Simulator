package nadav.tasher.frc.simulator.simulation;

import nadav.tasher.frc.simulator.simulation.entities.Obstacle;
import nadav.tasher.frc.simulator.simulation.entities.Robot;
import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;

import java.awt.*;
import java.util.ArrayList;

public class Mat {
    private int sizeX = 100, sizeY = 100;
    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private ArrayList<DynamicRobot> robots = new ArrayList<>();

    public Mat() {
    }

    protected Mat(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void addRobot(DynamicRobot robot) {
        robots.add(robot);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public Mat.Coordinates bound(Entity entity, Mat.Coordinates requested) {
        double nX = requested.getX();
        double nY = requested.getY();
        // Bound to mat
        nX = (nX >= 0) ? nX : 0;
        nX = (nX <= getSizeX() - entity.getSizeX()) ? nX : getSizeX() - entity.getSizeX();
        nY = (nY >= 0) ? nY : 0;
        nY = (nY <= getSizeY() - entity.getSizeY()) ? nY : getSizeY() - entity.getSizeY();
        ArrayList<Entity> all = new ArrayList<>();

        all.addAll(robots);
        all.addAll(obstacles);
        all.remove(entity);
//        if (nX < 0 || nX > getSizeX() - entity.getSizeX() || nY < 0 || nY > getSizeY() - entity.getSizeY())
//            return entity.getMatCoordinates();
        for (Entity e : all) {
            double startX = e.getMatCoordinates().getX() - entity.getSizeX(), endX = startX + e.getSizeX() + entity.getSizeX();
            double startY = e.getMatCoordinates().getY() - entity.getSizeY(), endY = startY + e.getSizeY() + entity.getSizeY();
            if (nX >= startX && nX <= endX && nY >= startY && nY <= endY) {
                return bound(entity, e.collision(entity, requested));
            }
        }
        return new Coordinates(nX, nY);
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        for (Robot r : robots) {
            r.draw(graphics2d, this);
        }
        for (Obstacle o : obstacles) {
            o.draw(graphics2d, this);
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public ArrayList<DynamicRobot> getRobots() {
        return robots;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public static class Coordinates extends nadav.tasher.frc.simulator.simulation.Coordinates {
        public Coordinates(double x, double y) {
            super(x, y);
        }
    }
}
