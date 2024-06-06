package menus.input;

public class ConfirmChoiceMenu extends SelectOptionMenu {

    /**
     * Constructor
     * Creates a menu with yes/no options for user to confirm a choice
     * @param title Title of menu to be displayed
     */
    public ConfirmChoiceMenu(String title){
        super(title,  new String[]{"Yes", "No"}, false);
    }
}
