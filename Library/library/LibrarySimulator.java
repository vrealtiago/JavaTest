package library;

import java.util.GregorianCalendar;

import exceptions.BorrowingException;
import exceptions.ResourceLoanException;
import reporting.ConsoleOutputService;
import reporting.FileOutputService;
import resources.Resource;
import resources.ResourceExtent;
import subscribers.SubscriberExtent;
import subscribers.Subscribers;

public class LibrarySimulator {
	LibraryServices library;
	LibraryReportingService reporting;

	public LibrarySimulator() {
		library = new LibraryServices();
		reporting = new LibraryReportingService();
		reporting.addOutputService(new ConsoleOutputService());
		reporting.addOutputService(new FileOutputService());
	}
	
	public static void main(String[] args) {
		LibrarySimulator librarySimulator = new LibrarySimulator();
		librarySimulator.runSimulator();
	}
	
	public void runReports() {
		reporting.outputResourcesReport();
		reporting.outputSubscribersReport();
		reporting.outputOutstandingLoansReport();
	}

	public void runSimulator() {
		reporting.outputOutstandingLoansReport();

		Resource resource = ResourceExtent.INSTANCE.findByPrimaryKey("R1");
		Subscribers subscriber = SubscriberExtent.INSTANCE.findByPrimaryKey("S1");

		try {
			library.loanResourceToSubscriber(resource, subscriber, new GregorianCalendar(2004, 00, 20));
		}
		catch(BorrowingException be) {
			System.out.println("Error - Max Limit");
		}
		catch(ResourceLoanException rle) {
			System.out.println("Error - Resource can not be loaned");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		reporting.outputOutstandingLoansReport();

		library.returnedResource(resource.getLoan(), new GregorianCalendar(2004, 00, 20));
		
		reporting.outputOutstandingLoansReport();

		try {
			library.loanResourceToSubscriber(resource, subscriber, new GregorianCalendar(2004, 00, 20));
		}
		catch(BorrowingException be) {
			System.out.println("Error - Max Limit");
		}
		catch(ResourceLoanException rle) {
			System.out.println("Error - Resource can not be loaned");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		reporting.outputOutstandingLoansReport();
	}
}
