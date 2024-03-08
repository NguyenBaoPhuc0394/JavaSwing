package loginSystem;
import java.util.HashMap;
public class Passwords {
	private HashMap<String,String>data = new HashMap<String,String>();
	public Passwords() {
		data.put("java", "1995");
		data.put("python", "1990");
		data.put("C++", "1982");
		data.put("golang", "2009");
	}
	public HashMap<String, String> getData() {
		return data;
	}
	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
	
}
