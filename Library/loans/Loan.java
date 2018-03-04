package loans;

import java.util.*;

import resources.*;
import reporting.OutputServiceContributor;
import subscribers.*;

public class Loan implements OutputServiceContributor {
    private Resource resource;
    private Subscribers subscriber;

    private GregorianCalendar loanDate;
    private GregorianCalendar returnDate;

    private String id;

    public static int idCounter = 0;

    public Loan() {
        this.id = "L" + idCounter++;
    }

    public String getId() {
        return id;
    }

    public String getFormattedString() {
        StringBuilder formattedString = new StringBuilder(resource == null ? "Unknown" : resource.getFormattedString());

        formattedString.append(" loaned to ");

        if (subscriber == null) {
            formattedString.append("Nobody");
        }

        formattedString.append(subscriber.getFormattedString());

        return formattedString.toString();
    }

    public GregorianCalendar getReturnDate() {
        return returnDate;
    }

    void setId(String id) {
        this.id = id;
    }

    public void setReturnDate(GregorianCalendar returnDate) {
        if (this.returnDate != null)
            throw new IllegalStateException("Return date has already been assigned");

        subscriber.removeLoan(this);
        resource.removeLoan();
        this.returnDate = returnDate;
    }

    public void setLoanDate(GregorianCalendar loanDate) {
        this.loanDate = loanDate;
    }

    public void setResource(Resource resource) { this.resource = resource; }

    public void setSubscriber(Subscribers subscriber) { this.subscriber = subscriber; }
}
