package menu;

import golfIreland.GameState;


import menus.input.ConfirmChoiceMenu;
import menus.input.DoubleMenu;
import menus.input.IntMenu;
import menus.input.SelectOptionMenu;
import menus.input.StringMenu;
import round.recordHole;
import round.recordShot;
import round.round;

import java.io.*;
import java.util.LinkedList;

import org.json.simple.parser.ParseException;

import actors.golfer;
import attributes.club;

public class StartMenu {

    private golfer player;
    private static GameState gameState;
    private boolean hasQuit;
    public final static String sectionBreak = "=====,\n";
    static final int MAX = 2;
	static golfer data[] = new golfer[MAX];
	static int count = 0;
	static golfer currentGolfer;
    

    /**
     * Constructor
     * Creates and presents the start menu
     * Calls the methods for the appropriate selection
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public StartMenu() throws FileNotFoundException, IOException, ParseException{

        //Options that may be presented in the menu
    	final String botaccount = "bbrobot";
        final String createPlayer = "Create account";
        final String loadPlayer = "Log in";
        final String options = "Options";
        final String quit = "Quit";

        LinkedList<String> menuOptions = new LinkedList<>();

        //adding possible options to the menu options
        menuOptions.add(botaccount);
        menuOptions.add(loadPlayer);
        menuOptions.add(createPlayer);
        menuOptions.add(options);
        menuOptions.add(quit);

        //creating menu to present options to user
        SelectOptionMenu start = new SelectOptionMenu("Start Menu", menuOptions.toArray(new String[0]), false);

        //getting user to select options and implementing it
        boolean hasFinished = false;
        while(!hasFinished){

            switch (menuOptions.get(start.getUserInput()-1)){

                //stating new game
            
            case botaccount -> {
            	this.initialiseBot();
            	hasFinished = true;
            	
            }
                case createPlayer -> {
                    this.addNewMember();
                    hasFinished = true;
                }
                //loading previous game from file
                case loadPlayer -> {
                    //loading game
                    LoadMenu load = new LoadMenu("golfers", false);
                    GameState gameState = load.loadGolfer();

                    //game successfully loaded
                    if(gameState != null) {
                        this.gameState = gameState;
                        hasFinished = true;
                    }
                    //game successfully loaded
                    else{
                        System.out.println("There was an error loading this golfer.");
                    }

                }
                //selecting options
                case options -> this.options();

                //quitting game
                case quit -> {
                    ConfirmChoiceMenu sureQuit = new ConfirmChoiceMenu("Are you sure you want to quit?");
                    if(sureQuit.getUserInput() == 1){
                        this.hasQuit = true;
                        hasFinished = true;
                        System.out.println("Goodbye.");
                    }

                }

            }
        }
    }

    /**
     * Creates a new game
     * - creates new banker object
     * - creates between 2 and 6 players and allows user to name them
     * - creates a board object from a file selected by the user
     * 
     */
    
private static void addNewMember() {
		
		if ( count < MAX ) {
			System.out.println("Add a New Member:\n");
			StringMenu name = new StringMenu("Enter your name", false);
			String forename = name.getUserInput();
			StringMenu secondname = new StringMenu("Enter your surname", false);
			String surname = secondname.getUserInput();
			StringMenu club = new StringMenu("What is your golf club?", false);
		    String course = club.getUserInput();
			DoubleMenu handi = new DoubleMenu("What is your handicap?", -100, 60);
			double handicap = handi.getUserInput();
			currentGolfer = new golfer(forename, surname, handicap, course);
			data[count] = currentGolfer;
			count++;
			System.out.println();
			
			//String fullname = forename + " " + surname;
			currentGolfer.setFullName();
			currentGolfer.getChallenges().setScoringChallenges();
			gameState = new GameState(currentGolfer);
			
			//SaveGolferMenu savegame = new SaveGolferMenu(gameState, currentGolfer.getFullName());
			SaveMenu savegolfer = new SaveMenu(gameState, currentGolfer.getFullName());
			
			
		}
		
		
		
	}

private static void initialiseBot() {
	
	currentGolfer = new golfer("bbrobot", "null", 3, "Portstewart");
	currentGolfer.getChallenges().setScoringChallenges();
	gameState = new GameState(currentGolfer);
	
	club putter = new club("Putter", "Scotty Cameron", "Titliest");
	currentGolfer.addClub(putter);
	club pw = new club("Pitching Wedge", "M2", "Taylormade");
	currentGolfer.addClub(pw);
	club lob = new club("Lob Wedge", "M2", "Taylormade");
	currentGolfer.addClub(lob);
	club nine = new club("9Iron", "M2", "Taylormade");
	currentGolfer.addClub(nine);
	club eight = new club("8Iron", "M2", "Taylormade");
	currentGolfer.addClub(eight);
	club seven = new club("7Iron", "M2", "Taylormade");
	currentGolfer.addClub(seven);
	club six = new club("6Iron", "M2", "Taylormade");
	currentGolfer.addClub(six);
	club five = new club("5Iron", "M2", "Taylormade");
	currentGolfer.addClub(five);
	club four = new club("4Iron", "M2", "Taylormade");
	currentGolfer.addClub(four);
	club threewood = new club("3Wood", "M2", "Taylormade");
	currentGolfer.addClub(threewood);
	club fivewood = new club("5Wood", "M2", "Taylormade");
	currentGolfer.addClub(fivewood);
	club driver = new club("Driver", "M2", "Taylormade");
	currentGolfer.addClub(driver);
	
	for(int j = 0; j <= 1; j++) {
	
	round test = new round("Port", 71, "Whites", 1, "07/12/2022");

	for (int i = 1; i <=4; i++) {

		recordShot test1 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot test2 = new recordShot(2, 200, "7Iron", 20, "Rough");
		recordShot test3 = new recordShot(3, 20, "Lob Wedge", 2, "Green");
		recordShot test4 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole = new recordHole(i, 400, 4);

		testHole.addShots(test1);
		testHole.addShots(test2);
		testHole.addShots(test3);
		testHole.addShots(test4);

		test.addHoles(testHole);

	}

	for (int i = 5; i <=8; i++) {

		recordShot test5 = new recordShot(1, 500, "Driver", 200, "Fairway");
		recordShot test6 = new recordShot(2, 300, "3Wood", 75, "Semi-Rough");
		recordShot test7 = new recordShot(3, 74, "Lob Wedge", 10, "Green");
		recordShot test8 = new recordShot(4, 10, "Putter", 3, "Green");
		recordShot test9 = new recordShot(5, 3, "Putter", 0, "Hole");

		recordHole testHole1 = new recordHole(i, 500, 5);

		testHole1.addShots(test5);
		testHole1.addShots(test6);
		testHole1.addShots(test7);
		testHole1.addShots(test8);
		testHole1.addShots(test9);

		test.addHoles(testHole1);

	}

	for (int i = 9; i <=14 ; i++) {
		recordShot test9 = new recordShot(1, 210, "4Iron", 20, "Bunker");
		recordShot test10 = new recordShot(2, 20, "Lob Wedge", 2, "Green");
		recordShot test11 = new recordShot(3, 2, "Putter", 0, "Hole");

		recordHole testHole2 = new recordHole(i, 210, 3);

		testHole2.addShots(test9);
		testHole2.addShots(test10);
		testHole2.addShots(test11);

		test.addHoles(testHole2);
	}

	for (int i = 15; i <=18; i++) {
		recordShot test13 = new recordShot(1, 400, "Driver", 200, "Rough");
		recordShot test14 = new recordShot(2, 200, "7Iron", 20, "Green");
		recordShot test15 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot test16 = new recordShot(4, 2, "Putter", 0, "Hole");

		recordHole testHole3 = new recordHole(i, 400, 4);

		testHole3.addShots(test13);
		testHole3.addShots(test14);
		testHole3.addShots(test15);
		testHole3.addShots(test16);

		test.addHoles(testHole3);
		
		
	}
	
	test.initStats();
	test.setName();
	currentGolfer.addPlayerRound(test);
	}
	
	//round2
	for(int l = 0; l <= 1; l++) {
		
		round testround2 = new round("castlerock", 71, "Whites", 1, "07/12/2022");

		for (int i = 1; i <=4; i++) {

			recordShot test1 = new recordShot(1, 400, "Driver", 200, "Fairway");
			recordShot test2 = new recordShot(2, 200, "7Iron", 20, "Green");
			recordShot test3 = new recordShot(3, 20, "Putter", 2, "Green");
			recordShot test4 = new recordShot(4, 2, "Putter", 0, "Hole");

			recordHole testHole = new recordHole(i, 400, 4);

			testHole.addShots(test1);
			testHole.addShots(test2);
			testHole.addShots(test3);
			testHole.addShots(test4);

			testround2.addHoles(testHole);

		}

		for (int i = 5; i <=8; i++) {

			recordShot test5 = new recordShot(1, 500, "Driver", 200, "Fairway");
			recordShot test6 = new recordShot(2, 200, "3Wood", 75, "Fairway");
			recordShot test7 = new recordShot(3, 75, "Lob Wedge", 10, "Green");
			recordShot test8 = new recordShot(4, 10, "Putter", 3, "Green");
			recordShot test9 = new recordShot(5, 3, "Putter", 0, "Hole");

			recordHole testHole1 = new recordHole(i, 500, 5);

			testHole1.addShots(test5);
			testHole1.addShots(test6);
			testHole1.addShots(test7);
			testHole1.addShots(test8);
			testHole1.addShots(test9);

			testround2.addHoles(testHole1);

		}

		for (int i = 9; i <=14 ; i++) {
			recordShot test9 = new recordShot(1, 210, "6Iron", 20, "Green");
			recordShot test10 = new recordShot(2, 20, "Green", 2, "Green");
			recordShot test11 = new recordShot(3, 2, "Putter", 0, "Hole");

			recordHole testHole2 = new recordHole(i, 210, 3);

			testHole2.addShots(test9);
			testHole2.addShots(test10);
			testHole2.addShots(test11);

			testround2.addHoles(testHole2);
		}

		for (int i = 15; i <=18; i++) {
			recordShot test13 = new recordShot(1, 400, "Driver", 100, "Rough");
			recordShot test14 = new recordShot(2, 100, "7Iron", 20, "Green");
			recordShot test15 = new recordShot(3, 20, "Putter", 0, "Hole");

			recordHole testHole3 = new recordHole(i, 400, 4);

			testHole3.addShots(test13);
			testHole3.addShots(test14);
			testHole3.addShots(test15);

			testround2.addHoles(testHole3);
			
			
		}
		
		testround2.initStats();
		testround2.setName();
		currentGolfer.addPlayerRound(testround2);
		}
}


    private void options(){
        System.out.println("YET TO BE IMPLEMENTED");
    }

    /**
     *
     * @return GameState object created for the game
     */
    public GameState getGameState(){
        return this.gameState;
    }

    /**
     *
     * @return true if user has selected quit, otherwise false
     */
    public boolean getHasQuit(){
        return this.hasQuit;
    }


}
