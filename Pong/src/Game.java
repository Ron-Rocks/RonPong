import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
	private boolean running = true;
	private BufferStrategy bs;
	private Graphics g;
	private Thread thread;
	private Display display;
	private int  Pwidth = 15;
	private int Pheight = 60;
	public static Paddle p1;
	public static Paddle p2;
	private KeyManager keyManager;
	
	public Game() {
		keyManager = new KeyManager();
	}
	public void update() {
		//CHECKING FOR INPUT
		if(keyManager.keys[p1.keyUp] && p1.y > 0) 
				p1.y -=10;
		else if (keyManager.keys[p1.keyDown] && p1.y +60< display.height)
				p1.y +=10;
		
		if(keyManager.keys[p2.keyUp]) 
			p2.y -=10;
		else if (keyManager.keys[p2.keyDown])
			p2.y +=10;
		
		
		
	}
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Draw Here
			g.clearRect(0, 0, display.width, display.height);
			g.fillRect(p1.x,p1.y,Pwidth,Pheight);
			g.fillRect(p2.x,p2.y,Pwidth,Pheight);
		
		bs.show();
		g.dispose();
	}
	
	
	public void run() {
		init();
		while (running) {
			update();
			render();
			try {
				thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
		
		
	
	public void start() {
	
		thread = new Thread(this);
		thread.start();

	}
	public void init() {
		
		
		 
		display = new Display();
		display.getFrame().addKeyListener(keyManager);
		p1 = new Paddle(1);
		p2 = new Paddle(2);
	}
	
}

	
	
