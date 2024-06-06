package round;

import java.util.LinkedList;
import java.util.Scanner;

import actors.golfer;
import attributes.club;
import menu.ViewBagMenu;
import menu.ViewRoundMenu;
import menus.input.ConfirmChoiceMenu;
import menus.input.IntMenu;
import menus.input.SelectOptionMenu1;
import menus.input.StringMenu;


public class recordShotTester {

	public static void main(String[] args) {
		
		golfer luke = new golfer("Luke", "Millar", 4, "Porstewart");
		club test = new club("8Iron", "AP3", "Titliest");
		luke.addClub(test);
		//test.addDist(170);
		//test.addDist(190);
		//test.addDist(120);
		//test.addDist(210);
		//test.addDist(230);
		//test.addDist(80);
		
		ViewBagMenu menu = new ViewBagMenu(luke);
		
		//System.out.println(test.avDis());
		/*golfer luke = new golfer("Luke", "Millar", 4, "Porstewart");
		club test = new club("8Iron", "AP3", "Titliest");
		club test2 = new club("7Iron", "M2", "Titliest");
		luke.addClub(test);
		luke.addClub(test2);
		
		SelectOptionMenu1 selectClub = new SelectOptionMenu1("Select a club.");
		int choice;
		String clb;
		
		 LinkedList<club> clubs = new LinkedList<>();
	        

	              clubs = new LinkedList<>(luke.displayClubs());
	            

	            //creating an array of string names of the company owned by the player
	            String[] options = new String[clubs.size()+1];

	            //add a back option to the start of the list
	            options[0] = "<-- Back";

	            //populating an array of string names of the companies owned by the player
	            for(int i=1; i<clubs.size()+1; i++){
	                options[i] = clubs.get(i-1).getClub();
	            }
	            
	            
	            //Scanner input = new Scanner(System.in);
	            //int choice = input.nextInt();
	            
	            selectClub.updateOptions(options, true);
	            
	            choice = selectClub.getUserInput();
	            
	            clb = options[choice];
	            System.out.println(clb);
	           
	            
	            
	*/
	}

}
