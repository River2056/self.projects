package salary_calculator;
import java.util.Scanner;
public class SalaryCalculatorV3 {

	public static void main(String[] args) {
		double salary = calculateSalary();
		int expenses = expenses();
		double account = salary - expenses;
		System.out.println();
		
		System.out.println("Your paycheck this month: " + salary);
		System.out.println("Your monthly expenses: " + expenses);
		System.out.println("Your account remainder: " + account);
	}
	
	public static double calculateSalary(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Input your day salary: ");
		int daySalary = scan.nextInt();
		System.out.println("How many days of work: ");
		int workDays = scan.nextInt();
		System.out.println("Overtime: ");
		int overtime = scan.nextInt();

		double salary = (daySalary * workDays) - (daySalary * workDays * 0.05);
		double overWork = overtime * (daySalary / 8) * 1.33;
		double trueSalary = salary + overWork;
		return trueSalary;
	}
	
	public static int expenses(){
		int[] expenses = new int[]{5500, 2020, 1500, 1000, 5550, 150, 90, 250*30, 800};
		/*
		rent = 5500;
		studentLoan = 2020;
		iphoneBills = 1500;
		eDating = 1000;
		computerClass = 5550;
		appleMusic = 150;
		iCloud = 90;
		dailyExpenses = 250 * 30;
		electricityBills = 800;
		*/
		int sum = 0;
			for(int x : expenses){ //enhanced for loop : adds all the elements together
				 sum = sum + x;  //count the sum of all elements add together
			 }
			return sum;
		}

}
