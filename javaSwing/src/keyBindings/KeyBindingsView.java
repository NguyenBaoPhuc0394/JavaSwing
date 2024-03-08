package keyBindings;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class KeyBindingsView extends JFrame{
	JLabel label;
	Action up,down,left,right;
	KeyBindingsView(){
		this.setTitle("Key Bindings");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		up = new UpAction();
		down = new DownAction();
		left = new LeftAction();
		right = new RightAction();
		
		label = new JLabel();
		label.setBackground(Color.MAGENTA);
		label.setBounds(0,0,100,100);
		label.setOpaque(true);
		
		label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");//UP: PgUP
		label.getActionMap().put("up",up);
		label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");//DOWN:PgDn
		label.getActionMap().put("down",down);
		label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");//LEFT:Home
		label.getActionMap().put("left",left);
		label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");//RIGHT:End
		label.getActionMap().put("right",right);
		
		this.add(label);
		this.setVisible(true);
	}
	public class UpAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY() - 10);
		}
	}
	public class DownAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY() + 10);
		}
	}
	public class LeftAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX() - 10, label.getY());
		}
	}
	public class RightAction extends AbstractAction{
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX() + 10, label.getY());
		}
	}
	public static void main(String[] args) {
		new KeyBindingsView();
	}
}
