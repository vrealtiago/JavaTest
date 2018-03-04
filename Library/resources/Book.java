package resources;

public class Book extends Resource {

    private String author;

    public Book (String id, String title, String extra){
        this.id = id;
        this.title = title;
        this.author = extra;
    }

    public int getMaxLoanPeriod() {
        return 28;
    }

    public double getSurcharge() {
        return 0;
    }

    public String getFormattedString() {
            return "Book - " + title + " by " + author;
    }

}
