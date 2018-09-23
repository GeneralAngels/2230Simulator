package nadav.tasher.frc.simulator.simulation.robots.types;

import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Robot;
import net.java.games.input.Component;

public class DynamicRobot extends Robot {
    private Motor[] motors = new Motor[0];

    public Motor[] getMotors() {
        return motors;
    }

    public void setMotors(Motor[] motors) {
        this.motors = motors;
    }

    public void handleComponent(Component component, Mat mat) {
        double value = component.getPollData();
        if (component.getName().equals("x")) {
            setAngle(bound(getAngle() + value / 1000));
        } else if (component.getName().equals("y")) {
            Mat.Coordinates current = getMatCoordinates();
            // Thing To Move Robot In Angle
            int x = (int) ((double) current.getX() + value * Math.cos(180 - getAngle() * 360));
            int y = (int) ((double) current.getY() + value * Math.sin(180 - getAngle() * 360));
            System.out.println("X,Y Togo " + value * Math.cos(180 - getAngle() * 360) + "," + value * Math.sin(180 - getAngle() * 360));
            setMatCoordinates(bound(new Mat.Coordinates(x, y), mat));
        } else if (component.getName().equals("z")) {
        }
    }

    private double bound(double value) {
//        if(value<-1)return bound(2+value);
//        if(value>1)return bound(value-2);
        if (value > 1) return bound(value - 1);
        if (value < 0) return bound(value + 1);
        return value;
    }

    private Mat.Coordinates bound(Mat.Coordinates coordinates, Mat mat) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        x = (x >= 0) ? x : 0;
        x = (x <= mat.getSizeX()) ? x : mat.getSizeX();
        y = (y >= 0) ? y : 0;
        y = (y <= mat.getSizeY()) ? y : mat.getSizeY();
        return new Mat.Coordinates(x, y);
    }

    private int direction(double angle) {
        return (angle > 180) ? 1 : -1;
    }
}
