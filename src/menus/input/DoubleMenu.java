package menus.input;

public class DoubleMenu extends Menu{

    final private double max;
    final private double min;

    /**
     *
     * @param title menu title
     * @param max maximum allowable value (inclusive)
     * @param min minimum allowable value (inclusive)
     */
    public DoubleMenu(String title, double min, double max){
        super(title);
        this.max = max;
        this.min = min;
    }

    /**
     * Print menu to screen
     */
    @Override
    protected void display() {
        //print title to screen
        displayTitle();
        System.out.println();
    }

    /**
     * Displays menu and gets user input.
     * Validates user input inc checking it's between the object's max and min values
     * @return user input integer
     */
    public double getUserInput() {
        display();

        double inputNum = 0;

        boolean ok = false;
        do {
            System.out.print("Enter Number: ");
            try {
                inputNum = this.getInput().nextDouble();
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

        System.out.println();

        return inputNum;
    }


}
