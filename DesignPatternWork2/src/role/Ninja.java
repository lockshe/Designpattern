package role;

public class Ninja extends Role {
	
	private static String name="»Ã’ﬂ";
	private static double MaxLife=1500;
	private static double MaxMagicValue=1000;
	private static double BasicAttackValue=300;
	private static int[] RoleProperties= {2,3};//ª Ù–‘£¨…∆”√µ∂
	
	public Ninja(String str) {
		super(name+str,MaxLife,MaxMagicValue,BasicAttackValue,RoleProperties);
	}
	
}
