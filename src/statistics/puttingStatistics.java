package statistics;

import java.util.LinkedList;

import round.recordHole;
import round.recordShot;
import round.round;

public class puttingStatistics {

	private int totalputts;
	private int footageheld;
	private int oneputts;
	private int twoputts;
	private int threeormoreputts;
	private int puttsinsidethree;
	private int puttsinsidesix;
	private int puttsinsideten;
	private int puttsinsidefithteen;
	private int puttsinsidetwenty;
	private double avgputtperhole;
	private int longestputt;

	public puttingStatistics() {

	}

	public void setTotalPutts(int total) {

		this.totalputts += total;

	}

	public int getTotalPutts() {

		return this.totalputts;

	}

	public void setFootageHeld(int total) {

		this.footageheld += total;

	}

	public int getFootageHeld() {

		return this.footageheld;

	}

	public void setOnePutts(int total) {

		this.oneputts += total;

	}

	public int getOnePutts() {

		return this.oneputts;

	}

	public void setTwoPutts(int total) {

		this.twoputts += total;

	}

	public int getTwoPutts() {

		return this.twoputts;

	}

	public void setThreePutts(int total) {

		this.threeormoreputts += total;

	}

	public int getTotalThreePutts() {

		return this.threeormoreputts;

	}

	public void setThreeFeetPutts(int total) {

		this.puttsinsidethree += total;

	}

	public int getThreeFeetPutts() {

		return this.puttsinsidethree;

	}

	public void setSixFeetPutts(int total) {

		this.puttsinsidesix += total;

	}

	public int getSixFeetPutts() {

		return this.puttsinsidesix;

	}

	public void setTenFeetPutts(int total) {

		this.puttsinsideten += total;

	}

	public int getTenFeetPutts() {

		return this.puttsinsideten;

	}

	public void setFithteenFeetPutts(int total) {

		this.puttsinsidefithteen += total;

	}

	public int getFithteenFeetPutts() {

		return this.puttsinsidefithteen;

	}
	
	public int getPuttsInsideTwenty() {
		return this.puttsinsidetwenty;
	}
	
	public double getAvgPuttPerHole() {
		
		double avg = this.totalputts/18;
		this.avgputtperhole = avg;
		return this.avgputtperhole;
	}
	

	public void updateStats(LinkedList<recordHole> hole) {
		
		this.longestputt = 0;
		
		for(int i = 0; i < hole.size(); i++) {

		int size = hole.get(i).getShots().size();

		//need to change this for hole outs
		int yardage = hole.get(i).getShots().get(size - 1).getDistance();
		
		if(yardage > this.longestputt) {
			this.longestputt = yardage;
		}
		
		
		this.footageheld += yardage;

		if (yardage <= 3) {
			this.puttsinsidethree++;
		} else if (yardage <= 6) {
			this.puttsinsidesix++;
		} else if (yardage <= 10) {
			this.puttsinsideten++;
		} else if (yardage <= 15) {
			this.puttsinsidefithteen++;
		} else if (yardage <= 20) {
			this.puttsinsidetwenty++;
		}

		int total = 0;
		for (int j = 1; j <= hole.get(i).getShots().size()-1; j++) {
			if (hole.get(i).getShots().get(j - 1).getEndPosition().equals("Green")
					&& hole.get(i).getShots().get(j).getClub().equals("Putter")) {
				total++;
			}

		}

		this.totalputts += total;

		if (total == 1) {
			this.oneputts++;
		} else if (total == 2) {
			this.twoputts++;
		} else if (total >= 3) {
			this.threeormoreputts++;
		}
		}
		

	}

	
	public String toString() {

		String summary = "";

		summary += "Total Putts: " + this.getTotalPutts() + "\n";
		summary += "Average Putts Per Hole: " + this.getAvgPuttPerHole() + "\n";
		summary += "Footage Held: " + this.getFootageHeld() + "\n";
		summary += "Longest Putt held: " + this.longestputt + "\n";
		summary += "One Putts: " + this.getOnePutts() + "\n";
		summary += "Two Putts: " + this.getTwoPutts() + "\n";
		summary += "Three Putts: " + this.getTotalThreePutts() + "\n";
		summary += "Putts inside three feet: " + this.getThreeFeetPutts() + "\n";
		summary += "Putts inside six feet: " + this.getSixFeetPutts() + "\n";
		summary += "Putts inside ten feet: " + this.getTenFeetPutts() + "\n";
		summary += "Putts inside fithteen feet: " + this.getFithteenFeetPutts() + "\n";
		summary += "Putts inside twenty feet: " +  this.puttsinsidetwenty + "\n";
		

		return summary;
	}

}
