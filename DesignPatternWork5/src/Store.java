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

public class Store extends JFrame {
	
	private JPanel jPanel=new JPanel();
	private JComboBox jComboBox =new JComboBox();
	private JLabel jLabel=new JLabel("��ѡ���ײ�����");
	private JButton okButton=new JButton("�ײ���ϸ��Ϣ");
	private double price;
	private ComputerStore computerStore;
	private Mainboard mainboard;
	private Cpu cpu;
	private Hardisk hardisk;
	private MemoryBank memoryBank;
	private GraphicCard graphicCard;
	
	public Store() {
	
		setSize(600, 300);
		setLocationRelativeTo(null);
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jPanel.setLayout(null);
		add(jPanel);
		

		jComboBox.addItem("ѧ����");
		jComboBox.addItem("��ҵ��");
		okButton.setBounds(220, 180, 150, 70);

		jLabel.setBounds(100, 50, 150, 50);
		jComboBox.setBounds(250, 50, 100, 50);
		jPanel.add(jLabel);
		jPanel.add(jComboBox);
		jPanel.add(okButton);
		
		setVisible(true);
	}
	
	public void listen() {
		
		jComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String string =jComboBox.getSelectedItem().toString();
				price=0;
				switch(string) {
				case "ѧ����":
					computerStore=new ForStudent();
					break;
				case "��ҵ��":
					computerStore=new ForCompany();
					break;

				}
				cpu=computerStore.createCpu();
				mainboard=computerStore.createMainboard();
				memoryBank=computerStore.createMemoryBank();
				hardisk=computerStore.createHardisk();
				graphicCard=computerStore.createGraphicCard();
				price=cpu.getPrice()+mainboard.getPrice()+memoryBank.getPrice()+hardisk.getPrice()+graphicCard.getPrice();
			}
		});
		
	
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "�ܼ�:"+price+"\n";
				message+=cpu.getName()+"  "+cpu.getPrice()+"Ԫ"+"\n";
				message+=graphicCard.getName()+"  "+graphicCard.getPrice()+"Ԫ"+"\n";
				message+=memoryBank.getName()+"  "+memoryBank.getPrice()+"Ԫ"+"\n";
				message+=mainboard.getName()+"  "+mainboard.getPrice()+"Ԫ"+"\n";
				message+=hardisk.getName()+"  "+hardisk.getPrice()+"Ԫ"+"\n";
				JOptionPane.showMessageDialog(null, message, "��ϸ��Ϣ", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
	
	public static void main(String[] args) {
		Store store=new Store();
		store.listen();
	}

}
