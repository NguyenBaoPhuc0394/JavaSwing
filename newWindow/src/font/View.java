package font;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {
	private Model model;
	private JButton jb1,jb2,jb3,jb4;
	private JLabel jlb;
	private JPanel jpanel1,jpanel2;
	private int select;
	public View() {
		model = new Model();
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
		jb1 = new JButton("1");
		jb2 = new JButton("2");
		jb3 = new JButton("3");
		jb4 = new JButton("4");
		jb1.setFocusable(false);
		jb2.setFocusable(false);
		jb3.setFocusable(false);
		jb4.setFocusable(false);
		
		Font font = new Font("Arial",Font.BOLD,20);
		ActionListener ac = new Control(this);
		
		jb1.addActionListener(ac);
		jb2.addActionListener(ac);
		jb3.addActionListener(ac);
		jb4.addActionListener(ac);
		
		jb1.setFont(font);
		jb2.setFont(font);
		jb3.setFont(font);
		jb4.setFont(font);
		
		jlb = new JLabel("Button : " + this.select);
		jlb.setVerticalAlignment(JLabel.EAST);
		jlb.setFont(font);
		
		jpanel1 = new JPanel();
		jpanel1.setLayout(new GridLayout(2,2));
		jpanel1.add(jb1);
		jpanel1.add(jb2);
		jpanel1.add(jb3);
		jpanel1.add(jb4);
		
		jpanel2 = new JPanel();
		jpanel2.setLayout(new FlowLayout());
		jpanel2.add(jlb);
		
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(2,1));
		this.add(jpanel1);
		this.add(jpanel2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Select");
	}
	public void change1() {
		this.select = 1;
		jlb.setText("Button : " + this.select);
	}
	public void change2() {
		this.select = 2;
		jlb.setText("Button : " + this.select);
	}
	public void change3() {
		this.select = 3;
		jlb.setText("Button : " + this.select);
	}
	public void change4() {
		this.select = 4;
		jlb.setText("Button : " + this.select);
	}
}
