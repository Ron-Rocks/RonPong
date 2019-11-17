import java.awt.event.KeyEvent;

public class Paddle {
	public int x,y,height,width;
	public int keyUp,keyDown;
	public Paddle(int a) {
		y = Display.height/2;
		if (a == 1) {
			this.x = 20;
			this.keyUp = KeyEvent.VK_W;
			this.keyDown = KeyEvent.VK_S;
		}else {
			this.x = Display.width - 35;
			this.keyUp = KeyEvent.VK_UP;
			this.keyDown = KeyEvent.VK_DOWN;
		}
	}
}
