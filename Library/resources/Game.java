package resources;

public class Game extends Resource {

    protected String gameType;

    public Game (String id, String title, String extra){
        this.id = id;
        this.title = title;
        this.gameType = extra;
    }

    public int getMaxLoanPeriod() {
        return GameType.get(gameType).getMaxLoanPeriod();
    }

    public double getSurcharge() {
        return GameType.get(gameType).getSurcharge();
    }

    public String getFormattedString() {
        return "Game - " + title + " for the " + gameType;
    }
}
