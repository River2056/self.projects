package mypackage;
import java.util.Scanner;
public class GuessWordGamePractice {

	public static void main(String[] args) {
		/* 1. 獲取隨機字符數組 char[] chs, 調用generate
		 * 2. 接收用戶輸入的字符串, 轉為字符數組 String str = scan.next();
		 *                                     char[] input = str.toCharArray();
		 * 3. 開始比較兩組數組: chs & input ; 檢查對幾個字符與位置
		 * 4. 對比完有兩個結果: 1)猜對了: 提示恭喜你並計算得分
		 *                     2)猜錯了: 給提示對幾個字符位置, 並loop重猜(猜錯1次-10分, 一個字符100分, 共500分)
		 * 循環:
 				猜--用戶輸入--對比--判斷對錯--錯--提示對幾個--loop
 				猜--用戶輸入--對比--判斷對錯--對--恭喜你得分--end
 			如何判斷猜對?
 				猜中5字符, 但位置沒有全對---猜錯---loop
 				猜中字符與位置5個----------猜對----end
 				所以猜對位置為5 == 猜對 == end
		 * */
		Scanner scan = new Scanner(System.in);
		char[] chs = generate();
		System.out.println(chs);
		
		int count = 0;
		while(true){
			System.out.println("歡迎來到猜字遊戲!");
			System.out.println("請輸入字母: ");
			String str = scan.next().toUpperCase();
			char[] input = str.toCharArray();
			int[] result = check(chs, input);
				if(result[0] == chs.length){
					int score = 100 * chs.length - 10 * count;
					System.out.println("恭喜你猜對了! 你的得分為: " + score + "分");
					break;
				}
				else{
					count++;
					System.out.println("你沒猜對哦~");
					System.out.println("你猜對的字符為: " + result[1] + "個,  " + "並且猜對位置為: " + result[0] + "個");
				}
		}
	}
	
	//做一個隨機生成隨機字符的方法
	public static char[] generate(){ //隨機生成字符數組
		char[] chs = new char[5]; //隨機生成五個字符
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'}; //創造一個字符範圍
		boolean[] flags = new boolean[letters.length]; //生成和letters一樣多的開關
		int index;
		for(int i = 0 ; i < chs.length ; i++){ //遍歷, 跑5遍 chs.length=5 0, 1, 2, 3, 4
			do{
				index = (int)(Math.random() * letters.length); //產生隨機下標(正好是0到25之間A~Z)
			}while(flags[index]); //如果為true, 則重新生成
			
			chs[i] = letters[index]; //產生隨機下標, 從範圍去抓取隨機字符, 並賦值給chs[i]
			flags[index] = true; //將開關打開, 此數不能再用
		}
		return chs;
	}
	
	//隨機生成的字符, 與用戶端做對比, 檢查是否猜中字符和位置
	public static int[] check(char[] chs, char[] input){ //生成兩個數據, 字符對與位置對的分數
		int[] result = new int[2];
		
		/* 讓chs去和每個input做比較
		 * chs[0] - input[0]
		 * chs[0] - input[1]
		 * chs[0] - input[2]
		 * chs[0] - input[3]
		 * chs[0] - input[4]
		 * -----------------
		 * chs[1] - input[0]
		 * chs[1] - input[1]
		 * chs[1] - input[2]
		 * chs[1] - input[3]
		 * chs[1] - input[4]
		 * -----------------
		 * chs[2] - input[0]
		 * chs[2] - input[1]
		 * chs[2] - input[2]
		 * chs[2] - input[3]
		 * chs[2] - input[4]
		 * ...
		 * 共做了25次比較-----外輪1次, 內輪5次
		 * */
		
		for(int i = 0 ; i < chs.length ; i++){ //外輪
			for(int j = 0 ; j < input.length ; j++){ //內輪
				if(chs[i] == input[j]){ //檢查字符是否對上, 對上則+1
					result[1]++;
					if(i == j){ //在字符對的基礎之上, 檢查位置是否有對上, 有則+1
						result[0]++;
					}
					break; //比對完字符和位置, 後面就不用比了, 直接進入下一輪
				}
			}
		}
		return result;
	}

}
