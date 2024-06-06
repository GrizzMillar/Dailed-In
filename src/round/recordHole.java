package round;

import java.util.LinkedList;

import actors.golfer;
import attributes.club;
import golfIreland.GameState;
import golfIreland.playerRound;
import menu.ViewBagMenu;
import menus.input.ConfirmChoiceMenu;
import menus.input.IntMenu;
import menus.input.SelectOptionMenu;
import menus.input.SelectOptionMenu1;
import menus.input.StringMenu;

public class recordHole {

	private int number;
	private int distance;
	private int par;
	private LinkedList<recordShot> shots = new LinkedList<>();
	private String hole;
	private int shot;


	public recordHole(int number, int distance, int par) {
		this.number = number;
		this.distance = distance;
		this.par = par;

	}

	public void fillHole(golfer golfer) {

		shot = 1;
		boolean inHole = false;
		do {

			System.out.println("Shot number: " + shot + "\n");
			IntMenu yardage = new IntMenu("What is the yardage to the hole?", 0, 900);
			int dis = yardage.getUserInput();

			SelectOptionMenu1 selectClub = new SelectOptionMenu1("Select a club.");
			int choice;
			String clb;

			LinkedList<club> clubs = new LinkedList<>();

			clubs = new LinkedList<>(golfer.displayClubs());

			// creating an array of string names of clubs owned by the player
			String[] options = new String[clubs.size() + 1];

			// add a back option to the start of the list
			options[0] = "<-- Back";

			// populating an array of string names of the clubs owned by the player
			for (int i = 1; i < clubs.size() + 1; i++) {
				options[i] = clubs.get(i - 1).getClub();
			}

			selectClub.updateOptions(options, true);

			choice = selectClub.getUserInput();

			clb = options[choice];

			IntMenu distancefrom = new IntMenu("How far did you finish from the hole?", 0, 900);
			int endd = distancefrom.getUserInput();
			int clubdis = dis - endd;

			golfer.displayClubs().get(choice - 1).addDist(clubdis);

			SelectOptionMenu finish = new SelectOptionMenu("Where did your ball finish??");
			LinkedList<String> option = new LinkedList<>();
			boolean finished = false;
			int input;
			String endp = "";

			final String fairway = "Fairway";
			final String green = "Green";
			final String rough = "Rough";
			final String semirough = "Semi-Rough";
			final String fairwaybunker = "Fairway Bunker";
			final String bunker = "Greenside Bunker";
			final String hole = "Hole";

			// while(!finished) {

			option.clear();
			option.add(fairway);
			option.add(rough);
			option.add(semirough);
			option.add(fairwaybunker);
			option.add(bunker);
			option.add(hole);
			option.add(green);

			finish.updateOptions(option.toArray(new String[0]), false);
			input = finish.getUserInput() - 1;

			switch (option.get(input)) {

			case fairway -> {

				endp = "Fairway";
				// finished = true;
				break;
			}

			case rough -> {
				endp = "Rough";
				break;
			}

			case semirough -> {
				endp = "Semi-Rough";
				break;

			}

			case fairwaybunker -> {
				endp = "Fairway Bunker";
				break;

			}

			case bunker -> {
				endp = "Bunker";
				break;

			}

			case green -> {

				endp = "Green";
				break;
			}

			case hole -> {
				endp = "Hole";
				break;
			}

			}

			recordShot sht = new recordShot(shot, dis, clb, endd, endp);

			this.addShots(sht);

			if (endp == hole) {
				inHole = true;
			} else {
				shot++;
			}

		} while (!inHole);

	}

	public int getScore() {

		return shot;
	}

	public int getNumberOfShots() {

		return shots.size();
	}

	public String getScoreName() {

		int par = this.getPar();

		String name = "";

		int dif = this.getPar() - this.getNumberOfShots();

		switch (dif) {
		case 0:
			name = "Par";
			break;
		case 1:
			name = "Birdie";
			break;
		case 2:
			if (this.getPar() == 3) {
				name = "HOLE IN ONE!";
			} else {
				name = "Eagle";
			}
			break;
		case 3:
			if (this.getPar() == 4) {
				name = "HOLE IN ONE!";
			} else {
				name = "Albatross";
			}
			break;
		case -1:
			name = "Bogey";
			break;
		case -2:
			name = "Double Bogey";
			break;
		case -3:
			name = "Triple Bogey";
			break;
		}

		return name;

	}

	public int getNumber() {
		return this.number;
	}

	public int getDistance() {
		return this.distance;
	}

	public int getPar() {
		return this.par;
	}

	public String toString() {

		this.hole = "";

		this.hole += "Hole number: " + this.number + "\n";
		this.hole += "The yardage of the hole is " + this.distance + "\n";
		this.hole += "The par of the hole is " + this.par + "\n";

		return this.hole;
	}

	public void getHoleDetails() {

		System.out.println(this.toString());

		this.displayShots();

		System.out.println("Score: " + this.getScore());
		System.out.println();
	}

	public void displayShots() {

		for (int i = 0; i < shots.size(); i++) {
			System.out.println(shots.get(i).toString());
		}
	}

	public void addShots(recordShot s) {
		shots.add(s);
	}

	public LinkedList<recordShot> getShots() {

		return this.shots;

	}

}
