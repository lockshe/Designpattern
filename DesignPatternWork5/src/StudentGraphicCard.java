
public class StudentGraphicCard implements GraphicCard {
	
	double price = 1099;
	String name  ="œ‘ø®:”∞≥€GeForce GTX 1050Ti";
	
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
