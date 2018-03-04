package library;
import java.util.*;

import loans.*;

import subscribers.*;
import resources.*;

public class LibraryServices {
	
	public LibraryServices() {
	}

	public void loanResourceToSubscriber(Resource resource, Subscribers subscriber, GregorianCalendar gregorianCalendar) throws Exception {
		LoanExtent.INSTANCE.createLoan(resource, subscriber, gregorianCalendar);
	}
	public void returnedResource(Loan loan, GregorianCalendar gregorianCalendar) {
		if ( loan != null ) {
			loan.setReturnDate(gregorianCalendar);
		}
	}

}
