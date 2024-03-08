package mouseE;

public class Model {
	private int x,y;
	private int count;
	private boolean check;
	
	public Model() {
		this.x = 0;
		this.y = 0;
		this.count = 0;
		this.check = false;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int addClick) {
		this.count = addClick;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public void addClick() {
		this.count++;
	}
	public void enter() {
		this.check = true;
	}
	public void exit() {
		this.check = false;
	}
}
