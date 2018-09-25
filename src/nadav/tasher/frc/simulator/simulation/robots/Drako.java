package nadav.tasher.frc.simulator.simulation.robots;

import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.Challenge2018;
import net.java.games.input.Component;

import java.awt.*;

public class Drako extends Challenge2018.Robot {
    public Drako(Mat mat) {
        super(mat);
        setColor(Color.WHITE);
        setMatCoordinates(new Mat.Coordinates(2, 2));
    }

    @Override
    public void handleComponent(Component component, Mat mat) {
        super.handleComponent(component, mat);
        if (component.getName().equals("Trigger") && component.getPollData() == 1) {
            setMatCoordinates(new Mat.Coordinates((int) getMatCoordinates().getX(), (int) getMatCoordinates().getY()));
            setAngle(getAngle() - getAngle() % 0.25);
        }
        if (component.getName().equals("Thumb") && component.getPollData() == 1) {
            setAngle(0.125);
        }
    }
}
