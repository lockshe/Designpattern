
public class Passerby implements Observer {

	private String obName="行人";
	
	public void update() {
		System.out.println(obName+"正在通过马路");
	}
	
	public String getObName() {
		return obName;
	}
	
	public void setObName(String obName) {
		this.obName = obName;
	}
}
