
public class Car implements Observer {

	private String obName="����";
	@Override
	public void update() {
		// TODO �Զ����ɵķ������
		System.out.println(obName+"����ͨ����·");
	}
	public String getObName() {
		return obName;
	}
	public void setObName(String obName) {
		this.obName = obName;
	}
	
	
}
