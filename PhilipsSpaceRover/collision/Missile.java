package collision;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Missile extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6643720629128937405L;

	//speed
	private	int dx = Collision.MISSILE_SPEED;

	//position
	private int x = 0;
	private int y = 0;
	
	private boolean visible = true;
	
	ImageIcon missile = null;
	Image missileImage = null;


	Missile( int x, int y){
		// setting the position of the missile
		// depends on the position of the craft
		
		this.x = x;
		this.y = y;
		
		missile = new ImageIcon(this.getClass().getResource("missile.png"));
		missileImage = missile.getImage();
		setVisible(true);
		
	}

	void move(){
		x = x+ dx;
	}

	// present in the JComponent class
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public boolean isVisible(){
		return visible;
	}
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	/**
	 * Needed to get the head of the missile to predict the collution point. 
	 * @return
	 */
	int getMisileTipPosition(){
		return missile.getIconWidth() + x;
	}
	
	Image getImage(){
		return missileImage;
	}
	public  Rectangle getBounds(){
		return new Rectangle(x,y,missileImage.getWidth(this),missileImage.getWidth(this)* 2);
	}


}
