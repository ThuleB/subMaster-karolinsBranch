package p1;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

public class ScreenListener implements Runnable{

	private Color introColor = new Color(5, 2, 5);
//	private Color colorRightCorner = new Color(78, 37, 74);
	
	
	// varje scen har en punkt med en färg som representerar en scen: 
	private Color dialog1Color = new Color(252, 232, 68);
	private Color dialog2Color = new Color(69, 66, 38);
	private Color dialog3Color = new Color (163, 196, 85); 
	private Color dialog4Color = new Color ( 16, 32, 99); 
	private Color directionColor; 
	private Color fightColor; 
	
	private Controller controller = new Controller(); 
	
	public ScreenListener(Controller controller){
		this.controller = controller; 
		
		new Thread(this).start();
	}
	
	public void run() {
		while (true){ 
			
		try {
			
			//Om titeln "Wolf Among Us" visas:  
			if ( new Robot().getPixelColor(241, 209).equals(introColor)){

				controller.setState( "INTRO" );
				
				//Om den första dialogen ( med fyra svarsalternativ) visas: 
		}else if( new Robot().getPixelColor(61, 159).equals(dialog1Color)){

				
				controller.setState( "DIALOG1" );
				System.out.println("screenlistener anropas");
			
				//Om den andra dialogen ( med fyra svarsalternativ) visas: 
			}else if ( new Robot().getPixelColor(345, 63).equals(dialog2Color)){
				
				controller.setState("DIALOG2");
				
				//Om den tredje dialogen... 
			}else if ( new Robot().getPixelColor(593, 239).equals(dialog3Color)){
				
				controller.setState("DIALOG3");
			
				//Fjärde dialogen
			}else if ( new Robot().getPixelColor(1334, 205).equals(dialog4Color)){
				
				controller.setState("DIALOG4");
				
			}
			
			
		} catch (AWTException e) {

			e.printStackTrace();
		}
			
		}
	}
	
	
	public static void main(String [] args){
//		new Thread(new ScreenListener()).start(); 
//		new ScreenListener();
	}

//
//POSITIONER: 
//
	//Bakgrund dialog2: 
//Position X: 345
//Position Y: 63
//Färg: java.awt.Color[r=69,g=66,b=38]
//
	//
//Position X: 144
//Position Y: 609
//Färg: java.awt.Color[r=46,g=44,b=21]
//
//Position X: 142
//Position Y: 661
//Färg: java.awt.Color[r=96,g=95,b=56]
//
//Position X: 140
//Position Y: 679
//Färg: java.awt.Color[r=45,g=45,b=22]
//
//Position X: 138
//Position Y: 732
//Färg: java.awt.Color[r=97,g=95,b=61]
//


}
