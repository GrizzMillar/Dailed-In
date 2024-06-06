package attributes;

import actors.golfer;
import menu.ViewBagMenu;

public class clubTester {

	public static void main(String[] args) {
		
		golfer luke = new golfer("Luke", "Millar", 2, "Portstewart");
		club testClub = new club("7Iron", "M2", "Taylormade");
		
		luke.addClub(testClub);
		int shot1 = 100;
		int shot2 = 200;
		
		luke.displayClubs().get(0).addDist(shot1);
		luke.displayClubs().get(0).addDist(shot2);
		
		
		ViewBagMenu testmenu = new ViewBagMenu(luke);

	}

}
