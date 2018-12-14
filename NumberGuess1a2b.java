package mypackage;
import java.util.Scanner;
public class NumberGuess1a2b {

	public static void main(String[] args) {
		/*1a2b
			1. get random number from method--generate(); char[] chs
			2. let user input number as String str; use scan.next();
			3. convert String str into char[] input; char[] input = str.toCharArray();
			4. compare char[] chs char[] input;
			5. check results:
				1) if right: print congratulations, 4A
				2) if wrong: print xAyB; x = correct value, y = correct position;
			Loop:
				guess---user input---print xAyB---loop
				guess---user input---4A---congrats!---end
		 * */
		Scanner scan = new Scanner(System.in);
		char[] chs = generate();
		System.out.println(chs); //for testing purposes
		System.out.println();
		System.out.println("Welcome to NumGuess1a2b game!");
		
		int count = 0;
		while(true){
			System.out.println("Please enter your number: (exit to quit)");
			String str = scan.next().toLowerCase(); //user input into String
			if(str.equals("exit")){
				System.out.println("Don't give up yet! Hope to see you soon!");
				break;
			}
			char[] input = str.toCharArray(); //convert String to char array
			int[] result = check(chs, input); //compare both
				if(result[0] == chs.length){ //position correct = 5 means all correct---end game
					count++;
					System.out.println("Congratulations! You win!" + " " + "guessed: " + count + " " + "times");
					break;
				}
				else{
					count++;
					System.out.println(result[0] + "A" + result[1] + "B");
				}
		}
	}
	
	public static char[] generate(){ //generate 4 random numbers for game
		char[] chs = new char[4];
		char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		boolean[] flags = new boolean[numbers.length]; //check switch: if on, value invalid, generate another
		for(int i = 0 ; i < chs.length ; i++){
			int index;
			do{
				index = (int)(Math.random()*10); //generate 0~9
			}while(flags[index]); //if true, go back to loop and generate again
			chs[i] = numbers[index]; //if false, value valid, save to chs[i], numbers[index] picks a number from group
			flags[index] = true; //turn on the switch to avoid duplicate numbers
		}
		return chs;
	}
	
	public static int[] check(char[] chs, char[] input){ //check two values
		int[] result = new int[2];
		for(int i = 0 ; i < chs.length ; i++){ //check for correct input
			for(int j = 0 ; j < input.length ; j++){ //check for correct position
				if(chs[i] == input[j]){ //check if value is correct
					if(i == j){ //check if position is correct
						result[0]++;
					}
					else{
						result[1]++;
					}
					break;
				}
			}
		}
		return result;
	}
	

}
