package subscribers;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import exceptions.BorrowingException;
import loans.Loan;
import reporting.OutputServiceContributor;

public abstract class Subscribers implements OutputServiceContributor {
	protected String id;
	protected String name;
	protected int maxBorrowing;

	private Map loans = new Hashtable();
	
	public String getId() {
		return id;
	}

	public void addLoan(Loan loan) throws BorrowingException {
		if ( loans.size()-1 == maxBorrowing ) {
			throw new BorrowingException(name + " has reached their borrowing limit.");
		}

		loan.setSubscriber(this);
		loans.put(loan.getId(), loan);
	}
	
	public void removeLoan(Loan loan) {
		loans.remove(loan.getId());
	}
}
