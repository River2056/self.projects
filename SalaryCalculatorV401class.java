package salary_calculator;

import java.util.Scanner;

public class SalaryCalculatorV401class {
	Scanner scan = new Scanner(System.in);
	int daySalary = scan.nextInt();
	int workDays = scan.nextInt();
	int overtime = scan.nextInt();
	
	CalculateSalary sal = new CalculateSalary(daySalary, workDays, overtime);
	Expenses exp = new Expenses();
	void printDataSalary(){
		System.out.println("Your paycheck: " + sal.trueSalary());
	}
	void printDataExpenses(){
		System.out.println("Your monthly expenses: " + exp.sum());
	}
	void printDataRemainder(){
		double remainder = sal.trueSalary() - exp.sum();
		System.out.println("Your account remainder: " + remainder);
	}
}

class CalculateSalary{
	int daySalary;
	int workDays;
	int overtime;
	
	CalculateSalary(int daySalary, int workDays, int overtime){
		this.daySalary = daySalary;
		this.workDays = workDays;
		this.overtime = overtime;
	}	
	double trueSalary(){
		double salary = (daySalary * workDays) - (daySalary * workDays * 0.05);
		double overWork = overtime * (daySalary / 8) * 1.33;
		double trueSalary = salary + overWork;
		return trueSalary;
	}
	
}


class Expenses{
	//members of Expenses;
	int rent;
	int studentLoan;
	int iphoneBills;
	int eDating;
	int computerClass;
	int appleMusic;
	int iCloud;
	int dailyExpenses;
	int electricityBills;
	
	//initialize value to all members
	Expenses(){ //5500, 2020, 1500, 1000, 5550, 150, 90, 250*30, 800
		rent = 5500;
		studentLoan = 2020;
		iphoneBills = 1500;
		eDating = 1000;
		computerClass = 5550;
		appleMusic = 150;
		iCloud = 90;
		dailyExpenses = 250 * 30;
		electricityBills = 800;
		
	}
	
	//methods for calculating expenses
	int sum(){
		int total = rent + studentLoan + iphoneBills + eDating + computerClass + appleMusic + iCloud + dailyExpenses
				+ electricityBills;
		return total;
	}
}
