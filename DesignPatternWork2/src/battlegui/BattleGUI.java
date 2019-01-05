package battlegui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.omg.CORBA.PUBLIC_MEMBER;

import magic.FireMagic;
import magic.Magic;
import magic.MetalMagic;
import magic.WaterMagic;
import weapon.Hand;
import weapon.Katana;
import weapon.Sword;
import weapon.Weapon;

public class BattleGUI extends JFrame {

		public static BattleSystem battleSystem;
		public static JTextArea jTextArea01;
		public static JButton jButton01;
		public static JButton jButton02;
		public static JButton jButton03;
		public static JButton jButton04;
		public static JButton jButton05;
		public static JButton jButton06;
		public static ImageIcon icon1;
		public static ImageIcon icon2;
		public static JLabel label01;
		public static JLabel label02;
		public static JPanel panel;
		private static JScrollPane jScrollPane;
		public BattleGUI(BattleSystem battle){
			
			battleSystem=battle;
			
			setSize(1000, 1000);
			setLocationRelativeTo(null);
		    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    
			panel=new JPanel();
			jTextArea01=new JTextArea();
			panel.setLayout(null);
			

			
			jButton01=new JButton("金系魔法");
			jButton02=new JButton("火系魔法");
			jButton03=new JButton("水系魔法");
			jButton04=new JButton("金刚掌");
			jButton05=new JButton("流放者大刀");
			jButton06=new JButton("残虹剑");
	
			jButton01.setBounds(50, 600, 200, 50);
			jButton02.setBounds(50, 700, 200, 50);
			jButton03.setBounds(50, 800, 200, 50);
			jButton04.setBounds(300, 600, 200, 50);
			jButton05.setBounds(300, 700, 200, 50);
			jButton06.setBounds(300, 800, 200, 50);
			jTextArea01.setBounds(300, 50, 300, 500);

			jTextArea01.setBackground(Color.lightGray);
			panel.setBackground(Color.BLACK);
			panel.add(jButton01);
			panel.add(jButton02);
			panel.add(jButton03);
			panel.add(jButton04);
			panel.add(jButton05);
			panel.add(jButton06);
			panel.add(jTextArea01);

			setVisible(true);
			setContentPane(panel);
			
			 showData();
		}
		
	public static void updateInformation() throws InterruptedException {
		
		Thread.sleep(10);
		if(battleSystem.getRole().getRoleProperties()[0]==1) {
			icon1=new ImageIcon("monk.jpg");
		}else if(battleSystem.getRole().getRoleProperties()[0]==2) {
			icon1=new ImageIcon("nijna.jpg");
		}
		else if(battleSystem.getRole().getRoleProperties()[0]==3) {
			icon1=new ImageIcon("swordman.jpg");
		}
		
		if(battleSystem.getMonster().getProperties()==1) {
			icon2=new ImageIcon("littlemonster.jpg");
		}else if(battleSystem.getMonster().getProperties()==2) {
			icon2=new ImageIcon("middlemonster.jpg");
		}
		else if(battleSystem.getMonster().getProperties()==3) {
			icon2=new ImageIcon("bossmonster.jpg");
		}
		label01=new JLabel(icon1);
		label02=new JLabel(icon2);
		label01.setBounds(50, 50, 200, 500);
		label02.setBounds(650, 50, 300, 500);
		panel.add(label01);
		panel.add(label02);
		panel.revalidate();
	}
	
	
	public static void showData() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					battleSystem.start();
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	
	public static void Click() throws InterruptedException {
			
		while(battleSystem.getRole().getCurrchoice()==0) {
			
			

			jButton01.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					battleSystem.getRole().setCurrchoice(1);
					return;
				}
			});
			
			jButton02.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					battleSystem.getRole().setCurrchoice(2);
					return;
				}
			});
			
			jButton03.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					battleSystem.getRole().setCurrchoice(3);
					return;
				}
			});
			
			jButton04.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					battleSystem.getRole().setCurrchoice(4);
					return;
				}
			});
			
			jButton05.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					battleSystem.getRole().setCurrchoice(5);
					return;
				}
			});
			
			jButton06.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
	
					battleSystem.getRole().setCurrchoice(6);
					return;
				}
			});
		}
					
	}
	

}
