package model;
//NegativeNumException is created as a custom exception that will trigger when negative numbers are found. It extends the default exception class
public class NegativeNumException extends Exception {
	// Constructor is created which holds a String message.
	NegativeNumException(String message) {
		// message is taken from the super class which is the original in built
		// exception class.
		super(message);
	}
}

