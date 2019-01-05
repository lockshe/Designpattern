
public class StudentHardisk implements Hardisk {
	
	double price = 319;
	String name  ="硬盘:西部数据M.2 2280（240GB）SSD";
	
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
