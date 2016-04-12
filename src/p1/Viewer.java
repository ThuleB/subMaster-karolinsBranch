package p1;

import java.awt.Color;
import gui.*;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
* a filter that lies top of the game with components that symbolizes the physical buttons 
* 
* * @author Karolin
 *
 */

//behöver ändras så att ETT filter innehåller alla symboler,
// lägg alternativt in en inre klass för att skapa frames

public class Viewer {
	private Controller controller; 
	
	private static JFrame frameLeft; 
	private static JFrame frameRight; 
	
//	private static JFrame emptyFrame;
	
//	ColorBox redBox = new ColorBox(new Color(225, 0 , 0, 100));
//	ColorBox blueBox = new ColorBox(new Color(0,225,0, 100));
//	ColorBox yellowBox = new ColorBox(new Color(225,225,0, 100));
//	ColorBox greenBox = new ColorBox(new Color(0,0,225, 100)); 


	public Viewer(){

		showFrames();
		
		try {
			Thread.sleep(6000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		closeFrames();
		
	}
	
	public Viewer(JFrame frame, Color box1, Color box2){
		frame.setUndecorated(true);
		frame.setBackground(new Color(0,0,0,0));
		frame.setPreferredSize(new Dimension(60, 120));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new ColorBox(box1));
		frame.add(new ColorBox(box2));
		
		GridLayout grid = new GridLayout(2,1);
		grid.setHgap(10);
		grid.setVgap(10);

		frame.setLayout(grid);
		frame.setAlwaysOnTop(true);
		frame.pack();
		frame.setVisible(true);
	
	}
	
	public class ColorBox extends JPanel{ 

		public ColorBox (Color color){
			setPreferredSize(new Dimension(50,50));
			setLocation(100, 100);
			setBackground(color);  
            setOpaque(true);
   		}

	}
	
	//metoder som bör fyllas: 
	
	public void showFrames(){	
		//anropas när svarsalternativen visas 
		frameLeft = new JFrame();
		frameLeft.setLocation(111, 607);
		Viewer filterLeft = new Viewer(frameLeft, new Color(225, 0 , 0, 150),new Color(0,225,0, 150));

		
		//yellow and blue rectangles : 
		
		frameRight = new JFrame();
		frameRight.setLocation(1158, 607);
		Viewer filterRight = new Viewer(frameRight, new Color(225, 225 , 0, 150), new Color(0, 0 , 225, 150));

	}
	
	
	public void closeFrames(){
		//anropas när spelaren har tryckt på ett svarsalternativ 
		frameRight.dispose();
		frameLeft.dispose();
	}
	
	
	public static void main (String [] args){
	
	//	new Viewer();
		JFrame frame = new JFrame();
		frame.setLocation(57, 150);
		new Viewer(frame,  new Color(5, 2, 5),new Color(0,225,0, 150));
	
	}
	
}
