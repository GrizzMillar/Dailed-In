package round;

import menus.input.IntMenu;
import menus.input.StringMenu;

public class recordShot {

	private int shotNumber;
	private int distance;
	private String club;
	private int enddistance;
	private String endposition;
	private String shot;
	private String note;
	
	
	public recordShot(int shotNumber, int distance, String club, int enddistance, String endposition) {
		this.shotNumber = shotNumber;
		this.distance = distance;
		this.club = club;
		this.enddistance = enddistance;
		this.endposition = endposition;
		
		
	}
	
	public String toString() {
		
		this.shot = "";
		
		this.shot += "Shot number: " + this.shotNumber + "\n";
		this.shot += "The distance to the hole is " + this.distance + "\n";
		this.shot += "The club you hit was a " + this.club + "\n";
		this.shot += "The distance left to the hole is " + this.enddistance + "\n";
		this.shot += "Your ball finished in " + this.endposition + "\n";
		
		
		return this.shot;
	}
	
	public void createNote(String nte) {
		
	   this.note = nte;
		
	}
	
	public String getNotes() {
		return this.note;
	}
	
	
	public String displayShot() {
		
		return this.shot;
	}
	
    public String getClub() {
		
		return this.club;
	}
	
	public String getEndPosition() {
		return endposition;
	}
	
	public int getDistance() {
		return this.distance;
	}
	public int getEndDistance() {
		return this.enddistance;
	}
	
	public int getNumber() {
		return this.shotNumber;
	}
	
	public String getCurrentPosition() {
		
		String current = " ";
		
		return current;
	}
	
}


