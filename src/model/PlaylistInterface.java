package model;

// the PlaylistInterface is created as an interface that is implemented by both the music and the talkshows classes. It is primarily used as a reference for the arrays, so it can be used polymorphically.
public interface PlaylistInterface {
	// an abstract method is used in this class so that it can be used in all of the
	// subclasses that stem from talkshows and music. getCsvString() is a good
	// method to do obtain a string message that gathers all the information from
	// each class to write to a csv, hence the name. getCsv could also be explicitly
	// written in each class that implements this method but has not been done so
	// code duplication will be slightly less
	public abstract String getCsvString();

}
