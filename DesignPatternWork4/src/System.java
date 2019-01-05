import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class System extends JFrame {
	
	private Ricenoodle order;
	private JPanel jPanel=new JPanel();
	private JComboBox jComboBox =new JComboBox();
	private JLabel jLabel=new JLabel("��ѡ����ʳ��������");
	private JLabel jLabel2 =new JLabel("��ѡ������");
	private JButton TofuButton=new JButton("������/2Ԫ");
	private JButton EggButton=new JButton("±����/1.5Ԫ");
	private JButton BeefButton=new JButton("ţ��/5Ԫ");
	private JButton okButton =new JButton("���ɶ���");
	private JTextArea jTextArea01=new JTextArea("����");
	private JTextArea jTextArea02=new JTextArea("�۸�");
	
	public System() {
		setName("����ϵͳ");
		
		setSize(600, 600);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jPanel.setLayout(null);
		add(jPanel);
		

		jComboBox.addItem("�ɽ�����");
		jComboBox.addItem("�Ὤ����");
		jComboBox.addItem("ˮ����");
		
		jLabel.setBounds(100, 50, 150, 50);
		jLabel2.setBounds(50, 150, 200, 50);
		jComboBox.setBounds(250, 50, 100, 50);
		TofuButton.setBounds(50, 200, 100, 100);
		EggButton.setBounds(230, 200, 120, 100);
		BeefButton.setBounds(450, 200, 100, 100);
		okButton.setBounds(230, 450, 100, 80);
		jTextArea01.setBounds(50,350 , 500, 30);
		jTextArea02.setBounds(50,400 , 50, 20);
		
		jPanel.add(jLabel);
		jPanel.add(jLabel2);
		jPanel.add(jComboBox);
		jPanel.add(BeefButton);
		jPanel.add(EggButton);
		jPanel.add(TofuButton);
		jPanel.add(okButton);
		jPanel.add(jTextArea01);
		jPanel.add(jTextArea02);
		
		setVisible(true);
	}
	
	public void listen() {
		
		jComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String string =jComboBox.getSelectedItem().toString();
				switch(string) {
				case "�ɽ�����":
					order=new DryRicenoodle();
					break;
				case "�Ὤ����":
					order=new SourRiceNoodle();
					break;
				case "ˮ����":
					order=new WaterRicenoodle();
					break;
				}
				
			}
		});
		
		
		TofuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				order=new Tofu(order);
				jTextArea01.setText(order.getDescription());
				jTextArea02.setText(order.cost()+"Ԫ");
				
			}
		});
		
		EggButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				order=new Egg(order);
				jTextArea01.setText(order.getDescription());
				jTextArea02.setText(order.cost()+"Ԫ");
				
			}
		});
		
		BeefButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				order=new Beef(order);
				jTextArea01.setText(order.getDescription());
				jTextArea02.setText(order.cost()+"Ԫ");
				
				
			}
		});
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,  "���Ѿ���������"+order.getDescription()+"��"+order.cost()+"Ԫ","������ʾ",JOptionPane.YES_NO_OPTION);
				
			}
		});
	}
	
	public static void main(String[] args) {
		System system=new System();
		system.listen();
	}

}
