
public class StudentMemoryBank implements MemoryBank {
	
	double price = 379;
	String name  ="�ڴ�:Ӣ�8GB DDR3 1600";
	
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
