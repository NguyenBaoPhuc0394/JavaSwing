package clock;

public class CounterModel {
	private int point;
//	public CounterModel() {
//
//	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void increment() {
		this.point++;
	}
	public void decrement() {
		this.point--;
	}
	public void reset() {
		this.point = 0;
	}
}
