package graphics2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	Image ima;
	public MyPanel() {
		ima = new ImageIcon("christmas-tree-2928142_1280.jpg").getImage();
		this.setPreferredSize(new Dimension(500,500));
	}
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(ima, 0, 0, null);
		g2d.setPaint(Color.orange);//mau vien
		g2d.setStroke(new BasicStroke(6));//do dam cua vien
		//g2d.drawLine(0, 0, 500, 500);
		//g2d.drawRect(50, 50, 150, 250);
		//g2d.fillRect(50, 50, 150, 250);
		g2d.drawOval(100, 100, 100, 100);
		g2d.fillOval(100, 100, 100, 100);
		
		g2d.drawArc(150, 150, 100, 100, 180, 180);
		
		g2d.setPaint(Color.green);//mau
		int []xPoint = {150,250,350};
		int []yPoint = {300,150,350};
		g2d.drawPolygon(xPoint, yPoint, 3);
		
		
		g2d.setFont(new Font("Arial",Font.BOLD,25));
		g2d.drawString("Hello javaSwing", 25, 25);
		
	}
}
