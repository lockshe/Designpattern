
public class Ship implements Vehicle {

	public final double speed=30.0;
	public final String name="轮船";
	
	
	public void run() {
		System.out.println("已为您提供的交通工具-----》"+name);
		System.out.println("时速为"+speed+"km/h");
	}

}
