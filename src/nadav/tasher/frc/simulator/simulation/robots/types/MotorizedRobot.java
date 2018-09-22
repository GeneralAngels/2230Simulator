package nadav.tasher.frc.simulator.simulation.robots.types;

import nadav.tasher.frc.simulator.simulation.Robot;

public class MotorizedRobot extends Robot {
    private Motor[] motors = new Motor[0];

    public Motor[] getMotors() {
        return motors;
    }

    public void setMotors(Motor[] motors) {
        this.motors = motors;
    }
}
