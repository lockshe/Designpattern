package monster;

import battlegui.BattleGUI;

public class Monster {
	private String name;

	private double MaxLife;
	private double CurrLife;
	private double AttackValue;
	private int properties;


	public boolean isAlive=true;
	
	public Monster() {
		
	}
	
	public Monster(String name,double MaxLife,double AttackValue,int properties) {
		this.name=name;
		this.MaxLife=MaxLife;
		this.CurrLife=MaxLife;
		this.AttackValue=AttackValue;
		this.properties=properties;
	}
	
	public boolean isalive() {
		if(this.CurrLife<=0) {
			System.out.println(name+"的生命值已为零，战斗结束，you win");
			BattleGUI.jTextArea01.append(name+"的生命值已为零，战斗结束，you win");
			BattleGUI.jTextArea01.append("\r\n");
			isAlive=false;
		}
		else {
			System.out.println(name+"当前生命值为"+this.CurrLife);
			BattleGUI.jTextArea01.append(name+"当前生命值为"+this.CurrLife);
			BattleGUI.jTextArea01.append("\r\n");
		}
		return isAlive;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxLife() {
		return MaxLife;
	}

	public void setMaxLife(double maxLife) {
		MaxLife = maxLife;
	}

	public double getCurrLife() {
		return CurrLife;
	}

	public void setCurrLife(double currLife) {
		CurrLife = currLife;
	}
	public double getAttackValue() {
		return AttackValue;
	}
	public void setAttackValue(double attackValue) {
		AttackValue = attackValue;
	}

	public int getProperties() {
		return properties;
	}

	public void setProperties(int properties) {
		this.properties = properties;
	}
	
	
}
