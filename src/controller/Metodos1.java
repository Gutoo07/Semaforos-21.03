package controller;
import java.util.concurrent.Semaphore;


public class Metodos1 extends Thread {
	
	private int id;
	private Semaphore semaforo;
	
	public Metodos1(Semaphore semaforo, int i) {
		id = (i+1);
		this.semaforo = semaforo;
	}
	public void run() {
		
	}
}
