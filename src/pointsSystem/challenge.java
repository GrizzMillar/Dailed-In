package pointsSystem;

public class challenge {
	
	private String name;
	private int points;
	private String description;
	private boolean completion;
	private int expected;
	
	public challenge(String name, int points, boolean completion, int expected) {
		
		this.name = name;
		this.points = points;
		this.completion = completion;
		this.expected = expected;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setDescription(String des) {
		
		this.description = des;
		
	}
	
	public String getDescription() {
		
		return this.description;
	}
	
	public void setCompletion(boolean comp) {
		
		this.completion = comp;
	}
	
	public boolean getCompletion() {
		
		return this.completion;
	}
	
	public int getExpected() {
		
		return this.expected;
	}

	
public boolean checkNumber(int expected, int returned) {
		
		boolean passed = false;
		
		if(returned >= expected) {
			passed = true;
		}
		
		return passed;
		
	}
}
