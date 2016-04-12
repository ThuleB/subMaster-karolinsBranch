package p1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Controller {
	private Viewer viewer;
	private Robot cursor;
	private ScreenListener listener; 
	
	private int x; 
	private int y; 
	
	
	// visar om spelet befinner sig i dialog- direction- eller cursor-läge. 
	private String state = "DIALOG";  
	
	//representerar vilken knapp som valt av input
	//	private String btn; 

	/**
	 * Sätter spel-läget
	 * @param state
	 */
	
	// ändra till bara en dialog? om det går
	public void setState(String state){
		this.state = state; 
		
		if (state.equals("INTRO")){
			// uppdatera Viewer
			viewer = new Viewer();
			
		}else if (state.equals("DIALOG1")){
			
			viewer = new Viewer();
			System.out.println("DIALOG1 i controller anropas");
			
		}else if (state.equals("DIALOG2")){
			
			viewer = new Viewer();
			
		}else if ( state.equals("DIALOG3")){
			 
			viewer = new Viewer(); 
			
		}else if ( state.equals("DIALOG4")){
			 
			viewer = new Viewer(); 
			
		}
		
	}
	
	public void btnClicked(String btnColor){
		if ( state.contains("DIALOG")){ 
			
			if (btnColor.equals("BLUE")){
				x = 376; 
				y = 638; 
			}else if (btnColor.equals("RED")){
				x = 986; 
				y = 632;
			}else if ( btnColor.equals("GREEN")){
				x = 378; 
				y = 697; 
			}else if ( btnColor.equals("YELLOW")){
				x = 991; 
				y = 969;
			}
			//Position X: 376
			//Position Y: 628
			//Färg: java.awt.Color[r=75,g=76,b=76]
			//
			//Position X: 986
			//Position Y: 632
			//Färg: java.awt.Color[r=8,g=5,b=0]
			//
			//Position X: 378
			//Position Y: 697
			//Färg: java.awt.Color[r=0,g=0,b=0]
			//
			//Position X: 991
			//Position Y: 696
			//Färg: java.awt.Color[r=14,g=17,b=10]
			//

			
			try {
				
				new Robot().mouseMove(x, y);
				new Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
				new Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);	
				
				viewer.closeFrames();
				
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	
	

	public void blueButton(){
		
		if (state.contains("DIALOG")){
			try {
				
				new Robot().mouseMove(206, 604);
				new Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
				new Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);				
				
			} catch (AWTException e) {

				e.printStackTrace();
			}
		}else { System.out.println("Funkar ej");
			
		}
	}
	
	public void redButton(){
		
		try {
			
			new Robot().mouseMove(206, 668);
			new Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
			new Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);				
			
		} catch (AWTException e) {

			e.printStackTrace();
		}
	}
		
		
	
	
	public void greenButton(){
		
		try {
			
			new Robot().mouseMove(1113, 601);
			new Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
			new Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);				
			
		} catch (AWTException e) {

			e.printStackTrace();
		}
	
		
	}
	
	public void yellowButton(){
		try {
			
			new Robot().mouseMove(1113, 668);
			new Robot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
			new Robot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);				
			
		} catch (AWTException e) {

			e.printStackTrace();
		}
	}

	
}
