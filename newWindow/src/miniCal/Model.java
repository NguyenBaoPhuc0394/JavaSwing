package miniCal;

public class Model {
	private double first;
	private double second;
	private double result;
	
	public Model() {
		
	}
	
	public double getFirst() {
		return first;
	}

	public void setFirst(double first) {
		this.first = first;
	}

	public double getSecond() {
		return second;
	}

	public void setSecond(double second) {
		this.second = second;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public void plus() {
		this.result = this.first + this.second;
	}
	public void minus() {
		this.result = this.first - this.second;
	}
	public void multiply() {
		this.result = this.first * this.second;
	}
	public void divide() {
		this.result = this.first / this.second;
	}
	public void mod() {
		this.result = this.first % this.second;
	}
	public void power() {
		this.result = Math.pow(this.first,this.second);
	}
}	
	
