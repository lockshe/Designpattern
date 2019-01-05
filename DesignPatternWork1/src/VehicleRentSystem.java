import java.util.HashMap;
import java.util.Scanner;

public class VehicleRentSystem {
	
	private Vehicle vehicle;
	private long driverID;
	private static HashMap<Long, Vehicle> rentlist=new HashMap<>();
	
	public void driverLogin() {
		System.out.println("=======================================");
		System.out.println("欢迎来到杨氏租赁行，请输入您的通用驾驶证号码");
		System.out.println("========================================");
		Scanner scanner=new Scanner(System.in);
		this.driverID=scanner.nextLong();
		if(rentlist.containsKey(driverID)) {
			System.out.println("================================");
			System.out.println("您已在我行租过车，不能再租其他的了");
			System.out.println("================================");
			Vehicle vehicle=rentlist.get(driverID);
			vehicle.run();
		}
		else {
			rentSevice();
		}
	}
	public void addDriver(Long driverId,Vehicle vehicle) {
		rentlist.put(driverID, vehicle);
	}
	
	public void rentSevice() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("===================================");
		System.out.println("请输入您想租赁交通工具的时速，单位km/h");
		System.out.println("===================================");
		double needSpeed=scanner.nextDouble();
		this.vehicle=(Vehicle)XMLUtil.getBean(needSpeed);
		addDriver(driverID, vehicle);
		vehicle.run();
	}
	
	
	public static void main(String[] args) {
		VehicleRentSystem system1=new VehicleRentSystem();
		while (true) {
			system1.driverLogin();
		}
	}

}
