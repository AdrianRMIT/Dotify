package controller;

//java io BufferedReader, Writer, FileReader and Writer are all imported so they can be used with loading and saving to .csv files.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//custom exceptions are imported so that they can be accessed.
import model.MissingDataException;
import model.NegativeNumException;
import model.PlaylistInterface;
//model.PlaylistManager is imported as it is the class that manages the Task Objects which the program manipulates.
import model.PlaylistManager;
//view.UI is imported so that the controller can manage the User Inputs and returns the relevant functions based on those inputs. In a way, the controller acts as a bridge for the entire program.
import view.UI;

//the class is started in this line, it is called DotifyController as it is the controller class for the program called Dotify. As stated above the controller acts as a bridge for the entire program.
public class DotifyController {
	// a PlaylistManager object is declared as model. Model is given to the
	// PlaylistManager
	// in accordance to the MVC Pattern. This model is
	// made private so that it can be accessed by following methods
	// within this class as an instance.
	private PlaylistManager model;
	// like the line above UI class object is declared as view. Simply put view is
	// the name given to the user interface in accordance to the MVC Pattern. This
	// view is also made private so that it can be accessed by following methods
	// within this class as an instance.
	private UI view;

	// Constructor is created to initialize the variables declared above.
	public DotifyController() {
		// this.model is initialized and creates a new object of the PlaylistManager
		// class
		// so that those methods inside that class can be accessed and used.
		// PlaylistManager interface is an easy reference
		// using tools and methods relating to the
		// managing of the music and talkshow objects as they are separate entities that
		// do not fit together.
		this.model = new PlaylistManager();
		// similar to above this.view is also initialized as UI as UI is an easy name to
		// call upon when using tools and methods relating to user interface.
		this.view = new UI(this);
	}

	// This method is created to bridge the UI to the Playlist Manager class. It
	// requires the parameters of title, artist, length, userRating in order to
	// complete a song object. It also throws potential exceptions that might arise
	// from the PlaylistManager class.
	public void addSong(String title, String artist, double length, int userRating)
			throws MissingDataException, NegativeNumException {
		// as stated above this method bridges the UI and the model, addSong is accessed
		// to tell the model to create an object using the parameters gathered in the
		// UI.
		this.model.addSong(title, artist, length, userRating);
	}

	// main is created.
	public static void main(String[] args) {
		// DotifyController is created as an object declared as dc for
		// short based on the DotifyController class. This initializes the entire
		// program.
		DotifyController dc = new DotifyController();
	}

	// same as the addSong method except this one creates asks the model to create a
	// MusicVideo object using its unique parameters.
	public void addMusicVideo(String title, String artist, String director, double length, boolean HD)
			throws NegativeNumException, MissingDataException {
		this.model.addMusicVideo(title, artist, director, length, HD);

	}

	// same as the addSong method except this one creates asks the model to create a
	// Podcast object using its unique parameters.
	public void addPodcast(String title, String host, double length, int numOfEpisodes, int episodeNum)
			throws MissingDataException, NegativeNumException {
		this.model.addPodcast(title, host, length, numOfEpisodes, episodeNum);

	}

	// same as the addSong method except this one creates asks the model to create a
	// Lecture object using its unique parameters.
	public void addLecture(String topic, String lecture, String institution, double length)
			throws MissingDataException, NegativeNumException {
		this.model.addLecture(topic, lecture, institution, length);

	}

	// viewPlaylist is created as a method in this class to assist the UI class
	// access the PlaylistManager class. This is done in accordance to the MVC
	// Pattern.
	public String viewPlaylist() {
		// this method simply returns the string that is received from the
		// PlaylistManager class.
		return this.model.viewPlaylist();

	}

	// readFromFile receives a filename variable as a parameter so it knows which
	// csv to read from. Alternatively could have used a hardcoded and explicit name
	// for the csv but that would mean the program will have no flexibility in
	// creating new csv files. It throws exception to the UI as the UI's job is to
	// handle all the user interaction.
	public void readFromFile(String filename) throws Exception {
		// BufferedReader is declared as fileObj, a simple name for an object related to
		// files. fileObj is initialized from the inbuilt and imported BufferedReader
		// class and is using the FileReader sending the parameter of the aforementioned
		// filename variable.
		BufferedReader fileObj = new BufferedReader(new FileReader(filename));
		// a string is declared as line as it is a simple term to refer to.
		String line;
		// line is initialized by running the fileObj's readLine() method.
		line = fileObj.readLine();
		// a while loop is created to loop through the contents of the csv file and read
		// every line. There is no efficient alternative to this outside of other style
		// loop systems like for loops, re writing line = fileObj.readLine(); every time
		// a line needs to be read is redundant and also does not allow the program to
		// stop when the csv is finished unless we know how many lines there are in the
		// program. This particular while loop will end when it encounters a line that
		// is no longer occupied and hence is null.
		while (line != null) {
			// String[] fields is declared as a temporary variable that will store the
			// information that will be split into fields. Split is used on the line
			// variable so the data can be separated into their own sections.
			String[] fields = line.split(",");
			// String objType gets its data from the first field in the csv line, this
			// denotes the type of object the following fields are for.
			String objType = fields[0];
			// if the first objType equals a song this statement triggers, allowing the
			// reader to know what data to send to the appropriate method. If there was no
			// verification different data will be sent to the wrong methods causing issues
			// with the array and the entire program.
			if (objType.equalsIgnoreCase("Song")) {
				// String declared title gets its data from fields[1] and so on.
				String title = fields[1];
				String artist = fields[2];
				// double length uses Double.parseDouble to convert the String into the
				// appropriate usable data type.
				double length = Double.parseDouble(fields[3]);
				// same as above but using Interger.parseInt.
				int userRating = Integer.parseInt(fields[4]);
				// addSong method is invoked so that the data obtained by the readline while
				// loop combo is sent to the PlaylistManager to create an object within an
				// array.
				this.model.addSong(title, artist, length, userRating);
				// statement is same as above except for MusicVideo data and invokes the
				// addMusicVideo method.
			} else if (objType.equalsIgnoreCase("MusicVideo")) {
				String title = fields[1];
				String artist = fields[2];
				double length = Double.parseDouble(fields[3]);
				String director = fields[4];
				boolean HD = Boolean.parseBoolean(fields[5]);
				this.model.addMusicVideo(title, artist, director, length, HD);
				// functionally similar to the above statements except for the Podcast objects.
			} else if (objType.equalsIgnoreCase("Podcast")) {
				String title = fields[1];
				String host = fields[2];
				double length = Double.parseDouble(fields[3]);
				int episodeNum = Integer.parseInt(fields[4]);
				int numOfEpisodes = Integer.parseInt(fields[5]);
				this.model.addPodcast(title, host, length, numOfEpisodes, episodeNum);
				// functionally similar to the above statements except for the Lecture objects.
			} else if (objType.equalsIgnoreCase("Lecture")) {
				String topic = fields[1];
				String lecturer = fields[2];
				double length = Double.parseDouble(fields[3]);
				String institution = fields[4];
				this.model.addLecture(topic, lecturer, institution, length);
			}
			// fileObj.readLine(); is invoked again so that the loop can keep proceeding
			// unless it is already reached its end. Like stated above there are no other
			// efficient means to read data like this method.
			line = fileObj.readLine();
		}
		// fileObj is closed to release memory because it is no longer needed, also
		// considered good practice to avoid any potential errors.
		fileObj.close();
	}

	// writeToFile is similar to the method above. This method writes and saves the
	// data instead of reads from a file. Like the above method this also requires
	// the parameter of filename so that it can save to an appropriate csv, allowing
	// the program to be more flexible than the alternative of having a hardcoded
	// and explicit name for a csv. Like its above counter part it also throws an
	// exception if something were to potentially go wrong.
	public void writeToFile(String filename) throws Exception {
		// BufferedWriter is declared fileObj as it is an easy variable name for the
		// object that will relate to the file. It is initialized to be created from the
		// BufferedWritter inbuilt in java. FileWriter is also used and the
		// aforementioned filname is used.
		BufferedWriter fileObj = new BufferedWriter(new FileWriter(filename));
		// Summary variable is declared as a String, getting its contents from using the
		// getCsvString method in the model section of the program.
		String summary = this.model.getCsvString();
		// fileObj now writes the data received from the model section of the program
		// into the the csv file in a preformatted style fit for csv's, given by
		// getCsvString() abstract method in the PlaylistManger interface.
		fileObj.write(summary);
		// fileObj is closed like its counterpart in the method above.
		fileObj.close();
	}
}
