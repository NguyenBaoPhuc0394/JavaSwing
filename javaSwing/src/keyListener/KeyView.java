package keyListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyView extends JFrame implements KeyListener{
	
	JLabel jlabel;
	ImageIcon icon;
	
	public KeyView() {
		this.Gui();
		this.setVisible(true);
	}

	private void Gui() {
		icon = new ImageIcon("icons8-java-48.png");
		
		jlabel = new JLabel();
		jlabel.setBounds(0, 0, 100, 100);
//		jlabel.setBackground(Color.red);
//		jlabel.setOpaque(false);
		jlabel.setIcon(icon);
		
		this.add(jlabel);
		this.setTitle("Menu");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.addKeyListener(this);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		switch(e.getKeyChar()) {//getKeyChar():lay ki tu
//			case 'a':
//				jlabel.setLocation(jlabel.getX() - 20, jlabel.getY());
//				break;
//			case 'b':
//				jlabel.setLocation(jlabel.getX(), jlabel.getY() - 20);
//				break;
//			case 'c':
//				jlabel.setLocation(jlabel.getX() + 20, jlabel.getY());
//				break;
//			case 'd':
//				jlabel.setLocation(jlabel.getX(), jlabel.getY() + 20);
//				break;
//		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {//getKeyCode: lay so
			case 37:
				jlabel.setLocation(jlabel.getX() - 20, jlabel.getY());
				break;
			case 38:
				jlabel.setLocation(jlabel.getX(), jlabel.getY() - 20);
				break;
			case 39:
				jlabel.setLocation(jlabel.getX() + 20, jlabel.getY());
				break;
			case 40:
				jlabel.setLocation(jlabel.getX(), jlabel.getY() + 20);
				break;
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println(e.getKeyChar());
//		System.out.println(e.getKeyCode());home:37,pgUp:38,end:39,pgDn:40
//		if(e.getKeyCode() == 37) {
//			int x = jlabel.getX();
//			int y = jlabel.getY();
//			jlabel.setLocation(x - 20, y);
//		}
//		if(e.getKeyCode() == 38) {
//			int x = jlabel.getX();
//			int y = jlabel.getY();
//			jlabel.setLocation(x , y - 20);
//		}
//		if(e.getKeyCode() == 39) {
//			int x = jlabel.getX();
//			int y = jlabel.getY();
//			jlabel.setLocation(x + 20, y);
//		}
//		if(e.getKeyCode() == 40) {
//			int x = jlabel.getX();
//			int y = jlabel.getY();
//			jlabel.setLocation(x , y + 20);
//		}
	}
	public static void main(String[] args) {
		new KeyView();
	}
}
