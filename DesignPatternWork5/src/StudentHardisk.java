
public class StudentHardisk implements Hardisk {
	
	double price = 319;
	String name  ="Ӳ��:��������M.2 2280��240GB��SSD";
	
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
