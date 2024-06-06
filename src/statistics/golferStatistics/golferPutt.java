package statistics.golferStatistics;

import java.util.ArrayList;
import java.util.LinkedList;

import statistics.puttingStatistics;

public class golferPutt {
	
	private ArrayList<Integer> putts = new ArrayList<Integer>();
	private int avputts;
	private ArrayList<Integer> footageheld = new ArrayList<Integer>();
	private int avfootageheld;
	private ArrayList<Integer> oneputts = new ArrayList<Integer>();
	private int avoneputts;
	private ArrayList<Integer> twoputts = new ArrayList<Integer>();
	private int avtwoputts;
	private ArrayList<Integer> threeormoreputts = new ArrayList<Integer>();
	private int avthreeputts;
	private ArrayList<Integer> puttsinsidethree = new ArrayList<Integer>();
	private int avputtsinsidethree;
	private ArrayList<Integer> puttsinsidesix = new ArrayList<Integer>();
	private int avputtsinsidesix;
	private ArrayList<Integer> puttsinsideten = new ArrayList<Integer>();
	private int avputtsinsideten;
	private ArrayList<Integer> puttsinsidefithteen = new ArrayList<Integer>();
	private int avputtsinsidefithteen;
	
	
	public golferPutt() {
		
	}
	
	public int findAverage(ArrayList<Integer> list) {
		
	
	int total = 0;
	for(int i = 0; i < list.size(); i++) {
		total += list.get(i);
	}
	
	int avg = total/list.size();
	
	return avg;
	
	}
	
	
	public void update(puttingStatistics putting) {
		
		this.putts.add(putting.getTotalPutts());
		this.footageheld.add(putting.getFootageHeld());
		this.oneputts.add(putting.getOnePutts());
		this.twoputts.add(putting.getTwoPutts());
		this.threeormoreputts.add(putting.getTotalThreePutts());
		this.puttsinsidethree.add(putting.getThreeFeetPutts());
		this.puttsinsidesix.add(putting.getSixFeetPutts());
		this.puttsinsideten.add(putting.getTenFeetPutts());
		this.puttsinsidefithteen.add(putting.getFithteenFeetPutts());
		
	}
	
	public String toString() {
		
		String str = "";
		
		str += "Average Putts Per Round: " + findAverage(this.putts) + "\n";
		str += "Average Footage Held Per Round: " + findAverage(this.footageheld) + "\n";
		str += "Average One Putts Per Round: " + findAverage(this.oneputts) + "\n";
		str += "Average Two Putts Per Round: " + findAverage(this.twoputts) + "\n";
		str += "Average Three Putts Per Round: " + findAverage(this.threeormoreputts) + "\n";
		str += "Average Putts inside three feet Per Round: " + findAverage(this.puttsinsidethree) + "\n";
		str += "Average Putts inside six feet Per Round: " + findAverage(this.puttsinsidesix) + "\n";
		str += "Average Putts inside ten feet Per Round: " + findAverage(this.puttsinsideten) + "\n";
		str += "Average Putts inside fithteen feet Per Round: " + findAverage(this.puttsinsidefithteen) + "\n";
		
		
		return str;
		
	}
	
	

}


