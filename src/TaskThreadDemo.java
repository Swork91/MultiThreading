import javax.swing.*;

public class TaskThreadDemo {

	public static void main(String[] args) {
		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable print100 = new PrintNum(100);
		
		//creating threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		FlashingText donk = new FlashingText();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.add(donk);
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