package cohen;

public class Projectile {
	double angle;
	double velocity;

	public Projectile(double angle, double velocity) {
		this.angle = angle;
		this.velocity = velocity;
	}

	public double calculateX(double time) {

		return Math.cos(Math.toRadians(angle)) * velocity * time;

	}

	public double calculateY(double time) {
		return Math.sin(Math.toRadians(angle)) * velocity * time - (.5 * 9.8 * (time * time));
	}

}
