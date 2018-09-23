package nadav.tasher.frc.simulator.simulation;

import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.Timer;
import java.util.TimerTask;

public class Simulation {
    public static int SECOND = 1000;
    private int refreshRate = 60;
    private Mat mat = new Mat();
    private Timer simulationTimer = new Timer();

    public Simulation(int refreshRate) {
        this.refreshRate = refreshRate;
        init();
    }

    public Simulation() {
        init();
    }

    private void init() {
        simulationTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handleInputs();
            }
        }, 0, SECOND / refreshRate);
    }

    public Mat getMat() {
        return mat;
    }

    private void handleInputs() {
        for (Controller controller : ControllerEnvironment.getDefaultEnvironment().getControllers()) {
            controller.poll();
            for (Component component : controller.getComponents()) {
                for (DynamicRobot r : mat.getRobots()) r.handleComponent(component, mat);
            }
        }
    }
}
