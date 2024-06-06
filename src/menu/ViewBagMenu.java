package menu;

import java.util.LinkedList;

import actors.golfer;
import menus.input.SelectOptionMenu1;
import round.round;
import attributes.club;
import golfIreland.playerRound;



public class ViewBagMenu {
	
	private final golfer player;

	
	public ViewBagMenu(golfer golfer) {
		
		this.player = golfer;
		
		selectClub();
	}
	
	private void selectClub(){
        LinkedList<club> clubs = new LinkedList<>();
        int choice;

        //create a menu containing all the companies as options
        SelectOptionMenu1 selectClub = new SelectOptionMenu1("Select a Club.") ;

       do {
                clubs = new LinkedList<>(player.displayClubs());
            

            //if the player doesn't own any companies, they are returned to the main menu
            if(clubs.size() == 0){
                System.out.println("You have no clubs.");
                return;
            }
            /*if Player they are viewing doesn't own any companies, they are returned to the main menu
            else if(companies.size() == 0 && viewOnly){
                System.out.println("They do not own any companies.");
            }*/

            //creating an array of string names of the company owned by the player
            String[] options = new String[clubs.size()+1];

            //add a back option to the start of the list
            options[0] = "<-- Back";

            //populating an array of string names of the companies owned by the player
            for(int i=1; i<clubs.size()+1; i++){
                options[i] = clubs.get(i-1).getClub();
            }

            //update options on select options menu
            selectClub.updateOptions(options, true);

            //get user choice
            choice = selectClub.getUserInput()-1;

            if (choice < 0) return;
            //calls method to present actions associated with that company
            actionClub(clubs.get(choice));
            //prints company info
           // else System.out.println(companies.get(choice));

        }
        //show menu until user select back option
        while(choice != -1);
    }

private void actionClub(club club){
    //List to hold menu options in
    LinkedList<String> options = new LinkedList<>();

    //All the menu options that can be presented
    final String back = "<-- Back";
    final String viewClubInfo = "View info";
    final String viewClubStatistics = "View statistics";
    //final String product = "Product";
    //final String franchise = "Franchise";
    //final String develop = "Develop ";
    //final String sell = "Sell ";
    //final String sellCompany = "Sell Company";
    //final String mortgageCompany = "Mortgage Company";
    //final String rename = "Rename Company";

    options.add(back);
    options.add(viewClubInfo);
    options.add(viewClubStatistics);

    //adding menu options
    /*if(round instanceof playerRound){
        playerRound[] fieldCompanies = round.getField().getCompanies();

        //checking if player owns a full field/set of companies
        int ownCount =0;
        for(RollCompany c: fieldCompanies){
            if(c.getOwner() == player){
                ownCount++;
            }
        }

        //allows player to buy/sell products/franchises if they own full field/set
        if (ownCount == fieldCompanies.length){
            int upgradeLevel = ((Company) company).getUpgradeLevel();

            //adding sell product/franchise menu options if company is appropriately upgraded already
            if(upgradeLevel > 0 && upgradeLevel <=4){
                options.add(sell + product);
            }else if(upgradeLevel == 5){
                options.add(sell + franchise);
            }

            //adding buy product/franchise menu options if company can be upgraded and not in sellOnly mode
            if (upgradeLevel < 4 && !sellOnly){
                options.add(develop + product);
            }else if(upgradeLevel == 4 && !sellOnly){
                options.add(develop + franchise);
            }
        }
    }

    //adding non-conditional options
    options.add(sellCompany);
    //TODO think of equivalent of mortgaging company
    options.add(mortgageCompany);
    //renaming the company
    options.add(rename);
*/
    //creates a menu with the options added
    SelectOptionMenu1 selectAction = new SelectOptionMenu1(club.getClub() +" - What would you like to do?", options.toArray(new String[0]), true);


    /*Displays menu until the user has finished with it. When:
     * - They sell the property
     * - Select 'Back'
     * - Decline to sell property
     * - Buyer of property declines to purchase it
     */
    
    boolean hasFinished = false;
    while(!hasFinished){
    	

        //process options from menu
        switch (options.get(selectAction.getUserInput()).trim()){

            //presenting previous menu if back selected
            case back:
                hasFinished = true;
                break;

            //Displays company info
            case viewClubInfo:
                System.out.println(club.toString());
                break;
                
            case viewClubStatistics:
            	
            	System.out.println("Club average distance is " + club.avDis() + " yards");
            	
            	break;

            //selling product/franchise
           /* case sell + product:
            case sell + franchise:
                ((Company) company).sellHouse(-1);
                break;

            //buying product/franchise
            case develop + product:
            case develop + franchise:
                ((Company) company).buyHouse();

            case sellCompany:
                //Ask player if they are sure they want to sell the company
                ConfirmChoiceMenu confirmSell  = new ConfirmChoiceMenu("Are you sure you want to sell "
                        +company.getName() +" for " +company.getPriceString());

                //if they do not want to sell the company, end method
                if(confirmSell.getUserInput() == 2){
                    hasFinished = true;
                    break;
                }

                //if the company is being purchased by another player, check the player buying it is happy to purchase it
                if (!(buyer instanceof Banker)){
                    //print company purchase price and prompt to confirm purchase
                    System.out.println("You have £" + buyer.getMoney() +"M.");
                    ConfirmChoiceMenu confirmBuy = new ConfirmChoiceMenu("Are you sure you want to buy "
                            +company.getName() +" for " +company.getPriceString());

                    //if they do not want to buy it, end method
                    if(confirmBuy.getUserInput() == 2){
                        hasFinished = true;
                        break;
                    }
                }

                //transfer of company from seller to buyer and funds from buyer to seller
                boolean hasBought = company.buyCompany(buyer, player, false);
                //informs of successful purchase if it is successful
                if(hasBought){
                    System.out.println("You have sold " +company.getName() + " to " + buyer.getName()
                            +" for " +company.getPriceString());
                    player.addTransactions("You have sold " +company.getName() + " to " + buyer.getName()
                            +" for " +company.getPriceString());
                }

                hasFinished = true;
                break;

            //TODO
            case mortgageCompany:
                System.out.println("This has not been implemented yet.");  
                break;
                
            case rename:
                //Ask player what they would like to rename the company to
            	StringMenu changeName = new StringMenu("What would you like to call this company? " , false);
            	String reName = changeName.getUserInput();
            	company.setName(reName);
            	System.out.println("You have changed the company name to " + reName );
            	
                break;

*/
                
        }
    }
}
	
	
}
