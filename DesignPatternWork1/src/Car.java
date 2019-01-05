
public class Car implements Vehicle {
	
	public final double speed=60.0;
	public final String name="汽车";
	@Override
	public void run() {

		System.out.println("已为您提供的交通工具-----》"+name);
		System.out.println("时速为"+speed+"km/h");
		
	}

}
