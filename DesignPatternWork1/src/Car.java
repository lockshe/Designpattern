
public class Car implements Vehicle {
	
	public final double speed=60.0;
	public final String name="����";
	@Override
	public void run() {

		System.out.println("��Ϊ���ṩ�Ľ�ͨ����-----��"+name);
		System.out.println("ʱ��Ϊ"+speed+"km/h");
		
	}

}
