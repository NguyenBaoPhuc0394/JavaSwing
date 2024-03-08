package background;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame implements ActionListener{
	private JButton jb1,jb2,jb3,jb4,jb5,jb6;
	private JLabel jlabel;
	private JPanel jpanel1, jpanel2;
	
	public View() {
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
		
		Font font = new Font("Arial",Font.BOLD,18);
		
		jb1 = new JButton("red");
		jb2 = new JButton("yellow");
		jb3 = new JButton("green");
		jb4 = new JButton("grey");
		jb5 = new JButton("black");
		jb6 = new JButton("blue");
		
		jb1.setFocusable(false);
		jb2.setFocusable(false);
		jb3.setFocusable(false);
		jb4.setFocusable(false);
		jb5.setFocusable(false);
		jb6.setFocusable(false);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		jb1.setFont(font);
		jb2.setFont(font);
		jb3.setFont(font);
		jb4.setFont(font);
		jb5.setFont(font);
		jb6.setFont(font);
		
		jlabel = new JLabel("TEXT", JLabel.CENTER);
		jlabel.setFont(font);
		
		jpanel1 = new JPanel();
		jpanel2 = new JPanel();
		
		jpanel1.setLayout(new FlowLayout());
		jpanel1.add(jlabel);
		
		jpanel2.setLayout(new GridLayout(2,3));
		jpanel2.add(jb1);
		jpanel2.add(jb2);
		jpanel2.add(jb3);
		jpanel2.add(jb4);
		jpanel2.add(jb5);
		jpanel2.add(jb6);
		
		this.setTitle("Select");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2,2));
		this.add(jpanel1);
		this.add(jpanel2);
	}
	
	public static void main(String[] args) {
		View view = new View();
	}
	public void select1() {
		this.jlabel.setForeground(Color.red);
	}
	public void select2() {
		this.jlabel.setForeground(Color.yellow);
	}
	public void select3() {
		this.jlabel.setForeground(Color.green);
	}
	public void select4() {
		this.jpanel1.setBackground(Color.gray);
		this.jpanel1.setOpaque(true);
	}
	public void select5() {
		this.jpanel1.setBackground(Color.black);
		this.jpanel1.setOpaque(true);
	}
	public void select6() {
		this.jpanel1.setBackground(Color.blue);
		this.jpanel1.setOpaque(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("red")) {
			this.select1();
		}
		if(e.getActionCommand().equals("yellow")) {
			this.select2();
		}
		if(e.getActionCommand().equals("green")) {
			this.select3();
		}
		if(e.getActionCommand().equals("grey")) {
			this.select4();
		}
		if(e.getActionCommand().equals("black")) {
			this.select5();
		}
		if(e.getActionCommand().equals("blue")) {
			this.select6();
		}
		
	}
}
