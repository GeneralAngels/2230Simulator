package nadav.tasher.frc.simulator.simulation.simulation;

import nadav.tasher.frc.simulator.simulation.simulation.entities.robots.DynamicRobot;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.ArrayList;
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
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        ArrayList<DynamicRobot> robots = mat.getRobots();
        for (int controller = 0; controller < controllers.length; controller++) {
            controllers[controller].poll();
            if (controller < robots.size()) {
                for (Component component : controllers[controller].getComponents()) {
                    if (controllers[controller].getType() == Controller.Type.STICK) {
                        if (component.getIdentifier() == Component.Identifier.Axis.Y) {
                            component = invertData(component);
                        }
                    }
                    robots.get(controller).handleComponent(component);
                }
            }
        }
    }

    private Component invertData(Component finalComponent) {
        return new Component() {
            @Override
            public Identifier getIdentifier() {
                return finalComponent.getIdentifier();
            }

            @Override
            public boolean isRelative() {
                return finalComponent.isRelative();
            }

            @Override
            public boolean isAnalog() {
                return finalComponent.isAnalog();
            }

            @Override
            public float getDeadZone() {
                return finalComponent.getDeadZone();
            }

            @Override
            public float getPollData() {
                return -finalComponent.getPollData();
            }

            @Override
            public String getName() {
                return finalComponent.getName();
            }
        };
    }
}
