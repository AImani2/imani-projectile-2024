package imani.projectile;

public class Projectile {

    private static final double GRAVITY = 9.8;
    private static final double HALF = 0.5;
    private double angle;
    private final double velocity;
    private double seconds;
    private final double radians;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }


    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(radians) * velocity * seconds - (HALF * GRAVITY * seconds * seconds);
    }

    public double getApexTime() {
        return (velocity * Math.sin(radians)) / GRAVITY;
    }

    public double getPeakY() {
        return ((Math.sin(radians) * velocity) * (Math.sin(radians) * velocity) / (2 * GRAVITY));
    }

}
