package magic;

public class Magic {
	private String magicname;
	private int properties;
	private double magicValue;
	private double damage;
	
	public Magic(String magicname,int properties,double magicValue,double damage) {
		this.magicname=magicname;
		this.properties=properties;
		this.magicValue=magicValue;
		this.damage=damage;
	}
	
	public String getMagicname() {
		return magicname;
	}
	public void setMagicname(String magicname) {
		this.magicname = magicname;
	}
	public int getProperties() {
		return properties;
	}
	public void setProperties(int properties) {
		this.properties = properties;
	}
	public double getMagicValue() {
		return magicValue;
	}
	public void setMagicValue(double magicValue) {
		this.magicValue = magicValue;
	}
	public double getDamage() {
		return damage;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}
	
	
}
