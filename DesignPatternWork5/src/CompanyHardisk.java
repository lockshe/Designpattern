
public class CompanyHardisk implements Hardisk {

	double price = 2399;
	String name  ="Ӳ��:����850 EVO SATA III��1TB��SSD";
	
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
