package nadav.tasher.simulator.utils.views.simulation;

import nadav.tasher.simulator.simulation.simulation.Mat;
import nadav.tasher.simulator.simulation.simulation.Simulation;
import nadav.tasher.simulator.simulation.simulation.entities.robots.DynamicRobot;
import nadav.tasher.simulator.utils.views.TextView;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static nadav.tasher.simulator.utils.Utils.y;

public class SimulationGUI extends JPanel {
    private static final int simulationRate = 60;
    private Simulation currentSimulation;
    private SimulationView simulationView;
    private TextView info = new TextView();
    private Timer infoUpdater = new Timer();

    public SimulationGUI(Mat mat) {
        init(mat);
    }

    private void init(Mat mat) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.DARK_GRAY);
        currentSimulation = new Simulation(mat, simulationRate);
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
                    stringBuilder.append(" m/s");
                    stringBuilder.append("<br/>");
                    stringBuilder.append(robot.getStatus().replaceAll("\n", "<br/>"));
                    stringBuilder.append("</p>");
                    stringBuilder.append("<br/>");
                }
                stringBuilder.append("<p style=\"color: #FFFFFF\">" + currentSimulation.getMat().getStatus().replaceAll("\n", "<br/>") + "</p>");
                info.setText(stringBuilder.toString());
            }
        }, 0, 1000 / 10);
    }
}