package xhaeneung;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int times = in.nextInt();

		for (int i = 0; i < times; i++) {
			String[] array = new String[5];
			for (int j = 0; j < 5; j++) {
				array[j] = in.next();
			}

			int A_num = 0, B_num = 0, result = 0;

			switch (array[0]) {
			case "one":	A_num = 1;
				break;
			case "two":	A_num = 2;
				break;
			case "three":	A_num = 3;
			break;
			case "four":
				A_num = 4;
				break;
			case "five":
				A_num = 5;
				break;
			case "six":
				A_num = 6;
				break;
			case "seven":
				A_num = 7;
				break;
			case "eight":
				A_num = 8;
				break;
			case "nine":
				A_num = 9;
				break;
			case "zero":
				A_num = 0;
				break;
			case "ten":
				A_num = 10;
				break;
			}

			switch (array[2]) {
			case "one":
				B_num = 1;
				break;
			case "two":
				B_num = 2;
				break;
			case "three":
				B_num = 3;
				break;
			case "four":
				B_num = 4;
				break;
			case "five":
				B_num = 5;
				break;
			case "six":
				B_num = 6;
				break;
			case "seven":
				B_num = 7;
				break;
			case "eight":
				B_num = 8;
				break;
			case "nine":
				B_num = 9;
				break;
			case "zero":
				B_num = 0;
				break;
			case "ten":
				B_num = 10;
				break;
			}

			if (array[1].equals("+")) {
				result = A_num + B_num;
			} else if (array[1].equals("-")) {
				result = A_num - B_num;
			} else if (array[1].equals("*")) {
				result = A_num * B_num;
			}
			//System.out.println(A_num + "," + B_num + "="+result);

			String result_s = "";

			switch (result) {
			case 1:
				result_s = "one";
				break;
			case 2:
				result_s = "two";
				break;
			case 3:
				result_s = "three";
				break;
			case 4:
				result_s = "four";
				break;
			case 5:
				result_s = "five";
				break;
			case 6:
				result_s = "six";
				break;
			case 7:
				result_s = "seven";
				break;
			case 8:
				result_s = "eight";
				break;
			case 9:
				result_s = "nine";
				break;
			case 0:
				result_s = "zero";
				break;
			case 10:
				result_s = "ten";
				break;
			}

			/////////////////  string of result  ////////////////////
			String str = result_s;
			String[] arr = str.split("");

			Arrays.sort(arr, new Comparator<String>() {
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			str = Arrays.toString(arr);
			str = str.substring(1, str.length() - 1);
			str = str.replaceAll(", ", "");

			/////////////////  string of input  /////////////////////

			String str_in = array[4];
			String[] arr_in = str_in.split("");

			Arrays.sort(arr_in, new Comparator<String>() {
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			str_in = Arrays.toString(arr_in);
			str_in = str_in.substring(1, str_in.length() - 1);
			str_in = str_in.replaceAll(", ", "");

			if (str_in.equals(str)) {
				if (result >= 0 && result <= 10) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}			
			}
			else{
				System.out.println("No");
			}
		}
	}

}

