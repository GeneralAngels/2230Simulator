package nadav.tasher.frc.simulator.simulation.obstacles;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.Entity;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Obstacle;

public class DoBlock extends Obstacle {
    private Todo todo;

    public DoBlock(Mat mat) {
        super(mat);
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    @Override
    protected Coordinates collision(Entity collision, Coordinates requested) {
        return todo.todo();
    }

    public interface Todo {
        Coordinates todo();
    }
}
