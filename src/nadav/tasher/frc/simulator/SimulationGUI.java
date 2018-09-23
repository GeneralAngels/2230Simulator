package nadav.tasher.frc.simulator;

import nadav.tasher.frc.simulator.simulation.Simulation;
import nadav.tasher.frc.simulator.simulation.robots.Drako;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SimulationGUI extends JPanel {
    private Simulation currentSimulation;
    private Timer screenTimer = new Timer();

    public SimulationGUI() {
        init();
    }

    private void init() {
        setBackground(Color.BLACK);
        currentSimulation = new Simulation();
        currentSimulation.getMat().addRobot(new Drako());
        screenTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, 1000);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentSimulation.getMat().draw(g);
    }
}
