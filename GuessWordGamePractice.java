package mypackage;
import java.util.Scanner;
public class GuessWordGamePractice {

	public static void main(String[] args) {
		/* 1. ����H���r�żƲ� char[] chs, �ե�generate
		 * 2. �����Τ��J���r�Ŧ�, �ର�r�żƲ� String str = scan.next();
		 *                                     char[] input = str.toCharArray();
		 * 3. �}�l�����ռƲ�: chs & input ; �ˬd��X�Ӧr�ŻP��m
		 * 4. ��񧹦���ӵ��G: 1)�q��F: ���ܮ��ߧA�íp��o��
		 *                     2)�q���F: �����ܹ�X�Ӧr�Ŧ�m, ��loop���q(�q��1��-10��, �@�Ӧr��100��, �@500��)
		 * �`��:
 				�q--�Τ��J--���--�P�_���--��--���ܹ�X��--loop
 				�q--�Τ��J--���--�P�_���--��--���ߧA�o��--end
 			�p��P�_�q��?
 				�q��5�r��, ����m�S������---�q��---loop
 				�q���r�ŻP��m5��----------�q��----end
 				�ҥH�q���m��5 == �q�� == end
		 * */
		Scanner scan = new Scanner(System.in);
		char[] chs = generate();
		System.out.println(chs);
		
		int count = 0;
		while(true){
			System.out.println("�w��Ө�q�r�C��!");
			System.out.println("�п�J�r��: ");
			String str = scan.next().toUpperCase();
			char[] input = str.toCharArray();
			int[] result = check(chs, input);
				if(result[0] == chs.length){
					int score = 100 * chs.length - 10 * count;
					System.out.println("���ߧA�q��F! �A���o����: " + score + "��");
					break;
				}
				else{
					count++;
					System.out.println("�A�S�q��@~");
					System.out.println("�A�q�諸�r�Ŭ�: " + result[1] + "��,  " + "�åB�q���m��: " + result[0] + "��");
				}
		}
	}
	
	//���@���H���ͦ��H���r�Ū���k
	public static char[] generate(){ //�H���ͦ��r�żƲ�
		char[] chs = new char[5]; //�H���ͦ����Ӧr��
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'}; //�гy�@�Ӧr�Žd��
		boolean[] flags = new boolean[letters.length]; //�ͦ��Mletters�@�˦h���}��
		int index;
		for(int i = 0 ; i < chs.length ; i++){ //�M��, �]5�M chs.length=5 0, 1, 2, 3, 4
			do{
				index = (int)(Math.random() * letters.length); //�����H���U��(���n�O0��25����A~Z)
			}while(flags[index]); //�p�G��true, �h���s�ͦ�
			
			chs[i] = letters[index]; //�����H���U��, �q�d��h����H���r��, �ý�ȵ�chs[i]
			flags[index] = true; //�N�}�����}, ���Ƥ���A��
		}
		return chs;
	}
	
	//�H���ͦ����r��, �P�Τ�ݰ����, �ˬd�O�_�q���r�ũM��m
	public static int[] check(char[] chs, char[] input){ //�ͦ���Ӽƾ�, �r�Ź�P��m�諸����
		int[] result = new int[2];
		
		/* ��chs�h�M�C��input�����
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
		 * �@���F25�����-----�~��1��, ����5��
		 * */
		
		for(int i = 0 ; i < chs.length ; i++){ //�~��
			for(int j = 0 ; j < input.length ; j++){ //����
				if(chs[i] == input[j]){ //�ˬd�r�ŬO�_��W, ��W�h+1
					result[1]++;
					if(i == j){ //�b�r�Ź諸��¦���W, �ˬd��m�O�_����W, ���h+1
						result[0]++;
					}
					break; //��粒�r�ũM��m, �᭱�N���Τ�F, �����i�J�U�@��
				}
			}
		}
		return result;
	}

}
