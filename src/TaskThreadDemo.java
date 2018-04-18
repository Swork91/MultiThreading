import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

public class TaskThreadDemo {

	public static void main(String[] args) {
		//using threads instead of timers
		FlashingText donk = new FlashingText();
		JFrame frame = new JFrame();
		frame.add(donk);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//threads
		//createThreads();
		
		//executors
		createExecutors(3);
	}
	
	public static void createThreads() {
		Runnable printA = new PrintChar('a', 1000);
		Runnable printB = new PrintChar('b', 1000);
		Runnable print100 = new PrintNum(1000);
		
		//creating threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	public static void createExecutors(int t) {
		int threadsToUse = t;
		//create thread pool of max t
		ExecutorService executor =  Executors.newFixedThreadPool(threadsToUse);
		
		executor.execute(new PrintChar('a', 1000));
		executor.execute(new PrintChar('b', 1000));
		executor.execute(new PrintNum(1000));
		
		executor.shutdown();
	}
}

class PrintChar implements Runnable {
private int time;
private char character;
	public PrintChar(char c, int t) {
		character = c;
		time = t;
	}

	@Override
	public void run() {
		for (int i=0; i<time; i++) {
			System.out.print(character);
		}
		
	}
	
}

class PrintNum implements Runnable {
private int num;
	public PrintNum(int n) {
		num = n;
	}

	@Override
	public void run() {
		for (int i=1; i<=num; i++) {
			System.out.print(" " + i);
		}
	}
	
}