package main;

import java.util.ArrayList;

public class ThreadsManager{
		
	private AnimationCallback cb;
	
	private ArrayList<Thread> threads = new ArrayList<Thread>();

	public ThreadsManager(AnimationCallback _cb) {
		this.cb = _cb;
	}
	
	public void stopThreads() {
		for(Thread th : threads) th.interrupt();
	}

	public void startTask(String task, int timer) {
		switch(task.trim().toLowerCase()){
		case "star":
			Thread starThread = new Thread(new Runnable() {
				@Override
				public void run() {	starAnimation(timer);	}
			});
			starThread.start();
			threads.add(starThread);
			break;
		
		case "update":
			Thread updateThread = new Thread(new Runnable() {
				
				@Override
				public void run() { updateAnimation(timer); }
			});
			updateThread.start();
			threads.add(updateThread);
			break;
		case "planets":
			Thread movePlanets = new Thread(new Runnable() {
				
				@Override
				public void run() { movePlanets(timer);}
			});
			movePlanets.start();
			threads.add(movePlanets);
			break;
		case "rocket":
			Thread moveRocket = new Thread(new Runnable() {
				
				@Override
				public void run() {moveRocket(timer);}
			});
			moveRocket.start();
			threads.add(moveRocket);
			break;
			
		case "meteor":
			Thread moveMeteor = new Thread(new Runnable() {
				
				@Override
				public void run() {moveMeteor(timer);}
			});
			moveMeteor.start();
			threads.add(moveMeteor);
			break;
		case "music":
			Thread moveMusic = new Thread(new Runnable() {
				
				@Override
				public void run() {moveMusic(timer);}
			});
			moveMusic.start();
			threads.add(moveMusic);
			break;
		default: System.err.print("Wrong task name "+task);
				
		}
		
	}
	
	private void updateAnimation(int timer) {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				cb.updateAnimation();
				Thread.sleep(timer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.print("Error in thread update animation");
			}
		}
	}
	
	//400 default timer
	private void starAnimation(int timer) {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(timer);
				cb.shineStars();
				Thread.sleep(timer);
				cb.stopShineStars();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.print("Error in thread stars");
			}
		}
		
	}
	
	private void movePlanets(int timer) {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(timer);
				cb.movePlanets();

			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.print("Error in thread planets");
			}
		}
	}
	
	private void moveRocket(int timer) {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(timer);
				cb.moveRocket();

			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.print("Error in thread rocket");
			}
		}
	}
	
	private void moveMeteor(int timer) {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(timer);
				cb.moveMeteor();

			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.print("Error in thread meteor");
			}
		}
	}
	
	private void moveMusic(int timer) {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(timer);
				cb.moveMusic();

			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.print("Error in thread music");
			}
		}
	}
	
}
