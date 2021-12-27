package de.tsawlen.advancedIT.testat;

import java.util.concurrent.Semaphore;

public class PrivateSharedSpace {
	
	private boolean blocked;
	private boolean[] waiting;
	private int lastDrivenThrough;
	private Semaphore[] privateSemaphore;
	
	//Initialisiere PrivateSharedSpace
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
	
	/***
	 * This function is responsable for letting Lok 0 enter the shared Space
	 * Return: void
	 */
	
	public void enterLok0() {
		
		//Check if the shared space is free and if lok 1 has already passed through the shared space
		if(!blocked && lastDrivenThrough == 1) {
			//Allow passage of the shared space
			privateSemaphore[0].release();
		}else {
			//Wait for the system to allow access to the shared space
			waiting[0] = true;
		}
		
		try {
			privateSemaphore[0].acquire();
			waiting[0] = false;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * This function is responsable for letting Lok 1 enter the shared Space
	 * Return: void
	 */
	public void enterLok1() {
		//Check if the shared space is free and if lok 0 has already passed through the shared space
		if(!blocked && lastDrivenThrough == 0) {
			//Allow passage of the shared space
			privateSemaphore[1].release();
		}else {
			//Wait for the system to allow access to the shared space
			waiting[1] = true;
		}
		
		try {
			privateSemaphore[1].acquire();
			waiting[1] = false;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/***
	 * This function is responsable for letting Lok 0 leave the shared Space
	 * Return: void
	 */
	public void exitLok0() {
		System.out.println("\t\t\tZug 0 verlässt gemeinsamen Bereich!");
		//Set the status of the last driven Train to Lok 0
		lastDrivenThrough = 0;
		//When Lok 1 is already waiting to access the shared space, let it drive through
		if(waiting[1]) {
			privateSemaphore[1].release();
		}
		
	}
	
	/***
	 * This function is responsable for letting Lok 1 leave the shared Space
	 * Return: void
	 */
	public void exitLok1() {
		System.out.println("\t\t\tZug 1 verlässt gemeinsamen Bereich!");
		//Set the status of the last driven Train to Lok 1
		lastDrivenThrough = 1;
		//When Lok 0 is already waiting to access the shared space, let it drive through
		if(waiting[0]) {
			privateSemaphore[0].release();
		}
		
	}
	

}
