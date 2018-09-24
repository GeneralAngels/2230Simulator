package nadav.tasher.frc.simulator.simulation.robots.types;

import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Robot;
import net.java.games.input.Component;

public class DynamicRobot extends Robot {
    private double speed = 0;
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
            setAngle(bound(getAngle() + value / 100));
        } else if (component.getName().equals("y")) {
            speed = -value / 10;
            if (value != 0) {
                Mat.Coordinates current = getMatCoordinates();
                double x = (current.getX() + speed * Math.cos(Math.toRadians(getAngle() * 360)));
                double y = (current.getY() + speed * Math.sin(Math.toRadians(getAngle() * 360)));
                setMatCoordinates(mat, new Mat.Coordinates(x, y));
            }
        } else if (component.getName().equals("z")) {
        }
    }

    public double getSpeed() {
        return speed;
    }

    private double bound(double value) {
//        if(value<-1)return bound(2+value);
//        if(value>1)return bound(value-2);
        if (value > 1) return bound(value - 1);
        if (value < 0) return bound(value + 1);
        return value;
    }
}
