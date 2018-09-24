package nadav.tasher.frc.simulator.simulation.entities;

import nadav.tasher.frc.simulator.simulation.Entity;

public class Obstacle extends Entity {
    /*
    Breaking-Force is in Newtons.
     */
    private int breakingForce = 100;
    private boolean isBroken = false;
//    private voi

    public void applyForce(int force) {
        if (force >= breakingForce) isBroken = true;
    }

    protected void setBreakingForce(int breakingForce) {
        this.breakingForce = breakingForce;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setState(String state) {
//        this.state=state;
    }
}
