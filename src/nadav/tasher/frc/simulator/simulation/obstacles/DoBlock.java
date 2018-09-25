package nadav.tasher.frc.simulator.simulation.obstacles;

import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;

import java.awt.*;

public class DoBlock extends Block {
    private Do todo;

    public DoBlock(Mat mat, double sizeX, double sizeY, Mat.Coordinates matCoordinates, Do todo) {
        super(mat, sizeX, sizeY, matCoordinates);
        this.todo = todo;
        setColor(Color.RED);
    }

    @Override
    protected Mat.Coordinates collision(Entity collision, Mat.Coordinates requested) {
        return todo.todo();
    }

    public interface Do {
        Mat.Coordinates todo();
    }
}
