package main;


public class Main{
	
	private static AnimationManager aManager;
	
	public static void main(String[] args) {
		Window window = new Window();
		window.draw();
		
		aManager = new AnimationManager(window);
		aManager.startTask();
	}


	
}
