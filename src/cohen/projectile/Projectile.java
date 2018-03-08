package cohen.projectile;

public class Projectile {
	double angle;
	double velocity;
	double time;
	
	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time; 
	}

	public double calculateX() {

		return Math.cos(Math.toRadians(angle)) * velocity * time;

	}

	public double calculateY() {
		return Math.sin(Math.toRadians(angle)) * velocity * time - (.5 * 9.8 * (time * time));
	}

}
