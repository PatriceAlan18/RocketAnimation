package main;

public class AnimationManager implements AnimationCallback{

	private Window window;
	private ThreadsManager tManager;
	
	public AnimationManager(Window window) {
		tManager = new ThreadsManager(this);
		this.window = window;
	}
	
	public void stopAnimation() {
		tManager.stopThreads();
	}
	
	public void startTask() {
		tManager.startTask("star", 400);
		tManager.startTask("update", 15);
		tManager.startTask("planets", 400);
		tManager.startTask("rocket", 400);
		tManager.startTask("meteor", 30);
		tManager.startTask("music", 45);
	}
	
	@Override
	public void shineStars() {
		window.shineStars();
	}

	@Override
	public void stopShineStars() {
		window.stopShineStars();

	}

	@Override
	public void updateAnimation() {
		window.repaint();
	}

	@Override
	public void movePlanets() {
		window.movePlanets();
	}

	@Override
	public void moveRocket() {
		window.moveRocket();
	}

	@Override
	public void moveMeteor() {
		window.moveMeteors();
	}

	@Override
	public void moveMusic() {
		window.moveMusic();
	}

}
