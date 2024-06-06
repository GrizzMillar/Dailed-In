package menus.input;

import menus.input.Menu;

public class StringMenu extends Menu {

    private final boolean allowNumbers;

    /**
     * Constructor
     * @param title Title for menu
     */
    public StringMenu(String title, boolean allowNumbers){
        super(title);
        this.allowNumbers = allowNumbers;
    }

    /**
     * Print prompt for user
     */
    protected void display(){
        displayTitle();
        System.out.println();
    }

    /**
     * Get String input from user.
     * Validates that it is a non-null String
     * @return String input by user
     */
    public String getUserInput() {
        display();

        String inputString = "";

        boolean ok;
        do {
            System.out.print("Enter Name: ");
            try {
                inputString = this.getInput().nextLine().trim();
                ok = true;

                //validation of player name input (must be something)
                if (inputString.equals("")){
                    System.out.println("You must enter something.");
                    ok = false;
                }
                else if(inputString.length() > 20){
                    System.out.println("Please enter a name with no more than 20 characters");
                    ok = false;
                }
                else if(!inputString.matches("[a-zA-Z]+") ){
                    if(!allowNumbers && inputString.matches("[a-zA-Z]+[0-9]+") ){
                        System.out.println("Please enter a name with no numbers or special characters");
                        ok = false;
                    }

                        //!inputString.matches("[a-zA-Z]+") ||
                    //&& allowNumbers
                }
            }
            catch(Exception ex) {
                System.out.println("Error input. Try again.");
                ok = false;
            }
        } while (!ok);

        System.out.println();

        return inputString;
    }

    /**
     *
     * @param title String to set as title
     */
    public void setTitle(String title){this.title = title;}
}
