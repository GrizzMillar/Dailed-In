package statistics;

import java.util.LinkedList;

import round.recordHole;

public class scoringStatistics {
	
	private int pars;
	private int birdies;
	private int eagles;
	private int alba;
	private int holeinone;
	private int bogeys;
	private int doublebogeys;
    private int tripleBogey;
    private int bouncebackbirdie;
    private int birdiestreak;
    private int parstreak;
    private int parsave;
    
	public scoringStatistics() {
		
	}
	
	public int getPars() {
		return this.pars;
	}
	
	public int getBirdies() {
		return this.birdies;
	}
	
	public int getEagles() {
		return this.eagles;
	}
	
	public int getAlbatrosses() {
		return this.alba;
	}
	
	public int getHoleInOne() {
		return this.holeinone;
	}
	
	public int getBogey() {
		return this.bogeys;
	}
	
	public int getDoubleBogey() {
		return this.doublebogeys;
	}
	
	public int getTripleBogeys() {
		return this.tripleBogey;
	}
	
	public int getBounceBackBirdie() {
		return this.bouncebackbirdie;
	}
	
	public int getBirdieStreak() {
		return this.birdiestreak;
	}
	
	public int getParStreak() {
		return this.parstreak;
	}
	
	public int getParSaves() {
		return this.parsave;
	}
	
	
	public void updateStats(LinkedList<recordHole> hole) {
		
		for (int i = 0; i < hole.size(); i++) {
		
			String score = hole.get(i).getScoreName();
			
		switch (score) {
		  case "Par":
		    this.pars ++;
		    break;
		  case "Birdie":
		    this.birdies ++;
		    break;
		  case "Eagle":
			  this.eagles ++;
		    break;
		  case "Albatross":
			  this.alba ++;
			  break;
		  case "HOLE IN ONE!":
			  this.holeinone ++;
		    break;
		  case "Bogey":
		    this.bogeys ++;
		    break;
		  case "Double Bogey":
		    this.doublebogeys ++;
		    break;
		  case "Triple Bogey":
		    this.tripleBogey ++;
		    break;
		}
		
		
		}
		
		
		//bounce back birdie check
		for(int i = 1; i < hole.size(); i++) {
			
            if(hole.get(i-1).getScoreName() == "Bogey" && hole.get(i).getScoreName() == "Birdie") {
            	
			this.bouncebackbirdie ++;
		}
		}
            
		//Birdie Streak Check
		for(int i =0; i < hole.size(); i++) {
          if(hole.get(i).getScoreName() == "Birdie") {
        	  int index = i;
        	  int birdiecount = 0;
        	 while(index < hole.size() && hole.get(index).getScoreName() == "Birdie") {
        		 index ++;
        		 birdiecount ++;
        		 
        		 if(birdiecount > this.birdiestreak) {
        			 this.birdiestreak = birdiecount;
        		 }
        		 
        		 
        	 }
          }
		}
		
		//Par Streak Check
		for(int i =0; i < hole.size(); i++) {
          if(hole.get(i).getScoreName() == "Par") {
        	  int index = i;
        	  int parcount = 0;
        	 while(index < hole.size() && hole.get(index).getScoreName() == "Par") {
        		 index ++;
        		 parcount ++;
        		 
        		 if(parcount > this.parstreak) {
        			 this.parstreak = parcount;
        		 }
        		 
        		 
        	 }
          }
		}
		
		//Par Save Check
		   for(int i = 0; i< hole.size(); i++) {
	        	  if(hole.get(i).getScoreName() == "Par") {
	        		  int size = hole.get(i).getShots().size();
	        		  if(hole.get(i).getShots().get(size - 3).getEndPosition() != "Green") {
	        			  this.parsave++;
	        		  }
	        	  }
	          }
		
		
		
	}
		
		public String toString() {
			
			String summary = "";
			
			summary += "Total Pars: " + this.getPars() + "\n";
			summary += "Total Birdies: " + this.getBirdies() + "\n";
			summary += "Total Eagles: " + this.getEagles() + "\n";
			summary += "Total Albatrosses: " + this.getAlbatrosses() + "\n";
			summary += "Total Hole in Ones: " + this.getHoleInOne()+ "\n";
			summary += "Total Bogeys: " + this.getBogey() + "\n";
			summary += "Total Double Bogeys: " + this.getDoubleBogey() + "\n";
			summary += "Total Triple Bogeys: " + this.getTripleBogeys() + "\n";
			summary += "\n";
			summary += "Bounce Back Birdies: " + this.getBounceBackBirdie() + "\n";
			summary += "Longest Birdie Streak: " + this.getBirdieStreak() + "\n";
			summary += "Longest Par Streaks: " + this.getParStreak() + "\n";
			summary += "Par Saves: " + this.getParSaves() + "\n";
			
			
			
			return summary;
			
		}
		
		public void setPars(int par) {
			this.pars = par;
		}
		
		public void setBirdies(int birdie) {
			this.birdies = birdie;
		}
		
		public void setEagles(int eagle) {
			this.eagles = eagle;
		}
		
		public void setAlbatrosses(int alba) {
			this.alba = alba;
		}
		
		public void setHoleInOne(int holeinone) {
			this.holeinone = holeinone;
		}
		
		public void setBogey(int bogey) {
			this.bogeys = bogey;
		}
		
		public void setDoubleBogey(int doubleBogey) {
			this.doublebogeys = doubleBogey;
		}
		
		public void setTripleBogeys(int triple) {
			this.tripleBogey = triple;
		}
		
		public void setBounceBackBirdie(int birdie) {
			this.bouncebackbirdie = birdie;
		}
		
		public void setBirdieStreak(int birdie) {
			this.birdiestreak = birdie;
		}
		
		public void setParStreak(int par) {
			this.parstreak = par;
		}
		
	}
	
	

