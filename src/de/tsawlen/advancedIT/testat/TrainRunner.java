package de.tsawlen.advancedIT.testat;

import java.util.ArrayList;

public class TrainRunner extends Thread{
	
	private int id;
	
	
	private static int velocityTrain1 = 100;
	private static int velocityTrain2 = 100;
	private static int lengthWithoutSharedSpace = 400;
	private static int length = 180;
	private static SharedSpace shSp = new SharedSpace();
	
	public TrainRunner(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		if(id == 0) {
			
			//Schleife des Threads für Lok 0
			while(true) {
				System.out.println("Zug 0 möchte in den gemeinsamen Bereich einfahren");
				shSp.enterLok0(velocityTrain1);
				System.out.println("\t\t\tZug 0 fährt durch gemeinsamen Bereich!");
				
				try {
					Thread.sleep((length / velocityTrain1) * 1000);
					shSp.exitLok0();
					System.out.println("Zug 0 fährt auf seinem eigenen Bereich!");
					Thread.sleep((lengthWithoutSharedSpace / velocityTrain1) * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else if (id == 1) {
			//Schleife des Threads für Lok 1
			while(true) {
				System.out.println("\t\t\t\t\t\tZug 1 möchte in den gemeinsamen Bereich einfahren");
				shSp.enterlok1(velocityTrain1);
				System.out.println("\t\t\tZug 1 fährt durch gemeinsamen Bereich!");
				try {
					Thread.sleep((length / velocityTrain2) * 1000);
					shSp.exitLok1();
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
		
		ArrayList<TrainRunner> threads = new ArrayList<>();
		
		//Erstelle und starte Threads
		for(int i = 0; i < 2; i++) {
			TrainRunner thread = new TrainRunner(i);
			threads.add(thread);
			threads.get(i).start();
		}
	}

}
