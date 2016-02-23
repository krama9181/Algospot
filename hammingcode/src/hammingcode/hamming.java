package hammingcode;

import java.util.Scanner;

public class hamming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int times = in.nextInt();
		
		for(int j = 0 ; j< times ; j++){
			int InputDecimal = in.nextInt();
			int[] code = new int[7];
			
			for(int k = 0; k < 7; k++){
				code[6-k] = (int) (InputDecimal % Math.pow(10, k+1));
				InputDecimal = InputDecimal - code[6-k];
				
				
				if(code[6-k] == 0){
					code[6-k] = 0;
				}
				else{
					code[6-k] = (int) (code[6-k] / Math.pow(10,k));
				}
			}
			
			
			int CheckBit_1, CheckBit_2, CheckBit_3 = 0;
			
			CheckBit_1 = (code[0] + code[2] + code [4] + code[6]) % 2;
			CheckBit_2 = (code[1] + code[2] + code [5] + code[6]) % 2;
			CheckBit_3 = (code[3] + code[4] + code [5] + code[6]) % 2;
			
			InputDecimal = CheckBit_1+CheckBit_2*10 + CheckBit_3 *100;			
			int Decimal = BinToDec(InputDecimal);
			
			int errorPosition = Decimal;
			
			if(InputDecimal == 0){
				
			}
			else{
				if(code[Decimal-1] == 1){
					code[Decimal-1] = 0;
				}
				else
					code[Decimal-1] = 1;
			}
			
			System.out.println(code[2] +""+ code[4] +""+ code [5] +""+ code[6]);
			
		}
		
		
		
	}
	
	static int BinToDec(int syndrome){	
		int changedDecimal = 0;
		
		for(int i = 0 ; i < 3 ; i++){
			int tempNum = (int) (syndrome % (Math.pow(10,  i+1)));
			syndrome = syndrome - tempNum;
			changedDecimal = (int) (tempNum * (Math.pow(2,i) / (Math.pow(10, i))) + changedDecimal);
		}
		return changedDecimal;
	}

}