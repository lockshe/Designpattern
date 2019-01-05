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
		System.out.println("��ѡ�����Ĺ�����ʽ");
		BattleGUI.jTextArea01.append("��ѡ�����Ĺ�����ʽ");
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

		System.out.println(name+"��"+weapon.getWeaponname()+"ɱ��"+monster.getName());
		System.out.println("���"+getCurrAttackValue()+"���˺�");
		BattleGUI.jTextArea01.append(name+"��"+weapon.getWeaponname()+"ɱ��"+monster.getName());
		BattleGUI.jTextArea01.append("\r\n");
		BattleGUI.jTextArea01.append("���"+getCurrAttackValue()+"���˺�");
		BattleGUI.jTextArea01.append("\r\n");
		monster.setCurrLife(monster.getCurrLife()-CurrAttackValue);
		return monster;
	}
	
	public Monster chooseMagic(Monster monster) {

		
		if(CurrMagicValue<magic.getMagicValue()) {
			System.out.println("ħ��ֵ�����޷�ʹ�ø�ħ��");
			BattleGUI.jTextArea01.append("ħ��ֵ�����޷�ʹ�ø�ħ��");
			BattleGUI.jTextArea01.append("\r\n");
			return monster;
		}
		else {
			System.out.println(name+"��"+monster.getName()+"ʹ����"+magic.getMagicname());
			System.out.println("���"+getCurrAttackValue()+"���˺�");
			
			BattleGUI.jTextArea01.append(name+"��"+monster.getName()+"ʹ����"+magic.getMagicname());
			BattleGUI.jTextArea01.append("\r\n");
			
			BattleGUI.jTextArea01.append("���"+getCurrAttackValue()+"���˺�");
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
			System.out.println("��������ֵ��Ϊ�㣬ս��������you died");
			BattleGUI.jTextArea01.append("��������ֵ��Ϊ�㣬ս��������you died");
			BattleGUI.jTextArea01.append("\r\n");
			isAlive=false;
		}
		else {
			System.out.println("����ǰ����ֵΪ"+this.CurrLife);
			BattleGUI.jTextArea01.append("����ǰ����ֵΪ"+this.CurrLife);
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
			this.CurrAttackValue*=buff;//װ���ӳ�
			System.out.println("ʹ����"+weapon.getWeaponname()+"�Խ�ɫ�мӳɣ������������");
			BattleGUI.jTextArea01.append("ʹ����"+weapon.getWeaponname()+"�Խ�ɫ�мӳɣ������������");
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
			this.CurrAttackValue*=buff;//װ���ӳ�
			System.out.println("ʹ����"+magic.getMagicname()+"�Խ�ɫ�мӳɣ������������");
			BattleGUI.jTextArea01.append("ʹ����"+magic.getMagicname()+"�Խ�ɫ�мӳɣ������������");
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
