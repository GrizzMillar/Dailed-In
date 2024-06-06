package statistics;

import java.util.LinkedList;

import round.recordHole;

public class aroundTheGreen {

	private int upanddowns;
	private int updownchances;
	private int sandsaves;
	private int sandchances;
	private int roughupndown;
	private int roughupndownchances;

	public aroundTheGreen() {

	}

	public int getUpAndDowns() {

		return this.upanddowns;
	}

	public int getSandSaves() {

		return this.sandsaves;
	}

	public int getRoughUpNDowns() {
		return this.roughupndown;
	}

	public void updateStats(LinkedList<recordHole> hole) {

		for (int i = 0; i < hole.size(); i++) {

			int last = hole.get(i).getShots().size();

			if (hole.get(i).getShots().get(last - 3).getEndPosition() != "Green") {

				this.upanddowns++;
			}

			if (hole.get(i).getShots().get(last - 3).getEndPosition() == "Bunker") {

				this.sandsaves++;
			}
			
			if (hole.get(i).getShots().get(last - 3).getEndPosition() == "Rough") {

				this.roughupndown++;
			}

		}

	}

	public String toString() {

		String str = "";

		str += "Up and Downs: " + this.upanddowns + "\n";
		str += "Sand Saves: " + this.sandsaves + "\n";
		str += "Up and Downs from the rough: " + this.roughupndown + "\n";

		return str;
	}

}
