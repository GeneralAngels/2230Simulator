package nadav.tasher.frc.simulator.simulation.robots;

import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.ChallengeRobot2018;
import net.java.games.input.Component;

import java.awt.*;

public class Drako extends ChallengeRobot2018 {
    public Drako() {
        super();
        setColor(Color.WHITE);
        setMatCoordinates(new Mat.Coordinates(20, 20));
    }

    @Override
    public void handleComponent(Component component, Mat mat) {
        super.handleComponent(component, mat);
        if (component.getName().equals("Trigger") && component.getPollData() == 1)
            setMatCoordinates(new Mat.Coordinates(20, 20));
//        System.out.println("Angle "+getAngle());
    }
}
