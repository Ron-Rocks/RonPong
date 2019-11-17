import java.awt.Canvas;

import javax.swing.JFrame;

public class Display {
	public static int width = 800;
	public static int height = 500;
	private JFrame frame;
	private Canvas canvas;
	public Display() {
		frame = new JFrame("Pong !!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(width,height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setFocusable(false);
		frame.add(canvas);
		 
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() {
		return frame;
	}
}
