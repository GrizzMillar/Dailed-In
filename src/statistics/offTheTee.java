package statistics;

import java.util.ArrayList;
import java.util.LinkedList;

import round.recordHole;

public class offTheTee {

	private int fairways;
	private int numoffairways;
	private double fairwaypercentage;
	private double avgdis;
	private double longest;
	private ArrayList<Double> dist = new ArrayList<Double>();

	public offTheTee() {

	}

	public void updateStats(LinkedList<recordHole> holes) {
		for (int i = 0; i < holes.size(); i++) {
			if (holes.get(i).getPar() != 3 && holes.get(i).getShots().get(0).getEndPosition().equals("Fairway")) {
				this.numoffairways++;
				this.fairways++;

				double distance = holes.get(i).getShots().get(0).getDistance()
						- holes.get(i).getShots().get(0).getEndDistance();
				this.dist.add(distance);

			} else if (holes.get(i).getPar() != 3 && holes.get(i).getShots().get(0).getEndPosition() != "Fairway") {
				this.numoffairways++;

				double distance = holes.get(i).getShots().get(0).getDistance()
						- holes.get(i).getShots().get(0).getEndDistance();
				this.dist.add(distance);
			}
			double percentage = this.setFairwayPercentage(this.fairways, this.numoffairways);
			this.fairwaypercentage = percentage;
			
		}
	}

	public void setTotalFairways(int total) {

		this.fairways += total;

	}

	public int getTotalFairways() {

		return this.fairways;

	}
	
	public double getFairwayPercentage() {
		return this.fairwaypercentage;
	}

	public void setAvgDis(int total) {

		this.avgdis += total;

	}

	public double getAvgDis() {

		double av = 0;
		double length = this.dist.size();
		for (int i = 0; i < this.dist.size(); i++) {
			av += this.dist.get(i);
		}

		this.avgdis = av / length;

		return this.avgdis;

	}

	public void setLongestTeeShot(int longest) {

		this.longest = longest;
	}

	public double getLongestTeeShot() {

		double longer = 0;

		for (int i = 0; i < this.dist.size(); i++) {
			if (this.dist.get(i) > longer) {
				longer = this.dist.get(i);
			}

		}

		this.longest = longer;
		return this.longest;
	}
	

	public double setFairwayPercentage(double stat, double chance) {

		double percentage = stat / chance * 100;

		return percentage;

	}

	public String toString() {

		String summary = "";


		summary += "Total Fairways: " + this.fairways + "/" + this.numoffairways + " " + this.fairwaypercentage + "%" + "\n";
		summary += "Average distance of the tee: " + this.getAvgDis() + "\n";
		summary += "Longest Tee Shot: " + this.getLongestTeeShot() + "\n";

		return summary;
	}

}
