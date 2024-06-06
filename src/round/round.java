package round;

import java.util.LinkedList;

import actors.golfer;
import golfIreland.GameState;
import menus.input.ConfirmChoiceMenu;
import menus.input.IntMenu;
import menus.input.StringMenu;
import pointsSystem.pointsManager;
import statistics.offTheTee;
import statistics.puttingStatistics;
import statistics.roundStatistics;
import statistics.scoringStatistics;

public class round {

	private String course;
	private int par;
	private String tee;
	private int numberofholes;
	private String round;
	private String date;
	private int roundScore;
	private int netScore;
	private String name;

	private LinkedList<recordHole> holes = new LinkedList<>();
	private roundStatistics rnd = new roundStatistics();
	private pointsManager points = new pointsManager();
	

	public round(String course, int par, String tee, int numberofholes, String date) {

		this.course = course;
		this.par = par;
		this.tee = tee;
		this.numberofholes = numberofholes;
		this.date = date;
		this.name = this.getName();
		

	}

	public String getName() {
		return this.name;
	}
	
	public void setName() {
		name = "";

		name += this.course + " " + this.date;
	}

	public int getNumberOfHoles() {

		return this.numberofholes;
	}
	
	public String getCourse () {
		return this.course;
	}
	
	public int getPar() {
		return this.par;
	}
	
	public String getTees() {
		return this.tee;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setScore(int score) {
		this.roundScore = score;
	}
	



	public void addScores(int h1, int h2, int h3, int h4, int h5, int h6, int h7, int h8, int h9, int h10, int h11,
			int h12, int h13, int h14, int h15, int h16, int h17, int h18) {

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

		this.round += score;

		this.round += "\n";

	}

	public void fillRound(golfer golfer) {

		int i = 1;
		int x = this.numberofholes;

		while (i <= x) {

			System.out.println("Hole: " + i);

			IntMenu yar = new IntMenu("Enter the Hole yardage", 0, 900);
			int distance = yar.getUserInput();
			IntMenu par = new IntMenu("Enter the Hole par", 1, 5);
			int pr = par.getUserInput();

			recordHole hole1 = new recordHole(i, distance, pr);
			i++;
			hole1.fillHole(golfer);

			this.addScores(hole1.getScore());
			this.addHoles(hole1);
			
			this.netScore = (int) (this.roundScore - golfer.getHandicap());
			
			this.initStats();
			this.initPoints();
			golfer.getStats().initialiseStats(rnd);
			golfer.addPoints(this.points.getTotalPoints());
			
		}

	}
	


	public void addScores(int score) {

		this.roundScore += score;

	}

	public int returnScore() {

		return this.roundScore;
	}
	
	public int returnNetScore() {
		return this.netScore;
	}


	public String toString() {

		this.round = "";

		this.round += "Couse: " + this.course + "\n";
		this.round += "Par: " + this.par + "\n";
		this.round += "Tees: " + this.tee + "\n";
		this.round += "Holes: " + this.numberofholes + "\n";
		this.round += "Date: " + this.date + "\n";

		return this.round;
	}

	public void getRoundDetails() {

		System.out.println(this.toString());

		displayHoles();

		
		System.out.println("Round Score: " + this.returnScore());

	}

	public void displayHoles() {

		for (int i = 0; i < this.holes.size(); i++) {
			this.holes.get(i).getHoleDetails();
		}
	}

	public LinkedList<recordHole> getHoles() {
		return this.holes;
	}
	public void addHoles(recordHole h) {
		this.holes.add(h);
	}
	
	public String roundSummary() {
		
		int par = this.getRoundStats().getScoreStats().getPars();
		int birdie = this.getRoundStats().getScoreStats().getBirdies();
		int eagle = this.getRoundStats().getScoreStats().getEagles();
		int holeinone = this.getRoundStats().getScoreStats().getHoleInOne();
	    int bogey = this.getRoundStats().getScoreStats().getBogey();
	    int doubleBogey = this.getRoundStats().getScoreStats().getDoubleBogey();
	    int triple = this.getRoundStats().getScoreStats().getTripleBogeys();
		
	    
		String summary = " ";
		
		summary += "+++++++++++++++++++++++" + "\n";
		summary += "+++++ROUND SUMMARY+++++" + "\n";
		summary += "+++++++++++++++++++++++" + "\n";
		summary += "Total Pars: " + par + " +" + this.points.getParPoints() + " " + " points" + "\n";
		summary += "Total Birdies: " + birdie + " +" + this.points.getBirdiePoints() + " " + " points" + "\n";
		summary += "Total Eagles: " + eagle + " +" + this.points.getEaglePoints() + " " + " points" + "\n";
		summary += "Total Hole In One's: " + holeinone + " +" + this.points.getHoleInOnePoints() + " " + " points" +"\n";
		summary += "Total Bogeys: " + bogey+ " +" + this.points.getBogeyPoints() + " " + " points" +"\n";
		summary += "Total Double Bogeys: " + doubleBogey + " +" + this.points.getDoubleBogeyPoints() + " " + " points" + "\n";
		
		summary += "Total Points: " + this.points.getTotalPoints();
		
		return summary;
	}
	
	
	
	public void initStats() {
		this.rnd.initialiseStats(this.getHoles());
	}
	
	public void initPoints() {
		this.points.initialisePoints(this);
	}
	
	public String getPuttingStats() {
		
		return this.rnd.getPuttingStats();
	}
	
public String getScoreStats() {
		
		return this.rnd.getScoringStats();
	}


public String getOffTeeStats() {
	
	return this.rnd.getTeeStats();
}

public String getApproachStats() {
	
	return this.rnd.getApproachStats();
}

public String getAroundGreenStats() {
	
	return this.rnd.getAroundGreenStats();
}

public roundStatistics getRoundStats() {
	
	return this.rnd;
}

}
