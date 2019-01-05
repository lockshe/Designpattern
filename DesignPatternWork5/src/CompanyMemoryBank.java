
public class CompanyMemoryBank implements MemoryBank {


	double price = 2599;
	String name  ="ÄÚ´æ:º£µÁ´¬¸´³ðÕßLPX 32GB DDR4";
	
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
