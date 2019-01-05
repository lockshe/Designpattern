package monster;

public class MiddleMonster extends Monster{
	private static String name="ÊØÄ¹ÈË";

	private static double MaxLife=3000;
	private static double AttackValue=150;
	private static int properties=2;
	
	public boolean isAlive=true;
	public MiddleMonster() {
		super(name, MaxLife, AttackValue,properties);
	}

}
