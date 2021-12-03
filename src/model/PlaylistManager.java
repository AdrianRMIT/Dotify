package model;

//PlaylistManager class is started
public class PlaylistManager {
	// private instance variables are created. playlist array is made up of the
	// different media objects
	// in order for the program to store multiple objects like a library.
	private PlaylistInterface[] playlist;
	// playlistCounter is essential for keeping track of how many tasks are in the
	// array.
	private int playlistCounter;

	// constructor method is created to initialize the afore mentioned variables.
	public PlaylistManager() {
		// playlist is initialized as an array with 2 spaces or elements. 2 being a low
		// number to verify if the upcoming expansion method works as it should.
		this.playlist = new PlaylistInterface[2];
		// playlistCounter is initialized as 0 as there are not yet any objects that
		// have
		// been added to the array.
		this.playlistCounter = 0;
	}

	// addSong carries the parameters of the title, artist, length, and userRating
	// into the method, allowing it to create new Song objects. Also throws any
	// found exceptions.
	public void addSong(String title, String artist, double length, int userRating)
			throws MissingDataException, NegativeNumException {
		// checkArrayExpansion() is used to verify if there is sufficient room to add
		// new content to the array, otherwise it will extend thereby avoiding a array
		// out of bounds exception.
		checkArrayExpansion();
		// the playlist array
		// with the current index given by the playlistCounter creates a new Song Object
		// with the aforementioned parameter variables.
		this.playlist[this.playlistCounter] = new Song(title, artist, length, userRating);
		// playlistCounter is incremented so it does not over write the previous indexes
		// and
		// also so that it can count and be used when the array is full. There are no
		// real effective alternatives to doing this as a non instanced counter won't be
		// able to track the number of objects created effectively.
		this.playlistCounter += 1;
	}

	// getCsvString is used to fetch the summary of each object polymporhically to
	// in a way that is formatted to be used with csv files.
	public String getCsvString() {
		// to achieve the statement above summary is created a temporary string variable
		// that is empty.
		String summary = "";
		// an int i is created as a temporary counter.
		int i = 0;
		// a while loop is set up to cycle through each element in the playlist array
		// that has been used (why we use playlistCounter instead of playlist.length)
		while (i < this.playlistCounter) {
			// summary is incremented like stated above using each objects unique
			// getCsvString() method polymorphically.
			summary += this.playlist[i].getCsvString() + "\n";
			// index is also incremented to achieve the above method.
			i += 1;
		}
		// once the while loop expires the completed summary is returned.
		return summary;
	}

	// checkArrayExpansion() is used to verify if there is sufficient room to add
	// new content to the array, otherwise it will extend thereby avoiding a array
	// out of bounds exception.
	private void checkArrayExpansion() {
		// a simple if statement to check whether there are more objects (known by the
		// playlistCounter) then there are space in the length of the array. this is
		// done in
		// order to expand the array automatically when it is full, other wise if this
		// is not done, the program will crash with an out of bounds error.
		if (this.playlistCounter == this.playlist.length) {
			// a temporary longerPlaylist variable is created, aptly named as it is a longer
			// version of the original.
			PlaylistInterface[] longerPlaylist;
			// longerPlaylist is initalized as an array of the playlist arrays length
			// multiplied by 2 so
			// there is more space for new content.
			longerPlaylist = new PlaylistInterface[this.playlist.length * 2];
			// a temporary counter called i is initialized as 0.
			int i = 0;
			// while loop is created to increment through the length of the original array
			// length, playlistCounter could have been used as well as they will be equal.
			while (i < this.playlist.length) {
				// each element of longerPlaylist is filled with the information in the same
				// element of the original array.
				longerPlaylist[i] = this.playlist[i];
				// i increments so every element will be copied.
				i += 1;
			}
			// the playlist variable will assume the identity of the new longerPlaylist,
			// done so
			// the rest of the program can call the same instance variable that scales when
			// needed.
			this.playlist = longerPlaylist;
		}

	}

	// this method is essentially the same as the addSong method but it uses the
	// parameters of a MusicVideo object to create one.
	public void addMusicVideo(String title, String artist, String director, double length, boolean HD)
			throws NegativeNumException, MissingDataException {
		checkArrayExpansion();
		this.playlist[this.playlistCounter] = new MusicVideo(title, artist, director, length, HD);
		this.playlistCounter += 1;

	}

	// this method is essentially the same as the addSong method but it uses the
	// parameters of a Podcast object to create one.
	public void addPodcast(String title, String presenter, double length, int numOfEpisodes, int episodeNum)
			throws MissingDataException, NegativeNumException {
		checkArrayExpansion();
		this.playlist[this.playlistCounter] = new Podcast(title, presenter, length, numOfEpisodes, episodeNum);
		this.playlistCounter += 1;
	}

	// this method is essentially the same as the addSong method but it uses the
	// parameters of a Lecture object to create one.
	public void addLecture(String topic, String lecture, String institution, double length)
			throws MissingDataException, NegativeNumException {
		checkArrayExpansion();
		this.playlist[this.playlistCounter] = new Lecture(topic, lecture, institution, length);
		this.playlistCounter += 1;
	}

	// method that gets the summary of the data from each object in the array.
	public String viewPlaylist() {
		// String summary is declared and is temporarily empty.
		String summary = "";
		// int is initialized as a local temporary counter to 0
		int i = 0;
		// int index is set to 1 to be used with the index in when the data is viewed,
		// could have also used the i variable with +1 but it could potentially cause
		// problems and this way is easier to manage.
		int index = 1;
		// the while loop is created in order to increment through the indexes of the
		// playlist array using the playlistCounter as the stop for the while loop as
		// there
		// are no more objects that exceeds the counter. If this was not done we will
		// get
		// information that is null or empty.
		while (i < this.playlistCounter) {
			// as stated above the index is used for formatting purposes.
			summary += index + ". ";
			// summary String is filled incrementally when the while loop increments through
			// the array. It uses the defualt (overriden) getString method in the class of
			// each of the objects to fetch the
			// information in a pre formatted way. +\n is used for the same reason. This
			// works polymorphically.
			summary += this.playlist[i] + "\n";
			// i is incremented to achieve the above method.
			i += 1;
			// index is also incremented to achieve the above method.
			index += 1;
		}
		// once the while loop expires the completed summary is returned.
		return summary;
	}

}
