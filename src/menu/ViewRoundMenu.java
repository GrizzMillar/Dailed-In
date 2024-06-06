package menu;

import java.util.LinkedList;

import actors.golfer;
import menus.input.SelectOptionMenu;
import menus.input.SelectOptionMenu1;
import round.round;
import golfIreland.playerRound;

public class ViewRoundMenu {

	private final golfer player;

	public ViewRoundMenu(golfer golfer) {

		this.player = golfer;

		selectRound();
	}

	private void selectRound() {
		LinkedList<round> rounds = new LinkedList<>();
		int choice;

		SelectOptionMenu1 selectRound = new SelectOptionMenu1("Select a round.");

		do {
			rounds = new LinkedList<>(player.displayRound());

			// if the player doesn't own any companies, they are returned to the main menu
			if (rounds.size() == 0) {
				System.out.println("You have not recorded any rounds.");
				return;
			}

			String[] options = new String[rounds.size() + 1];

			// add a back option to the start of the list
			options[0] = "<-- Back";

			// populating an array of string names of the companies owned by the player
			for (int i = 1; i < rounds.size() + 1; i++) {
				options[i] = rounds.get(i - 1).getName();
			}

			// update options on select options menu
			selectRound.updateOptions(options, true);

			// get user choice
			choice = selectRound.getUserInput() - 1;

			if (choice < 0)
				return;
			// calls method to present actions associated with that company
			actionRound(rounds.get(choice));

		}
		// show menu until user select back option
		while (choice != -1);
	}

	private void actionRound(round round) {
		// List to hold menu options in
		LinkedList<String> options = new LinkedList<>();

		// All the menu options that can be presented
		final String back = "<-- Back";
		final String viewRoundInfo = "View round";
		final String viewRoundStats = "View stats";
		final String compare = "Compare against last round";

		options.add(back);
		options.add(viewRoundInfo);
		options.add(viewRoundStats);
		options.add(compare);

		// creates a menu with the options added
		SelectOptionMenu1 selectAction = new SelectOptionMenu1(round.getName() + " - What would you like to do?",
				options.toArray(new String[0]), true);

		boolean hasFinished = false;
		while (!hasFinished) {

			// process options from menu
			switch (options.get(selectAction.getUserInput()).trim()) {

			// presenting previous menu if back selected
			case back:
				hasFinished = true;
				break;

			// Displays company info
			case viewRoundInfo:
				round.getRoundDetails();
				break;

			case viewRoundStats:
				// round.getStats();
				final String back1 = "<--Back";
				final String scoring = "Scoring";
				final String putting = "Putting";
				final String tee = "Off The Tee";
				final String approach = "Approach to Green";
				final String green = "Around the Green";
				LinkedList<String> statoptions = new LinkedList<>();
				statoptions.add(back1);
				statoptions.add(scoring);
				statoptions.add(putting);
				statoptions.add(tee);
				statoptions.add(approach);
				statoptions.add(green);

				SelectOptionMenu stats = new SelectOptionMenu("Select a stat category",
						statoptions.toArray(new String[0]), true);

				boolean finished = false;

				while (!finished) {
					switch (statoptions.get(stats.getUserInput()).trim()) {

					case back1:
						finished = true;
						break;

					case scoring:
						System.out.println(round.getScoreStats());
						break;

					case putting:
						System.out.println(round.getPuttingStats());
						break;

					case tee:
						System.out.println(round.getOffTeeStats());
						break;
						
					case approach:
						System.out.println(round.getApproachStats());
						break;
						
					case green:
						System.out.println(round.getAroundGreenStats());
						break;

					}
				}

				break;

			case compare:
				int size = this.player.displayRound().size();

				if (size < 2) {
					System.out.println("You do not have enough rounds to compare");
				} else {
					round round1 = this.player.displayRound().getLast();
					round round2 = this.player.displayRound().get(size - 1);

					System.out.println(compareRounds(round1, round2));
				}

			}
		}
	}

	public static String compareRounds(round round1, round round2) {

		String str = "";

		int rndonescore = round1.returnScore();
		int rndtwoscore = round2.returnScore();
		int scorediff = rndonescore - rndtwoscore;

		int rndonepars = round1.getRoundStats().getScoreStats().getPars();
		int rndtwopars = round2.getRoundStats().getScoreStats().getPars();
		int pardiff = rndonepars - rndtwopars;

		int rndonebirdies = round1.getRoundStats().getScoreStats().getBirdies();
		int rndtwobirdies = round2.getRoundStats().getScoreStats().getBirdies();
		int birdiediff = rndonebirdies - rndtwobirdies;

		int rndonebogeys = round1.getRoundStats().getScoreStats().getBogey();
		int rndtwobogeys = round2.getRoundStats().getScoreStats().getBogey();
		int bogeydiff = rndonebogeys - rndtwobogeys;

		int rndonedbogeys = round1.getRoundStats().getScoreStats().getDoubleBogey();
		int rndtwodbogeys = round2.getRoundStats().getScoreStats().getDoubleBogey();
		int dbogeydiff = rndonedbogeys - rndtwodbogeys;

		int rndoneputts = round1.getRoundStats().getPuttStats().getTotalPutts();
		int rndtwoputts = round2.getRoundStats().getPuttStats().getTotalPutts();
		int puttsdiff = rndoneputts - rndtwoputts;

		if (Math.signum(scorediff) == -1.0) {
			str += "Youre score improved by " + scorediff + "Shots" + "\n";
		} else if (Math.signum(scorediff) == 1) {
			str += "Youre score increased by " + scorediff + "Shots" + "\n";
		} else {
			str += "Youre score did not change " + "\n";
		}

		str += "Your total number of pars " + getCompareMessage(pardiff);
		str += "Your total number of birdies " + getCompareMessage(birdiediff);
		str += "Your total number of bogeys " + getCompareMessage(bogeydiff);
		str += "Your total number of double bogeys " + getCompareMessage(dbogeydiff);
		str += "Your total number of putts " + getCompareMessage(puttsdiff);

		return str;

	}

	public static String getCompareMessage(int diff) {

		String str = "";

		if (Math.signum(diff) == -1.0) {
			str += "improved by " + diff + "\n";
		} else if (Math.signum(diff) == 1) {
			str += "decreased by " + diff + "\n";
		} else {
			str += "did not change " + "\n";
		}

		return str;

	}

}