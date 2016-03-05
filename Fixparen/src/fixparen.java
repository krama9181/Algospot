import java.util.Scanner;
import java.util.Stack;

public class fixparen {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int times = in.nextInt();
		
		for(int i =0 ; i < times ; i++){
			String inputParen = in.next();
			char[] Paren = inputParen.toCharArray();

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
			Stack<Integer> bracket_offset = new Stack<Integer>();
			
			char[] clearParen = new char[Paren.length];
			
			for(int j = 0; j < Paren.length; j++){
				if(leftBracket.contains(seq.subSequence(j, j+1))){
					bracket.add(Paren[j]);
					bracket_offset.add(j);
					clearParen[j] = (Paren[j]);
				}
				if(rightBracket.contains(seq.subSequence(j, j+1))){
				
					char stackedBracket = bracket.pop();
					int stackedOffset = bracket_offset.pop();
					
					int stackedLeft = leftBracket.indexOf(stackedBracket);
					int stackedRight = rightBracket.indexOf(Paren[j]);
				
					if(stackedLeft < stackedRight){
						clearParen[j] = rightBracket.charAt(stackedLeft);
					}
					else{
						clearParen[stackedOffset] = leftBracket.charAt(stackedRight);
						clearParen[j] = rightBracket.charAt(stackedRight);
					}
					
				}		
			}
			System.out.println(clearParen);
		}
	}

}
