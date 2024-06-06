package attributes;

import java.util.ArrayList;

public class club {

	private String club;
	private String series;
	private String manufacturer;
	private double avgDist;
	private ArrayList<Double> distance = new ArrayList<Double>();
	
	
	public club(String club, String series, String manufacturer) {
		
		this.club = club;
		this.series = series;
		this.manufacturer = manufacturer;
		
		
	}
	
	public void setClub(String club) {
		this.club = club;
	}
	
	
	public String getClub() {
		return this.club;
	}
	
	public ArrayList<Double> getDistance() {
		
		return this.distance;
	}
	
	public void setManufacturer(String manu) {
		this.manufacturer = manu;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	public void setSeries(String series) {
		this.series = series;
	}
	
	public String getSeries() {
		return this.series;
	}
	
	public String toString() {
		
		String data = "Club: " + this.getClub() + " Manufacturer: " + this.getManufacturer() + " Series: " + this.getSeries();
		
		return data;
		
	}
	
	public void addDist(double dis) {
		this.distance.add(dis);
	}
	
	public double avDis() {
		
		double av = 0;
		double length = this.distance.size();
		for(int i =0; i < this.distance.size(); i++) {
			av += this.distance.get(i);
		}
		
		this.avgDist = av/length;
		
		return this.avgDist;
	}
}

