package resources;

import exceptions.ResourceLoanException;
import reporting.OutputServiceContributor;
import loans.*;

public abstract class Resource implements OutputServiceContributor {

	protected String id;
	protected String title;

	public Loan loan;

	public String getId() {
		return id;
	}

	public void addLoad(Loan loan) throws ResourceLoanException {
		if ( this.loan != null ) {
			throw new ResourceLoanException("This resource is already on loan: "+this.loan.getFormattedString());
		}
		this.loan = loan;
	}
	public void removeLoan() {
		loan = null;
	}

	public Loan getLoan() {
		return loan;
	}

	public abstract int getMaxLoanPeriod();

	public abstract double getSurcharge();
}
