package Display;

public class main implements Runnable {

	// FPS
		boolean running = true;
		final int FPS = 60;
		 long startFPS, currentFPS;
		 long maxLoopTimes = 1000/FPS;
	
	// frame
		static main main = new main();
		frame frame;

	public static void main(String[] args) {
		// create a thread with the runnable of the 'class'-main
			new Thread(main).start();

	}

	@Override
	public void run() {
		// create frame
			 frame = new frame();
		
		// FPS counter
			 	while(running) {
			 		startFPS = System.currentTimeMillis();
			 		update();
			 		currentFPS = System.currentTimeMillis();
			 		if(currentFPS - startFPS >= maxLoopTimes) {
			 			continue;
			 		}
			 		render();
			 		currentFPS = System.currentTimeMillis();
			 		System.out.println(maxLoopTimes + " : " + (currentFPS - startFPS));
			 		if(currentFPS - startFPS <= maxLoopTimes) {
			 			try {
							Thread.sleep(maxLoopTimes - (currentFPS - startFPS));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
			 		}
			 	}
		
	}
	
	void update() {
		
	}
	
	void render() {
		
	}

}
