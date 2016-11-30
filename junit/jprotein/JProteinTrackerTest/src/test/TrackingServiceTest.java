package test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import test.BadTestCategory;
import test.GoodTestCategory;
import tracker.InvalidGoalException;
import tracker.TrackingService;

public class TrackingServiceTest {
	
	private TrackingService service;

	@BeforeClass
	public static void before() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void after() {
		System.out.println("AfterClass");
	}
	
	@Before
	public void setUp() 
	{
		System.out.println("Before");
		service = new TrackingService();
	}
	
	@After
	public void tearDown() {
		System.out.println("After");
	}
	
	@Test
	@Category({GoodTestCategory.class, BadTestCategory.class})
	public void newTrackingServiceTotalIsZero() 
	{
		assertEquals("Tracking Service Total was not zero", 0, service.getTotal());
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void whenAddingProteinTotalIncreasisByThatAmount() 
	{
		service.addProtein(10);
		
		assertEquals("Protein amount was not correct", 10, service.getTotal());
		assertThat(service.getTotal(), is(10));
		
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void whenRemovingProteinTotalRemainsZero() 
	{
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void whenGoalSetToLessThenZeroExceptionIsThrown() throws InvalidGoalException 
	{
		thrown.expect(InvalidGoalException.class);
		thrown.expectMessage(JUnitMatchers.containsString("Goal was less then Zero"));
		service.setGoal(-5);
	}
	
	@Rule
	public Timeout timeout = new Timeout(200);
	
	@Test
	public void badTest() 
	{
		for (int i = 0; i < 10000000; i++) 
			service.addProtein(1);
	}

}
