package springtesting;

import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.*;

@Component
public class SalesAnalysisService {
	
	private final SalesRepository repo;

	@Autowired
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
