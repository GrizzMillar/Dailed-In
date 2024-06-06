package pointsSystem;

import java.util.LinkedList;

/*This class defines all career challenges
 * These challenges are then added to an array list once a player profile is created using the setScoringChalleges method
 * At the end of each round 
 * 
 * 
 * Scoring
 * Eagles, Birdies, Pars - make 10, 50, 100, 150, 200, 400, 700, 1000
 * Hole in Ones - 1, 2, 3
 * Bounce back birdies - make 5, 10, 15, 20, 40, 50
 * Bogey, Par save's - make 10, 20, 30, 40, 50, 100
 * 
 * 
 */

public class careerChallenges {

	private LinkedList<challenge> challenges = new LinkedList<challenge>();
	private LinkedList<challenge> completedchallenges = new LinkedList<challenge>();

	private challenge tenPars = new challenge("Make 10 Pars", 100, false, 10);

	private challenge tenBirdies = new challenge("Make 10 Birdies", 150, false, 10);

	private challenge tenEagles = new challenge("Make 10 Eagles", 100, false, 10);

	private challenge oneHoleInOne = new challenge("Make a Hole In One", 1000, false, 1);

	private challenge fiveBounceBackBirdies = new challenge("Make 5 Bounce Back Birdies", 100, false, 10);

	private challenge tenParSaves = new challenge("Make 10 Par saves", 100, false, 10);

	private challenge tenBogeySaves = new challenge("Make 10 Bogey Saves", 100, false, 10);

	public careerChallenges() {

	}

	public void setScoringChallenges() {

		this.challenges.add(this.tenPars);
		this.challenges.add(this.tenBirdies);
		this.challenges.add(this.tenEagles);
		this.challenges.add(this.oneHoleInOne);
		this.challenges.add(this.fiveBounceBackBirdies);
		this.challenges.add(this.tenParSaves);
		this.challenges.add(this.tenBogeySaves);
	
	}
	


	public String getScoringChallenges() {
		
		String str = "";

		for (int i = 0; i < this.challenges.size(); i++) {
			str += this.challenges.get(i).getName();
		}
		
		return str;
	}
	
	public String getCompletedScoringChallenges() {
		
		String str = "";
		
		if(this.completedchallenges.size() == 0) {
			str += "You have not yet completed any challenges";
		} else {
		

		for (int i = 0; i < this.completedchallenges.size(); i++) {
			str += this.completedchallenges.get(i).getName() + "\n";
		}
		
		}
		
		return str;
	}

	public LinkedList<challenge> getChallenges() {
		return this.challenges;
	}
	
	public LinkedList<challenge> getCompletedChallenges() {
		return this.completedchallenges;
	}
}
