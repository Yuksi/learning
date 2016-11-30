package springtesting;

import java.io.PrintStream;

import springtesting.SalesReport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLSalesReportRunner {
	
	private static String fileLocation;

public static void main(String[] args) {
		
		if (args.length < 1) {
			System.err.println("You must provide a commandLine argument specifying the file to analize");
			System.exit(-1);
		}
		
		fileLocation = args[0];
		
		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("springtesting/application-context.xml");
		
		SalesReport report = xmlContext.getBean(SalesReport.class);
		report.report();
		xmlContext.close();
	}

	public static PrintStream getOutput() {
		return System.out;
	}
	
	public static String getFileLocation() {
		return fileLocation;
	}
}
