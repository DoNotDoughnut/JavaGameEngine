package net.rhys.gameengine;

import net.rhys.gameengine.input.EKeyInput;
import net.rhys.gameengine.input.EMouseInput;
import net.rhys.gameengine.render.ECanvas;
import net.rhys.gameengine.render.ERenderer;
import net.rhys.gameengine.render.EWindow;

/**
* The EEngine program is a library meant to help
* with creating a window and rendering stuff to it
*
* @author  Rhys Holloway
* @version Pre-release 1
* @since   2020-01-17
*/
public class EEngine implements Runnable {
	
	private boolean running = false;
	private Thread thread;

	public final String title;
	public static final String resources = "/res/";
	public final int width, height, scale;
	
	public ERenderer graphics;
	public EWindow window;
	public EKeyInput keyInput;
	public EMouseInput mouseInput;
	public ECanvas canvas;

	public static int UPS, FPS;
	public static long timer = System.currentTimeMillis();

	public EEngine(String title, int width, int height, int scale) {

		this.title = title;
		this.width = width;
		this.height = height;
		this.scale = scale;
		
		graphics = new ERenderer(width, height, scale); // Establishes game renderer
		keyInput = new EKeyInput();
		mouseInput = new EMouseInput(graphics);
		canvas = new ECanvas(width, height, scale, keyInput, mouseInput);
		window = new EWindow(title, canvas);
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double updateEvery = 1000000000.0 / 60.0; // 1 billion / 60 (more accurate than milliseconds)
		double delta = 0;

		window.setVisible(true);
		
		while (running) {
			long now = System.nanoTime();

			delta += (now - lastTime) / updateEvery; // Sets delta is checked to see if the time in between last
			// time this was called and now was more than 1/60th of a second

			lastTime = now;
			
			input();

			while (delta >= 1) { // Runs 60 times per second so game update speed wont be off
				update();
				delta--;
			}
			render(); // Renders as many times per second as possible
			canvas.render(graphics); // Draws what was rendered

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}

		}
		end();
	}
	
	public void render() {
		
	}

	public void input() {
		
	}

	public void update() {
		
	}

	public void end() {
		
	}

	public synchronized void start() { // See below

		running = true;
		thread = new Thread(this, title);

		thread.start(); // Start the application thread. I think this calls run();
	}

	public synchronized void stop() { // When exit call is given, stop run(); and close the thread.
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
