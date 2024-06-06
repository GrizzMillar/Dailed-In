package menus.input;

import java.util.Scanner;

public class NumMenu {

    final private int max;
    final private int min;
    final private String title;
    private Scanner input;

    /**
     *
     * @param title menu title
     * @param max maximum allowable value (inclusive)
     * @param min minimum allowable value (inclusive)
     */
    public NumMenu(String title, int min, int max){
        this.title = title;
        this.max = max;
        this.min = min;
    }


    /**
     * Print menu to screen
     */
    
    protected void display() {
        //print title to screen
        displayTitle();
        System.out.println();
    }
    
    protected void displayTitle(){
        System.out.println(this.getTitle());
        for (int count = 0; count < this.getTitle().length(); count++) {
            System.out.print("+");
        }
    }
	 
	 protected String getTitle(){return this.title;}


    /**
     * Displays menu and gets user input.
     * Validates user input inc checking it's between the object's max and min values
     * @return user input integer
     */
    public int getUserInput() {
        display();

        int inputNum = 0;

        boolean ok = false;
        do {
            System.out.print("Enter Number: ");
            try {
                 inputNum = this.getInput().nextInt();
                if ( inputNum >= min && inputNum <= max ) {
                    ok = true;
                }
                else {
                    System.out.println("Enter a value between 2 and 6.");
                }
            }
            catch(Exception ex) {
                System.out.println("Error input.");
                this.getInput().nextLine();
            }
        } while (!ok);
        this.getInput().nextLine();

        return inputNum;
    }
    
    public Scanner getInput(){return this.input;}

}
