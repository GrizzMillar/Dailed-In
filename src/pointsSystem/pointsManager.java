package pointsSystem;

import round.round;

public class pointsManager {
	
	/*-	150 for finishing a round
-	100 for shooting your handicap
-	300 for shooting under your handicap
-	50 for shooting worse than your handicap
-	Handicap par 20 points
-	Handicap birdie 30 points
-	Handicap bogey 10 points
*/
	
	private int finishRound = 150;
	private int levelHandicap = 100;
	private int underHandicap = 300;
	private int overHandicap = 50;
	private int par = 20;
	private int birdie = 30;
	private int eagle = 40;
	private int holeinone = 50;
	private int bogey = 10;
	private int doubleBogey = 5;
	private int totalPoints;
	private int parpoints;
	private int birdiepoints;
	private int eaglepoints;
	private int holeinonepoints;
    private int bogeypoints;
    private int doubleBogeypoints;
	
	
	public pointsManager() {
		
	}
	
	public void initialisePoints(round round) {
		
		int handicap = 0;
		
		if(round.returnNetScore() == round.returnScore()) {
			handicap = this.levelHandicap;
		} else if (round.returnNetScore() < round.returnScore()) {
			handicap = this.underHandicap;
		} else {
			handicap = this.overHandicap;
		}
		this.parpoints = round.getRoundStats().getScoreStats().getPars() * this.par;
		this.birdiepoints = round.getRoundStats().getScoreStats().getBirdies() * this.birdie;
		this.eaglepoints = round.getRoundStats().getScoreStats().getEagles() * this.eagle;
		this.holeinonepoints = round.getRoundStats().getScoreStats().getHoleInOne() * this.holeinone;
	    this.bogeypoints = round.getRoundStats().getScoreStats().getBogey() * this.bogey;
	    this.doubleBogeypoints = round.getRoundStats().getScoreStats().getDoubleBogey() * this.doubleBogey;
	    
	    this.totalPoints = handicap + 150 + this.parpoints + this.birdiepoints + this.eaglepoints + this.holeinonepoints + this.bogeypoints + this.doubleBogeypoints;
	    
	    
	    
		
	}
	
	public int getTotalPoints() {
		return this.totalPoints;
	}
	
	public int getParPoints() {
		return this.parpoints;
	}
	
	public int getBirdiePoints() {
		return this.birdiepoints;
	}
	
	public int getEaglePoints() {
		return this.eaglepoints;
	}
	
	public int getHoleInOnePoints() {
		return this.holeinonepoints;
	}
	
	public int getBogeyPoints() {
		return this.bogeypoints;
	}
	
	public int getDoubleBogeyPoints() {
		return this.doubleBogeypoints;
	}

}
