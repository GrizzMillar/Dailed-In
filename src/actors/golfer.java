package actors;

import java.util.LinkedList;

import attributes.club;
import golfIreland.playerRound;
import menus.input.IntMenu;
import pointsSystem.careerChallenges;
import pointsSystem.challenge;
import pointsSystem.prestige;
import round.round;
import statistics.roundStatistics;
import statistics.golferStatistics.golferStats;

public class golfer {

	private int id;
	private static int nextID = 1;
	private String firstName;
	private String secondName;
	private String fullName;
	private double handicap;
	private String club;
	private static LinkedList<playerRound> rounds = new LinkedList<>();
	private static LinkedList<round> round = new LinkedList<>();
	private static LinkedList<club> bag = new LinkedList<>();
	private static golferStats stats = new golferStats();
	private static prestige level = new prestige(0, 0, 0);
	private static careerChallenges challenges = new careerChallenges();

	public golfer(String firstName, String secondName, double handicap, String club) {

		this.firstName = firstName;
		this.secondName = secondName;
		this.handicap = handicap;
		this.club = club;
		this.id = useNextID();

	}

	private int useNextID() {
		return nextID++;
	}

	private void setHandicap(double handicap) {

		this.handicap = handicap;

	}

	public void setfirstName(String name) {
		if (name != null) {
			this.firstName = name;
		} else {
			if (this.firstName == null)
				// a default value
				this.firstName = "Unknown";
		}

	}

	public void setFullName() {

		this.fullName = this.getfirstName() + " " + this.getsecondName();

	}

	public void setsecondName(String name) {
		if (name != null) {
			this.secondName = name;
		} else {
			if (this.secondName == null)
				// a default value
				this.secondName = "Unknown";
		}

	}

	public void setClub(String club) {

		if (club != null) {
			this.club = club;
		} else {
			if (this.club == null)
				// a default value
				this.club = "Unknown";
		}

	}

	public String toString() {
		String data = "Member ID: " + getId() + ": " + "First Name: " + getfirstName() + ": " + "Second Name: "
				+ getsecondName() + "\n";
		data += "Handicap: " + getHandicap() + ": " + "Club: " + getClub() + "\n";
		data += this.getPrestige().toString();
		return data;
	}

	public int getId() {
		return this.id;
	}

	public double getHandicap() {
		return this.handicap;
	}

	public String getfirstName() {
		return this.firstName;
	}

	public String getsecondName() {
		return this.secondName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public String getClub() {
		return this.club;
	}

	public prestige getPrestige() {
		return this.level;
	}

	public void addPoints(int points) {
		this.level.addPoints(points);
	}

	public careerChallenges getChallenges() {
		return this.challenges;
	}

	public static LinkedList<playerRound> displayRounds() {

		return rounds;
	}

	public static void addRound(playerRound r) {
		rounds.add(r);
	}

	public static LinkedList<round> displayRound() {

		return round;
	}

	public static void addPlayerRound(round r) {
		round.add(r);
	}

	public static void addClub(club c) {
		bag.add(c);
	}

	public void getClubs() {
		for (int i = 0; i < bag.size(); i++) {
			System.out.println(bag.get(i).toString());
		}
	}

	public static LinkedList<club> displayClubs() {

		return bag;
	}

	public golferStats getStats() {

		return this.stats;
	}

}
