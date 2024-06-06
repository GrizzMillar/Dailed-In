package statistics.golferStatistics;

import java.util.ArrayList;

import statistics.puttingStatistics;
import statistics.scoringStatistics;

public class golferScoring {
	
	private ArrayList<Integer> pars = new ArrayList<Integer>();
	private ArrayList<Integer> birdies = new ArrayList<Integer>();
	private ArrayList<Integer> eagles = new ArrayList<Integer>();
	private ArrayList<Integer> alba = new ArrayList<Integer>();
	private ArrayList<Integer> holeinone = new ArrayList<Integer>();
	private ArrayList<Integer> bogeys = new ArrayList<Integer>();
	private ArrayList<Integer> doublebogeys = new ArrayList<Integer>();
	private ArrayList<Integer> triplebogeys = new ArrayList<Integer>();
	private ArrayList<Integer> bouncebackbirdie = new ArrayList<Integer>();
	private ArrayList<Integer> birdiestreak = new ArrayList<Integer>();
	private ArrayList<Integer> parstreak = new ArrayList<Integer>();
    


	public golferScoring() {
		
	}
	
	public ArrayList<Integer> getPars() {
		return this.pars;
	}
	
	public int getTotalPars() {
		int total = 0;
		
		for (int i = 0; i < this.pars.size(); i++) {
			total += this.pars.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getBirdies() {
		return this.birdies;
	}
	
	public int getTotalBirdies() {
		int total = 0;
		
		for (int i = 0; i < this.birdies.size(); i++) {
			total += this.birdies.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getEagles() {
		return this.eagles;
	}
	
	public int getTotalEagles() {
		int total = 0;
		
		for (int i = 0; i < this.eagles.size(); i++) {
			total += this.eagles.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getAlbatrosses() {
		return this.getAlbatrosses();
	}
	
	public int getTotalAlbatrosses() {
		int total = 0;
		
		for (int i = 0; i < this.alba.size(); i++) {
			total += this.alba.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getHoleInOne() {
		return this.holeinone;
	}
	
	public int getTotalHoleInOne() {
		int total = 0;
		
		for (int i = 0; i < this.holeinone.size(); i++) {
			total += this.holeinone.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getBogey() {
		return this.bogeys;
	}
	
	public int getTotalBogeys() {
		int total = 0;
		
		for (int i = 0; i < this.bogeys.size(); i++) {
			total += this.bogeys.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getDoubleBogey() {
		return this.doublebogeys;
	}
	
	public int getTotalDoubleBogeys() {
		int total = 0;
		
		for (int i = 0; i < this.doublebogeys.size(); i++) {
			total += this.doublebogeys.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getTripleBogeys() {
		return this.triplebogeys;
	}
	
	public int getTotalTripleBogeys() {
		int total = 0;
		
		for (int i = 0; i < this.triplebogeys.size(); i++) {
			total += this.triplebogeys.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getBounceBackBirdie() {
		return this.bouncebackbirdie;
	}
	
	public int getTotalBounceBackBirdies() {
		int total = 0;
		
		for (int i = 0; i < this.bouncebackbirdie.size(); i++) {
			total += this.bouncebackbirdie.get(i);
		}
		return total;
	}
	
	public ArrayList<Integer> getBirdieStreak() {
		return this.birdiestreak;
	}
	
	public ArrayList<Integer> getParStreak() {
		return this.parstreak;
	}
	
	public int findAverage(ArrayList<Integer> list) {
		
	
	int total = 0;
	for(int i = 0; i < list.size(); i++) {
		total += list.get(i);
	}
	
	int avg = total/list.size();
	
	return avg;
	
	}
	
	
	public void update(scoringStatistics scores) {
		
		this.pars.add(scores.getPars());
		this.birdies.add(scores.getBirdies());
		this.eagles.add(scores.getEagles());
		this.alba.add(scores.getAlbatrosses());
		this.holeinone.add(scores.getHoleInOne());
		this.bogeys.add(scores.getBogey());
		this.doublebogeys.add(scores.getDoubleBogey());
		this.triplebogeys.add(scores.getTripleBogeys());
		this.bouncebackbirdie.add(scores.getBounceBackBirdie());
		this.birdiestreak.add(scores.getBirdieStreak());
		this.parstreak.add(scores.getParStreak());
		
	}
	
	public String toString() {
		
		String str = "";
		
		str += "Average Pars Per Round: " + findAverage(this.pars) + "\n";
		str += "Average Birdies Per Round: " + findAverage(this.birdies) + "\n";
		str += "Average Eagles Per Round: " + findAverage(this.eagles) + "\n";
		str += "Average Albatrosses Per Round: " + findAverage(this.alba) + "\n";
		str += "Average Hole in One's Per Round: " + findAverage(this.holeinone) + "\n";
		str += "Average Bogeys Per Round: " + findAverage(this.bogeys) + "\n";
		str += "Average Double Bogeys Per Round: " + findAverage(this.doublebogeys) + "\n";
		str += "Average Triple Bogeys Per Round: " + findAverage(this.triplebogeys) + "\n";
		str += "Average Bounce Back Birdies Per Round: " + findAverage(this.bouncebackbirdie) + "\n";
		str += "Average Birdie Streak Per Round: " + findAverage(this.birdiestreak) + "\n";
		str += "Average Par Streak Per Round: " + findAverage(this.parstreak) + "\n";
		
		
		return str;
		
	}
	
	

}



