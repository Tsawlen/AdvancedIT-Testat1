package de.tsawlen.advancedIT.testat;

import java.util.concurrent.Semaphore;

public class SharedSpace {

	//Configuration for needed semaphores
	private Semaphore zug1 = new Semaphore(1,true);
	private Semaphore zug2 = new Semaphore(0,true);
	
	/***
	 * This method is the entry-method for the critical section of the shared track for train 0.
	 * 
	 * @param velocity
	 */
	public void enterLok0(int velocity) {
		
		try {
			//aquire semaphore for train 0, which has the start value 1 and can be released by the exit-method of train 1
			zug1.acquire();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/***
	 * This method is the entry-method for the critical section of the shared track for train 1.
	 * 
	 * @param velocity
	 */
	public void enterlok1(int velocity) {
		
		try {
			//aquire semaphore for train 0, which has the start value 0 and can be released by the exit-method of train 0
			zug2.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/***
	 * This method is the exit-method for the critical section of the shared track for train 0.
	 * 
	 */
	public void exitLok0() {
		System.out.println("\t\t\tZug 0 verlässt gemeinsamen Bereich!");
		//release semaphore for train 1, so it can drive through the shared track
		zug2.release();
	}
	
	/***
	 * This method is the exit-method for the critical section of the shared track for train 1.
	 */
	public void exitLok1() {
		System.out.println("\t\t\tZug 1 verlässt gemeinsamen Bereich!");
		//release semaphore for train 0, so it can drive through the shared track
		zug1.release();
	}
	
}
