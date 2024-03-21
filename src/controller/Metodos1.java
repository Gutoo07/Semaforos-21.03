package controller;
import java.util.concurrent.Semaphore;


public class Metodos1 extends Thread {
	
	private int id;
	private Semaphore semaforo;
	private int progresso, buff, porta, d4;
	static int tocha, pedra;
	static int portasAbertas[] = new int[4];
	
	public Metodos1(Semaphore semaforo, int i) {
		id = (i+1);
		this.semaforo = semaforo;
	}
	public void run() {
		while (progresso<2000) {
			
			if (buff == 0) {
				progresso += (int) ((Math.random()*3) + 2);
				System.out.println("Cavaleiro #" + id + " andou " + progresso + "m");
			} else if (buff == 1) {
				progresso += (int) ((Math.random()*5) + 2);
				System.out.println("Cavaleiro #" + id + " andou " + progresso + "m");
			} else if ( buff == 2) {
				progresso += (int) ((Math.random()*7) + 2);
				System.out.println("Cavaleiro #" + id + " andou " + progresso + "m");
			}
			if (progresso>=500) {
				if (tocha<1) {
					++tocha;
					buff++;
					System.err.println("Cavaleiro #" + id + " pegou a tocha!");
				}								
			}
			if (progresso>=1500) {
				if (pedra<1) {
					++pedra;
					buff++;
					System.err.println("Cavaleiro #" + id + " pegou a pedra brilhante!");
				}
			}
						
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		try {
			semaforo.acquire();
			porta(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	private void porta(int id) {
		porta = (int) ((Math.random()*4) + 1);
		
		if (portasAbertas[porta-1] == 0) {
			portasAbertas[porta-1] = 1;
		} else if (portasAbertas[porta-1] == 1) {
			while (portasAbertas[porta-1] == 1) {
				porta = (int) ((Math.random()*4) + 1);
			}
			portasAbertas[porta-1] = 1;
		}
		
		System.err.println("Cavaleiro #" + id + " abriu a " + porta + "a porta");
		d4 = (int) ((Math.random()*4) + 1);
		if (d4 == porta) {
			System.err.println("Cavaleiro #" + id + " tirou " + d4 +  " e conseguiu fugir! ggwp");
		} else {
			System.err.println("Cavaleiro #" + id + " tirou " + d4 + " e morreu.");
		}
		
	}
}
 