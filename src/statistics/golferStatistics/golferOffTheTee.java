package statistics.golferStatistics;

import java.util.ArrayList;

import statistics.offTheTee;

public class golferOffTheTee {
	
	private ArrayList<Double> longestDrive = new ArrayList<Double>();
	private ArrayList<Double> avgdrivingdistance = new ArrayList<Double>();
	private ArrayList<Double> fairwayshit = new ArrayList<Double>();
	private ArrayList<Double> missedfairways = new ArrayList<Double>();
	private ArrayList<Double> roughtendency = new ArrayList<Double>();
	private ArrayList<Double> fairwaybunkertendency = new ArrayList<Double>();
	
	public golferOffTheTee() {
		
	}
	
	public void updateStats(offTheTee stats) {
		
		this.longestDrive.add(stats.getLongestTeeShot());
		this.avgdrivingdistance.add(stats.getAvgDis());
		this.fairwayshit.add(stats.getFairwayPercentage());
		
		
	}
	
	/*public int getLongestDrive() {
		return this.longestDrive;
	}
	
	public int getAvgDrivingDistance() {
		return this.avgdrivingdistance;
	}
	
	public int getFairwaysHit() {
		return this.fairwayshit;
	}
	
	public int getMissedFairways() {
		return this.missedfairways;
	}
	
	public int getRoughTendency() {
		return this.roughtendency;
	}
	
	public int getFairwayBunkerTendency() {
		return this.fairwaybunkertendency;
	}
	*/
	public double getAverage(ArrayList<Double> list) {

		double av = 0;
		double length = list.size();
		for (int i = 0; i < list.size(); i++) {
			av += list.get(i);
		}

		double average = av / length;

		return average;

	}
	
	public String toString() {
		
		String str = "";
		
		str += "Longest Drive: " + this.getAverage(this.longestDrive) + "\n";
		str += "Average driving distance: " + this.getAverage(this.avgdrivingdistance) + "\n";
		str += "Average fairway percentage: " + this.getAverage(this.fairwayshit) + "%" + "\n";
		str += "";
		
		return str;
	}

}
