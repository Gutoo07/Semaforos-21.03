package view;
import java.util.concurrent.Semaphore;

import controller.Metodos1;

public class Main1 {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for ( int i = 0; i < 4; i++) {
			Thread cavaleiro = new Metodos1(semaforo , i);
			cavaleiro.start();
		}
	}

}
