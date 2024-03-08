package javaSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextField extends JFrame implements ActionListener{
	JTextField jt;
	JButton jb;
	public TextField() {
		jt = new JTextField();
		jt.setPreferredSize(new Dimension(250,40));
		jt.setBackground(Color.black);
		jt.setForeground(Color.green);
		jt.setCaretColor(Color.white);
		jt.setText("username");
//		jt.setEditable(false);
		
		jb = new JButton();
		jb.setText("Submit");
		jb.addActionListener(this);
		
		this.add(jt);
		this.add(jb);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb) {
			System.out.println("textField");
			jt.setEditable(false);
		}
		
	}
	public static void main(String[] args) {
		TextField tx = new TextField();
	}
}
