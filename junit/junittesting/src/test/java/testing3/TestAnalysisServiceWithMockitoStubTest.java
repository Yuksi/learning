package testing3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;

import testing3.after_refactor.Sale;
import testing3.after_refactor.SalesAnalysisService;
import testing3.after_refactor.SalesRepository;

public class TestAnalysisServiceWithMockitoStubTest {
	
	private static final List<Sale> exampleSales = Arrays.asList(
			new Sale("Apples", "Cardiff", 10, 2),
			new Sale("Oranges", "Cardiff", 3, 5),
			new Sale("Bananas", "Cardiff", 6, 20),
			new Sale("Oranges", "London", 5, 7)
	);
	
	private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
	
	static {
		expectedStoreSales.put("Cardiff", 155);
		expectedStoreSales.put("London", 35);
	}
	
	@Test
	public void shouldAggregateStoreSales() {
		//given
		SalesRepository stubrepo = Mockito.mock(SalesRepository.class);
		Mockito.when(stubrepo.loadSales()).thenReturn(exampleSales);
		
		SalesAnalysisService analizer = new SalesAnalysisService(stubrepo);
		//when
		Map<String, Integer> storeSales = analizer.tallyStoreSales();
		//then
		assertEquals(expectedStoreSales, storeSales);
	}

}
