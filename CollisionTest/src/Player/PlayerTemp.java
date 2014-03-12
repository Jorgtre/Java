package Player;

public class PlayerTemp {
	private float X;
	private float Y;
	private float vlx;
	private float vly;
	private int W;
	private int H;
	
	public PlayerTemp(int x, int y, int w, int h){
		this.X = x;
		this.Y = y;
		this.W = w;
		this.H = h;
	}

	public void setX(int x) {
		this.X = x;
	}
	public void setY(int y) {
		this.Y = y;
	}
	public void setW(int w) {
		this.W = w;
	}
	public void setH(int h) {
		this.H = h;
	}
	public void setVlx(float vlx){
		this.vlx = vlx;
	}
	public void setVly(float vly){
		this.vly = vly;
	}
	public float getX(){
		return X;
	}
	public float getY(){
		return Y;
	}
	public int getW(){
		return W;
	}
	public int getH(){
		return H;
	}
	public float getVlx(){
		return vlx;
	}
	public float getVly(){
		return vly;
	}
	public void addToVlx(float velocity){
		this.vlx += velocity;
	}
	public void addToVly(float velocity){
		this.vly += velocity;
	}
	public void addToX(float value){
		this.X += value;
	}
	public void addToY(float value){
		this.Y += value;
	}
	
	
	
	public void move(){
		X += vlx;
		Y += vly;
		
	}
	
}
