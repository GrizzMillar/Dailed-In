package golfIreland;

import java.io.File;

import menu.ViewChallenges;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import actors.golfer;
import attributes.club;
import golfIreland.GameState;

import menu.StartMenu;
import menu.ViewBagMenu;
import menu.ViewRoundMenu;

import menus.input.ConfirmChoiceMenu;
import menus.input.DoubleMenu;
import menus.input.IntMenu;


import menu.LoadMenu;

import menus.input.Menu;
import menus.input.NumMenu;
import menus.input.SelectOptionMenu;
import menus.input.StringMenu;
import pointsSystem.challenge;
import round.recordHole;
import round.recordShot;
import round.round;
import statistics.golferStatistics.golferStats;
import menu.ViewRoundsMenu;

//TODO LIST

//Fix up and down error
//Fix numbers on menu when selecting clubs (0 counts as club for some reason)
//Fix club stats
//Create bbrobot account for testing all features
//Initialise bbrobot at each sign in with 3 rounds and 12 clubs
//Cross check stats 
//Create bbrobot with sign and save all rounds/clubs then test that stats are correct after sign in

public class application {

	private static GameState gameState;

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		StartMenu start = new StartMenu();
		if (start.getHasQuit()) {
			return;
		}

		gameState = start.getGameState();
		gameState.setChallenges(1, 2, 3);

		if (gameState != null)
			golferMenu();

	}

	public static void applicationTester(golfer tester) {

		round test = new round("Port", 71, "Whites", 1, "07/12/2022");

		recordShot test1 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot test2 = new recordShot(2, 200, "7Iron", 20, "Semi-Rough");
		recordShot test3 = new recordShot(3, 20, "Lob Wedge", 2, "Green");
		recordShot test4 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole = new recordHole(1, 400, 4);

		testHole.addShots(test1);
		testHole.addShots(test2);
		testHole.addShots(test3);
		testHole.addShots(test4);

		test.addHoles(testHole);

		recordShot test5 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot test6 = new recordShot(2, 200, "7Iron", 20, "Green");
		recordShot test7 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot test8 = new recordShot(4, 2, "Putter", 0, "Hole");

		recordHole testHole1 = new recordHole(1, 400, 4);

		testHole1.addShots(test5);
		testHole1.addShots(test6);
		testHole1.addShots(test7);
		testHole1.addShots(test8);

		test.addHoles(testHole1);

		recordShot test9 = new recordShot(1, 400, "Driver", 40, "Green");
		recordShot test10 = new recordShot(2, 40, "Putter", 20, "Green");
		recordShot test11 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot test12 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole2 = new recordHole(1, 400, 5);

		testHole2.addShots(test9);
		testHole2.addShots(test10);
		testHole2.addShots(test11);
		testHole2.addShots(test12);

		test.addHoles(testHole2);

		recordShot test13 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot test14 = new recordShot(2, 200, "7Iron", 20, "Semi-Rough");
		recordShot test15 = new recordShot(3, 20, "Lob Wedge", 5, "Green");
		recordShot test16 = new recordShot(4, 5, "Putter", 1, "Green");
		recordShot test99 = new recordShot(5, 5, "Putter", 0, "Hole");

		recordHole testHole3 = new recordHole(1, 400, 4);

		testHole3.addShots(test13);
		testHole3.addShots(test14);
		testHole3.addShots(test15);
		testHole3.addShots(test16);
		testHole3.addShots(test99);

		test.addHoles(testHole3);

		round testround2 = new round("Port", 71, "Whites", 1, "07/12/2022");

		recordShot testshot1 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot testshot2 = new recordShot(2, 200, "7Iron", 20, "Semi-Rough");
		recordShot testshot3 = new recordShot(3, 20, "Lob Wedge", 2, "Green");
		recordShot testshot4 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole4 = new recordHole(1, 400, 4);

		testHole4.addShots(testshot1);
		testHole4.addShots(testshot2);
		testHole4.addShots(testshot3);
		testHole4.addShots(testshot4);

		testround2.addHoles(testHole4);

		recordShot testshot5 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot testshot6 = new recordShot(2, 200, "7Iron", 20, "Semi-Rough");
		recordShot testshot7 = new recordShot(3, 20, "Lob Wedge", 2, "Green");
		recordShot testshot8 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole5 = new recordHole(1, 400, 4);

		testHole5.addShots(testshot5);
		testHole5.addShots(testshot6);
		testHole5.addShots(testshot7);
		testHole5.addShots(testshot8);

		testround2.addHoles(testHole5);

		recordShot testshot9 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot testshot10 = new recordShot(2, 200, "7Iron", 20, "Green");
		recordShot testshot11 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot testshot12 = new recordShot(4, 2, "Putter", 0, "Hole");

		recordHole testHole6 = new recordHole(1, 400, 5);

		testHole6.addShots(testshot9);
		testHole6.addShots(testshot10);
		testHole6.addShots(testshot11);
		testHole6.addShots(testshot12);

		testround2.addHoles(testHole6);

		recordShot testshot13 = new recordShot(1, 400, "Driver", 200, "Green");
		recordShot testshot14 = new recordShot(2, 60, "Putter", 20, "Green");
		recordShot testshot15 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot testshot16 = new recordShot(4, 2, "Putter", 0, "Hole");

		recordHole testHole7 = new recordHole(1, 400, 4);

		testHole7.addShots(testshot13);
		testHole7.addShots(testshot14);
		testHole7.addShots(testshot15);
		testHole7.addShots(testshot16);

		testround2.addHoles(testHole7);

		tester.addPlayerRound(test);
		tester.addPlayerRound(testround2);

		test.initStats();
		testround2.initStats();

		tester.getStats().initialiseStats(test.getRoundStats());
		tester.getStats().initialiseStats(testround2.getRoundStats());
	}

	public static void golferMenu() throws FileNotFoundException, IOException, ParseException {

		boolean isFinished = false;
		int choice;

		SelectOptionMenu normalPlayMenu = new SelectOptionMenu("What would you like to do?");
		// Options to be presented to a player each turn
		LinkedList<String> options = new LinkedList<>();
		// Options that can be displayed to the user
		final String startRound = "Start Round";
		final String enterScore = "Enter Score";
		final String viewBag = "View Bag";
		final String viewScores = "See previous scores";
		final String viewRounds = "See previous rounds";
		final String viewOtherPlayers = "View other players";
		final String viewProfile = "View profile";
		final String logOut = "Log out";

		// setting the initial player for the first turn
		golfer currentPlayer = gameState.getCurrentGolfer();
		
		club test1 = new club("Putter", "AP3", "Titliest");
		currentPlayer.addClub(test1);


		// repeatedly shows normal turn menu until game is ended
		while (!isFinished) {

			// resets the options each loop
			options.clear();
			options.add(startRound);
			options.add(enterScore);
			options.add(viewBag);
			options.add(viewScores);
			options.add(viewRounds);
			options.add(viewOtherPlayers);
			options.add(viewProfile);
			options.add(logOut);

			// updates options in menu and gets user selection
			normalPlayMenu.updateOptions(options.toArray(new String[0]), false);
			choice = normalPlayMenu.getUserInput() - 1;

			// Selects user choice
			switch (options.get(choice)) {

			case startRound -> {
				//enterRound();
				applicationTester(currentPlayer);
			}
			case enterScore -> {
				enterScore();
			}

			case viewBag -> {
				SelectOptionMenu bag = new SelectOptionMenu("What would you like to do?");
				LinkedList<String> option = new LinkedList<>();
				boolean finished = false;
				int input;

				final String goback = "Back";
				final String viewbag = "View Bag";
				final String addClub = "Add a club";

				while (!finished) {

					option.clear();
					option.add(goback);
					option.add(viewbag);
					option.add(addClub);

					bag.updateOptions(option.toArray(new String[0]), false);
					input = bag.getUserInput() - 1;

					switch (option.get(input)) {

					case goback -> {
						finished = true;
					}

					case viewbag -> new ViewBagMenu(currentPlayer);

					case addClub -> {
						addClub(currentPlayer);

					}

					}

				}

			}

			// Displays a list of the player's owned companies
			case viewScores -> new ViewRoundsMenu(currentPlayer);

			case viewRounds -> new ViewRoundMenu(currentPlayer);

			case viewOtherPlayers -> {

				LoadMenu load = new LoadMenu("golfers", true);
				golfer view = load.loadOtherGolfer();
				viewPlayer(view);

			}

			case viewProfile -> {
				playerProfile(currentPlayer);

				SelectOptionMenu stats = new SelectOptionMenu("Profile Options");
				LinkedList<String> option = new LinkedList<>();
				boolean finished = false;
				int input;

				final String goback = "Back";
				final String viewStats = "View Stats";
				final String viewChallenges = "Career Challenges";

				while (!finished) {

					option.clear();
					option.add(goback);
					option.add(viewStats);
					option.add(viewChallenges);

					stats.updateOptions(option.toArray(new String[0]), true);
					input = stats.getUserInput();

					switch (option.get(input)) {

					case goback -> {
						finished = true;
					}

					case viewStats -> {
						LinkedList<String> categories = new LinkedList<>();
						final String back = "<--Back";
						final String putting = "Putting";
						final String scoring = "Scoring";
						categories.add(back);
						categories.add(putting);
						categories.add(scoring);

						SelectOptionMenu pickStat = new SelectOptionMenu("Pick a statistics category",
								categories.toArray(new String[0]), true);

						boolean hasfinished = false;
						while (!hasfinished) {

							switch (categories.get(pickStat.getUserInput()).trim()) {

							case back -> {
								hasfinished = true;
								break;
							}

							case putting -> {
								System.out.println(currentPlayer.getStats().getPuttingStats());
								break;
							}

							case scoring -> {
								System.out.println(currentPlayer.getStats().getScoringStats());
								break;
							}

							}
						}

					}

					case viewChallenges -> {
						LinkedList<String> challenges = new LinkedList<>();
						final String bck = "<--Back";
						final String chal = "Challenges";
						final String completedchal = "Completed Challenges";

						SelectOptionMenu pickChal = new SelectOptionMenu("Pick a Challenges category");
						int num;

						boolean hasfinished = false;
						while (!hasfinished) {

							challenges.clear();
							challenges.add(bck);
							challenges.add(chal);
							challenges.add(completedchal);

							pickChal.updateOptions(challenges.toArray(new String[0]), true);
							num = pickChal.getUserInput();

							switch (challenges.get(num)) {

							case bck -> {
								hasfinished = true;
								break;
							}

							case chal -> {
								System.out.println(currentPlayer.getChallenges().getScoringChallenges());
								break;
							}

							case completedchal -> {
								System.out.println(currentPlayer.getChallenges().getCompletedScoringChallenges());
								break;
							}

							}

						}
					}

					}

				}
			}


			case logOut -> {

				isFinished = true;
				System.out.println("Goodbye");
				break;

			}
			}

		}

	}

	public static void viewPlayer(golfer player) {

		boolean isFinished = false;
		int choice;

		SelectOptionMenu normalPlayMenu = new SelectOptionMenu("What would you like to do?");
		// Options to be presented to a player each turn
		LinkedList<String> options = new LinkedList<>();
		// Options that can be displayed to the user
		final String back = "Back";
		final String viewProfile = "View profile";
		final String viewBag = "View Bag";
		final String viewScores = "See previous scores";
		final String viewRounds = "See previous rounds";
		final String viewFriends = "View friends";

		// repeatedly shows normal turn menu until game is ended
		while (!isFinished) {

			// resets the options each loop
			options.clear();

			options.add(back);
			options.add(viewProfile);
			options.add(viewBag);
			options.add(viewScores);
			options.add(viewRounds);
			options.add(viewFriends);

			// updates options in menu and gets user selection
			normalPlayMenu.updateOptions(options.toArray(new String[0]), true);
			choice = normalPlayMenu.getUserInput() - 1;

			// Selects user choice
			switch (options.get(choice)) {

			case back -> {
				isFinished = true;
			}
			case viewProfile -> {
				playerProfile(player);

				SelectOptionMenu stats = new SelectOptionMenu("Profile Options");
				LinkedList<String> option = new LinkedList<>();
				boolean finished = false;
				int input;

				final String goback = "Back";
				final String viewStats = "View Stats";
				final String viewChallenges = "View Challenges";

				while (!finished) {

					option.clear();
					option.add(goback);
					option.add(viewStats);
					option.add(viewChallenges);

					stats.updateOptions(option.toArray(new String[0]), true);
					input = stats.getUserInput();

					switch (option.get(input)) {

					case goback -> {
						finished = true;
					}

					case viewStats -> {
						LinkedList<String> categories = new LinkedList<>();
						final String bck = "<--Back";
						final String putting = "Putting";
						final String scoring = "Scoring";

						SelectOptionMenu pickStat = new SelectOptionMenu("Pick a statistics category");
						int num;

						boolean hasfinished = false;
						while (!hasfinished) {

							categories.clear();
							categories.add(bck);
							categories.add(putting);
							categories.add(scoring);

							pickStat.updateOptions(categories.toArray(new String[0]), true);
							num = pickStat.getUserInput();

							switch (categories.get(num)) {

							case bck -> {
								hasfinished = true;
								break;
							}

							case putting -> {
								System.out.println(player.getStats().getPuttingStats());
								break;
							}

							case scoring -> {
								System.out.println(player.getStats().getScoringStats());
								break;
							}

							}

						}

					}

					case viewChallenges -> {
						System.out.println("Hello");

					}


					}

				}

			}

			case viewBag -> new ViewBagMenu(player);

			case viewScores -> new ViewRoundsMenu(player);

			case viewRounds -> new ViewRoundMenu(player);

			case viewFriends -> {
				System.out.println("To be implemented");
			}

			}

		}
	}

	public static void playerProfile(golfer player) {

		System.out.println(player.toString());
		System.out.println(gameState.getDailyChallenges().getChallenges());
	}

	public static void enterScore() {

		StringMenu name = new StringMenu("Please enter the name of the course", false);
		String course = name.getUserInput();
		StringMenu date = new StringMenu("Please enter the date of the round", false);
		String roundDate = date.getUserInput();
		playerRound round = new playerRound(course, roundDate);
		round.setName();

		IntMenu hole1 = new IntMenu("Hole 1", 0, 25);
		int h1 = hole1.getUserInput();
		IntMenu hole2 = new IntMenu("Hole 2", 1, 25);
		int h2 = hole2.getUserInput();
		IntMenu hole3 = new IntMenu("Hole 3", 1, 25);
		int h3 = hole3.getUserInput();
		IntMenu hole4 = new IntMenu("Hole 4", 1, 25);
		int h4 = hole4.getUserInput();
		IntMenu hole5 = new IntMenu("Hole 5", 1, 25);
		int h5 = hole5.getUserInput();
		IntMenu hole6 = new IntMenu("Hole 6", 1, 25);
		int h6 = hole6.getUserInput();
		IntMenu hole7 = new IntMenu("Hole 7", 1, 25);
		int h7 = hole7.getUserInput();
		IntMenu hole8 = new IntMenu("Hole 8", 1, 25);
		int h8 = hole8.getUserInput();
		IntMenu hole9 = new IntMenu("Hole 9", 1, 25);
		int h9 = hole9.getUserInput();
		IntMenu hole10 = new IntMenu("Hole 10", 1, 25);
		int h10 = hole10.getUserInput();
		IntMenu hole11 = new IntMenu("Hole 11", 1, 25);
		int h11 = hole11.getUserInput();
		IntMenu hole12 = new IntMenu("Hole 12", 1, 25);
		int h12 = hole12.getUserInput();
		IntMenu hole13 = new IntMenu("Hole 13", 1, 25);
		int h13 = hole13.getUserInput();
		IntMenu hole14 = new IntMenu("Hole 14", 1, 25);
		int h14 = hole14.getUserInput();
		IntMenu hole15 = new IntMenu("Hole 15", 1, 25);
		int h15 = hole15.getUserInput();
		IntMenu hole16 = new IntMenu("Hole 16", 1, 25);
		int h16 = hole16.getUserInput();
		IntMenu hole17 = new IntMenu("Hole 17", 1, 25);
		int h17 = hole17.getUserInput();
		IntMenu hole18 = new IntMenu("Hole 18", 1, 25);
		int h18 = hole18.getUserInput();

		addScores(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18);


		round.addScores(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18);

		gameState.getCurrentGolfer().addRound(round);

	}

	public static void enterRound() {

		StringMenu name = new StringMenu("Please enter the name of the course", false);
		String course = name.getUserInput();
		IntMenu par = new IntMenu("Please enter the par of the course", 50, 80);
		int pr = par.getUserInput();
		StringMenu tee = new StringMenu("What tees will you be playing from?", false);
		String t = tee.getUserInput();
		IntMenu num = new IntMenu("How many holes will you be playing?", 1, 18);
		int nm = num.getUserInput();
		StringMenu date = new StringMenu("Please enter the date of the round", false);
		String roundDate = date.getUserInput();
		round round = new round(course, pr, t, nm, roundDate);
		round.setName();

		round.fillRound(gameState.getCurrentGolfer());

		System.out.println("Youre Score was " + round.returnScore());
		System.out.println("Youre Net Score was " + round.returnNetScore());
		System.out.println(round.roundSummary());
		checkChallenges(gameState.getCurrentGolfer(), gameState.getCurrentGolfer().getStats());
		System.out.println("Prestige: " + gameState.getCurrentGolfer().getPrestige().getNumber());
		System.out.println("Level: " + gameState.getCurrentGolfer().getPrestige().getLevel());
		System.out.println("Points: " + gameState.getCurrentGolfer().getPrestige().getPoints());

		gameState.getCurrentGolfer().addPlayerRound(round);
		saveround(round, gameState.getCurrentGolfer().getFullName());

	}

	public static void saveround(round round, String filename) {

		// Create a JSON array to hold hole data
		JSONArray holesArray = new JSONArray();
		for (int i = 0; i < round.getHoles().size(); i++) {
			// Create a new JSONObject for each hole
			JSONObject holeObject = new JSONObject();
			recordHole hole = round.getHoles().get(i);
			holeObject.put("Hole Number", hole.getNumber());
			holeObject.put("Hole Yardage", hole.getDistance());
			holeObject.put("Par", hole.getPar());

			// Create a JSON array to hold shot data for the hole
			JSONArray shotsArray = new JSONArray();
			for (int j = 0; j < hole.getShots().size(); j++) {
				// Create a JSONObject for each shot and add it to the shots array
				recordShot shot = hole.getShots().get(j);

				JSONObject shotObject = new JSONObject();
				shotObject.put("Number", shot.getNumber());
				shotObject.put("Distance", shot.getDistance());
				shotObject.put("Club", shot.getClub());
				shotObject.put("End Distance", shot.getEndDistance());
				shotObject.put("End Position", shot.getEndPosition());
				shotsArray.add(shotObject);
			}

			// Add the shots array to the hole object and add the hole object to the holes
			// array
			holeObject.put("shots", shotsArray);
			holesArray.add(holeObject);
		}

		JSONObject roundObject = new JSONObject();
		roundObject.put("Course Name", round.getCourse());
		roundObject.put("Par", round.getPar());
		roundObject.put("Tees", round.getTees());
		roundObject.put("Number of holes", round.getNumberOfHoles());
		roundObject.put("Date", round.getDate());
		roundObject.put("holes", holesArray);

		// Write the JSON data to a file
		try (FileWriter file = new FileWriter("rounds/" + filename + ".json")) {
			file.write(roundObject.toJSONString());
			System.out.println("Successfully wrote JSON to file");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addScores(int... values) {
		int tot = 0;

		for (int i = 0; i < values.length; i++) {
			tot += values[i];
		}

		System.out.println("Your score was: " + tot);

	}

	public static void addClub(golfer currentGolfer) throws FileNotFoundException, IOException, ParseException {

		System.out.println("Add a new club to your bag");
		System.out.println("++++++++++++++++++++++++++");

		StringMenu club = new StringMenu("What is the club?", false);
		String clb = club.getUserInput();

		StringMenu series = new StringMenu("What is the series of club?", false);
		String srs = series.getUserInput();

		StringMenu manufacturer = new StringMenu("Who is the club manufacturer?", false);
		String manu = manufacturer.getUserInput();

		club myClub = new club(clb, srs, manu);

		currentGolfer.addClub(myClub);

		saveClubs(gameState.getCurrentGolfer().getFullName(), myClub);
	}

	public static void saveClubs(String filename, club clb) throws FileNotFoundException, IOException, ParseException {

		// Load the JSON file into a JSONObject
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("golfers/" + filename + ".json"));

		// Get the golfclubs array from the JSON object
		JSONArray clubsArray = (JSONArray) jsonObject.get("Clubs");

		// Create a new golfclub object and add it to the array
		JSONObject newGolfclub = new JSONObject();
		newGolfclub.put("Club", clb.getClub());
		newGolfclub.put("Series", clb.getSeries());
		newGolfclub.put("Manufacturer", clb.getManufacturer());

		clubsArray.add(newGolfclub);

		// Write the updated JSON data back to the file
		try (FileWriter file = new FileWriter("golfers/" + filename + ".json")) {

			file.write(jsonObject.toJSONString());
			System.out.println("Successfully updated JSON file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void checkChallenges(golfer golfer, golferStats stats) {

		for (int i = 0; i < golfer.getChallenges().getChallenges().size(); i++) {
			challenge chal = golfer.getChallenges().getChallenges().get(i);
			if (chooseChallenge(chal, stats) == true) {
				int points = chal.getPoints();
				System.out.println("Congrats Challenge Passed - " + chal.getName() + " + " + points + " points");
				golfer.addPoints(points);
				golfer.getChallenges().getChallenges().remove(chal);
				golfer.getChallenges().getCompletedChallenges().add(chal);
			}
		}
	}

	public static boolean chooseChallenge(challenge chal, golferStats stats) {

		boolean passed = false;

		switch (chal.getName()) {

		case "Make 10 Pars":
			passed = chal.checkNumber(chal.getExpected(), stats.getScoreStats().getTotalPars());
			break;
		case "Make 10 Birdies":
			passed = chal.checkNumber(chal.getExpected(), stats.getScoreStats().getTotalBirdies());
			break;
		case "Make 10 Eagles":
			passed = chal.checkNumber(chal.getExpected(), stats.getScoreStats().getTotalEagles());
			break;
		case "Make a Hole In One":
			passed = chal.checkNumber(chal.getExpected(), stats.getScoreStats().getTotalHoleInOne());
			break;
		case "Make 5 Bounce Back Birdies":
			passed = chal.checkNumber(chal.getExpected(), stats.getScoreStats().getTotalBounceBackBirdies());
			break;
		case "Make 10 Par saves":
			break;
		case "Make 10 Bogey Saves":
			break;
		}

		return passed;

	}

}
