
public class CompanyGraphicCard implements GraphicCard {
	

	double price = 9999;
	String name  ="�Կ�:�߲ʺ�iGame GeForce RTX 2080 Ti";
	
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
