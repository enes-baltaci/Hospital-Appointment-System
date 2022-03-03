package Login_Scr;

import java.util.Calendar;
import java.util.TimeZone;

public class Date {
	
	static Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	
	int[] days()
	{
		int day[] = new int[30];
		int currentDay = calendar.get(Calendar.DATE);
		
		for (int i = 0; i < day.length; i++) {
			day[i] = currentDay++;
			if (currentDay > 30) currentDay = 1;
		}		
		return day;
	}
	
	int[] months()
	{		
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		
		if (days()[0] != 1) {	
			int month[] = new int[2];
			
			month[0] = currentMonth++;
			
			if (currentMonth > 12) currentMonth = 1;
			
			month[1] = currentMonth;
			return month;			
		}
		else
		{
			int month[] = new int[1];
			month[0] = currentMonth;
			return month;
		}
	}
	
	int year()
	{
		return calendar.get(Calendar.YEAR);
	}
}