package menus.input;

public class SelectOptionMenu1 extends Menu {
	private String[] items;
	private int startIndex;

	/**
	 * Constructor
	 * @param title	String title to be displayed
	 * @param data 	String array of the options to be displayed
	 */
	public SelectOptionMenu1(String title, String[] data, boolean hasBack) {
		super(title);
		this.items = data;

		if(hasBack){
			startIndex = 0;
		}else{
			startIndex = 1;
		}
	}

	/**
	 * Constructor
	 * @param title String title to be displayed
	 */
	public SelectOptionMenu1(String title){
		super(title);
	}

	/**
	 * Updates the items[] attribute
	 * @param data	String array containing new options to be displayed
	 */
	public void updateOptions(String[] data, boolean hasBack) {
		this.items = data;

		if(hasBack){
			startIndex = 0;
		}else{
			startIndex = 1;
		}
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

	/**]
	 * Displays the menu and reads the input selection from the user command line input
	 * @return	Integer input by user
	 */
	public int getUserInput() {
		if ( items == null || items.length == 0 ) {
			return 0;
		}
		int value = 0;
		display();
		boolean ok = false;
		do {
			System.out.print("Enter Selection: ");
			try {
				value = this.getInput().nextInt();
				if ( (value >= startIndex && value <= items.length) ) {
					ok = true;
				}
				else {
					System.out.println("Enter a value between " +startIndex +" and " + items.length);
				}
			}
			catch(Exception ex) {
				System.out.println("Error input.");
				this.getInput().nextLine();
			}
		} while (!ok);

		return value;
	}


}

