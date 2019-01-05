package battlegui;

import java.awt.Graphics;
import java.awt.Image;

 
import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
//设置主页背景图片的JPnel类
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
