
public class StudentMainboard implements Mainboard {

	double price = 599;
	String name  ="Ö÷°å£º¼¼¼ÎB450M DS3H";
	
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
