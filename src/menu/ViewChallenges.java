package menu;

import java.util.LinkedList;

import actors.golfer;
import menus.input.SelectOptionMenu;
import pointsSystem.challenge;

public class ViewChallenges {
	
	private golfer player;
	
	public ViewChallenges(golfer golfer) {
		
		this.player = golfer;
		selectChallenges();
	}
	
	private void selectChallenges() {
		
		int choice;
		
		SelectOptionMenu challengeMenu = new SelectOptionMenu("Challenges");
		
		do {
			
			String[] options = new String[3];
			
			final String challenges = "Career Challenges";
			final String completed = "Completed Challenges";
			
			options[0] = "<--Back";
			options[1] = challenges;
			options[2] = completed;
			
			challengeMenu.updateOptions(options, true);

            //get user choice
            choice = challengeMenu.getUserInput();
            
            if (choice < 0) return;
            displayChallenges(choice);
			
		}
		
		while(choice != -1);
		
		
	}
	
	private void displayChallenges(int choice) {
		
		switch(choice) {
		
		case 1:
			this.player.getChallenges().getScoringChallenges();
			break;
		case 2:
			this.player.getChallenges().getCompletedScoringChallenges();
			break;
		}
		
		
	}

}
