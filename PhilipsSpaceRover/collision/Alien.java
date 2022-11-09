package collision;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Alien extends JComponent{
	
	private static final long serialVersionUID = 6539677401648040347L;
	
	ImageIcon alienIcon = null;
	Image alienImage = null;
	
	// Position of Alien
	int x = 0;
	int y = 0;
	
	private boolean visible = true;
	
	// rate of movement is dependant on level
	int dx = Collision.LEVEL;
	
	Alien(int x, int y){
		alienIcon = new ImageIcon(this.getClass().getResource("alien.png"));
		alienImage = alienIcon.getImage();
		setVisible(true);
		//setting the initial position
		this.x = x;
		this.y = y;
	}
	
	public void move(){
		x -= dx;
	}
	
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
	
	public Image getImage(){
		return alienImage;
	}
	public  Rectangle getBounds(){
		return new Rectangle(x,y,alienImage.getWidth(this),alienImage.getWidth(this));
	}
}
