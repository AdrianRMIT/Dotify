package view;

//as this is the main class that will be handling inputs from the user, java.util.scanner is imported to scan keyboard inputs for user input.
import java.util.Scanner;
//controller is imported as the UI will need to communicate with the controller in order to run the program.
import controller.DotifyController;
//custom exception classes are imported in order for them to be accessed within the UI class.
import model.MissingDataException;
import model.NegativeNumException;

//class UI is started.
public class UI {
	// the scanner is simply declared as sc short for scanner for ease of access.
	private Scanner sc;
	// DotifyController is simply declared as controller for ease of access.
	private DotifyController controller;

	// the constructor is set up importing the controller as a parameter, this is
	// because it will use a lot of the methods from that class.
	public UI(DotifyController controller) {
		// controller variable is initialized with the a aforementioned controller
		// variable, this is to create a local and instanced controller.
		this.controller = controller;
		// the sc variable is initialized to be created from the Scanner system in order
		// to scan inputs.
		this.sc = new Scanner(System.in);
		// filename is created from the String data type as it can be anything the user
		// would want it to be, hence String is the most useful data type as it is not
		// restrictive like integers.
		String filename;
		// the afore mentioned filename will be initialized from an input from the user,
		// doing this allows the user to pick which ever file they want to use or
		// create, giving the program flexibility. getInput has a simple prompt for the
		// user so they know what to reply with.
		filename = getInput("Enter playlist file name\n");
		// whatever the user inputs, .csv is added so that it can be used with the
		// BufferedReader and Writer as appropriate filenames.
		filename = filename + ".csv";
		// try and catch is set up in order to call the readFromFile method in the
		// controller
		try {
			// controller is called with the readFromFile method which will simply send the
			// filename in order for the controller to
			// open and read any existing data if there are any. If this is not done then
			// the program would have not of had any sort of progression.
			this.controller.readFromFile(filename);
			// catch is set up to catch any errors that might have occurred while trying to
			// achieve the task of readingFromFile. If this is not done then a crash will be
			// experienced whenever the user inputs a csv that has not been created yet.
		} catch (Exception e) {
			// the exception would occur when he user inputs a csv that has not been created
			// yet. As such a simple message will explain the situation.
			System.out.println(
					filename + " was not found " + filename + " will be created when a content is added and saved\n");
		}
		// String intro is declared. intro being a simple name for the introduction
		// message for the program.
		String intro;
		// intro is initialized in parts in order for the output to be visualised in the
		// code.
		intro = "";
		intro += "=============================\n";
		intro += "Wecome to Dotify Audio Player\n";
		intro += "The BEST Audio Player in the World!\n";
		intro += "Wecome to Dotify Audio Player!!!!\n";
		intro += "=============================\n";
		// intro is printed once it has been completed.
		System.out.println(intro);
		// like intro, the menu is set up the same way, displaying all the options that
		// the user can chose from to run the program.
		String menu;
		menu = "";
		menu += "Please Select an Option:\n";
		menu += "[A]dd\n";
		menu += "[V]iew\n";
		menu += "[S]ave\n";
		menu += "E[x]it\n";
		// String choice is declared, choice being a descriptive name for the variable
		// that will contain the option the user has chosen.
		String choice;
		// choice is initialized with the getInput method, carrying the menu variable as
		// the prompt so the user will know how to respond. The menu could have been
		// manually printed before but would make code look less organized and getInput
		// will have less flexibility as a stand alone method.
		choice = getInput(menu);
		// while loop is created to create a looping menu system that will only
		// terminated when the user exits with inputting x. IgnoreCase is used from
		// here on out so that the user will be able to use capital variants of letters.
		// Not doing this simple thing can lead to problems when the program is running
		// as it will be less graceful.
		while (!choice.equalsIgnoreCase("x")) {
			// if statement that will activate when the input of choice is a or A.
			if (choice.equalsIgnoreCase("a")) {
				// simple user message to explain that they have chosen the add task function of
				// the program, not necessary but good so that the user has more feedback.
				System.out.println("Adding...");
				// contentOptions variable is declared as and is incrementally initialized with
				// another menu
				// describing the options the user can choose, hence why its called
				// contentOptions.
				String contentOptions;
				contentOptions = "";
				contentOptions += "What type of Content are you adding?\n";
				contentOptions += "[S]ong\n";
				contentOptions += "[A]lbum\n";
				contentOptions += "[M]usic Video\n";
				contentOptions += "[P]odcast\n";
				contentOptions += "[L]ecture\n";
				// like choice variable above, content choice will hold the option the user will
				// choose.
				String contentChoice;
				// a boolean is declared as validContentChoice so it can be used to verify if
				// a possible option was chosen. Another way to achieve this is using a while
				// loop that has an exit similar to the previous menu, however that is more
				// useful if the loop has an exit, this one does not.
				boolean validContentChoice;
				// as explained above.
				contentChoice = getInput(contentOptions);
				// as explained above.
				validContentChoice = false;
				// as explained above the validContentChoice while loop is used to verify that
				// the user chooses a valid option, otherwise it will loop as the boolean value
				// continues to be false.
				while (!validContentChoice) {
					// as with the menu above
					if (contentChoice.equalsIgnoreCase("s")) {
						System.out.println("Adding a Song...");
						// validContentChoice switches to true as explained above so the while loop will
						// terminate
						validContentChoice = true;
						// addSongViaMenu() method is called. ViaMenu is added to the name as it is a
						// local variable access through the menu. It is not necessary but it is better
						// to limit code clutter.
						addSongViaMenu();

						// as with the menu above
					} else if (contentChoice.equalsIgnoreCase("a")) {
						System.out.println("Adding an Album...");
						// as with the menu option above
						validContentChoice = true;
						// an integer value is set up as a counter for the while loop.
						int i = 0;
						// numberOfTracks that the user will want to add will be the maximum value for
						// the counter in the while loop. This ensures that the user will enter the
						// exact amount of objects as they want.
						int numOfTracks;
						// numOfTracks is easily obtained via getIntInput, similar to getInput except it
						// verifies that the input is an integer
						// instead of a string. This avoids crashing the program as int data types need
						// to have a integer, this can also be avoided by using try and catch but this
						// way is less elegant as we would need to try and catch every time we need to
						// use Integer.parseInt() method.
						numOfTracks = getIntInput("Enter Number of Tracks (cannot be under 0): ");
						// as stated above numOfTracks will be the limit of the while loop, hence a
						// while loop is set to ensure the numOfTracks value is above 0, otherwise it
						// will loop.
						while (numOfTracks < 1) {
							numOfTracks = getIntInput("Enter Number of Tracks (cannot be under 0): ");
						}
						// as mentioned above.
						while (i < numOfTracks) {
							// the addSongViaMenu() is called again to gather the needed data to create how
							// ever many items the user wanted to.
							addSongViaMenu();
							// the counter is incremented to avoid an infinite loop.
							i++;
						}
						// as with the option above.
					} else if (contentChoice.equalsIgnoreCase("m")) {
						System.out.println("Adding a Music Video...");
						// as explained above.
						validContentChoice = true;
						// addMusicVideoViaMenu() is similar to the method addSongViaMenu(), but with
						// different prompts to create a MusicVideo object.
						addMusicVideoViaMenu();
						// as with above.
					} else if (contentChoice.equalsIgnoreCase("p")) {
						System.out.println("Adding a Podcast...");
						// as with above.
						validContentChoice = true;
						// addPodcastViaMenu() is similar to the method addSongViaMenu(), but with
						// different prompts to create a Podcast object.
						addPodcastViaMenu();
						// as with above.
					} else if (contentChoice.equalsIgnoreCase("l")) {
						System.out.println("Adding a Lecture...");
						// as with above.
						validContentChoice = true;
						// addLectureViaMenu() is similar to the method addSongViaMenu(), but with
						// different prompts to create a Lecture object.
						addLectureViaMenu();

					} else {
						// simple output message, working with the while loop, creating a
						// infinite loop until a useful input is entered by the user.
						System.out.println("Please choose a valid option...");
						// as stated above.
						contentChoice = getInput(contentOptions);
					}
				}
				// similar to the if statement above except this one will trigger when the user
				// enters V.
			} else if (choice.equalsIgnoreCase("v")) {
				// as with the option above.
				System.out.println("Viewing...");
				// the viewPlaylist() method is used from the controller class, because we don't
				// need to get a special or specific variable from the playlist it is used
				// inside a println function (the default to String will do the rest of the
				// work).
				System.out.println(this.controller.viewPlaylist());
				// like above.
			} else if (choice.equalsIgnoreCase("s")) {
				System.out.println("Saving to file...");
				// try and catch is used similar to the situation in the start of the class.
				try {
					// writeToFile from the controller is called carrying the variable of filename
					// so we can use the appropriate filename.
					this.controller.writeToFile(filename);
					// exception similar the start of the code's situation.
				} catch (Exception e) {
					// any errors is recorded inside the message variable and is printed out with
					// the getMessage() from the exception class to provide more clarity.
					String message = "Error " + e.getMessage() + "\n";
					System.out.println(message);
				}
				// simple output message, working with the while loop, creating a
				// infinite loop until a useful input is entered by the user.
			} else {
				System.out.println("Sorry that was not an option");
			}
			// another instance of choice invoking the getInput method to continue the while
			// loop and thereby continue the program until x is inputted by the user.
			choice = getInput(menu);
		}
		// String Exit is declared as a temporary container variable for the exit
		// message.
		String exit;
		// like menu and intro the message is incremented so it can be visualised in the
		// code better.
		exit = "";
		exit += "=======================================\n";
		exit += "Thank you for using Dotify Audio Player\n";
		exit += "=======================================\n";
		// exit is printed when it is completed.
		System.out.println(exit);
	}

	// private is used in this case instead of public as the method does not need to
	// be accessed by any other method in the code outside of this class. This will
	// trigger via the Menu hence the name.
	private void addLectureViaMenu() {
		// essentially the method gathers the required data needed to create an object.
		// Topic, lecture and institution are all strings hence why they use getInput.
		String topic = getInput("Enter Lecture Topic: ");
		String lecture = getInput("Enter Lecturer: ");
		String institution = getInput("Enter Institution: ");
		// length is similar to above but uses getDoubleInput as the method so it can
		// gather the length data, it is a double as time can be in decimals.
		double length = getDoubleInput("Enter Length: ");
		// try and except is used to avoid potential errors and to exercise creating
		// new custom exceptions.
		try {
			// addLecture from the controller is called and carries all the gathered data.
			this.controller.addLecture(topic, lecture, institution, length);
			// missingDataException is caught if there is a problem with the aforementioned
			// data.
		} catch (MissingDataException e) {
			// like the error messages in the catch statement in the beginning of the code.
			String message = "Error " + e.getMessage() + "\n";
			System.out.println(message);
			// NegativeNumException is caught if there is a problem with the aforementioned
			// data, specifically to do with the int or length values. This, unlike the
			// above custom exception, this one can be accessed if the user enters negative
			// int or double. This could have been completely avoided using methods like
			// verifying with boolean that will be shown in the next few methods or a while
			// loop verification with compound statement. This is however not done so the
			// exception can be viewed and accessed.
		} catch (NegativeNumException e) {
			// like the error messages in the catch statement in the beginning of the code.
			String message = "Error " + e.getMessage() + "\n";
			System.out.println(message);
		}

	}

	// addPodcastViaMenu() is very similar to the above method except this one
	// gathers information needed to create a Podcast object.
	private void addPodcastViaMenu() {
		// like above
		String title = getInput("Enter Podcast Title: ");
		// like above
		String host = getInput("Enter Host: ");
		// like above
		double length = getDoubleInput("Enter Length: ");
		// like above, except it uses the getIntInput to directly get a int value.
		// numOfEpisodes is used as the variable to denote the total number of available
		// episodes.
		int numOfEpisodes = getIntInput("Enter Total Number of Available Episodes: ");
		// like above int variable except this one contains the number of the current
		// episode, hence why it is called episodeNum.
		int episodeNum = getIntInput("Enter Episode Number: ");
		// while loop is created to ensure that the current episode is within the limits
		// of the total episodes.
		while (numOfEpisodes < episodeNum) {
			// like stated above, the while loop will continuously ask the user to enter a
			// correct value, it also changes to prompt so the user will get some extra
			// help.
			episodeNum = getIntInput(
					"Episode Number must be under the Total Number of Available Episodes\nEnter Episode Number: ");
		}
		// as with the method above.
		try {
			// addPodcast() method is called from the controller that carries all the
			// gathered data.
			this.controller.addPodcast(title, host, length, numOfEpisodes, episodeNum);
		} catch (MissingDataException e) {
			String message = "Error " + e.getMessage() + "\n";
			System.out.println(message);
		} catch (NegativeNumException e) {
			String message = "Error " + e.getMessage() + "\n";
			System.out.println(message);
		}
	}

	// similar to the above options addMusicVideoViaMenu() is a method that is
	// created to gather the data needed to create MusicVideo.
	private void addMusicVideoViaMenu() {
		// same type of code as above methods.
		String title = getInput("Enter MV Title: ");
		String artist = getInput("Enter Artist: ");
		String director = getInput("Enter Director or Production House: ");
		// same type of code as above methods.
		double length = getDoubleInput("Enter Length (Minutes.Seconds): ");
		// boolean HD is declared, denoting the "quality of the music video".
		boolean HD;
		// HD is initialized as temporarily false as the return value will need it to be
		// initialized.
		HD = false;
		// HDInput is created as a temporary container for the input Y or N.
		String HDInput;
		// as with the method below (getIntInput/getDoubleInput), checkBol is used a
		// switch to terminate the while loop.
		boolean checkBol = false;
		// as stated above while loop is created with checkBol to verify the users
		// input. If it does not meet requirements it will be repeated indefinitely.
		while (checkBol == false) {
			// simple input statement using getInput.
			HDInput = getInput("Get HD Version? (Y/N)");
			// an if statement that will switch the boolean values HD to true and also to
			// terminate the while loop.
			if (HDInput.equalsIgnoreCase("y")) {
				HD = true;
				checkBol = true;
				// same as the above the if statement, except this option will get HD variable
				// to be false.
			} else if (HDInput.equalsIgnoreCase("n")) {
				HD = false;
				checkBol = true;
			}
		}
		// try and catch, same as the above methods.
		try {
			// addMusicVideo is used from the controller to carry the obtained data into a
			// method which will create a MusicVideo object.
			this.controller.addMusicVideo(title, artist, director, length, HD);
		} catch (NegativeNumException e) {
			String message = "Error " + e.getMessage() + "\n";
			System.out.println(message);
		} catch (MissingDataException e) {
			String message = "Error " + e.getMessage() + "\n";
			System.out.println(message);
		}

	}

	// Similar to the above methods.
	private void addSongViaMenu() {
		// same as the above methods.
		String title = getInput("Enter Title: ");
		String artist = getInput("Enter Artist: ");
		// same as the above methods
		double length = getDoubleInput("Enter Length (Minutes.Seconds): ");
		// same as the above methods.
		int userRating = getIntInput("Enter User Rating (1-5): ");
		// a simple while loop with a compound statement to ensure the value is between
		// 1-5, otherwise it will loop infinitely.
		while (userRating < 1 || userRating > 5) {
			// as stated above, the userRating will need to be 1-5 otherwise the prompt
			// repeats.
			userRating = getIntInput("Enter User Rating (1-5): ");
		}
		// try and except same as the above methods.
		try {
			// same as the above methods, this one has its own method that will create a
			// Song object.
			this.controller.addSong(title, artist, length, userRating);
		} catch (MissingDataException e) {
			String message = "Error " + e.getMessage() + "\n";
			System.out.println(message);
		} catch (NegativeNumException e) {
			String message = "Error " + e.getMessage() + "\n";
			System.out.println(message);
		}
	}

	// private is used in this case instead of public as the method does not need to
	// be accessed by any other method in the code outside of this class. A string
	// prompt is used as a parameter so the method will be more flexible.
	private String getInput(String prompt) {
		// the prompt is printed so the user will know what to input.
		System.out.println(prompt);
		// String input is declared, input being a suitable name for the variable that
		// contains the users input. the input is initialized using the scanner called
		// sc nextline method. strip is also used to get rid of extra information that
		// is not used.
		String input = this.sc.nextLine().strip();
		// a while loop is created to make sure that the code will infinitely ask the
		// user to input something, otherwise it will ask again as long the input is
		// blank.
		while (input.isBlank()) {
			// a simple message to tell the user that the input is blank.
			System.out.println("Input cannot be Blank");
			// prompt is again printed so the user will know what to put in.
			System.out.println(prompt);
			// like above, input gets its data from the scanner.
			input = this.sc.nextLine().strip();
		}
		// after a suitable response ie. not blank is inputted it is returned to the
		// calling variable.
		return input;
	}

	// similar to getInput, this method gets a Int, it also uses a prompt parameter
	// so it too can be flexible.
	private int getIntInput(String prompt) {
		// like the previous method, String input is declared, input being a suitable
		// name for the variable that
		// contains the users input. This input is initialized by invoking the getInput
		// method. This works as it is a String.
		String input = getInput(prompt);
		// a boolean is set up called checkInt and is set to false, this is to be used
		// with the verification process.
		boolean checkInt = false;
		// int verifiedInt is declared and is temporarily set to 0 so the return
		// function will work. verifiedInt is a descriptive name for the variable that
		// will be certified or verified as an Int by the method.
		int verifiedInt = 0;
		// a while loop is used for the verification process and will loop infinitely as
		// long as checkInt is false.
		while (checkInt == false) {
			// try is used in this case to avoid crashing the program if the input variable
			// cannot be transformed into an Int.
			try {
				// the verifiedInt initializes when the input is transformed into an int.
				verifiedInt = Integer.parseInt(input);
				// if the above line is successful then checkInt becomes true, ending the
				// potentially infinite loop.
				checkInt = true;
				// catch to complete the try and catch function. triggers when try fails or
				// essentially when the input variable cannot be transformed into an int.
			} catch (Exception e) {
				// input is again initialized and sends a new prompt to the user. As this is in
				// a while loop it will keep happening unless an appropriate int is inputed and
				// converted into verifiedInt variable.
				input = getInput("Input has to be a whole Number");
			}
		}
		// the verifiedInt is returned, if there was no check process it could crash the
		// program.
		return verifiedInt;
	}

	// essentially the same code as getIntInput except this is used as a stand alone
	// method because it gathers Double variables.
	private double getDoubleInput(String prompt) {
		String input = getInput(prompt);
		boolean checkDouble = false;
		double verifiedDouble = 0;
		while (checkDouble == false) {
			try {
				verifiedDouble = Double.parseDouble(input);
				checkDouble = true;
			} catch (Exception e) {
				input = getInput("Input has to be a Number, can have decimals");
			}
		}
		return verifiedDouble;
	}

}
