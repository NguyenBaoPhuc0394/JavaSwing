package javaSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Exam extends JFrame implements ActionListener{
	private JButton jbutton;
	private JLabel jlabel;
	public Exam() {
		addButton();
		initGUI();
//		JButton jbutton = new JButton("1");
//		this.add(jbutton);
//		jbutton.setBounds(10, 10, 20, 20);
//		
//		this.setSize(500,500);
//		this.setLocationRelativeTo(null);
//		this.setLayout(null);
//		this.getContentPane().setBackground(Color.GRAY);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setVisible(true);
	}
	public void initGUI() {
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void addButton() {
		ImageIcon image = new ImageIcon("icons8-java-64.png");
		ImageIcon icon = new ImageIcon("icons8-java-48.png");
		jlabel = new JLabel();
		jlabel.setIcon(icon);
		jlabel.setBounds(150, 150, 250, 250);
		jlabel.setVisible(false);
		jbutton = new JButton("1");
		jbutton.setBounds(10, 10, 100, 100);
		jbutton.addActionListener(this);
		jbutton.setIcon(image);
		jbutton.setText("button");
		jbutton.setFont(new Font("Comic Sans",Font.BOLD,18));
		jbutton.setFocusable(false);
		this.add(jbutton);
		this.add(jlabel);
	}
	public static void main(String[] args) {
		Exam exm = new Exam();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbutton)
//			System.out.println("hello");
			jlabel.setVisible(true);
	}
}
