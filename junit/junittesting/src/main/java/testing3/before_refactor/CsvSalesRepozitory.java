package testing3.before_refactor;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CsvSalesRepozitory implements SalesRepository {

	private final String fileLocation;
	private PrintStream error;
	private List<Sale> sales;

	public CsvSalesRepozitory(String fileLocation) {
		this.fileLocation = fileLocation;
		this.error = System.out;
	}
	
	public void setError(PrintStream error) {
		this.error = error;
	}
	
	private int parseInt(String value) {
		return Integer.parseInt(value.trim());
	}

	public List<Sale> loadSales() {
		if (sales == null) {
			sales = new ArrayList<>();
			try (CSVReader reader = new CSVReader(new FileReader(fileLocation))) {
				String[] nextLine;
				while ((nextLine = reader.readNext()) != null){
					String product = nextLine[0].trim();
					String store = nextLine[1].trim();
					int number = parseInt(nextLine[2]);
					int pricePerItem = parseInt(nextLine[3]);
					sales.add(new Sale(product, store, number, pricePerItem));
				}
				return sales;
			} catch (IOException e) {
				e.printStackTrace(error);
				return null;
			}
		}
		return sales;
	}

}
