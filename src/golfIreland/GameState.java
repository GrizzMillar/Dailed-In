package golfIreland;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import actors.golfer;
import pointsSystem.dailyChallenges;



public class GameState {

	private final golfer currentGolfer;
	private dailyChallenges daily = new dailyChallenges();
    private boolean isEnded = false;
    private boolean startTurnCanMove;
    private boolean toggleMove = false;


    public GameState(golfer currentGolfer){
        this.currentGolfer = currentGolfer;
      
    }
    
    public golfer getCurrentGolfer(){return this.currentGolfer;}
    
    public String getCurrentGolferDetails() {
    	
    	return this.currentGolfer.toString();
    }
    
    public dailyChallenges getDailyChallenges() {
    	return this.daily;
    }
    
    public void setChallenges(int one, int two, int three) {
    	
    	this.daily.setChallenges(one, two, three);
    }
   /* public GameState(Player[] allPlayers, Banker bank, List<Double> marketIndexHistory){
        this.allPlayers = Arrays.asList(allPlayers);
        this.bank = bank;
        this.marketIndexHistory = marketIndexHistory;
        this.numRolls = 0;
    }


    public void setBoard(Board board){
        this.board = board;
    }

    /**
     * selects player for the next turn. If there is only one non-bankrupt player left, it sets isEnded to true
     * @return Player whose turn it is
     */
   /* public Player nextPlayer(){
        Player currentPlayer;
        do {
            indexCurrentPlayer++;
            indexCurrentPlayer = indexCurrentPlayer % allPlayers.size();
            currentPlayer = allPlayers.get(indexCurrentPlayer);

            //if all the players other than one have been rejected game is over

        }while(currentPlayer.getIsBankrupt());

        loadCurrentPlayerData();
        return currentPlayer;
    }

    /**
     * update the stored data to the new currentPlayer object
     */
    
    /*
    private void loadCurrentPlayerData(){
        this.startTurnCanMove = this.allPlayers.get(indexCurrentPlayer).getCanMove();
        this.lastRoll = 0;
        this.numDoubleRolls = 0;
        this.numRolls = 0;
        this.toggleMove = false;
    }

    /**
     *
     * @return true if the PLayer can roll the dice
     */
    /*
    public boolean canRoll(){return numRolls - numDoubleRolls == 0;}

    public boolean canEndTurn(){
        return !canRoll();
    }

    /**
     *
     * @return true if the currentPlayer started their turn in jail
     */
    /*
    public boolean getStartInJail(){
        return !startTurnCanMove;
    }

    /**
     *
     * @return true if the currentPlayer is in jail
     */
    /*
    public boolean getInJail(){
        return !allPlayers.get(indexCurrentPlayer).getCanMove();
    }


    /**
     * Updates the required data after the player rolls the dice
     * @param a integer value rolled on dice 1
     * @param b ioteger value rolled on dice 2
     */
    /*
    public void rolled(int a, int b){
        boolean lastRollDouble = false;
        this.lastRoll = a+b;
        this.numRolls++;

        //if rolled a double updates stats
        if(a==b){
            this.numDoubleRolls++;
            lastRollDouble = true;
        }

        //if rolled more than one double but not yet 3 doubles in a row
        if(numDoubleRolls >= 1 && numDoubleRolls <3){
            //informs them of their double
            System.out.println("You rolled a double! Have another roll.");
        }
        //if rolled 3 doubles in a row
        else if(numDoubleRolls == 3){
            //moves to jail and informs them
            System.out.println("You have rolled 3 doubles in a row! Unfortunately this lead to you getting hacked.");
            toggleMove = true;
        }

        //if they rolled a double and was in jail
        if(lastRollDouble && !allPlayers.get(indexCurrentPlayer).getCanMove()){
            //releases player and infroms them
            System.out.println("You rolled a double! You have successfully prevented being hacked.");
            toggleMove = true;
        }
    }

    public boolean toggleMove(){
        return toggleMove;
    }

    public int getLastRoll(){
        return this.lastRoll;
    }

    public Banker getBanker(){
        return this.bank;
    }

    public List<Player> getAllPlayers(){ return this.allPlayers;}

    public Board getBoard(){return this.board;}

    public Player getCurrentPlayer(){return this.allPlayers.get(indexCurrentPlayer);}

    /**
     * @return players who are still playing (not bankrupt)
     */
    /*
    public List<Player> getActivePlayers(){
        List<Player> activePlayers = allPlayers;

        activePlayers.removeIf(Player::getIsBankrupt);

        return activePlayers;
    }
*/
    public void gameOver(){this.isEnded = true;}

    public boolean isEnded() {return this.isEnded;}
/*
    public void updateMarketIndex(double d){
        this.marketIndexHistory.add(0, this.marketIndexHistory.get(0) * d);
        this.marketIndexHistory.remove(11);
    }

    public List<Double> getMarketIndex(){return new LinkedList<>(this.marketIndexHistory);}
*/
}

