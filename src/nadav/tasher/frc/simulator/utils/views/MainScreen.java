package nadav.tasher.frc.simulator.utils.views;

import nadav.tasher.frc.simulator.simulation.challenges.Challenges;
import nadav.tasher.frc.simulator.simulation.simulation.Challenge;
import nadav.tasher.frc.simulator.simulation.simulation.Mat;
import nadav.tasher.frc.simulator.utils.views.simulation.SimulationGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static nadav.tasher.frc.simulator.utils.Utils.x;
import static nadav.tasher.frc.simulator.utils.Utils.y;

public class MainScreen extends JPanel {
    public MainScreen() {
        setChoosing();
    }

    private void setChoosing() {
        removeAll();
        setBackground(Color.DARK_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel options = new JPanel(new GridLayout(Challenges.challenges.length, 1));
        options.setAlignmentY(CENTER_ALIGNMENT);
        options.setAlignmentX(CENTER_ALIGNMENT);
        setBorder(BorderFactory.createEmptyBorder(y() / 4, x() / 4, y() / 4, x() / 4));
        options.setPreferredSize(new Dimension(x() / 2, y() / 2));
        options.setMaximumSize(options.getPreferredSize());
        options.setMinimumSize(options.getPreferredSize());
        options.setSize(options.getPreferredSize());
        add(options);
        for (Mat challenge : Challenges.challenges) {
            if (challenge.getClass().isAnnotationPresent(Challenge.class)) {
                JButton challengeButton = new JButton(challenge.getClass().getAnnotation(Challenge.class).name());
                challengeButton.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        setSimulation(challenge);
                    }
                });
                options.add(challengeButton);
            }
        }
    }

    private void setSimulation(Mat mat) {
        removeAll();
        setBorder(null);
        setLayout(new GridLayout(1, 1));
        add(new SimulationGUI(mat));
    }
}
