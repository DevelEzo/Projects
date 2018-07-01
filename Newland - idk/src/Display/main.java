package Display;

public class main implements Runnable {

	// FPS
		boolean running = true;
		int FPS = 60;
		long startFps, currentFps;
		long maxLoops = 1000 / FPS;

	// frame
		frame frame;

	public static void main(String[] args) {
		// create a new thread with runnable of 'class'-main
			new Thread(new main()).start();
	}

	@Override
	public void run() {
		// create frame
			frame = new frame("Newland - A World Editor");

		// FPS counter 
			while (running) {
				startFps = System.currentTimeMillis();
				update();
				currentFps = System.currentTimeMillis();
				if (currentFps - startFps >= maxLoops) {
					continue;
				}
				render();
				currentFps = System.currentTimeMillis();
				// System.out.println(maxLoops + " : " + (currentFps - startFps));
				if (currentFps - startFps <= maxLoops) {
					try {
						Thread.sleep(maxLoops - (currentFps - startFps));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

	}

	void update() {
		// panel
			frame.panel.update();
	}

	void render() {
		// panel
			frame.panel.repaint();
	}

}
