package actors;

import java.util.LinkedList;

public class Coach {
	
	private int userID;
	private String email;
	private String firstName;
	private String secondName;
	private String club;
	private String status;
	private LinkedList<Golfer> students;
	
	public Coach(int userID, String email, String firstName, String secondName, String club, String status) {
		this.userID = userID;
		this.email = email;
		this.firstName = firstName;
		this.secondName = secondName;
		this.club = club;
		this.status = status;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getSecondName() {
		return this.secondName;
	}
	
	public String getClub() {
		return this.club;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public LinkedList<Golfer> getStudents() {
		return this.students;
	}
	
	public void addStudent(Golfer golfer) {
		this.students.add(golfer);
	}

}
