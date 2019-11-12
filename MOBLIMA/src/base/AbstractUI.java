package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import util.DateTimeHelper;

public abstract class AbstractUI {
	private AbstractUI prevUI;
	
	
	public abstract void start();
	
	public int getInputChoice(int lowerBound, int upperBound) {
		Scanner sc = new Scanner(System.in);
		int choice;
		try {
			while (true) {
				System.out.println("Enter your choice:");
				choice = sc.nextInt();
				
				if (choice>=lowerBound && choice<=upperBound) {
					break;
				} else {
					System.out.println("Wrong Input! Try again!");
				}
			}
		} catch (Exception e) {
			System.out.println("Wrong Input! Please make a choice");
			return getInputChoice(lowerBound, upperBound);
		}
		
		return choice;
	}
	
	public String getInputString() {
		Scanner sc = new Scanner(System.in);
		String input;
		try {
			input = sc.nextLine().trim();
		} catch(Exception e) {
			System.out.println("Wrong Input! Try again!");
			return getInputString();
		}
		
		return input;
	}
	
	public double getInputDouble() {
		double input;
		Scanner sc = new Scanner(System.in);
		try {
			 input = sc.nextDouble();
		 } catch(Exception e) {
			System.out.println("Wrong Input! Try again!");
			return getInputDouble();
		}
		return input;
	}
	
	public int getInputInteger() {
		Scanner sc = new Scanner(System.in);
		int input;
		try {
			 input = sc.nextInt();
		} catch(Exception e) {
			System.out.println("Wrong Input! Try again!");
			return getInputInteger();
		}
		
		return input;
	}
	
	public ArrayList<String> getInputListString() {
		String terminate = "QUIT";
		ArrayList<String> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String input = this.getInputString();
		arr.add(input);
		while (true){
			System.out.println("Enter next String (Enter " +terminate+ " to stop:)");
			input = this.getInputString();
			if (input.equals(terminate))
				break;
			
			arr.add(input);
		} 
		return arr;
	}
	
	public String getInputDate() {
		String dateStr;
		try {
			while (true) {
				System.out.println("Enter date in "+DateTimeHelper.DATE_FORMAT);
				dateStr = this.getInputString();
				LocalDate date = DateTimeHelper.convertStringToDate(dateStr);
				if (DateTimeHelper.fromToday(date))
					break;
				System.out.println("Input date from today");
			}
		} catch (Exception e) {
			System.out.println("Wront Input! Try Again");
			return this.getInputDate();
		}
		return dateStr;
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
