package nadav.tasher.frc.simulator.simulation;

import nadav.tasher.frc.simulator.parts.Tower;
import nadav.tasher.frc.simulator.parts.Tube;
import net.java.games.input.*;

import java.util.Timer;
import java.util.TimerTask;

public class Simulation {
    private int refreshRate = 30;
    private Robot robot;
    private Mat mat;

    private Tower<Component> stateTower = new Tower<>();
    private Tube<Component> stateTube = new Tube<>();

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

    private void handleInputs() {
        Event event = new Event();
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        for (int i = 0; i < controllers.length; i++) {
            controllers[i].poll();
            EventQueue queue = controllers[i].getEventQueue();
            while (queue.getNextEvent(event)) {
                Component comp = event.getComponent();
                stateTower.tell(comp);
                stateTube.blow(comp);
            }
        }
    }
}
