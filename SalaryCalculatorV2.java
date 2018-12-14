package salary_calculator;
import java.util.Scanner;
public class SalaryCalculatorV2 {

	public static void main(String[] args) {
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
		
		System.out.println("Your paycheck = " + trueSalary);
		
		
		//salary = (daySalary * workDays) - (daySalary * workDays * 0.05)
		//overtime = (daySalary / 8) * 1.33
		//input daySalary
		//input workDays
		//input overtime
		//trueSalary = salary + overtime
		//System.out.println("Á~¸ê¬°: " + trueSalary)
		
		 int[] expenses = new int[]{5500, 2020, 1500, 1000, 5550, 150, 90, 250*30, 800};
		 int sum = 0;
		 for(int x : expenses){ //enhanced for loop : adds all the elements together
			 sum = sum + x;  //count the sum of all elements add together
		 }
		  System.out.println("Your monthly expenses= " + sum);
		/*
		int rent = 5500;
		int studentLoan = 2020;
		int phoneBills = 1500;
		int eDating = 1000;
		int computerClass = 5550;
		int appleMusic = 150;
		int iCloud = 30;
		int dailyExpenses = 250 * 30;
		int electricityBills = 800;
		*/
		
		double totalWallet = trueSalary - sum;
		System.out.println("Your account amount = " + totalWallet);
		/* count total wallet:
		 * trueSalary - monthlyExpenses
		 * 
		 * monthlyExpenses = rent + studentLoan + phoneBills + eDating + computerClass
		 * + appleMusic + dailyExpenses + electricityBills
		 * 
		 * trueSalary - monthlyExpenses = account
		 *  
		 * */

	}
		
}


