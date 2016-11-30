package testing2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeapYearTest {

	//a year is a leap year if it is devisible by 4
	//but years, divisible by 100, are not leap years
	//except years divisible by 400
	
	@Test
	public void leapYearsAreDivisibleByFour() {
		assertTrue(LeapYear.isLeapYear(2016));
	}
	
	@Test
	public void normalYearsAreNotDivisibleByFour() {
		assertFalse(LeapYear.isLeapYear(2015));
	}
	
	@Test
	public void leapYearsAreNotDivisibleByOneHundred() {
		assertFalse(LeapYear.isLeapYear(1900));
	}
	
	@Test
	public void leapYearsAreDivisibleByFourHundred() {
		assertTrue(LeapYear.isLeapYear(800));
	}
}
