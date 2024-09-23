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
		tManager.startTask("update", 10);
		tManager.startTask("planets", 400);
		tManager.startTask("rocket", 400);
		tManager.startTask("meteor", 30);
	}
	
	@Override
	public void shineStars() {
		// TODO Auto-generated method stub
		window.shineStars();
	}

	@Override
	public void stopShineStars() {
		// TODO Auto-generated method stub
		window.stopShineStars();

	}

	@Override
	public void updateAnimation() {
		window.repaint();
		//System.out.print("UPDATE");
	}

	@Override
	public void movePlanets() {
		// TODO Auto-generated method stub
		window.movePlanets();
	}

	@Override
	public void moveRocket() {
		// TODO Auto-generated method stub
		window.moveRocket();
	}

	@Override
	public void moveMeteor() {
		// TODO Auto-generated method stub
		window.moveMeteors();
	}

}
