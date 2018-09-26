package nadav.tasher.frc.simulator.simulation;

import nadav.tasher.frc.simulator.simulation.entities.Obstacle;
import nadav.tasher.frc.simulator.simulation.entities.Robot;
import nadav.tasher.frc.simulator.simulation.entities.robots.DynamicRobot;

import java.awt.*;
import java.util.ArrayList;

public class Mat {
    private int width = 100, height = 100;
    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private ArrayList<DynamicRobot> robots = new ArrayList<>();

    public Mat() {
    }

    protected Mat(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public ArrayList<Entity> getAllEntities() {
        ArrayList<Entity> entities = new ArrayList<>();
        entities.addAll(robots);
        entities.addAll(obstacles);
        return entities;
    }

    public void addRobot(DynamicRobot robot) {
        robots.add(robot);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public String getStatus() {
        return "Robots: " + robots.size() + ", Obstacles: " + obstacles.size();
    }

    public Coordinates bound(Entity entity, Coordinates requested) {
        double nX = requested.getX();
        double nY = requested.getY();
        // Bound to mat
        nX = (nX >= 0) ? nX : 0;
        nX = (nX <= getWidth() - entity.getWidth()) ? nX : getWidth() - entity.getWidth();
        nY = (nY >= 0) ? nY : 0;
        nY = (nY <= getHeight() - entity.getHeight()) ? nY : getHeight() - entity.getHeight();
        ArrayList<Entity> all = new ArrayList<>();
        all.addAll(robots);
        all.addAll(obstacles);
        all.remove(entity);
        for (Entity e : all) {
            double startX = e.getCoordinates().getX() - entity.getWidth(), endX = startX + e.getWidth() + entity.getWidth();
            double startY = e.getCoordinates().getY() - entity.getHeight(), endY = startY + e.getHeight() + entity.getHeight();
//            if (nX >= startX && nX <= endX && nY >= startY && nY <= endY) {
//                return bound(entity, e.collision(entity, requested));
//            }
            if (nX > startX && nX < endX && nY > startY && nY < endY) {
                Coordinates unbounded = e.collision(entity, requested);
                if (unbounded != null)
                    return bound(entity, unbounded);
            }
        }
        return new Coordinates(nX, nY);
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        for (Obstacle o : obstacles) {
            o.draw(graphics2d);
        }
        for (Robot r : robots) {
            r.draw(graphics2d);
        }
    }

    public int getWidth() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<DynamicRobot> getRobots() {
        return robots;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }
}
