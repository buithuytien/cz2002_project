package base;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class AbstractUI {
	private AbstractUI prevUI;
	
	
	public abstract void start();
	
	public int getInputChoice(int lowerBound, int upperBound) {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while (true) {
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			if (choice>=lowerBound && choice<=upperBound) {
				break;
			} else {
				System.out.println("Wrong Input! Try again!");
			}
		}
		
		return choice;
	}
	
	public String getInputString() {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine().trim();
		
		return input;
	}
	
	public double getInputDouble() {
		Scanner sc = new Scanner(System.in);
		double input = sc.nextDouble();
		return input;
	}
	
	public void goBack() {
		if (this.prevUI == null) {
			System.exit(1);
		}
		this.prevUI.start();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public AbstractUI getPrevUI() {
		return this.prevUI;
	}
	
	public void setPrevUI(AbstractUI itemUI) {
		this.prevUI = itemUI;
	}
	
	public void intent(AbstractUI nextUI) {
		nextUI.setPrevUI(this);
		nextUI.start();
	}

}
