package statistics;

import java.util.LinkedList;

import round.recordHole;
import round.recordShot;

public class approachToTheGreen {

	private int greensinreg;
	private int gir200plus;
	private int gir150175;
	private int gir125;
	private int gir100;
	private int gir75100;
	private int gir75;
	private int girfromrough;
	private int girfromsemi;
	private int girfrombunker;

	public approachToTheGreen() {

	}

	public int getGreensInReg() {
		return this.greensinreg;
	}

	public int getGIR200Plus() {
		return this.gir200plus;
	}

	public int getGIR150175() {
		return this.gir150175;
	}

	public int getGIR125() {
		return this.gir125;
	}

	public int getGIR100() {
		return this.gir100;
	}

	public int getGIR75100() {
		return this.gir75100;
	}
	
	public int getGIR75() {
		return this.gir75;
	}

	public int getGIRRough() {
		return this.girfromrough;
	}

	public int getGIRSemi() {
		return this.girfromsemi;
	}

	public int getGIRBunker() {
		return this.girfrombunker;
	}

	public void updateStats(LinkedList<recordHole> hole) {

		for (int i = 0; i < hole.size(); i++) {
			int par = hole.get(i).getPar();
			if (par == 3) {
				if (hole.get(i).getShots().getFirst().getEndPosition().equals("Green")) {
					this.greensinreg++;
					findYardage(hole.get(i));
				}
			} else if (par == 4) {
				if (hole.get(i).getShots().getFirst().getEndPosition().equals("Green")
						|| hole.get(i).getShots().get(1).getEndPosition().equals("Green")) {
					this.greensinreg++;
					findYardage(hole.get(i));
				}
			} else if (par == 5) {
				if (hole.get(i).getShots().getFirst().getEndPosition().equals("Green")
						|| hole.get(i).getShots().get(1).getEndPosition().equals("Green")
						|| hole.get(i).getShots().get(2).getEndPosition().equals("Green")) {
					this.greensinreg++;
					findYardage(hole.get(i));
				}
			}

		}

	}

	public void findYardage(recordHole hole) {

		LinkedList<recordShot> shots = hole.getShots();
		int distance = 0;
		for (int i = 0; i < shots.size(); i++) {
			if (shots.get(i).getEndPosition().equals("Green")) {
				if(hole.getPar() != 3 && shots.get(i-1).getEndPosition().equals("Rough")) {
					this.girfromrough++;
				} else if(hole.getPar() != 3 && shots.get(i-1).getEndPosition().equals("Semi-Rough")) {
					this.girfromsemi++;
				} else if(hole.getPar() != 3 && shots.get(i-1).getEndPosition().equals("Fairway Bunker")) {
					this.girfrombunker++;
				}
				distance = shots.get(i).getDistance();
				break;
			}
		}

		if (distance >= 200) {
			this.gir200plus++;
		} else if (distance >= 150 && distance <= 175) {
			this.gir150175++;
		} else if (distance <= 125) {
			this.gir125++;
			if(distance >= 100) {
				this.gir100 ++;
			} else if (distance >= 75 && distance <= 100) {
				this.gir75100++;
			} else if (distance < 75) {
				this.gir75++;
			}
		} else if (distance >= 100) {
			this.gir100++;
		} 

	}

	public String toString() {

		String str = "";

		str += "Greens In Regulation: " + this.greensinreg + "/18" + "\n";
		str += "GIR 200+ yards: " + this.gir200plus + "\n";
		str += "GIR 150-175 yards: " + this.gir150175 + "\n";
		str += "GIR <125 yards: " + this.gir125 + "\n";
		str += "GIR 100+ yards: " + this.gir100 + "\n";
		str += "GIR 75-100 yards: " + this.gir75100 + "\n";
		str += "GIR <75 yards: " + this.gir75 + "\n";
		str += "GIR from the Rough: " +  this.girfromrough + "\n";
		str += "GIR from the Semi-Rough: " +  this.girfromsemi + "\n";
		str += "GIR from the Bunker: " +  this.girfrombunker + "\n";

		return str;
	}
}
