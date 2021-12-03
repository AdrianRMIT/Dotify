package model;

// abstract Music Class is created and implements the PlaylistInterface.
public abstract class Music implements PlaylistInterface {
	// String title, artist and double length are created as private variables as
	// they need to be instanced to be accessed by subclasses and methods. they are also common amongst the subclasses that stem from this class.
	private String title;
	private String artist;
	private double length;

	// constructor is created to get all the needed parameters to create a object of
	// this type.
	Music(String title, String artist, double length) {
		// variables get localized.
		this.title = title;
		this.artist = artist;
		this.length = length;
	}

	// an abstract method toString is used,
	// Although it could have been its own method with partial String data and can
	// be accessed
	// by the subclasses it is more useful to have it as abstract so the formatting
	// of the strings can be done in each subclass with more ease.
	public abstract String toString();
	
	//simple accessor methods to be used by the subclasses, to obtain specifically the title.
	public String getTitle() {
		return this.title;
	}
	//simple accessor methods to be used by the subclasses, to obtain specifically the artist.
	public String getArtist() {
		return this.artist;
	}
	//simple accessor methods to be used by the subclasses, to obtain specifically the length.
	public double getLength() {
		return this.length;
	}
}
