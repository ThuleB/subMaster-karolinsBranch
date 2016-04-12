package p1;

public class Start {

	
	public static void main ( String [] args){ 
		Controller c = new Controller();
		
		new ScreenListener(c); 
		new Input(c);
		
	}
}
