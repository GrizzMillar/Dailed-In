package menu;

import actors.golfer;
import round.recordHole;
import round.recordShot;
import round.round;

public class testMenu {

	public static void main(String[] args) {
		
		round testround2 = new round("Port", 71, "Whites", 1, "07/12/2022");

		recordShot testshot1 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot testshot2 = new recordShot(2, 200, "7Iron", 20, "Semi-Rough");
		recordShot testshot3 = new recordShot(3, 20, "Lob Wedge", 2, "Green");
		recordShot testshot4 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole4 = new recordHole(1, 400, 4);

		testHole4.addShots(testshot1);
		testHole4.addShots(testshot2);
		testHole4.addShots(testshot3);
		testHole4.addShots(testshot4);

		testround2.addHoles(testHole4);

		recordShot testshot5 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot testshot6 = new recordShot(2, 200, "7Iron", 20, "Semi-Rough");
		recordShot testshot7 = new recordShot(3, 20, "Lob Wedge", 2, "Green");
		recordShot testshot8 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole5 = new recordHole(1, 400, 4);

		testHole5.addShots(testshot5);
		testHole5.addShots(testshot6);
		testHole5.addShots(testshot7);
		testHole5.addShots(testshot8);

		testround2.addHoles(testHole5);

		recordShot testshot9 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot testshot10 = new recordShot(2, 200, "7Iron", 20, "Green");
		recordShot testshot11 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot testshot12 = new recordShot(4, 2, "Putter", 0, "Hole");

		recordHole testHole6 = new recordHole(1, 400, 4);

		testHole6.addShots(testshot9);
		testHole6.addShots(testshot10);
		testHole6.addShots(testshot11);
		testHole6.addShots(testshot12);

		testround2.addHoles(testHole6);

		recordShot testshot13 = new recordShot(1, 400, "Driver", 200, "Green");
		recordShot testshot14 = new recordShot(2, 60, "Putter", 20, "Green");
		recordShot testshot15 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot testshot16 = new recordShot(4, 2, "Putter", 0, "Hole");

		recordHole testHole7 = new recordHole(1, 400, 4);

		testHole7.addShots(testshot13);
		testHole7.addShots(testshot14);
		testHole7.addShots(testshot15);
		testHole7.addShots(testshot16);

		testround2.addHoles(testHole7);
		testround2.initStats();
		testround2.setScore(72);

		round test = new round("Port", 71, "Whites", 1, "07/12/2022");

		recordShot test1 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot test2 = new recordShot(2, 200, "7Iron", 20, "Semi-Rough");
		recordShot test3 = new recordShot(3, 20, "Lob Wedge", 2, "Green");
		recordShot test4 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole = new recordHole(1, 400, 5);

		testHole.addShots(test1);
		testHole.addShots(test2);
		testHole.addShots(test3);
		testHole.addShots(test4);

		test.addHoles(testHole);

		recordShot test5 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot test6 = new recordShot(2, 200, "7Iron", 20, "Green");
		recordShot test7 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot test8 = new recordShot(4, 2, "Putter", 0, "Hole");

		recordHole testHole1 = new recordHole(1, 400, 4);

		testHole1.addShots(test5);
		testHole1.addShots(test6);
		testHole1.addShots(test7);
		testHole1.addShots(test8);

		test.addHoles(testHole1);

		recordShot test9 = new recordShot(1, 400, "Driver", 40, "Green");
		recordShot test10 = new recordShot(2, 40, "Putter", 20, "Green");
		recordShot test11 = new recordShot(3, 20, "Putter", 2, "Green");
		recordShot test12 = new recordShot(4, 4, "Putter", 0, "Hole");

		recordHole testHole2 = new recordHole(1, 400, 3);

		testHole2.addShots(test9);
		testHole2.addShots(test10);
		testHole2.addShots(test11);
		testHole2.addShots(test12);

		test.addHoles(testHole2);

		recordShot test13 = new recordShot(1, 400, "Driver", 200, "Fairway");
		recordShot test14 = new recordShot(2, 200, "7Iron", 20, "Semi-Rough");
		recordShot test15 = new recordShot(3, 20, "Lob Wedge", 5, "Green");
		recordShot test16 = new recordShot(4, 5, "Putter", 1, "Green");
		recordShot test99 = new recordShot(5, 5, "Putter", 0, "Hole");

		recordHole testHole3 = new recordHole(1, 400, 4);

		testHole3.addShots(test13);
		testHole3.addShots(test14);
		testHole3.addShots(test15);
		testHole3.addShots(test16);
		testHole3.addShots(test99);

		test.addHoles(testHole3);
		test.initStats();
		test.setScore(72);


		//golfer luke = new golfer("Luke" ,"Millar", 4, "Portsteart");
		//luke.getChallenges().setScoringChallenges();
		
		//ViewChallenges test = new ViewChallenges(luke);
		
		
		
		System.out.println(compareRounds(test, testround2));
	

	}
	
	public static String compareRounds(round round1, round round2) {
		
		String str = "";
		
		int rndonescore = round1.returnScore();
		int rndtwoscore = round2.returnScore();
		int scorediff = rndonescore - rndtwoscore;
		
		int rndonepars = round1.getRoundStats().getScoreStats().getPars();
		int rndtwopars = round2.getRoundStats().getScoreStats().getPars();
		int pardiff = rndonepars - rndtwopars;
		
		int rndonebirdies = round1.getRoundStats().getScoreStats().getBirdies();
		int rndtwobirdies = round2.getRoundStats().getScoreStats().getBirdies();
		int birdiediff = rndonebirdies - rndtwobirdies;
		
		int rndonebogeys = round1.getRoundStats().getScoreStats().getBogey();
		int rndtwobogeys = round2.getRoundStats().getScoreStats().getBogey();
		int bogeydiff = rndonebogeys - rndtwobogeys;
		
		int rndonedbogeys = round1.getRoundStats().getScoreStats().getDoubleBogey();
		int rndtwodbogeys = round2.getRoundStats().getScoreStats().getDoubleBogey();
		int dbogeydiff = rndonedbogeys - rndtwodbogeys;
		
		int rndoneputts = round1.getRoundStats().getPuttStats().getTotalPutts();
		int rndtwoputts = round2.getRoundStats().getPuttStats().getTotalPutts();
		int puttsdiff = rndoneputts - rndtwoputts;
		
		if(Math.signum(scorediff) == -1.0) {
			str += "Youre score improved by " + scorediff + "Shots" + "\n";
		} else if(Math.signum(scorediff) == 1){
			str += "Youre score increased by " + scorediff + "Shots" + "\n";
		} else {
			str += "Youre score did not change " + "\n";
		}
		
		str += "Your total number of pars " + getCompareMessage(pardiff); 
		str += "Your total number of birdies " + getCompareMessage(birdiediff);
		str += "Your total number of bogeys " + getCompareMessage(bogeydiff);
		str += "Your total number of double bogeys " + getCompareMessage(dbogeydiff);
		str += "Your total number of putts " + getCompareMessage(puttsdiff);
			
		return str;
		
	}
	
	public static String getCompareMessage(int diff) {
		
		String str = "";
		
		if(Math.signum(diff) == -1.0) {
			str += "improved by " + diff + "\n";
		} else if(Math.signum(diff) == 1){
			str += "decreased by " + diff + "\n";
		} else {
			str += "did not change " + "\n";
		}
		
		return str;
		
	}
	

}
