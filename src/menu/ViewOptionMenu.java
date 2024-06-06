package menu;

import menu.Menu;



public class ViewOptionMenu extends Menu {
    private String[] items;
    protected int startIndex;

    public ViewOptionMenu(String title, String[] data){
        super(title);
        this.items = data;
        this.startIndex = 1;
    }

    public ViewOptionMenu(String title){
        super(title);
    }

    /**
     * Prints the menu to screen
     */
    @Override
    public void display() {
        displayTitle();

        System.out.println();
        for (int option = startIndex; option < items.length+startIndex; option++) {
            System.out.println(option + ". " + items[option - startIndex]);
        }
        System.out.println();
    }


    /**
     * Updates the items[] attribute
     * @param data	String array containing new options to be displayed
     * @param hasBack Boolean true if has back at index 0, otherwise false
     */
    public void updateOptions(String[] data, boolean hasBack) {
        this.items = data;

        if(hasBack){
            startIndex = 0;
        }else{
            startIndex = 1;
        }
    }

    public String[] getItems(){return this.items;}


}

