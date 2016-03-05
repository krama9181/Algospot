package nQueen;

import java.util.Scanner;

public class nqueen_problem {
	
	static int numberofQueens, successCase;
	static int column[];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int times = in.nextInt();
		
		while(times-- > 0){
			successCase = 0;
			numberofQueens = in.nextInt();
			
			
			column = new int[numberofQueens+1];
			
			queens(0);
			
			System.out.println(successCase);
		}
	
	}
	
	public static void queens(int i){
		if(promising(i)){
			if(i == numberofQueens){
				successCase++;
			}
			
			else{
				for(int j = 1; j <= numberofQueens ; j ++){
					column[i+1] = j;
					
					queens(i+1);
				}
			}
		}
	}
	
	public static boolean promising(int i){
		int formerRow = 1;
		boolean promisingResult = true;
		
		while(formerRow < i && promisingResult){
			if((column[formerRow] == column[i]) || Math.abs(formerRow-i) == Math.abs(column[formerRow]-column[i])){
				promisingResult = false;
			}
			formerRow++;
		
		}
		return promisingResult;
		
	}
}
