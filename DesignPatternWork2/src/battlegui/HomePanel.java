package battlegui;

import java.awt.Graphics;
import java.awt.Image;

 
import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
//������ҳ����ͼƬ��JPnel��
public class HomePanel extends JPanel {
	ImageIcon icon;
	Image img;
	public HomePanel() {
		
		icon=new ImageIcon("darksoul.jpg");
		img=icon.getImage();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
	}
 
}
