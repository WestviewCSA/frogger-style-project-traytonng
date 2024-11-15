import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//for any debugging code we add 
	public static boolean debugging = true; 
	
	
	
	//Timer related variables
	int waveTimer = 5; //each wave of enemies is 20s
	long ellapseTime = 0;
	Font timeFont = new Font("Courier", Font.BOLD, 70);
	int level = 0;
	
	
	Font myFont = new Font("Courier", Font.BOLD, 40);
	SimpleAudioPlayer backgroundMusic = new SimpleAudioPlayer("scifi.wav", false);
//	Music soundBang = new Music("bang.wav", false);
//	Music soundHaha = new Music("haha.wav", false);
	
	
	Background Background = new Background(0,0); 
	Luke Vader = new Luke(100,200); 
	StormTrooper Storm = new StormTrooper(100,200); 
	LOG log = new LOG(100, -200); 
	FrogLog log2 = new FrogLog(100, -200); 
	LOG3 log3 = new LOG3(100, -200); 
	LOG3 log4 = new LOG3(100, -200); 
	OtherFrogLog log5 = new OtherFrogLog(100,-100);
	Luke luke = new Luke(250,485); 
	DROID droid = new DROID(100,200); 
	DROID2 droid2 = new DROID2(100,200);
	Ending bush = new Ending(0,0);
	WinScreen win = new WinScreen(0,0);

	
	// a row of LukeScrolling Object
	OtherStorm[] row1 = new OtherStorm[10];
	LOG[] row2 = new LOG[5];
	FrogLog[] row3 = new FrogLog[2]; 
	LOG3[] row4 = new LOG3[4]; 
	StormTrooper[] row5 = new StormTrooper[10]; 
	LOG3[] row6 = new LOG3[3]; 
	OtherFrogLog[] row7 = new OtherFrogLog[1]; 
	DROID[] row9 = new DROID[1]; 
	DROID2[] row10 = new DROID2[1]; 
	Ending[] row11 = new Ending[1]; 


	
	
	//frame width/height
	int width = 600;
	int height = 600;

	public void paint(Graphics g) {
		super.paintComponent(g);
		
		
		Background.paint(g);
		log.paint(g);
		bush.paint(g);

		//have the row1 objects paint on the screen!!!!!!
		//for each obj in row1 
		
		for(OtherStorm obj : row1) { 
			obj.paint(g);
		}
		
		for(LOG obj1 : row2) { 
			obj1.paint(g); 
		}
		
		for(LOG3 obj : row4) { 
			obj.paint(g); 
	
		} 
		for(StormTrooper obj : row5) { 
			obj.paint(g); 
		} 
		for(OtherFrogLog obj : row7) { 
			obj.paint(g); 
		} 
		
		for(FrogLog obj6 : row3) { 
			obj6.paint(g);
						
		} 
		
		for(DROID obj : row9) {
			obj.paint(g);
		}
		
		for(DROID2 obj : row10) {
			obj.paint(g); 
		
		}
		
		for(Ending obj : row11) {
			obj.paint(g);
		}
		
		
		//boolean riding1 = false; 
		//for (FrogLog obj6: row3) { 
			//if(obj6.coolided(luke)) {
			//	luke.setVx(obj6.v);
			//	riding1 = true; 
			//	break;
			//}
		
		
	//	if(!riding1 && luke.y()) < 300) {
	//	riding1 = false; 
		//	luke.setVx(0); 
		//	luke.x = 250;
		//	luke.y = 485; 
			//IF ! riding any luke is in the mist area 
			//rest back to start 	
		
		//} 
		
		
		/*
		 * Collision detection 
		 */
		
	//Log 1 y = 215
		
	//Log 2 y = 170
		
	//2nd FrogLog y = 125
		
		
		
		
		
		

		boolean riding2 = false;
		for(FrogLog obj6 : row3) {	
			if(obj6.coolided(luke)){
				luke.setVx(-2);
				riding2 = true; 
				break;
	} 
		if(!riding2 && luke.y < 215) {
			//riding2 =false;
			luke.setVx(0);
			luke.x = 250;
			luke.y = 485;
		}
		
		
		
	}
		for(StormTrooper obj : row5) { 
			
		if(obj.coolided(luke)) { 
			System.out.println("Skywalker spotted!");
				//luke = new Luke(250,485); 
		}
		
		for(OtherStorm obj1 : row1) {
		
		if(obj1.coolided(luke)) {
			System.out.println("Skywalker spotted!"); 
				//luke = new Luke(250,485); 

		}
		
		for(DROID obj2 : row9) {
			if(obj2.coolided(luke)) {
			System.out.println("return to training!");
			//	luke = new Luke(250,485); 

		
			}
			
		for(DROID2 obj3 : row10) { 
			if(obj3.coolided(luke)) {
				System.out.println("return to training!");
				//	luke = new Luke(250,485); 

			}
			
		for(Ending obj4 : row11) {
			if(obj4.coolided(luke)) {
				System.out.println("Mission Accomplished!");
				win.paint(g);
				luke(800,800);
			
			}
			
			
		
		
		}
		
		
		
		
			
			
		}
			
		}
		
		

		}
		
		
		//paint the other objects on the screen
		
		luke.paint(g);

		
		
		}
		
		} 
	
	private Object luke(int i, int j) {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.white);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);
	
		//backgroundMusic.play();

		/*
		 * setup any 1D array here! - create the objects that go in them
		 * 
		 */
	
		//traverse the array --> infinite scrolling x 
		for(int i = 0; i < row1.length; i++) { 
			row1[i] = new OtherStorm( i*150 ,350); 
		}
		for(int i = 0; i <row2.length; i++) { 
			row2[i] = new LOG(i*150, 295); 
		
		}
		for(int i = 0; i <row4.length; i++) { 
			row4[i] = new LOG3(i*150, 200);
		
		}
 
		for(int i = 0; i <row5.length; i++) { 
			row5[i] = new StormTrooper(i*150, 420); 
		}
		for(int i = 0; i <row3.length; i++) { 
			row3[i] = new FrogLog(i*150, 240); 
		}
		for(int i = 0; i <row7.length; i++) { 
			row7[i] = new OtherFrogLog(i*150, 150);  
		}
		for(int i = 0; i <row9.length; i++) { 
			row9[i] = new DROID(i*150, 100); 
		}
		for(int i = 0; i <row10.length; i++) { 
			row10[i] = new DROID2(i*150, 100); 
		}
		
		for(int i = 0; i <row11.length; i++) { 
			row11[i] = new Ending(i*150, 0);
		
		}
		
		
		//the cursor image must be outside of the src folder
		//you will need to import a couple of classes to make it fully 
		//functional! use eclipse quick-fixes
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("torch.png").getImage(),
				new Point(0,0),"custom cursor"));	
		
		
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(luke.getX());
		System.out.println(luke.getY());

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		
	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		if(arg0.getKeyCode() == 87){ 
			luke.move(0);
			//move main character up
		}else if(arg0.getKeyCode()== 83){ 
			luke.move(1);
		} 
		
		if(arg0.getKeyCode()==65){ 
			luke.move(2);
		}else if(arg0.getKeyCode()==68){ 
			luke.move(3);
			
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
