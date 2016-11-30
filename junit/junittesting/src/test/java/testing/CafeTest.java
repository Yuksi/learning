package testing;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

public class CafeTest {
	public static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
	private static final int NO_MILK = 0;
	private static final int NO_BEANS = 0;
	
	private Cafe cafe;
	
	@Before
	public void before() {
		cafe = new Cafe();
	}
	
	@Test
	public void canBrewEspresso() {
		//given
		withBeans();
		//when
		Coffee coffee = cafe.brew(CoffeeType.Espresso);
		//then
		assertThat(coffee, hasProperty("beans", equalTo(ESPRESSO_BEANS)));
		
		
		assertEquals("Wrong number of milk", NO_MILK, coffee.getMilk());
		assertEquals("Wrong coffeType", CoffeeType.Espresso, coffee.getCoffeeType());
	}
	
	@Test
	public void brewingEspressoConsumesBeans() {
		//given
		withBeans();
		//when
		Coffee coffee = cafe.brew(CoffeeType.Espresso);
		//then
		assertEquals(NO_BEANS, cafe.getBeansInStock());
		
	}
	
	@Test
	public void canBrewLatte() {
		//given
		withBeans();
		cafe.restockMilk(CoffeeType.Latte.getRequiredMilk());
		//when
		Coffee coffee = cafe.brew(CoffeeType.Latte);
		//then
		assertEquals("Wrong coffeType", CoffeeType.Latte, coffee.getCoffeeType());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void mustRestockMilk() {
		//when
		cafe.restockMilk(NO_MILK);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void mustRestockBeans() {
		//when
		cafe.restockBeans(NO_BEANS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void lattesRequiresMilk() {
		//given
		withBeans();
		//when
		cafe.brew(CoffeeType.Latte);
	}

	private void withBeans() {
		cafe.restockBeans(ESPRESSO_BEANS);
	}
}
