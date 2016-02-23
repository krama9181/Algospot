package endians;

import java.text.NumberFormat;
import java.util.Scanner;

import org.omg.CORBA.Request;

public class Main {

	public static <UnsignedLong> void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int times = in.nextInt();
		
		for(int i = 0; i < times ; i++){
			long input = in.nextLong();
	
			//System.out.println(Integer.toBinaryString(input));
			
			String binary = Long.toBinaryString(input);
						
			StringBuffer sb = new StringBuffer();
			
			if(binary.length() <= 32){
				for(int j = 0 ; j < 32-binary.length();j++){
					sb.append(0);
				}
				sb.append(binary);
			}
			//else if(binary.length())
		
			StringBuffer Lil_com = new StringBuffer();
			
			Lil_com.append(sb.substring(24,32));
			Lil_com.append(sb.substring(16,24));
			Lil_com.append(sb.substring(8,16));
			Lil_com.append(sb.substring(0,8));
			
			String Lil_temp = Lil_com.toString();

					
			
			long result = 0;
			
			for(int j=0 ; j < 32 ; j++){
				char charAt = Lil_temp.charAt(j);
				
				if(charAt=='1'){
					if(j==31){
						result = result + 1;
					}
					else{
						result = result + (squarter(31-j));					

					}
					
				}
				
			}
	
			NumberFormat nf = NumberFormat.getInstance(); //NumberFormat 객체 생성 
			nf.setGroupingUsed(false); //지수 표현 제거 
			String value = nf.format(result); //포맷에 맞춤 
			
			
			
			System.out.println(unsigned32(result)); 
			
			
		}
		
	}
	public static long squarter(int n){
		
		if(n==1){
			return 2;
		}
		else
			return 2*squarter(n-1);
	}
	
	public static long unsigned32(long result){
		return result & 0xFFFFFFFFL;
	}

}