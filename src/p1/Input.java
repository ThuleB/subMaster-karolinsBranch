package p1;

import java.awt.Robot;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

// Ska importera JInput istället för JNative
public class Input implements NativeKeyListener{

	private Robot robot; 
//	private int posX, posY; 	
	
	private Controller controller; 
	
	public Input(Controller controller){
		this.controller = controller; 
		
		   try {
	            GlobalScreen.registerNativeHook();
	        }
	        catch (NativeHookException ex) {
	            System.err.println("There was a problem registering the native hook.");
	        }

	        GlobalScreen.addNativeKeyListener(this);
	    }

	
	
	  public void nativeKeyPressed(NativeKeyEvent e) {
		  
		  if ( e.getKeyCode() == NativeKeyEvent.VC_UP) {
			 
			//  controller.blueButton();
			  controller.btnClicked("BLUE");
			  
		  } if ( e.getKeyCode() == NativeKeyEvent.VC_LEFT) {
			  
			  //controller.redButton();
			  controller.btnClicked("RED");

		  } if ( e.getKeyCode() == NativeKeyEvent.VC_RIGHT){
			  
			//  controller.greenButton();
			  controller.btnClicked("GREEN");
			  
		  } if ( e.getKeyCode() == NativeKeyEvent.VC_DOWN){ 
			
			  // controller.yellowButton();
			  controller.btnClicked("YELLOW");
			  
		  }if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
	            try { 
					GlobalScreen.unregisterNativeHook();
				} catch (NativeHookException e1) {
					System.out.println("funkar ej"); 
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	           
	       }
		  
	    }

	public void nativeKeyReleased(NativeKeyEvent arg0) {
		
	}


	public void nativeKeyTyped(NativeKeyEvent arg0) {
		
	}
	
	
	public static void main (String[] args) {
		new Input(new Controller());
	}
	
}





