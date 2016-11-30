package springtesting;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesReport {
	
	private final PrintStream output;
	private final SalesAnalysisService analyzer;
	
	@Autowired
	public SalesReport(PrintStream output, SalesAnalysisService analizer) {
		this.output = output;
		this.analyzer = analizer;
	}
	
	public void report() {
		output.printf("\n"+"Sales Report for %s"+"\n"+"%n", LocalDate.now());
		
		printTable("Store Sales", analyzer.tallyStoreSales());
		printTable("Product Sales", analyzer.tallyProductSales());
	}
	
	private void printTable(String title, Map<String, Integer> values) {
		output.printf("---------- %s ----------%n", title);
		printRow(title, "Value");
		values.forEach((key, value) -> printRow(key, ""+value));
		output.println();
		output.println();
	}

	private void printRow(String first, String second) {
		output.printf("- %-15s - %6.6s -%n", first, second);
	}

}
