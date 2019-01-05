package battlegui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class StartGUI {
	
	private JFrame frame=new JFrame("�ڰ�֮��");
	private JPanel panel=new HomePanel();
	private JButton startButton=new JButton("��ʼ��Ϸ");
	private JButton quitButton=new JButton("�˳���Ϸ");
	
	public void display() {
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    panel.setLayout(null);

		
		panel.add(startButton);
		panel.add(quitButton);
		startButton.setBounds(frame.getWidth()/2-100, frame.getHeight()/2-150, 200, 100);
		quitButton.setBounds(frame.getWidth()/2-100, frame.getHeight()/2+50, 200, 100);

		frame.setVisible(true);
		frame.add(panel);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				frame.dispose();
				initRoleGUI.initrole();
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});

	}
	
	public static void main(String[] args) {
		StartGUI startGUI=new StartGUI();
		startGUI.display();
	}

}
