package guice;

import java.util.Map;
import java.util.function.Function;

import com.google.inject.Inject;

import static java.util.stream.Collectors.*;

public class SalesAnalysisService {
	
	private final SalesRepository repo;

	@Inject
	public SalesAnalysisService(SalesRepository repo) {
		this.repo = repo;
	}

	public Map<String, Integer> tallyStoreSales() {
		return tallySalesBy(Sale::getStore);
	}

	public Map<String, Integer> tallyProductSales() {
		return tallySalesBy(Sale::getProduct);
	}
	
	private Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
		return repo.loadSales()
				.stream()
				.collect(groupingBy(classifier,
						summingInt(Sale::getValue)));
	}

}
