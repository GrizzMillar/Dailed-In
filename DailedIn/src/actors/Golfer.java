package actors;

import java.util.LinkedList;

import round.Round;

public class Golfer {
	
	private int userID;
	private String email;
	private String firstName;
	private String secondName;
	private double handicap;
	private String club;
	private LinkedList<Round> rounds;
	private LinkedList<Club> bag;
	
	
	public Golfer (int userID, String email, String firstName, String secondName, double handicap, String club) {
		this.userID = userID;
		this.email = email;
		this.firstName = firstName;
		this.secondName = secondName;
		this.handicap = handicap;
		this.club = club;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getSecondName() {
		return this.secondName;
	}
	
	public Double getHandicap() {
		return this.handicap;
	}
	
	public String getClub() {
		return this.club;
	}
	
	public LinkedList<Round> getRounds() {
		return this.rounds;
	}
	
	public void addRound(Round round) {
		this.rounds.add(round);
	}
	
	public LinkedList<Club> getClubs() {
		return this.bag;
	}
	
	public void addClub(Club club) {
		this.bag.add(club);
	}

}
