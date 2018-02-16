package cohen.projectile;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProjectileGUI extends JFrame {
	public ProjectileGUI() {
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		// panel.add(new JLabel);

	}

	public static void main(String args[]) {
		new ProjectileGUI().setVisible(true);
	}

}
