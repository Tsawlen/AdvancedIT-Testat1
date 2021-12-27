package de.tsawlen.advancedIT.testat;

import java.util.concurrent.Semaphore;

public class PrivateSharedSpace {
	
	private boolean blocked;
	private boolean[] waiting;
	private int lastDrivenThrough;
	private Semaphore[] privateSemaphore;
	
	public PrivateSharedSpace() {
		
		blocked = false;
		lastDrivenThrough = 1;
		waiting = new boolean[2];
		privateSemaphore = new Semaphore[2];
		for(int i = 0; i < 2; i++) {
			waiting[i] = false;
			privateSemaphore[i] = new Semaphore(0, true);
		}
		
	}
	
	public void enterLok0() {
		
		if(!blocked && lastDrivenThrough == 1) {
			privateSemaphore[0].release();
		}else {
			waiting[0] = true;
		}
		
		try {
			privateSemaphore[0].acquire();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterLok1() {
		
		if(!blocked && lastDrivenThrough == 0) {
			privateSemaphore[1].release();
		}else {
			waiting[1] = true;
		}
		
		try {
			privateSemaphore[1].acquire();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void exitLok0() {
		System.out.println("\t\t\tZug 0 verlässt gemeinsamen Bereich!");
		lastDrivenThrough = 0;
		if(waiting[1]) {
			privateSemaphore[1].release();
		}
		
	}
	
	public void exitLok1() {
		System.out.println("\t\t\tZug 1 verlässt gemeinsamen Bereich!");
		lastDrivenThrough = 1;
		if(waiting[0]) {
			privateSemaphore[0].release();
		}
		
	}
	

}
