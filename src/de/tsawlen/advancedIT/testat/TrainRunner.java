package de.tsawlen.advancedIT.testat;

import java.util.ArrayList;

public class TrainRunner extends Thread{
	
	private int id;
	
	//Configuration of the track
	private static int velocityTrain1 = 100;
	private static int velocityTrain2 = 100;
	private static int lengthWithoutSharedSpace = 400;
	private static int length = 180;
	private static SharedSpace shSp = new SharedSpace();
	
	/***
	 * This is the constructor of this class
	 * @param id - The id of the thread
	 */
	public TrainRunner(int id) {
		this.id = id;
	}
	
	/***
	 * This method is responsible for starting the thread
	 */
	@Override
	public void run() {
		if(id == 0) {
			
			//loop for train 0
			while(true) {
				System.out.println("Zug 0 möchte in den gemeinsamen Bereich einfahren");
				//start the enter-method for the critical section
				shSp.enterLok0(velocityTrain1);
				System.out.println("\t\t\tZug 0 fährt durch gemeinsamen Bereich!");
				
				try {
					//simulate the time needed to drive through the shared track
					Thread.sleep((length / velocityTrain1) * 1000);
					//start the exit-method for the critical section
					shSp.exitLok0();
					System.out.println("Zug 0 fährt auf seinem eigenen Bereich!");
					//simulate the time needed to drive through the own track
					Thread.sleep((lengthWithoutSharedSpace / velocityTrain1) * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else if (id == 1) {
			//loop for train 1
			while(true) {
				System.out.println("\t\t\t\t\t\tZug 1 möchte in den gemeinsamen Bereich einfahren");
				//start the enter-method for the critical section
				shSp.enterlok1(velocityTrain1);
				System.out.println("\t\t\tZug 1 fährt durch gemeinsamen Bereich!");
				try {
					//simulate the time needed to drive through the shared track
					Thread.sleep((length / velocityTrain2) * 1000);
					//start the exit-method for the critical section
					shSp.exitLok1();
					System.out.println("\t\t\t\t\t\tZug 1 fährt auf seinem eigenen Bereich!");
					//simulate the time needed to drive through the own space
					Thread.sleep((lengthWithoutSharedSpace / velocityTrain2) * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}
	
	/***
	 * Entry point of the program for exercise A
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<TrainRunner> threads = new ArrayList<>();
		
		//Initialize and start needed threads
		for(int i = 0; i < 2; i++) {
			TrainRunner thread = new TrainRunner(i);
			threads.add(thread);
			threads.get(i).start();
		}
	}

}
