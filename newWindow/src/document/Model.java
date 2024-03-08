package document;

public class Model {
	private String num;
	private String key;
	private String vanBan;
	Model(){
		num = "";
		vanBan = "";
		key = "";
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVanBan() {
		return vanBan;
	}
	public void setVanBan(String vanBan) {
		this.vanBan = vanBan;
	}
	public void count() {
		int p = 0;
		int c = 0;
		while(true) {
			int i = this.vanBan.indexOf(key,p);
			if(i == -1) {
				break;
			}
			else {
				p = i + 1;
				c++;
			}
		}
		this.num = String.valueOf(c);
	}
}
