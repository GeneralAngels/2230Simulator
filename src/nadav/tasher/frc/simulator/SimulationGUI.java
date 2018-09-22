package nadav.tasher.frc.simulator;

import nadav.tasher.frc.simulator.simulation.Simulation;

import javax.swing.*;
import java.awt.*;

public class SimulationGUI extends JPanel {
    private Simulation currentSimulation;

    public SimulationGUI() {
        init();
    }

    private void init() {
        setBackground(Color.BLACK);
        currentSimulation = new Simulation();

    }
}
