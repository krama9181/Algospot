import java.util.Scanner;
import java.util.Stack;

public class fixparen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int times = in.nextInt();
		
		for(int i =0 ; i < times ; i++){
			
			
			String inputParen = in.next();
			char[] Paren = inputParen.toCharArray();
//		
			String leftBracket = in.next();
			char[] priority = leftBracket.toCharArray();
			

			String rightBracket = "";
			for(int k = 0 ; k < priority.length; k++){
				if(priority[k] == '{'){
					rightBracket = rightBracket + '}';
					continue;
				}
				if(priority[k] == '('){
					rightBracket = rightBracket + ')';
					continue;
				}
				if(priority[k] == '['){
					rightBracket = rightBracket + ']';
					continue;
				}
				if(priority[k] == '<'){
					rightBracket = rightBracket + '>';
					continue;
				}
			}
						
			CharSequence seq = new String(inputParen);
			
			Stack<Character> bracket = new Stack<Character>();
			
//			StringBuffer clearParen = new StringBuffer();		
//			StringBuffer partofParen = new StringBuffer();	
		
			StringBuilder clearParen = new StringBuilder();		
			String partofParen = "";
			
			int threshold =1000;
			int trigger = 0;
			
			for(int j = 0; j < Paren.length; j++){
				if(leftBracket.contains(seq.subSequence(j, j+1))){
					bracket.add(Paren[j]);
					
				}
							
				if(bracket.size() != 0 && rightBracket.contains(seq.subSequence(j, j+1))){
					StringBuffer tempParen = new StringBuffer();
				
					char stackedBracket = bracket.pop();
					
					if(threshold > bracket.size()){
						threshold = bracket.size();
					}
					else{
						trigger++;
					}
					
				
					
					int stackedLeft = leftBracket.indexOf(stackedBracket);
					int stackedRight = rightBracket.indexOf(Paren[j]);
					
					if(stackedLeft < stackedRight){
						if(trigger > 0){
							tempParen.append(partofParen);
							tempParen.append(leftBracket.charAt(stackedLeft));
							tempParen.append(rightBracket.charAt(stackedLeft));
							trigger--;
						}
						else{
							tempParen.append(leftBracket.charAt(stackedLeft));
							tempParen.append(partofParen);
							tempParen.append(rightBracket.charAt(stackedLeft));
						}
						
						
					}
					else{
						if(trigger > 0){
							tempParen.append(partofParen);
							tempParen.append(leftBracket.charAt(stackedRight));
							tempParen.append(rightBracket.charAt(stackedRight));
							trigger--;

						}
						else{
							tempParen.append(leftBracket.charAt(stackedRight));
							tempParen.append(partofParen);
							tempParen.append(rightBracket.charAt(stackedRight));
						}
						
					}
					
					partofParen = tempParen.toString();
					//System.out.println(trigger);
					
					if(bracket.isEmpty() || j==Paren.length-1){
						clearParen.append(tempParen);
						partofParen = "";
						trigger = 0;
						threshold =1000;

					}
					
				}
				
				
			}
			System.out.println(clearParen);
		}
	}

}
