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

    public Mat(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void addRobot(DynamicRobot robot) {
        robots.add(robot);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public void draw(Graphics graphics) {
        // Draw Mat
//        BufferedImage bufferImage = new BufferedImage((int)graphics.getClip().getBounds().getWidth(),(int)graphics.getClip().getBounds().getHeight(),BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        for (Robot r : robots) {
            r.draw(graphics2d, this);
        }
        for (Obstacle o : obstacles) {
            o.draw(graphics2d, this);
        }
//        graphics.drawImage(bufferImage,0,0,null);

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

    public static class Coordinates extends nadav.tasher.frc.simulator.simulation.Coordinates {
        public Coordinates(int x, int y) {
            super(x, y);
        }
    }
}
