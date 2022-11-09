package collision;

import javax.swing.JFrame;

public class Collision extends JFrame {

	private static final long serialVersionUID = -1363701722206540150L;
	
	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 300;
	public static final int MISSILE_SPEED = 1;
	public static final int CRAFT_SPEED = 2;
	
	public static int LEVEL = 1;

	
	public Collision() {
		//overriding the initial propertise
		
		add(new Board());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("My Space Rover - PJ");
		setResizable(false);
		setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Collision();

	}

}
