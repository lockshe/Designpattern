package weapon;

public class Weapon {
	
	private String weaponname;
	private int properties;
	private double atk;
	
	public Weapon() {
		
	}
	
	public Weapon(String weaponname,int properties,double atk) {
		this.weaponname=weaponname;
		this.properties=properties;
		this.atk=atk;
	}

	public String getWeaponname() {
		return weaponname;
	}

	public void setWeaponname(String weaponname) {
		this.weaponname = weaponname;
	}

	public int getProperties() {
		return properties;
	}

	public void setProperties(int properties) {бо
		this.properties = properties;
	}

	public double getAtk() {
		return atk;
	}

	public void setAtk(double atk) {
		this.atk = atk;
	}
	
}
