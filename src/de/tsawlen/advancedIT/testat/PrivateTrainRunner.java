package de.tsawlen.advancedIT.testat;

import java.util.ArrayList;

public class PrivateTrainRunner extends Thread {
	
	
	public static PrivateSharedSpace pShSp = new PrivateSharedSpace();
	
	//Settings for the Test
	private static int velocityTrain1 = 200;
	private static int velocityTrain2 = 100;
	private static int lengthWithoutSharedSpace = 400;
	private static int length = 180;
	
	private int id;
	
	public PrivateTrainRunner(int id) {
		this.id = id;
	}
	
	/***
	 * This function is responsible for running the threads of the PrivateTrainRunner
	 */
	@Override
	public void run() {
		
		//Area for Thread with id 0
		if(id == 0) {
			
			
			while(true) {
				
				System.out.println("Zug 0 möchte in den gemeinsamen Bereich einfahren");
				//Try enter the shared space
				pShSp.enterLok0();
				System.out.println("\t\t\tZug 0 fährt durch gemeinsamen Bereich!");
				
				try {
					//drive through the shared space (simulated through sleeping for the time the train would take to pass trough the shared space)
					Thread.sleep((length / velocityTrain1) * 1000);
					//exit the shared space
					pShSp.exitLok0();
					System.out.println("Zug 0 fährt auf seinem eigenen Bereich!");
					//drive through the own space (simulated through sleeping for the time the train would take to pass trough the own space)
					Thread.sleep((lengthWithoutSharedSpace / velocityTrain1) * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		//Area for Thread with id 1
		else if(id == 1) {
			
			while(true) {
				
				System.out.println("\t\t\t\t\t\tZug 1 möchte in den gemeinsamen Bereich einfahren");
				pShSp.enterLok1();
				System.out.println("\t\t\tZug 1 fährt durch gemeinsamen Bereich!");
				try {
					//drive through the shared space (simulated through sleeping for the time the train would take to pass trough the shared space)
					Thread.sleep((length / velocityTrain2) * 1000);
					//exit the shared space
					pShSp.exitLok1();
					System.out.println("\t\t\t\t\t\tZug 1 fährt auf seinem eigenen Bereich!");
					//drive through the own space (simulated through sleeping for the time the train would take to pass trough the own space)
					Thread.sleep((lengthWithoutSharedSpace / velocityTrain2) * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<PrivateTrainRunner> threads = new ArrayList<>();
		
		//Create and start tests
		for(int i = 0; i < 2; i++) {
			PrivateTrainRunner thread = new PrivateTrainRunner(i);
			threads.add(thread);
			threads.get(i).start();
		}
		
		
	}

}
