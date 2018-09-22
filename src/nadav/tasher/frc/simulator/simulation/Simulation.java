package nadav.tasher.frc.simulator.simulation;

import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.Timer;
import java.util.TimerTask;

public class Simulation {
    private int refreshRate = 20;
    private Mat mat = new Mat();

    public Simulation(int refreshRate) {
        this.refreshRate = refreshRate;
        init();
    }

    public Simulation() {
        init();
    }

    private void init() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handleInputs();
            }
        }, 0, 1000 / refreshRate);
    }

    public Mat getMat() {
        return mat;
    }

    private void handleInputs() {
        for (Controller controller : ControllerEnvironment.getDefaultEnvironment().getControllers()) {
            controller.poll();
            for (Component component : controller.getComponents()) {
                for (DynamicRobot r : mat.getRobots()) r.handleComponent(component);
            }
        }
    }
}
