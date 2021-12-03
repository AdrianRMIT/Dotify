package model;

// lecture is created as the one of the main objects that will be managed by the program, it extends TalkShows as it is the same style.
public class Lecture extends TalkShows {
	// topic, lecturer and institution are all declared as instance variables as
	// they will be accessed by the class' methods.
	private String topic;
	private String lecturer;
	private String institution;

	// lecture requires parameters in order to be initialized, like stated in the
	// comments above, topic, lecturer, institution and length are
	// all variables that this objects needs to be created. MissingDataException and
	// NegativeNumException are thrown here as the custom exception classes.
	Lecture(String topic, String lecturer, String institution, double length)
			throws MissingDataException, NegativeNumException {
		// length is the only derived variable from the super class of TalkShows. Hence
		// why super is used to obtain that variable.
		super(length);
		// all the variables are attached to their local, instanced variables so they
		// can be used by the other methods.
		this.topic = topic;
		this.lecturer = lecturer;
		this.institution = institution;
		// the if statement with the compound statement to trigger if there is missing
		// String variables.
		if (topic.isBlank() || lecturer.isBlank() || institution.isBlank()) {
			// a new custom MissingDataException is thrown with a statement to denote the
			// error.
			throw new MissingDataException("There was a problem creating media object, parameter data is missing");
		}
		// similar to above except with a much more straight forward statement simply
		// triggering when the length is less than 0.
		if (length <= 0) {
			// a new custom NegativeNumException is thrown with a statement to denote the
			// error.
			throw new NegativeNumException("Please Check Length Parameter if it is less than 0");
		}
	}

	@Override
	// getCsvString is a method used to format the variables in the class into a csv
	// style to be written.
	public String getCsvString() {
		// to achieve the statement above message is created a temporary string variable
		// that is empty.
		String message;
		// the message is incremented with data from topic and so forth followed by ,'s
		// so it is suitable for the csv format.
		message = "";
		// Lecture is added at the start of the string for sorting purposes explained in the readFromFile method in the controller.
		message += "Lecture,";
		message += this.topic + ",";
		message += this.lecturer + ",";
		// super is used to access the getLength() method, which will get the Length
		// value.
		message += super.getLength() + ",";
		message += this.institution + ",";
		// once the message string is fully realized it is returned.
		return message;
	}

	@Override
	// toString is used to format the data into a readable way as to be printed
	// within the program.
	public String toString() {
		// like stated above, string.format is used to organize the data in a neat manner.
		String message = String.format("%-15s Topic: %-20s Lecturer: %-20s Length: %-15.2f Institution: %s", "Lecture",
				this.topic, this.lecturer, super.getLength(), this.institution);
		// once the message string is fully realized it is returned.
		return message;
	}

}
