
public class Airplane implements Vehicle {

	public final double speed=150.0;
	public final String name="�ɻ�";
	@Override
	public void run() {

		System.out.println("��Ϊ���ṩ�Ľ�ͨ����-----��"+name);
		System.out.println("ʱ��Ϊ"+speed+"km/h");
		
	}
}
