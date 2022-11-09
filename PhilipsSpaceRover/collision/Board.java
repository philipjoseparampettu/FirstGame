package collision;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board  extends JPanel implements ActionListener{

	private static final long serialVersionUID = -2552939677265680237L;
	private Craft craft = null;
	private ArrayList<Missile> missiles = null;
	private Missile missile = null;
	private ArrayList<Alien> aliens = null;
	private Timer timer = null; 

	boolean isGameOver = false;
	boolean isLevelIncrement = false;

	int score = 0;

	private int[][] alienPos = { 
			{2380, 29}, {2500, 59}, {1380, 89},
			{780, 109}, {580, 139}, {680, 239}, 
			{790, 259}, {760, 50}, {790, 150},
			{980, 209}, {560, 45}, {510, 70},
			{930, 159}, {590, 80}, {530, 60},
			{940, 59}, {990, 30}, {920, 200},
			{900, 259}, {660, 50}, {540, 90},
			{810, 220}, {860, 20}, {740, 180},
			{820, 128}, {490, 170}, {700, 30}
	};

//  To use if implementing increment level system	
//	private static final int DELAY = 100;
//	private static final int PERIOD_BETWEEN_EXECUTION = 5000;

	public Board(){
		System.out.println("-->Board() ");		
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		setVisible(true);
		setSize(400, 300);

		craft = new Craft();
		addKeyListener(new MovementKeys());	
		add(craft);

		initiateAliens();

//		java.util.Timer levelTimer = new Timer();
//		levelTimer.schedule(incrementLevel(), DELAY, PERIOD_BETWEEN_EXECUTION);

		timer = new Timer(5,this);
		timer.start();
		System.out.println("<--Board() ");	
	}

	private void initiateAliens(){
		aliens = new ArrayList<Alien>();

		for(int i = 0; i<alienPos.length; i++){
			aliens.add( new Alien (alienPos[i][0], alienPos[i][1]));
		}

	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
		// All aliens are killed or passed craft
		if(aliens.size() <= 0){
			isGameOver = true;
		}

		if(!isGameOver){
			g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);

			ArrayList<Missile> missiles = craft.getMissilesFired();
			for(int count = 0; count<missiles.size(); count++ ){
				Missile	missile = 	missiles.get(count);
				g2d.drawImage(missile.getImage(), missile.getMisileTipPosition(), missile.getY(), this);   
			}

			Alien alien = null; 
			for(int i = 0; i<aliens.size(); i++ ){
				alien = aliens.get(i);
				if (alien.isVisible()){
					g2d.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
				}
			}
			g2d.setColor(Color.WHITE);
			g2d.drawString("Aliens left: " + aliens.size(), 5, 15);
			g2d.drawString("Your Score: " + score, Collision.FRAME_WIDTH - 100, 15);


		} else {
			String gameOverMsg = "Game Over";
			String scoreMsg = "YOUR SCORE IS : " +score;
			Font small = new Font("Helvetica", Font.BOLD, 20);
			FontMetrics metr = this.getFontMetrics(small);

			g.setColor(Color.red);
			g.setFont(small);
			g.drawString(gameOverMsg, (Collision.FRAME_WIDTH - metr.stringWidth(gameOverMsg))/2 ,
					-(Collision.HEIGHT - metr.stringWidth(gameOverMsg)/2)  );

			g.drawString(scoreMsg, (Collision.FRAME_WIDTH - metr.stringWidth(scoreMsg))/2 ,
					-(Collision.HEIGHT - metr.stringWidth(scoreMsg)/2) );
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}



	public void actionPerformed(ActionEvent actionEvent) {
		craft.move();
		Rectangle craftBoundary, missileBoundary, alienBoundary = null;

		craftBoundary = craft.getBounds();
		
		Alien alien = null; 
		for(int i = 0; i < aliens.size(); i++ ){
			alien = aliens.get(i);
			alien.move();		
			if(alien.getX() <=  0 ){
				alien.setVisible(false);
				aliens.remove(alien);
			} 

			alienBoundary = alien.getBounds();
			
			if(craftBoundary.intersects(alienBoundary) ){//&& alien.isVisible() ){
				isGameOver = true;
				alien.setVisible(false);
				craft.setVisible(false);
				System.out.println("****************************** Collusion");
				timer.stop();
			} 

			missiles = craft.getMissilesFired();

			for(int count = 0; count<missiles.size(); count++ ){
				missile = 	missiles.get(count);
				missile.move();


				// reached end of frame so destroy 
				if(missile.getMisileTipPosition() >= Collision.FRAME_WIDTH ){
					missile.setVisible(false);
				}else{
					missileBoundary = missile.getBounds();
					if(missileBoundary.intersects(alienBoundary)){
						score += 10;
						alien.setVisible(false);
						missile.setVisible(false);
					} 

				}
					if (!alien.isVisible()){
						aliens.remove(alien);
					}
					if (!missile.isVisible()) {
						missiles.remove(missile);
					}
			}					repaint();
	
		}
		repaint();
	}
	

	/**
	 * Implementing the key listener
	 * @author U16280
	 *
	 */
	class MovementKeys implements KeyListener{
		public void keyPressed(KeyEvent e) {
			craft.accelerate(e);
		}
		public void keyReleased(KeyEvent e) {
			craft.decelerate(e);
		}
		public void keyTyped(KeyEvent e) {
			// do nothing
		}
	}
}
