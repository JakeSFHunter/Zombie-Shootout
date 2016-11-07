import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	public boolean keyW = false, keyS = false;
	public boolean keyA = false, keyD = false;
	public boolean keySpace = false;
	public boolean keyP = false;
	
	public void keyPressed(KeyEvent e) {
		int d = e.getKeyCode();
		if (d == KeyEvent.VK_W) {
			keyW = true;
		}
		if (d == KeyEvent.VK_S) {
			keyS = true;
		}
		if (d == KeyEvent.VK_A) {
			keyA = true;
		}
		if (d == KeyEvent.VK_D) {
			keyD = true;
		}
		if (d == KeyEvent.VK_SPACE) {
			keySpace = true;
		}
		if (d == KeyEvent.VK_P) {
			keyP = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		int d = e.getKeyCode();
		if (d == KeyEvent.VK_W) {
			keyW = false;
		}
		if (d == KeyEvent.VK_S) {
			keyS = false;
		}
		if (d == KeyEvent.VK_A) {
			keyA = false;
		}
		if (d == KeyEvent.VK_D) {
			keyD = false;
		}
		if (d == KeyEvent.VK_SPACE) {
			keySpace = false;
		}
		if (d == KeyEvent.VK_P) {
			keyP = false;
		}

	}

	public void keyTyped(KeyEvent e) {
	}
}
