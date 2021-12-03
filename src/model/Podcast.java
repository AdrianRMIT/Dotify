package model;

//lecture is created as the one of the main objects that will be managed by the program, it extends TalkShows as it is the same style.
public class Podcast extends TalkShows {
	// title, host, episodeNum and numOfEpisodes are all unique to Podcast hence why
	// they are declared as local instance variables within this class.
	private String title;
	private String host;
	private int episodeNum;
	private int numOfEpisodes;
	
	// Podcast requires parameters in order to be initialized, like stated in the
	// comments above, title, host, length, numOfEpisodes and episodeNum are
	// all variables that this objects needs to be created. MissingDataException and
	// NegativeNumException are thrown here as the custom exception classes.
	Podcast(String title, String host, double length, int numOfEpisodes, int episodeNum)
			throws MissingDataException, NegativeNumException {
		// length is the only derived variable from the super class of TalkShows. Hence
		// why super is used to obtain that variable.
		super(length);
		// all the variables are attached to their local, instanced variables so they
		// can be used by the other methods.
		this.title = title;
		this.host = host;
		this.episodeNum = episodeNum;
		this.numOfEpisodes = numOfEpisodes;
		// the if statement with the compound statement to trigger if there is missing
		// String variables.
		if (title.isBlank() || host.isBlank()) {
			// a new custom MissingDataException is thrown with a statement to denote the
			// error.
			throw new MissingDataException("There was a problem creating media object, parameter data is missing");
		}
		// similar to above except with a much more straight forward statement simply
		// triggering when the length is less than 0.
		if (length <= 0) {
			// a new custom NegativeNumException is thrown with a statement to denote the
			// error.
			throw new NegativeNumException("Please Check Length Parameter if it is 0 or less.");
		}
		// similar to above except with a much more straight forward statement simply
		// triggering when the numOfEpisodes or episodeNum is less than 0.
		if (numOfEpisodes <= 0 || episodeNum <= 0) {
			// a new custom NegativeNumException is thrown with a statement to denote the
			// error.
			throw new NegativeNumException("Please Check Int Parameter if it is less than 0");
		}
	}

	@Override
	// getCsvString is a method used to format the variables in the class into a csv
	// style to be written.
	public String getCsvString() {
		// to achieve the statement above message is created a temporary string variable
		// that is empty.
		String message;
		// the message is incremented with data from title and so forth followed by ,'s
		// so it is suitable for the csv format.
		message = "";
		// Podcast is added at the start of the string for sorting purposes explained in the readFromFile method in the controller.
		message += "Podcast,";
		message += this.title + ",";
		message += this.host + ",";
		// super is used to access the getLength() method, which will get the Length
		// value.
		message += super.getLength() + ",";
		message += this.episodeNum + ",";
		message += this.numOfEpisodes + ",";
		// once the message string is fully realized it is returned.
		return message;
	}

	@Override
	// toString is used to format the data into a readable way as to be printed
	// within the program.
	public String toString() {
		// like stated above, string.format is used to organize the data in a neat manner.
		String message = String.format("%-15s Title: %-20s Hosted by: %-20s Length: %-15.2f Episode: %d/%d", "Podcast",
				this.title, this.host, super.getLength(), this.episodeNum, this.numOfEpisodes);
		// once the message string is fully realized it is returned.
		return message;
	}

}
