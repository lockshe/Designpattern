package battlegui;
import java.util.Random;
import java.util.Scanner;

import monster.BossMonster;
import monster.LittleMonster;
import monster.MiddleMonster;
import monster.Monster;
import role.Monk;
import role.Ninja;
import role.Role;
import role.Swordman;

public class BattleSystem {
	private Role role;
	private Monster monster;
	
	public BattleSystem(int choice,String name) {
		
		switch (choice) {
		case 1:
			Monk monk = new Monk(name);
			setRole(monk);
			break;
		case 2:
			Ninja ninja=new Ninja(name);
			setRole(ninja);
			break;
			
		case 3:
			Swordman swordman=new Swordman(name);
			setRole(swordman);
			break;
			
		default:
			break;
		}
		
	}
	
	public void start() throws InterruptedException {
		
		System.out.println("========����Ѱ�ҹ���===========");
	
		BattleGUI.jTextArea01.append("======����Ѱ�ҹ���========");
		BattleGUI.jTextArea01.append("\r\n");
		
		int research;
		Random random=new Random();
		research=random.nextInt(100);
		if(research<50) {
			LittleMonster littleMonster =new LittleMonster();
			setMonster(littleMonster);
		}
		else if(research<70) {
			MiddleMonster middleMonster=new MiddleMonster();
			setMonster(middleMonster);
		}
		else {
			BossMonster bossMonster =new BossMonster();
			setMonster(bossMonster);
		}

		BattleGUI.updateInformation();
		
		System.out.println("���ҵ�����=====��"+monster.getName()+"ս����ʼ");
		BattleGUI.jTextArea01.append("���ҵ�����=====��"+monster.getName()+"ս����ʼ");
		BattleGUI.jTextArea01.append("\r\n");
		while(monster.isalive()&&role.isalive()) {
		
			monster=role.chooseAttackMethod(monster);
			System.out.println(monster.getName()+"��"+role.getName()+"�����˽���");
			System.out.println("�����"+monster.getAttackValue()+"���˺�");
			BattleGUI.jTextArea01.append(monster.getName()+"��"+role.getName()+"�����˽���");
			BattleGUI.jTextArea01.append("\r\n");
			BattleGUI.jTextArea01.append("�����"+monster.getAttackValue()+"���˺�");
			BattleGUI.jTextArea01.append("\r\n");
			role.setCurrLife(role.getCurrLife()-monster.getAttackValue());
			Thread.sleep(5000);
		}
	}
	
	public void run() throws InterruptedException {

		while(true) {

			System.out.println("��ӭ����DarkSoulϵͳ,1===��ʼ��֣�2===����������Ϣ 3=====�˳�ϵͳ");
			int choice;
			Scanner scanner=new Scanner(System.in);
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				start();
				break;
			case 2:
				role.reset();
				break;
			case 3:
				return;
			}
			
		}
	}

	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Monster getMonster() {
		return monster;
	}
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	

	
}
