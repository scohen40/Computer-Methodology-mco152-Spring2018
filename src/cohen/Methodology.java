package cohen;

public class Methodology {
	public static void main(String[] args) {
		double angle = 72;
		double velocity = 23;
		Projectile proj = new Projectile(angle, velocity);
		
		for(double time = 0; time <= 10; time++)
		{
			System.out.println(time + "\t" + proj.calculateX(time) + ", " + proj.calculateY(time));
		}
	}

}
