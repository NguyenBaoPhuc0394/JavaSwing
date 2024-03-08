package mouseListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mouse extends JFrame implements MouseListener{
	JLabel jlabel;
	public Mouse() {
		this.Gui();
		this.setVisible(true);
	}
	private void Gui() {
		jlabel = new JLabel();
		jlabel.setBounds(0, 0, 100, 100);
		jlabel.setBackground(Color.red);
		jlabel.setOpaque(true);
		jlabel.addMouseListener(this);
		
		this.add(jlabel);
		this.setTitle("Menu");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
	}
	public static void main(String[] args) {
		new Mouse();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Clicked");
		//jlabel.setBackground(Color.yellow);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("Pressed");
		jlabel.setBackground(Color.blue);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Released");
		jlabel.setBackground(Color.green);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
//		System.out.println("Entered");
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("Exited");
		
	}
}
