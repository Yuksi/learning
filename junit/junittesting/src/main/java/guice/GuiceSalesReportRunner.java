package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceSalesReportRunner {
	
	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.err.println("You must provide a commandLine argument specifying the file to analize");
			System.exit(-1);
		}
		
		CsvSalesRepozitory repo = new CsvSalesRepozitory(args[0]);
		repo.setError(System.err);
		
		Injector injector = Guice.createInjector(new SalesModule(args[0]));
		SalesReport report = injector.getInstance(SalesReport.class);
		report.report();
	}

}
