package pointsSystem;

public class prestige {
	
	private int number;
	private int level;
	private int points;

	public prestige(int number, int level, int points) {
		this.number = number;
		this.level = level;
		this.points = points;
		
	}
	
public void setNumber(int number) {
		
		this.number = number;
	}
	
	public void setLevel(int level) {
		
		this.level = level;
	}
	
public void setPoints(int points) {
		
		this.points = points;
	}

public void addPoints(int points) {
	this.points += points;
	
	if(this.points >= 1000) {
		this.points = this.points - 1000;
		levelUp();
	}
}

public void levelUp() {
	this.level += 1;
	
	if(this.level >= 61 ) {
		this.level = 0;
		this.number += 1;
	}
}

public int getNumber() {
	
	return this.number;
}

public int getLevel() {
	
	return this.level;
}

public int getPoints() {
	
	return this.points;
}

public String toString() {
	
	String str = "";
	
	str += "Prestige: " + this.getNumber() + "\n";
	str += "Level: " + this.getLevel() + "\n";
	str += "Points: " + this.getPoints() + "\n";
	
	return str;
}

	
	
}
