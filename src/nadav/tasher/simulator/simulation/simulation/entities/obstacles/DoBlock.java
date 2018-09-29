package nadav.tasher.simulator.simulation.simulation.entities.obstacles;

import nadav.tasher.simulator.simulation.simulation.Coordinates;
import nadav.tasher.simulator.simulation.simulation.Entity;
import nadav.tasher.simulator.simulation.simulation.Mat;
import nadav.tasher.simulator.simulation.simulation.entities.Obstacle;

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
        return todo.todo(collision, requested);
    }

    public interface Todo {
        Coordinates todo(Entity collision, Coordinates requestedCoordinates);
    }
}
