package model;

//Class is functionally similar to the sister subclass of MusicVideo. The only differences are the parameters and variables. It extends the music class as it shares some similarities with it including the variables of artist, title and length.
public class Song extends Music {
	// the variable of userRating is unique to Song so it is delcared as an int
	// within this class.
	private int userRating;

	// constructor is created that gathers the parameters needed to make a
	// Song Object. It also throws custom exceptions should they arise similar
	// to the other classes.
	Song(String title, String artist, double length, int userRating) throws MissingDataException, NegativeNumException {
		// as title, artist and length are declared in the super class they are taken
		// here via the super() method.
		super(title, artist, length);
		// userRating is initialized as a local variable as stated above.
		this.userRating = userRating;
		// like stated above, the exceptions will trigger when the requirements are met,
		// in this case then title or artist is blank.
		if (title.isBlank() || artist.isBlank()) {
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
	// toString is used to format the data into a readable way as to be printed
	// within the program.
	public String toString() {
		// like stated above, string.format is used to format the data in a neat manner.
		String message = String.format("%-15s Title: %-20s Artist: %-20s Length: %-15.2f User Rating: %d/5 Stars",
				"Song", super.getTitle(), super.getArtist(), super.getLength(), this.userRating);
		// once the message string is fully realized it is returned.
		return message;
	}

	@Override
	// getCsvString is a method used to format the variables in the class into a csv
	// style to be written.
	public String getCsvString() {
		// to achieve the statement above message is created a temporary string variable
		// that is empty
		String message;
		// the message is incremented with data from title and so forth followed by ,'s
		// so it is suitable for the csv format.
		message = "";
		// song is added at the start of the string for sorting purposes explained in the readFromFile method in the controller.
		message += "Song,";
		// super is used to access the getLength(), getTitle() and getArtist methods,
		// which will get those super class values
		message += super.getTitle() + ",";
		message += super.getArtist() + ",";
		message += super.getLength() + ",";
		message += this.userRating;
		// once the message string is fully realized it is returned.
		return message;
	}

}
