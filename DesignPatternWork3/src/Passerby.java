
public class Passerby implements Observer {

	private String obName="����";
	
	public void update() {
		System.out.println(obName+"����ͨ����·");
	}
	
	public String getObName() {
		return obName;
	}
	
	public void setObName(String obName) {
		this.obName = obName;
	}
}
