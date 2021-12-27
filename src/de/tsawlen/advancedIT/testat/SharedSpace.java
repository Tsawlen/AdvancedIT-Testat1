package de.tsawlen.advancedIT.testat;

import java.util.concurrent.Semaphore;

public class SharedSpace {

	private Semaphore zug1 = new Semaphore(1,true);
	private Semaphore zug2 = new Semaphore(0,true);
	
	public void enterLok0(int velocity) {
		
		try {
			zug1.acquire();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void enterlok1(int velocity) {
		
		try {
			zug2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void exitLok0() {
		System.out.println("\t\t\tZug 0 verlässt gemeinsamen Bereich!");
		zug2.release();
	}
	
	public void exitLok1() {
		System.out.println("\t\t\tZug 1 verlässt gemeinsamen Bereich!");
		zug1.release();
	}
	
}
