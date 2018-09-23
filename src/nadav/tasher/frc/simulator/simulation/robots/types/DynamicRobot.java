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

    public void handleComponent(Component component) {
        float value = component.getPollData();
        if (component.getName().equals("x")) {
            setAngle(bound(getAngle() + value / 10));
        } else if (component.getName().equals("y")) {
            Mat.Coordinates current = getMatCoordinates();
            // Thing To Move Robot In Angle
            setMatCoordinates(current);
        } else if (component.getName().equals("z")) {
        }
    }

    private double bound(double value) {
        return value;
    }
}
