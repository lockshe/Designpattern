package monster;

public class BossMonster extends Monster {
	private static String name="∆Ô øπ≈¥Ô";

	private static double MaxLife=6000;
	private static double AttackValue=300;
	private static int properties=3;
	public boolean isAlive=true;

	public BossMonster() {
		super(name, MaxLife, AttackValue,properties);
	}
}
