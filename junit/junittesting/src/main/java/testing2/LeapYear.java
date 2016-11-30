package testing2;

public class LeapYear {

	public static boolean isLeapYear(final int year) {
		return isDevisible(year, 4) && !isDevisible(year,100) || isDevisible(year,400);
	}
	
	public static boolean isDevisible(final int year, final int denominator){
		return year % denominator == 0;
	}
}
