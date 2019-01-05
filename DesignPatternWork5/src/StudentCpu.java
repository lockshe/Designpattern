
public class StudentCpu implements Cpu {
	
	double price = 1039;
	String name  ="CPU:Intel-i7-4790k";
	
	public void display() {
		System.out.println(name);
	}
	
	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
