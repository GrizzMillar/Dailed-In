package statistics.golferStatistics;


import java.util.LinkedList;

import round.recordHole;
import round.round;
import statistics.puttingStatistics;
import statistics.roundStatistics;
import statistics.scoringStatistics;

public class golferStats {
	
	
	private golferPutt putt = new golferPutt();
	private golferScoring score = new golferScoring();
	
	public golferStats() {
		
	}
	
	public golferPutt getPuttStats() {
		return this.putt;
	}
	
	public golferScoring getScoreStats() {
		return this.score;
	}
	
	public void initialiseStats(roundStatistics round) {
		
		this.putt.update(round.getPuttStats());
		this.score.update(round.getScoreStats());
	}
	
	
	
	public String getPuttingStats() {
		
		return this.putt.toString();
	}
	
public String getScoringStats() {
		
		return this.score.toString();
	}
	
	

}

