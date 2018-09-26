package nadav.tasher.frc.simulator.simulation.robots.types;

import nadav.tasher.frc.simulator.simulation.Coordinates;
import nadav.tasher.frc.simulator.simulation.Mat;
import nadav.tasher.frc.simulator.simulation.entities.Robot;
import net.java.games.input.Component;

public class DynamicRobot extends Robot {
    private double speed = 0;

    protected DynamicRobot(Mat mat) {
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

    public void handleComponent(Component component) {
        double value = component.getPollData();
        if (component.getName().equals("x")) {
            setAngle(bound(getAngle() + value / 100));
        } else if (component.getName().equals("y")) {
            speed = -value / 10;
        } else if (component.getName().equals("z")) {
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
