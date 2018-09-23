package nadav.tasher.frc.simulator;

import nadav.tasher.frc.simulator.simulation.Simulation;
import nadav.tasher.frc.simulator.simulation.entities.Robot;
import nadav.tasher.frc.simulator.simulation.robots.Drako;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static nadav.tasher.frc.simulator.Utils.y;

public class SimulationGUI extends JPanel {
    private Simulation currentSimulation;
    private SimulationView simulationView;
    private TextView info = new TextView();
    private Timer infoUpdater = new Timer();

    public SimulationGUI() {
        init();
    }

    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        currentSimulation = new Simulation();
        currentSimulation.getMat().addRobot(new Drako());
        simulationView = new SimulationView(new Dimension(y(), y()), currentSimulation, 30);
        add(simulationView);
        add(info);
        initInfoUpdater();
    }

    private void initInfoUpdater() {
        infoUpdater.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                for (Robot robot : currentSimulation.getMat().getRobots()) {
                    stringBuilder.append(robot.getName());
                    stringBuilder.append("\n");
                    stringBuilder.append("X ");
                    stringBuilder.append(robot.getMatCoordinates().getX());
                    stringBuilder.append("\n");
                    stringBuilder.append("Y ");
                    stringBuilder.append(robot.getMatCoordinates().getY());
                    stringBuilder.append("\n");
                    stringBuilder.append("α ");
                    stringBuilder.append((float) robot.getAngle() * 360);
                    stringBuilder.append("\n");
                }
                info.setText(stringBuilder.toString());
            }
        }, 0, 1000 / 10);
    }

    public static class SimulationView extends JPanel {
        private Simulation simulation;
        private boolean draw = true;

        public SimulationView(Dimension size, Simulation simulation, int refreshRate) {
            this.simulation = simulation;
            setPreferredSize(size);
            setMaximumSize(size);
            setMaximumSize(size);
            setSize(size);
            setBackground(Color.BLACK);
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
}
