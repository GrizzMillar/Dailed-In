package menu;

import java.util.Scanner;

public abstract class Menu {

        protected String title;
        private final Scanner input;

        /**
         * Constructor
         * @param title	String title to be displayed
         */
        public Menu(String title){
            this.title = title;
            this.input = new Scanner(System.in);
        }

        /**
         * Prints the menu to screen
         */
        protected abstract void display();

        protected void displayTitle(){
            System.out.println(this.getTitle());
            for (int count = 0; count < this.getTitle().length(); count++) {
                System.out.print("+");
            }
        }

        /**
         * Displays the menu and reads the input selection from the user command line input
         * @return	Integer input by user
         */
        public Scanner getInput(){return this.input;}

    /**
     *
     * @return title
     */
    protected String getTitle(){return this.title;}

    }

