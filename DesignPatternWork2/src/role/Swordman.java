package role;


public class Swordman extends Role {
	
	private static String name="����";
	private static double MaxLife=2000;
	private static double MaxMagicValue=2000;
	private static double BasicAttackValue=200;
	private static int[] RoleProperties= {3,1};//ˮ���ԣ����ý�
	
	public Swordman(String str) {
		super(name+str,MaxLife,MaxMagicValue,BasicAttackValue,RoleProperties);
	}
	
}
