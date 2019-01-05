package role;

import java.util.Random;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

import battlegui.BattleGUI;
import magic.FireMagic;
import magic.Magic;
import magic.MetalMagic;
import magic.WaterMagic;
import monster.Monster;
import weapon.Hand;
import weapon.Katana;
import weapon.Sword;
import weapon.Weapon;

public class Role {
	
	private String name;
	private double MaxLife;
	private double CurrLife;
	private double MaxMagicValue;
	private double CurrMagicValue;
	private double BasicAttackValue;
	private double CurrAttackValue;
	private int[] RoleProperties;

	private int currchoice;
	
	boolean isAlive=true;
	
	private Weapon weapon;
	private Magic magic;
	public Role() {
		
	}
	
	public Role(String name,double MaxLife,double MaxMagicValue,double BasicAttackValue,int[] RoleProperties) {
		this.name=name;
		this.MaxLife=MaxLife;
		this.CurrLife=MaxLife;
		this.MaxMagicValue=MaxMagicValue;
		this.CurrMagicValue=MaxMagicValue;
		this.BasicAttackValue=BasicAttackValue;
		this.CurrAttackValue=BasicAttackValue;
		this.RoleProperties=RoleProperties;
	}
	
	public Monster chooseAttackMethod(Monster monster) throws InterruptedException {
		System.out.println("请选择您的攻击方式");
		BattleGUI.jTextArea01.append("请选择您的攻击方式");
		BattleGUI.jTextArea01.append("\r\n");
		BattleGUI.Click();;
		if (currchoice>3) {
			switch(currchoice) {
			case 4: setWeapon(new Hand());
					setCurrchoice(0);
					break;
			case 5:setWeapon(new Katana());
					setCurrchoice(0);
					break;
				
			case 6:setWeapon(new Sword());
					setCurrchoice(0);
					break;
			}
			return chooseWeapon(monster);
		}else {
			
			switch(currchoice) {
			case 1: setMagic(new MetalMagic());
					setCurrchoice(0);
					break;
			case 2:	setMagic(new FireMagic());
					setCurrchoice(0);
					break;
			case 3:	setMagic(new WaterMagic());
					setCurrchoice(0);
					break;
			}

			return chooseMagic(monster);

		}

	}
	
	public Monster chooseWeapon(Monster monster) {

		System.out.println(name+"用"+weapon.getWeaponname()+"杀向"+monster.getName());
		System.out.println("造成"+getCurrAttackValue()+"点伤害");
		BattleGUI.jTextArea01.append(name+"用"+weapon.getWeaponname()+"杀向"+monster.getName());
		BattleGUI.jTextArea01.append("\r\n");
		BattleGUI.jTextArea01.append("造成"+getCurrAttackValue()+"点伤害");
		BattleGUI.jTextArea01.append("\r\n");
		monster.setCurrLife(monster.getCurrLife()-CurrAttackValue);
		return monster;
	}
	
	public Monster chooseMagic(Monster monster) {

		
		if(CurrMagicValue<magic.getMagicValue()) {
			System.out.println("魔法值不足无法使用该魔法");
			BattleGUI.jTextArea01.append("魔法值不足无法使用该魔法");
			BattleGUI.jTextArea01.append("\r\n");
			return monster;
		}
		else {
			System.out.println(name+"对"+monster.getName()+"使用了"+magic.getMagicname());
			System.out.println("造成"+getCurrAttackValue()+"点伤害");
			
			BattleGUI.jTextArea01.append(name+"对"+monster.getName()+"使用了"+magic.getMagicname());
			BattleGUI.jTextArea01.append("\r\n");
			
			BattleGUI.jTextArea01.append("造成"+getCurrAttackValue()+"点伤害");
			BattleGUI.jTextArea01.append("\r\n");
			monster.setCurrLife(monster.getCurrLife()-CurrAttackValue);
			return monster;
		}
	}
	

	public void reset() {
		setCurrLife(MaxLife);
		setCurrAttackValue(BasicAttackValue);
		setCurrMagicValue(MaxMagicValue);
	}
	
	public boolean isalive() {
		if(this.CurrLife<=0) {
			System.out.println("您的生命值已为零，战斗结束，you died");
			BattleGUI.jTextArea01.append("您的生命值已为零，战斗结束，you died");
			BattleGUI.jTextArea01.append("\r\n");
			isAlive=false;
		}
		else {
			System.out.println("您当前生命值为"+this.CurrLife);
			BattleGUI.jTextArea01.append("您当前生命值为"+this.CurrLife);
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
	public double getMaxMagicValue() {
		return MaxMagicValue;
	}
	public void setMaxMagicValue(double maxMagicValue) {
		MaxMagicValue = maxMagicValue;
	}
	public double getCurrMagicValue() {
		return CurrMagicValue;
	}
	public void setCurrMagicValue(double currMagicValue) {
		CurrMagicValue = currMagicValue;
	}
	public double getBasicAttackValue() {
		return BasicAttackValue;
	}
	public void setBasicAttackValue(double basicAttackValue) {
		BasicAttackValue = basicAttackValue;
	}
	public double getCurrAttackValue() {
		return CurrAttackValue;
	}
	public void setCurrAttackValue(double currAttackValue) {
		CurrAttackValue = currAttackValue;
	}
	public int getCurrchoice() {
		return currchoice;
	}

	public void setCurrchoice(int currchoice) {
		this.currchoice = currchoice;
	}

	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		this.CurrAttackValue=this.BasicAttackValue+weapon.getAtk();
		if(this.RoleProperties[1]==weapon.getProperties()) {
			Random random=new Random();
			double buff=random.nextInt(1)+1;
			this.CurrAttackValue*=buff;//装备加成
			System.out.println("使用了"+weapon.getWeaponname()+"对角色有加成，攻击力提高了");
			BattleGUI.jTextArea01.append("使用了"+weapon.getWeaponname()+"对角色有加成，攻击力提高了");
			BattleGUI.jTextArea01.append("\r\n");
		}
	}
	public Magic getMagic() {
		return magic;
	}
	public void setMagic(Magic magic) {
		this.magic = magic;
		this.CurrAttackValue=this.BasicAttackValue+magic.getDamage();
		if(this.RoleProperties[0]==magic.getProperties()) {
			Random random=new Random();
			double buff=random.nextInt(1)+1;
			this.CurrAttackValue*=buff;//装备加成
			System.out.println("使用了"+magic.getMagicname()+"对角色有加成，攻击力提高了");
			BattleGUI.jTextArea01.append("使用了"+magic.getMagicname()+"对角色有加成，攻击力提高了");
			BattleGUI.jTextArea01.append("\r\n");
		}
	}

	public int[] getRoleProperties() {
		return RoleProperties;
	}

	public void setRoleProperties(int[] roleProperties) {
		RoleProperties = roleProperties;
	}
	
	
}
