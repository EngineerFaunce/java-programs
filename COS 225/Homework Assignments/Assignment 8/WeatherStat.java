package wFaunceA8;

public class WeatherStat {
	private String month;
	private int temp;
	
	public WeatherStat() {
		month = "";
		temp = 0;
	}
	
	public WeatherStat(String m, int t) {
		month = m;
		temp = t;
	}
	
	public getMonth() {
		return month;
	}
	
	public getTemp() {
		return temp;
	}
	
	public void setMonth(String m) {
		month = m;
	}
	
	public void setTemp(int t) {
		temp = t;
	}
	
}