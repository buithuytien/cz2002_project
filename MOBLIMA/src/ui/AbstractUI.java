package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import util.DateTimeHelper;

/**
 * abstract class AbstractUI
 * composition of AbstractCRUD and AbstractEntity
 * @author Ronald
 *
 */
public abstract class AbstractUI {
	/**
	 * to save the previous menu accessed
	 */
	private AbstractUI prevUI;
	
	/**
	 * abstract method to initialize selected menu
	 * to be override
	 */
	public abstract void start();
	
	/**
	 * method to get the input of the user
	 * to choose the option given in the UI menu
	 * @param lowerBound
	 * @param upperBound
	 * @return the user's input integer in a given range
	 */
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
					System.out.println("Wrong input! Please try again!");
				}
			}
		} catch (Exception e) {
			System.out.println("Wrong input! Please make a choice!");
			return getInputChoice(lowerBound, upperBound);
		}
		
		return choice;
	}
	
	/**
	 * method for user to input a string 
	 * depending on the requirements of the UI menu
	 * @return the user's input string
	 */
	public String getInputString() {
		Scanner sc = new Scanner(System.in);
		String input;
		try {
			input = sc.nextLine().trim();
		} catch(Exception e) {
			System.out.println("Wrong input! Please try again!");
			return getInputString();
		}
		
		return input;
	}
	
	/**
	 * method for user to input a double
	 * depending on the requirements of the UI menu
	 * @return the user's input double
	 */
	public double getInputDouble() {
		double input;
		Scanner sc = new Scanner(System.in);
		try {
			 input = sc.nextDouble();
		 } catch(Exception e) {
			System.out.println("Wrong input! Please try again!");
			return getInputDouble();
		}
		return input;
	}
	
	/**
	 * method for user to input an integer
	 * depending on the requirements of the UI menu
	 * @return the user's input integer
	 */
	public int getInputInteger() {
		Scanner sc = new Scanner(System.in);
		int input;
		try {
			 input = sc.nextInt();
		} catch(Exception e) {
			System.out.println("Wrong input! Try again!");
			return getInputInteger();
		}
		
		return input;
	}
	
	/**
	 * method for user to input an array of strings
	 * depending on the requirements of the UI menu
	 * @return the user's input of strings in an array
	 */
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
	
	/**
	 * method for user to input the date
	 * depending on the requirements of the UI menu
	 * @return the user's input of date
	 */
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
			System.out.println("Wront input! Please try Again");
			return this.getInputDate();
		}
		return dateStr;
	}
	
	/**
	 * method to return to previous menu
	 */
	public void goBack() {
		if (this.prevUI == null) {
			System.exit(1);
		}
		this.prevUI.start();
	}
	
	/**
	 * method to stop the program
	 */
	public void exit() {
		System.exit(0);
	}
	
	/**
	 * accessor method to get the previous menu
	 * @return the previous display menu's class
	 */
	public AbstractUI getPrevUI() {
		return this.prevUI;
	}
	
	/**
	 * mutator method to set the previous menu
	 * @param itemUI
	 */
	public void setPrevUI(AbstractUI itemUI) {
		this.prevUI = itemUI;
	}
	
	/**
	 * method to save the current menu as previous menu
	 * and display the next menu
	 * depending on the choice entered by user
	 * @param nextUI
	 */
	public void intent(AbstractUI nextUI) {
		nextUI.setPrevUI(this);
		nextUI.start();
	}

}
