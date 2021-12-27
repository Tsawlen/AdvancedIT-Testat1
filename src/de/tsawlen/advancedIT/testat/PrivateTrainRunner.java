package de.tsawlen.advancedIT.testat;

import java.util.ArrayList;

public class PrivateTrainRunner extends Thread {
	
	public static PrivateSharedSpace pShSp = new PrivateSharedSpace();
	
	private static int velocityTrain1 = 200;
	private static int velocityTrain2 = 100;
	private static int lengthWithoutSharedSpace = 400;
	private static int length = 180;
	
	private int id;
	
	public PrivateTrainRunner(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		
		if(id == 0) {
			
			while(true) {
				
				System.out.println("Zug 0 möchte in den gemeinsamen Bereich einfahren");
				pShSp.enterLok0();
				System.out.println("\t\t\tZug 0 fährt durch gemeinsamen Bereich!");
				
				try {
					Thread.sleep((length / velocityTrain1) * 1000);
					pShSp.exitLok0();
					System.out.println("Zug 0 fährt auf seinem eigenen Bereich!");
					Thread.sleep((lengthWithoutSharedSpace / velocityTrain1) * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}else if(id == 1) {
			
			while(true) {
				
				System.out.println("\t\t\t\t\t\tZug 1 möchte in den gemeinsamen Bereich einfahren");
				pShSp.enterLok1();
				System.out.println("\t\t\tZug 1 fährt durch gemeinsamen Bereich!");
				try {
					Thread.sleep((length / velocityTrain2) * 1000);
					pShSp.exitLok1();
					System.out.println("\t\t\t\t\t\tZug 1 fährt auf seinem eigenen Bereich!");
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
		
		//Erstelle und starte Threads
		for(int i = 0; i < 2; i++) {
			PrivateTrainRunner thread = new PrivateTrainRunner(i);
			threads.add(thread);
			threads.get(i).start();
		}
		
		
	}

}
