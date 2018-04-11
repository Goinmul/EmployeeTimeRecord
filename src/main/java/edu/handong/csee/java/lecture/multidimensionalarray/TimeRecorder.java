package edu.handong.csee.java.lecture.multidimensionalarray;
import java.util.Scanner;
/**
 * This is a class for calculating employee's work hours,
 * by weeks and by each employee's.
 * @author Hyun Woo Kwon
 *
 */
public class TimeRecorder {
	
	private final int NUM_OF_WORK_DAYS = 5; // An employee works for five days from Monday to Friday 
	private int[][] hours; // instantiating a 2D array
	private enum WeekDays {Monday, Tuesday, Wendesday, Thursday, Friday}; // enum gives each word a value(integer)
	private int[] dayHours = new int[WeekDays.values().length]; // integer array like [mon][tue][wed][thur][fri]. (work time)
	private int[] weekHours; // integer array.
	
	public static void main(String[] args) { // main function
		
		TimeRecorder myTimeRecoder = new TimeRecorder(); // instantiating the class
		
		myTimeRecoder.getData(); // activating all the actions below.
		myTimeRecoder.computeTotals();
		myTimeRecoder.printResults();

	}
	
	public void getData() { // method for getting data.
		
		Scanner myScanner = new Scanner(System.in); // instantiating scanner.
		
		System.out.print("How many employees do you want" +
								"to process for their work time? ");
		
		int numOfEmployees = myScanner.nextInt(); // let's say user put 3 (I understood this by an example)
		
		hours = new int[numOfEmployees][NUM_OF_WORK_DAYS]; // hours[3][5]
		
		for(int employeeCount=0; employeeCount < hours.length; employeeCount++) { //hours.length = 3 (iterate 3 times)
			System.out.println("Input work time for Employee " + (employeeCount+1) + ": "); // giving work times for employee 1, 2, 3
	
			for(WeekDays currentDay:WeekDays.values()) { // literate till there is a remaining value in WeekDays. ( iterate 5 times	)		
				System.out.print("  Input work time for Employee " + (employeeCount+1) 
									+ " on " + currentDay + ": ");
				hours[employeeCount][currentDay.ordinal()] = myScanner.nextInt(); // User gives value to hours[0][0~4], [1][0~4], [2][0~4]
			}
		}
		
		myScanner.close(); // closing scanner.
	}
	
	
	public void computeTotals() { // the 'Totals' column shown in the Console
		
		weekHours = new int[hours.length]; // 3 cell array
		
		for(WeekDays currentDay:WeekDays.values()) { // literate 5 times ( monday ~ friday )
			
			dayHours[currentDay.ordinal()] = 0; // 5 cell array
			
			for(int employeeCount=0; employeeCount < hours.length; employeeCount++) {	// hours.length is 3 at [3][5]. (iterate 3 times)
				
				dayHours[currentDay.ordinal()] = dayHours[currentDay.ordinal()] + hours[employeeCount][currentDay.ordinal()];
				// giving total hours worked on days. (monday total, tuesday total, ... )
			}
			
		}
		
	weekHours = new int[hours.length]; // hours.length is 3 (number of rows)
		
		for(int employeeCount=0; employeeCount < hours.length; employeeCount++) { // iterate 3 times ( employee num )
			
			weekHours[employeeCount] = 0; // gives a row of weekHour value with below for loop
		
			for(WeekDays currentDay:WeekDays.values()) { // now you know, it should iterate 5 times( for monday ~ friday )
				weekHours[employeeCount] = weekHours[employeeCount] 
															+ hours[employeeCount][currentDay.ordinal()];
				// giving total workhours for each employee.
			}
		}
		
	}
	
	public void printResults() {
		
		System.out.println();
		
		// print the first line: "Employee   1   2   3   Totals"
		System.out.print("Employee" + addSpace("Employee".length()));
		
		for(int employeeCount = 0; employeeCount < hours.length; employeeCount++) { // printing out Employee  1   2   3
			System.out.print(employeeCount+1 + "\t");
		}
		
		System.out.print("Totals");
		System.out.println();
		
		// print work time per each weekday
		for(WeekDays currentDay:WeekDays.values()) {
			
			System.out.print(currentDay + addSpace(currentDay.name().length()));
			for(int employCount = 0; employCount < hours.length ;employCount++) {
				System.out.print(hours[employCount][currentDay.ordinal()] + "\t");
			}
			System.out.print(dayHours[currentDay.ordinal()]);
			System.out.println();
		}
		
		// print total per employee
		System.out.print("Total = " + addSpace("Total = ".length()));
		for(int employeeCount = 0; employeeCount < hours.length; employeeCount++) {
			System.out.print(weekHours[employeeCount] +"\t");
		}
	}
	
	private String addSpace(int length) {
		
		final int maxWeekDayLength = 9;
		String spaces = " ";
		
		for(int spaceCount=0; spaceCount < maxWeekDayLength-length; spaceCount++) {
			spaces = spaces + " ";
		}
		
		return spaces;
	}
}
