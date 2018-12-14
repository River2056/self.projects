package mypackage;
import java.util.Scanner;
public class BinaryNumCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int input = scan.nextInt();
		int x = input;
		int y = input;
		int count = 0;
		do{
			x /= 2;
			count++;
		}while(x != 0);  //see how many count
		
		int[] ans = new int[count]; //count determine array length
		for(int i = 0 ; i < ans.length ; i++){
			ans[i] = y % 2;
			if(y != 0){
				y /= 2;
			}
		}
		
		//print backwards to get real number
		System.out.println("Binary number is: ");
		for(int i = ans.length-1 ; i >= 0 ; i--){
			System.out.print(ans[i]);
		}
		scan.close();
	}		
}


