import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Sprite{
	private Image forward;// backward, left, right; 	
	private AffineTransform tx;
	
	int dir = 0; 					//0-forward, 1-backward, 2-left, 3-right
	int width, height;
	int x, y;						//position of the object
	int vx, vy;						//movement variables
	double scaleWidth = 1.125;		//change to scale image
	double scaleHeight = 1.125; 		//change to scale image

	public Sprite() {
		
		//load the main image(front or forward view) 
		forward 	= getImage("/imgs/"+"LukeBack.png"); //load the image for Luke
		
		//width and height for hitbox
		width = 40;
		height = 45;
		
		
		x = -width; //off screen 
		y = 300;
		
		vx = 0;
		vy = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									//use your variables
	}

	//2nd constructor - allow setting x and y during construction
		public Sprite(int x, int y) { 
			
			//call default constructor for all the normal stuff
			this(); //involes default constructor 
			
			//do the specific task for THIS constructor 
			this.x = x; 
			this.y = y; 
			
		} 
			
			public void move(int dir) { 
				
				switch(dir) { 
				
				case 0: //hop up
					y -= height/1; //move up a body length
					break;
				case 1: //hop down --> move down by a body length
					y += height/1; 
					break; 
				case 2: //hop left			
					x -= width/2.5; 
					break;
				case 3: //hop right	
					x += width/2.5; 
					break; 
				
				}
				
			}
			
			//Setters
			
		public void setX(int newX) {
			x = newX; 
		}
				
		public void setVx(int newVx) {
				vx = newVx; 		
		}
		
		/*
		 * Getters!
		 */
		
		public int getX() { 
		return x; 
		
		}
		
		public int getY() { 
			return y; 
		}
		
		public int getWidth() { 
			return width;
		}
		
		public int getHeight() {
			return height; 
		}
	
		public int getVx() {
			return vx; 
		}
		
		public int getVy() {
			return vy; 
		}
	
		
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		//Update x and y if using vx and vy variables
		
		x	+=	vx;
		y	+=	vy;	
		
		if(x > 554 || x < -6) {
			x = 250;
		}
		if(y > 575 || y < 0) {
		y = 485;
		}
	
		
		
		
		
		init(x,y);
		
		g2.drawImage(forward, tx, null);
		
		
		//draw hitbox based on x, y, width, height
		//for collision detection
		if(Frame.debugging) { 
			//draw hitbox only if debug
			//g.setColor(Color.green); 
			//g.drawRect(x, y, 40, 45); 
		}
		

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Luke.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
