package monster;

public class LittleMonster extends Monster{
	private static String name="Сආ�";

	private static double MaxLife=1000;
	private static double AttackValue=100;
	private static int properties=1;
	
	public boolean isAlive=true;

	public LittleMonster() {
		super(name, MaxLife, AttackValue,properties);
	}

}
