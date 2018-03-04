package subscribers;
import reporting.OutputServiceContributor;

public class Pensioner extends Subscribers implements OutputServiceContributor {
	
	public Pensioner(String id, String name) {
		super.id = id;
		super.name = name;
		super.maxBorrowing = 3;
	}
	
	public String getFormattedString() {
		return "Pensioner: " + super.name;
	}
}
