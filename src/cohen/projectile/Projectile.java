package cohen.projectile;

public class Projectile {
	private double angle;
	private double velocity;
	private double time;
	
	public Projectile(double angle, double velocity) {
		this.angle = angle;
		this.velocity = velocity;
	}
	
	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time; 
	}
	

	public double getX() {

		return Math.cos(Math.toRadians(angle)) * velocity * time;

	}
	
	public double getX(double time) {

		return Math.cos(Math.toRadians(angle)) * velocity * time;

	}

	public double getY() {
		return Math.sin(Math.toRadians(angle)) * velocity * time - (.5 * 9.8 * (time * time));
	}

	
	public double getY(double time) {
		return Math.sin(Math.toRadians(angle)) * velocity * time - (.5 * 9.8 * (time * time));
	}

}
