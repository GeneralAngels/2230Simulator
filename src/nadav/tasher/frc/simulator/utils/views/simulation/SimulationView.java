package nadav.tasher.frc.simulator.utils.views.simulation;

import nadav.tasher.frc.simulator.simulation.simulation.Simulation;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SimulationView extends JPanel {
    private Simulation simulation;
    private boolean draw = true;

    public SimulationView(Dimension size, Simulation simulation, int refreshRate) {
        this.simulation = simulation;
        int height = size.height;
        int width = height * simulation.getMat().getWidth() / simulation.getMat().getHeight();
        size = new Dimension(width, height);
        setPreferredSize(size);
        setMaximumSize(size);
        setMaximumSize(size);
        setSize(size);
        setBackground(new Color(20, 20, 20));
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (draw)
                    repaint();
            }
        }, 0, 1000 / refreshRate);
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        simulation.getMat().draw(g);
    }
}
