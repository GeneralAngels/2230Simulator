package nadav.tasher.frc.simulator.simulation.robots;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.challenges.Challenge2018;
import net.java.games.input.Component;

import java.awt.*;

public class Drako extends Challenge2018.Robot {

    public Drako(Mat mat) {
        super(mat);
        setColor(Color.RED);
        setCoordinates(new Coordinates(1, 3));
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
        for (Entity e : getMat().getAllEntities()) track(e, graphics, getColor());
    }

    @Override
    public void handleComponent(Component component) {
        super.handleComponent(component);
        if (component.getName().equals("Trigger") && component.getPollData() == 1) {
        }
        if (component.getName().equals("y")) {
//            setSpeed(component.getPollData());
        }
    }
}
