package statistics;

import java.util.ArrayList;

import actors.golfer;
import attributes.club;
import round.recordHole;
import round.recordShot;
import round.round;

public class statisticsTester {

	public static void main(String[] args) {


		round test = new round("Port", 71, "Whites", 1, "07/12/2022");

		for (int i = 1; i <=4; i++) {

			recordShot test1 = new recordShot(1, 400, "Driver", 200, "Fairway");
			recordShot test2 = new recordShot(2, 200, "7Iron", 20, "Rough");
			recordShot test3 = new recordShot(3, 20, "Lob Wedge", 2, "Green");
			recordShot test4 = new recordShot(4, 4, "Putter", 0, "Hole");

			recordHole testHole = new recordHole(i, 400, 4);

			testHole.addShots(test1);
			testHole.addShots(test2);
			testHole.addShots(test3);
			testHole.addShots(test4);

			test.addHoles(testHole);

		}

		for (int i = 5; i <=8; i++) {

			recordShot test5 = new recordShot(1, 500, "Driver", 200, "Fairway");
			recordShot test6 = new recordShot(2, 300, "3Wood", 75, "Semi-Rough");
			recordShot test7 = new recordShot(3, 74, "Lob Wedge", 10, "Green");
			recordShot test8 = new recordShot(4, 10, "Putter", 3, "Green");
			recordShot test9 = new recordShot(5, 3, "Putter", 0, "Hole");

			recordHole testHole1 = new recordHole(i, 500, 5);

			testHole1.addShots(test5);
			testHole1.addShots(test6);
			testHole1.addShots(test7);
			testHole1.addShots(test8);
			testHole1.addShots(test9);

			test.addHoles(testHole1);

		}

		for (int i = 9; i <=14 ; i++) {
			recordShot test9 = new recordShot(1, 210, "4Iron", 20, "Bunker");
			recordShot test10 = new recordShot(2, 20, "Lob Wedge", 2, "Green");
			recordShot test11 = new recordShot(3, 2, "Putter", 0, "Hole");

			recordHole testHole2 = new recordHole(i, 210, 3);

			testHole2.addShots(test9);
			testHole2.addShots(test10);
			testHole2.addShots(test11);

			test.addHoles(testHole2);
		}

		for (int i = 15; i <=18; i++) {
			recordShot test13 = new recordShot(1, 400, "Driver", 200, "Rough");
			recordShot test14 = new recordShot(2, 200, "7Iron", 20, "Green");
			recordShot test15 = new recordShot(3, 20, "Putter", 2, "Green");
			recordShot test16 = new recordShot(4, 2, "Putter", 0, "Hole");

			recordHole testHole3 = new recordHole(i, 400, 4);

			testHole3.addShots(test13);
			testHole3.addShots(test14);
			testHole3.addShots(test15);
			testHole3.addShots(test16);

			test.addHoles(testHole3);
		}

		// puttingStatistics testputt = new puttingStatistics(test);

		/*
		 * for(int i = 0; i < test.getHoles().size(); i++) {
		 * testputt.updateStats(test.getHoles().get(i));
		 * 
		 * }
		 */

		// test.setPuttStats(testputt);
		// System.out.println(testputt.toString());
		// test.setPuttStats();
		// System.out.println(test.getPuttingStats());
		// test.getRoundDetails();
		/*
		 * int par = 4; int score = 4; int acc = par - score; String name = "";
		 * 
		 * if(acc == 0) { name = "double bogey"; } System.out.println(name);
		 */

		// System.out.println(testHole.getScoreName());

		// System.out.println(testHole1.getScoreName());

		// scoringStatistics score = new scoringStatistics();

		// test.initStats();

		// System.out.println(test.getScoreStats());

		// System.out.println(test.getScoreStats());
		// System.out.println(test.getPuttingStats());

		// round newround = new round("Rush", 71, "Whites", 1, "07/12/2022");

		golfer luke = new golfer("Luke", "Millar", 6, "Portstewart");
		// club iron = new club("7iron", "APEX", "Taylormade");
		// luke.addClub(iron);

		// newround.fillRound(luke);
		// System.out.println(newround.getStatistics());

		// roundStatistics rnd = new roundStatistics();
		// rnd.initialiseStats(newround.getHoles());
		// System.out.println(rnd.toString());
		// newround.initStats();
		// System.out.println(newround.getStatistics());

		aroundTheGreen aroundGreen = new aroundTheGreen();
		aroundGreen.updateStats(test.getHoles());
		
		offTheTee tee = new offTheTee();
		tee.updateStats(test.getHoles());
		
		approachToTheGreen green = new approachToTheGreen();
		green.updateStats(test.getHoles());
		
		scoringStatistics scores = new scoringStatistics();
		scores.updateStats(test.getHoles());
		
		puttingStatistics putts = new puttingStatistics();
		
	    putts.updateStats(test.getHoles());
		
		
		System.out.println(aroundGreen.toString());
		System.out.println(tee.toString());
		System.out.println(green.toString());
		System.out.println(scores.toString());
		System.out.println(putts.toString());
		

	}


}
