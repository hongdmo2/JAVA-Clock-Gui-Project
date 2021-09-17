

public class Clock {
	private int second;  
	private int minute;
	private int hour;
	
	public Clock() {
		this.second = 0;
		this.minute = 0;
		this.hour = 0;
	}
	public Clock(int hour, int minute, int second) {
		this.second = second;
		this.minute = minute;
		this.hour = hour;
	}
	//Getters and Setters 
	public int getsecond() {
		return second;
	}
	public void setsecond(int second) {
		this.second = second;
	}
	public int getminute() {
		return minute;
	}
	public void setminute(int minute) {
		this.minute = minute;
	}
	public int gethour() {
		return hour;
	}
	public void sethour(int hour) {
		this.hour = hour;
	}
	
	
	
	// toString method to return a object information.
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
}
