package model;

//MissingDataException is created as a custom exception that will trigger when Missing Data is found. It extends the default exception class
public class MissingDataException extends Exception {
	// Constructor is created which holds a String message.
	MissingDataException(String message) {
		// message is taken from the super class which is the original in built
		// exception class.
		super(message);
	}
}
