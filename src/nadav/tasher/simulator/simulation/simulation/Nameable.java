package nadav.tasher.simulator.simulation.simulation;

public class Nameable {
    private String name = "Unnamed";

    public Nameable() {
        name = getClass().getSimpleName();
    }

    public Nameable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
