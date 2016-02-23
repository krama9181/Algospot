package weeklycalendar;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int times;
		times = in.nextInt();
		
		for(int i = 0; i < times ; i++){
			int month, date;
			String day;
			month = in.nextInt();
			date = in.nextInt();
			day = in.next();
			
			int[] calendar = new int[7];
			calendar = calcuratCalendar(month, date, day);
		
			System.out.println(calendar[0] +" " +calendar[1]+" " +calendar[2]+" " +calendar[3]+" " +calendar[4]+" "+ calendar[5]+" "+ calendar[6] );
			
		}
	}
	static int[] calcuratCalendar (int month, int date, String day){
		int []LittleCalendar = new int[7];
		
		int[] month_31 = {1,3,5,7,8,10,12};
		int[] month_30 = {4,6,9,11};
		int month_29 = 2;
		
		int startDate = 0;
		int beforeMonthTotalDate = 0;
		int nowMonthTotalDate = 0;
		
		for(int i =0; i < month_31.length; i++ ){
			if(month_31[i] == month){
				nowMonthTotalDate = 31;
				beforeMonthTotalDate = 30;
				break;
			}
		}
		
		for(int i =0; i < month_30.length; i++ ){
			if(month_30[i] == month){
				nowMonthTotalDate = 30;
				beforeMonthTotalDate = 31;
				break;
			}
		}
			
		if (month_29 == month){
			nowMonthTotalDate = 28;
			beforeMonthTotalDate = 31;
		}
		
		if(month == 1  || month == 8){
			beforeMonthTotalDate = 31;
		}
		if(month == 3){
			beforeMonthTotalDate = 28;
		}
		
		//System.out.println(beforeMonthTotalDate +"-" + nowMonthTotalDate);
		
		
		if(day.equals("Monday")){
			startDate = date - 1;
		}
		else if(day.equals("Tuesday")){
			startDate = date - 2;
		}	
		else if(day.equals("Wednesday")){
			startDate = date - 3;	
		}
		else if(day.equals("Thursday")){
				startDate = date - 4;
		}
		else if(day.equals("Friday")){
				startDate = date - 5;
		}
		else if(day.equals("Saturday")){		
			startDate = date - 6;	
		}
		else{
			startDate = date;
		}
		
		if(startDate <= 0){
			startDate = startDate + beforeMonthTotalDate;
		}
		
		day = "Sunday";
		int calMonth;
				
		if(date <15){
			calMonth = beforeMonthTotalDate;
		}
		else{
			calMonth = nowMonthTotalDate;
		}
		
		if(day.equals("Sunday")){
			LittleCalendar[0] = startDate;
			startDate = startDate + 1;
			if(startDate > calMonth){
				startDate = 1;
			}
			LittleCalendar[1] = startDate;
			startDate = startDate + 1;
			if(startDate > calMonth){
				startDate = 1;
			}
			LittleCalendar[2] = startDate;
			startDate = startDate + 1;
			if(startDate > calMonth){
				startDate = 1;
			}
			LittleCalendar[3] = startDate;

			startDate = startDate + 1;
			if(startDate > calMonth){
				startDate = 1;
			}
			LittleCalendar[4] = startDate;

			startDate = startDate + 1;
			if(startDate > calMonth){
				startDate = 1;
			}
			LittleCalendar[5] = startDate;

			startDate = startDate + 1;
			if(startDate > calMonth){
				startDate = 1;
			}
			LittleCalendar[6] = startDate;
		}
		
	
		return LittleCalendar;
	}
}
