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
        float value = component.getPollData();
        if (component.getName().equals("x")) {
            setAngle(bound(getAngle() + value / 10));
        } else if (component.getName().equals("y")) {
            Mat.Coordinates current = getMatCoordinates();
            // Thing To Move Robot In Angle
            int x = (int) (current.getX() + value * 10 * Math.cos(getAngle() * 180));
            int y = (int) (current.getY() + value * 10 * Math.sin(getAngle() * 180));
            setMatCoordinates(bound(new Mat.Coordinates(x, y), mat));
        } else if (component.getName().equals("z")) {
        }
    }

    private double bound(double value) {
//        if(value<-1)return bound(2+value);
//        if(value>1)return bound(value-2);
        if (value > 1) return bound(value - 1);
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
}
