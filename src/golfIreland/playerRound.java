package golfIreland;

public class playerRound {
	
	private String date;
	private String coursename;
	private String round;
	
	public playerRound(String name, String date) {
		
		this.coursename = name;
		this.date = date;
		
	}
	
	public String getName() {
		
		return this.coursename;
	}
	
	public void setName() {
		
		String name2 = "";
		
		name2 += this.coursename + " " + this.date;
		
		this.coursename = name2;
	}
	
	public String getDate() {
		
		return this.date;
	}
	
	
	public void addScores(int h1, int h2, int h3, int h4, int h5, int h6, int h7, int h8, int h9, int h10, int h11, int h12, int h13, int h14, int h15, int h16, int h17, int h18) {
		
		 this.round = "";
		
		this.round += "Hole 1: " + h1 + "\n";
		this.round += "Hole 2: " + h2 + "\n";
		this.round += "Hole 3: " + h3 + "\n";
		this.round += "Hole 4: " + h4 + "\n";
		this.round += "Hole 5: " + h5 + "\n";
		this.round += "Hole 6: " + h6 + "\n";
		this.round += "Hole 7: " + h7 + "\n";
		this.round += "Hole 8: " + h8 + "\n";
		this.round += "Hole 9: " + h9 + "\n";
		this.round += "Hole 10: " + h10 + "\n";
		this.round += "Hole 11: " + h11 + "\n";
		this.round += "Hole 12: " + h12 + "\n";
		this.round += "Hole 13: " + h13 + "\n";
		this.round += "Hole 14: " + h14 + "\n";
		this.round += "Hole 15: " + h15 + "\n";
		this.round += "Hole 16: " + h16 + "\n";
		this.round += "Hole 17: " + h17 + "\n";
		this.round += "Hole 18: " + h18 + "\n";
		
		int score = h1 + h2 + h3 + h4 + h5 + h6 + h7 + h8 + h9 + h10 + h11 + h12 + h13 + h14 + h15 + h16 + h17 + h18;
		
		this.round += "Score: " + score;
		
		this.round += "\n";
		
		
	}
	
	public String getRoundDetails() {
		
		return this.round;
	}
	

}
