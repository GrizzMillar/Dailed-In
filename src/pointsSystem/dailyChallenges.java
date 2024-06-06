package pointsSystem;
import round.round;

public class dailyChallenges {
	
	private String dailyChallenge1;
	private String dailyChallenge2;
	private String dailyChallenge3;
	

	public dailyChallenges() {
		
	}
	
	public void setChallenges(int challenge1, int challenge2, int challenge3) {
		
	   /*setChallenge1(challenge1);
	   setChallenge2(challenge2);
	   setChallenge3(challenge3);*/
		
		this.dailyChallenge1 = setChallenge(challenge1);
		this.dailyChallenge2 = setChallenge(challenge2);
		this.dailyChallenge3 = setChallenge(challenge3);
		   
	   }
	
	 public String setChallenge(int challenge) {
			
		   String chal = "";
		   switch(challenge) {
		   
		   case 1: 
			   chal = "Pick up three birdie's in your round";
			   break;
			   
		   case 2: 
			   chal = "Bounce Back Biride";
			   break;
			   
		   case 3: 
			   chal = "No driver Birdie";
			   break;
			   
		   case 4:
			   chal = "No challenge"; 
			   break;
		   }
		   
		   return chal;
}
	   
	   
	   
	   public String getChallenges() {
		   
		   return this.dailyChallenge1 + ", " + this.dailyChallenge2 + ", " + this.dailyChallenge3;
	   }
	
	public boolean check(round round, String score, int number, boolean isSearch,boolean bounceBack, boolean noDriver) {
		 
		boolean pass = false;
		
		//Check for certain amount of score's in round
		if (isSearch == true) {
		int num = 0;
		
		for(int i = 0; i < round.getHoles().size(); i++) {
			if (round.getHoles().get(i).getScoreName() == score) {
				num++;
			}
		}
		
		if (num >= number) {
			pass = true;
		} else {
			pass = false;
		}
		
		//Bounce Back Birdie Check
		} else if(bounceBack == true){
			for(int i = 1; i < round.getHoles().size(); i++) {
				if (round.getHoles().get(i).getScoreName() == "Birdie" && round.getHoles().get(i-1).getScoreName() == "Bogey" || round.getHoles().get(i-1).getScoreName() == "Double Bogey" ) {
					pass = true;
				} else {
					continue;
				}
				
			}
	    //Check for birdie without driver
		} else {
			for(int i = 1; i < round.getHoles().size(); i++) {
				if (round.getHoles().get(i).getScoreName() == "Birdie" && round.getHoles().get(i).getShots().get(0).getClub() != "Driver") {
					pass = true;
				} else {
					continue;
				}
				
			}
			
		}
		
		return pass;
	}
	
	
	
	
	
	
	
}
