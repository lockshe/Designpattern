
public class CompanyCpu implements Cpu {
	double price = 4999;
	String name  ="CPU:Intel-i9-9900k";
	
	public void display() {
		System.out.println(name);
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

}
