package dragoncurve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int times, generation;
		int main_start, end;
		
		times=in.nextInt();
		
	
		for (int j = 0; j < times; j++) {
			generation=in.nextInt();
			main_start=in.nextInt();
			end=in.nextInt();
						
			
			int start = main_start;
			int divide_3 = 1;
			int to_pm = 1;
			
			StringBuffer test_curve = new StringBuffer();

			for (int i = 0; i < end; i++) {

				if ((start % 3) != 0 && (to_pm == 1)) {
					if ((start % 6 == 1) || (start % 6 == 5)) {
						test_curve.append("F");
						//System.out.println(start);
					} else if (start % 6 == 2) {
						test_curve.append("X");
						//System.out.println(start);
					} else if (start % 6 == 4) {
						test_curve.append("Y");
						//System.out.println(start);

					}
				} else {
					if (divide_3 == 1) {
						start = start / 3;
						to_pm = 0;
					}
					if (start % 4 == 1) {
						test_curve.append("+");
						//System.out.println(start);
						to_pm = 1;
						divide_3 = 1;
					} else if (start % 4 == 3) {
						test_curve.append("-");
						//System.out.println(start);
						to_pm = 1;
						divide_3 = 1;
					} else if ((start & (start - 1)) == 0) {
						test_curve.append("+");
						//System.out.println(start);
						to_pm = 1;
						divide_3 = 1;
					} else {
						start = (start / 2);
						i--;
						divide_3 = 0;
						continue;
					}
				}
				start = ++main_start;
			}
			System.out.println(test_curve);
		}
	}
}