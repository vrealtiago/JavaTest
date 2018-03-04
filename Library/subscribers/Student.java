package subscribers;

import reporting.OutputServiceContributor;

public class Student extends Subscribers{
	public String institution;
	
	
	public Student(String id, String name, String institution) {
		super.id = id;
		super.name = name;
		this.institution = institution;
		super.maxBorrowing = 6;
	}
	
	public String getFormattedString() {
		return "Student: " + super.name + " - " + institution;
	}
}
