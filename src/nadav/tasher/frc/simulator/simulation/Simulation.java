package nadav.tasher.frc.simulator.simulation;

import nadav.tasher.frc.simulator.simulation.entities.robots.DynamicRobot;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.Timer;
import java.util.TimerTask;

public class Simulation {
    public static int SECOND = 1000;
    private int simulationRate = 30;
    private Mat mat = new Mat();
    private Timer simulationTimer = new Timer();

    public Simulation(Mat mat, int simulationRate) {
        this.simulationRate = simulationRate;
        this.mat = mat;
        init();
    }

    public Simulation(int simulationRate) {
        this.simulationRate = simulationRate;
        init();
    }

    public Simulation(Mat mat) {
        this.mat = mat;
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
                for (Entity entity : mat.getAllEntities()) entity.simulate(SECOND / simulationRate);
            }
        }, 0, SECOND / simulationRate);
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
