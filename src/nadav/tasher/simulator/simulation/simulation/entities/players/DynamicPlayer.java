package nadav.tasher.simulator.simulation.simulation.entities.players;

import nadav.tasher.simulator.simulation.simulation.Coordinates;
import nadav.tasher.simulator.simulation.simulation.Mat;
import nadav.tasher.simulator.simulation.simulation.entities.Player;
import net.java.games.input.Component;

public class DynamicPlayer extends Player {
    private double speed = 0;

    protected DynamicPlayer(Mat mat) {
        super(mat);
    }

    @Override
    public void simulate(long elapsedTime) {
        if (speed != 0) {
            double x = (getCoordinates().getX() + speed * Math.cos(Math.toRadians(getAngle() * 360)));
            double y = (getCoordinates().getY() + speed * Math.sin(Math.toRadians(getAngle() * 360)));
            setCoordinates(new Coordinates(x, y));
        }
        super.simulate(elapsedTime);
    }

    @Override
    public void handleComponent(Component component) {
        double value = component.getPollData();
        if (component.getIdentifier() == Component.Identifier.Axis.X) {
            setAngle(bound(getAngle() + value / 100));
        } else if (component.getIdentifier() == Component.Identifier.Axis.Y) {
            speed = -value / 10;
        } else if (component.getIdentifier() == Component.Identifier.Axis.Z) {
        }
    }

    public double getSpeed() {
        return speed;
    }

    protected void setSpeed(double speed) {
        this.speed = speed;
    }

    private double bound(double value) {
//        if(value<-1)return bound(2+value);
//        if(value>1)return bound(value-2);
        if (value > 1) return bound(value - 1);
        if (value < 0) return bound(value + 1);
        return value;
    }
}
