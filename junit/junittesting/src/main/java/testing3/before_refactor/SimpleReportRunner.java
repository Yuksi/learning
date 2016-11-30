package testing3.before_refactor;

public class SimpleReportRunner {
	
	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.err.println("You must provide a commandLine argument specifying the file to analize");
			System.exit(-1);
		}
		
		CsvSalesRepozitory repo = new CsvSalesRepozitory(args[0]);
		repo.setError(System.err);
		
		SalesAnalysisService analyser = new SalesAnalysisService(repo);
		SalesReport report = new SalesReport(System.out, analyser);
		report.report();
	}

}
