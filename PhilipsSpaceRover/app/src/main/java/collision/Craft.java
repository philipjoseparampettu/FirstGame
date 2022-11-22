package collision;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;


public class Craft extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -163200063618139510L;
//	speed
	private	int dx = 0;
	private	int dy = 0;

//	position
	private int x = 0;
	private int y = 0;

	private boolean visible = true;
	private ImageIcon craftIcon= null;
	private Image craftImage= null;

	private  ArrayList<Missile> missiles = null;

	Craft(){
		craftIcon = new ImageIcon(this.getClass().getResource("../images/craft.png"),"craft image");
		craftImage = craftIcon.getImage();
		missiles = new ArrayList<Missile>();
		setVisible(true);

		dx = 0;
		dy = 0;
	}

	void move(){
		x = x+ dx;
		y = y + dy;
		// to keep the craft inside the window pane
		if(x > Collision.FRAME_WIDTH - craftImage.getWidth(this)){
			x = Collision.FRAME_WIDTH - craftImage.getWidth(this);	
		}
		if(x < 0){
			x=1;
		}

		if(y > (Collision.FRAME_HEIGHT - craftIcon.getIconHeight() * 2) ){
			y = (Collision.FRAME_HEIGHT - craftIcon.getIconHeight() * 2);	
		}
		if(y <0){
			y=1;
		}
	}

	ArrayList<Missile> getMissilesFired(){

		return this.missiles;
	}
	Image getImage(){
		return this.craftImage;
	}

//	Already over ridden in the jComponenet class
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean isVisible(){
		return visible;
	}
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	public  Rectangle getBounds(){
		return new Rectangle(x,y,craftImage.getWidth(this),craftImage.getHeight(this));
	}


//	firing missile
	void fire(){
//		location of missile = craft present location + size of image
		missiles.add(new Missile(craftIcon.getIconWidth()+this.x
				,craftIcon.getIconHeight()/2 +this.y));
	}

	void accelerate( KeyEvent keyEvent){

		// craft movement 
		if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
			dy = -Collision.CRAFT_SPEED;
		}
		if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
			dx = Collision.CRAFT_SPEED;
		}
		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
			dx = -Collision.CRAFT_SPEED;
		}
		if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
			dy = Collision.CRAFT_SPEED;
		}

		// craft fire 
		if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE){
			fire();
		}
	}

	void decelerate(KeyEvent keyEvent){
		if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
			dy = 0;
		}
		if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
			dx = 0;
		}
		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
			dx = 0;
		}
		if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
			dy = 0;
		}
	}
}
