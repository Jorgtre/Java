package Utility;

public class Timer {
	private long stime = System.currentTimeMillis();
	private long ctime;
	private int time;
	private boolean active;
	
	public Timer(){
		
	}
	public void update(){
		ctime = System.currentTimeMillis();
		if ((ctime - stime) / 1000 > time && active)	{time++;}
	}
	public int getTime(){
		return time;
	}
	
	
}
