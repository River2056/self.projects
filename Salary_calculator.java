package salary_calculator;
import java.util.Scanner;
public class Salary_calculator {

	public static void main(String[] args) {
				
	        System.out.println(calculateSalary());

	    }
	    public static double calculateSalary(){
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println("�п�J���~: ");
	    	int salary = scan.nextInt();
	    	System.out.println("�п�J�Ѽ�: ");
			int workdays = scan.nextInt();
			System.out.println("�п�J�[�Z�ɼ�: ");
			int overtime = scan.nextInt();
	    	double totalOvertime = overtime * (salary / 8) * 1.33, 
	    	totalSalary = (salary * workdays) - (salary * workdays * 0.05) + totalOvertime;
	    return  totalSalary;}

	}

