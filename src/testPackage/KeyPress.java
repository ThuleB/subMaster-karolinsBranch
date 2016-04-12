package testPackage;



import java.awt.Dimension;
import java.awt.Toolkit;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
/**
 * KeyPress som flyttar muspekaren till bestämd position vid knapptryck.
 * @author Mathias
 * 
 */
public class KeyPress implements NativeKeyListener {
	public void nativeKeyPressed(NativeKeyEvent e) {

		// Toolkit som fångar upp storlek på skärmen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// initiserar höjd o bredd i double
		double d_width = screenSize.getWidth();
		double d_height = screenSize.getHeight();

		// Omvandlar double till int, då moveCursor() endast kan ta emot int
		// variabler
		int width = (int) d_width;
		int height = (int) d_height;

		String S = NativeKeyEvent.getKeyText(e.getKeyCode());
		System.out.println("Key Pressed: " + S);

		if (S == "D") {
			new MoveCursor().moveCursor(width / 3, height / 2 + height / 3);
		}
		if (S == "F") {
			new MoveCursor().moveCursor(width / 3, height / 3 + height / 4);
		}
		if (S == "J") {
			new MoveCursor().moveCursor(width / 2 + width / 6, height / 3 + height / 4);
		}
		if (S == "K") {
			new MoveCursor().moveCursor(width / 2 + width / 6, height / 2 + height / 3);
		}
		if (S == "E") {
			new MoveCursor().clickCursor();
		}
		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			try {
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
