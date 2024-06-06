package statistics;

import java.util.LinkedList;

import round.recordHole;
import round.round;

//Approach to the Green, Around the Green, Streaks, 

public class roundStatistics {

	private puttingStatistics putt = new puttingStatistics();
	private scoringStatistics score = new scoringStatistics();
	private offTheTee tee = new offTheTee();
	private aroundTheGreen green = new aroundTheGreen();
	private approachToTheGreen approach = new approachToTheGreen();

	public roundStatistics() {

	}

	public puttingStatistics getPuttStats() {
		return this.putt;
	}

	public scoringStatistics getScoreStats() {
		return this.score;
	}

	public offTheTee getOffTheTeeStats() {
		return this.tee;
	}

	public aroundTheGreen getAroundTheGreenStats() {
		return this.green;
	}
	
	public approachToTheGreen getApproachToGreenStats() {
		return this.approach;
	}

	public void initialiseStats(LinkedList<recordHole> hole) {

	    this.putt.updateStats(hole);
		this.score.updateStats(hole);
		this.tee.updateStats(hole);
		this.green.updateStats(hole);
		this.approach.updateStats(hole);
	}


	public String getPuttingStats() {

		return this.putt.toString();
	}

	public String getScoringStats() {

		return this.score.toString();
	}

	public String getTeeStats() {

		return this.tee.toString();
	}
	
	public String getAroundGreenStats() {
		
		return this.green.toString();
	}
	
	public String getApproachStats() {
		 return this.approach.toString();
	}

}
