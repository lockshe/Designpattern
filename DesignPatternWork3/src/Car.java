
public class Car implements Observer {

	private String obName="车辆";
	@Override
	public void update() {
		// TODO 自动生成的方法存根
		System.out.println(obName+"正在通过马路");
	}
	public String getObName() {
		return obName;
	}
	public void setObName(String obName) {
		this.obName = obName;
	}
	
	
}
