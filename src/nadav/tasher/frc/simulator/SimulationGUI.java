package nadav.tasher.frc.simulator;

import nadav.tasher.frc.simulator.simulation.Simulation;
import nadav.tasher.frc.simulator.simulation.challenges.Challenge2018;
import nadav.tasher.frc.simulator.simulation.robots.Drako;
import nadav.tasher.frc.simulator.simulation.robots.types.DynamicRobot;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static nadav.tasher.frc.simulator.Utils.y;

public class SimulationGUI extends JPanel {
    private static final int simulationRate = 60;
    private Simulation currentSimulation;
    private SimulationView simulationView;
    private TextView info = new TextView();
    private Timer infoUpdater = new Timer();

    public SimulationGUI() {
        init();
    }

    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.DARK_GRAY);
        currentSimulation = new Simulation(new Challenge2018.Mat(), simulationRate);
        currentSimulation.getMat().addRobot(new Drako(currentSimulation.getMat()));
        simulationView = new SimulationView(new Dimension(y(), y()), currentSimulation, 50);
        add(simulationView);
        add(info);
        initInfoUpdater();
    }

    private void initInfoUpdater() {
        infoUpdater.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                for (DynamicRobot robot : currentSimulation.getMat().getRobots()) {
                    stringBuilder.append("<p style=\"color: #" + Integer.toHexString(robot.getColor().getRGB()).substring(2) + ";\">");
                    stringBuilder.append(robot.getName());
                    stringBuilder.append("<br/>");
                    stringBuilder.append("V ");
                    stringBuilder.append((int) (robot.getSpeed() * simulationRate));
                    stringBuilder.append("M/s");
                    stringBuilder.append("<br/>");
                    stringBuilder.append("X ");
                    stringBuilder.append((int) robot.getMatCoordinates().getX());
                    stringBuilder.append("<br/>");
                    stringBuilder.append("Y ");
                    stringBuilder.append((int) robot.getMatCoordinates().getY());
                    stringBuilder.append("<br/>");
                    stringBuilder.append("α ");
                    stringBuilder.append((int) (robot.getAngle() * 360));
                    stringBuilder.append("</p>");
                    stringBuilder.append("<br/>");
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
            int height = size.height;
            int width = height * simulation.getMat().getSizeX() / simulation.getMat().getSizeY();
            size = new Dimension(width, height);
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
