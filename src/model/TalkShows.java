package model;

//abstract TalkShows Class is created and implements the PlaylistInterface.
public abstract class TalkShows implements PlaylistInterface {
	// double length is created as a private variable as
	// it needs to be instanced to be accessed by subclasses and methods. It is also
	// common amongst the subclasses that stem from this class.
	private double length;
	// constructor is created to get the parameter to create a object of
	// this type.
	TalkShows(double length) {
		// length variable get localized.
		this.length = length;
	}
	// an abstract method toString is used,
	// Although it could have been its own method with partial String data and can
	// be accessed
	// by the subclasses it is more useful to have it as abstract so the formatting
	// of the strings can be done in each subclass with more ease.
	public abstract String toString();
	
	//simple accessor method to be used by the subclasses, to obtain specifically the length.
	public double getLength() {
		return this.length;
	}
}
