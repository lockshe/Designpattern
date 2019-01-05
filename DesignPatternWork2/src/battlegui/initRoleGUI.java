package battlegui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.omg.CORBA.PUBLIC_MEMBER;


public class initRoleGUI  {

	public static BattleSystem battleSystem;
	public static void initrole() {
		JFrame frame=new JFrame("创建角色");
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		JButton okButton=new JButton("确定");
		JTextField textField=new JTextField();


		JPanel panel01=new JPanel();
		JPanel panel02=new JPanel();
		JPanel panel03=new JPanel();
		
		ImageIcon icon1=new ImageIcon("monk.jpg");
		ImageIcon icon2=new ImageIcon("nijna.jpg");
		ImageIcon icon3=new ImageIcon("swordman.jpg");
		

		JLabel label01=new JLabel("大侠，请输入尊姓大名");
		JLabel label02=new JLabel("请选择您的角色");
		JLabel label03=new JLabel(icon1);
		JLabel label04=new JLabel(icon2);
		JLabel label05=new JLabel(icon3);

		JRadioButton jRadioButton01=new JRadioButton("和尚");
		JRadioButton jRadioButton02=new JRadioButton("忍者");
		JRadioButton jRadioButton03=new JRadioButton("侠客");
		
		JButton jButton01=new JButton("确认创建");
		
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(jRadioButton01);
		buttonGroup.add(jRadioButton02);
		buttonGroup.add(jRadioButton03);
		

		
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    
		jRadioButton01.setBounds(0, 200, 100, 50);
		jRadioButton02.setBounds(200, 200, 100, 50);
		jRadioButton03.setBounds(400, 200, 100, 50);
		
		jRadioButton01.setBackground(Color.GREEN);
		jRadioButton02.setBackground(Color.BLUE);
		jRadioButton03.setBackground(Color.PINK);
		
		label03.setBounds(0, 300, 150, 300);
		label04.setBounds(200, 300, 150, 300);
		label05.setBounds(400, 300, 150, 300);
		jButton01.setBounds(200, 450, 100, 50);

		textField.setBounds(200, 75,200, 50);
		label01.setBounds(50, 75, 200, 50);
		panel.add(textField);
		panel.add(label01);
		panel.add(panel02);
		panel.add(jRadioButton01);
		panel.add(jRadioButton02);
		panel.add(jRadioButton03);
		panel.add(jButton01);
		panel.add(label03);
		panel.add(label04);
		panel.add(label05);

		panel.setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setContentPane(panel);
		
		jButton01.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choice = 0;
				String name=textField.getText().trim();
				if(jRadioButton01.isSelected()) {
					choice=1;
				}
				else if (jRadioButton02.isSelected()){
					choice=2;
				}
				else if(jRadioButton03.isSelected()) {
					choice=3;
				}
				else {
					JOptionPane.showMessageDialog(null, "您还没有选择您的角色", "别急", JOptionPane.INFORMATION_MESSAGE);
				}
	
				battleSystem=new BattleSystem(choice, name);

				int n=JOptionPane.showConfirmDialog(null,  "您已经创建"+battleSystem.getRole().getName(),"创建提示",JOptionPane.YES_NO_OPTION);
				
				if(n==0) {
					frame.dispose();
					BattleGUI battleGUI=new BattleGUI(battleSystem);
				}
			}
		});
	}
	public static void main(String[] args) {
		initRoleGUI.initrole();
	}
}
