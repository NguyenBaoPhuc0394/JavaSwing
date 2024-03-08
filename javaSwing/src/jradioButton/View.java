package jradioButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class View extends JFrame implements ActionListener{
	private JRadioButton jrd1,jrd2,jrd3;
	
	public View() {
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setTitle("JRadioButton");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		jrd1 = new JRadioButton("one");
		jrd1.setFocusable(false);
		jrd1.addActionListener(this);
		//jrd1.setMnemonic(JRadioButton.CENTER);
		jrd2 = new JRadioButton("two");
		jrd2.setFocusable(false);
		jrd2.addActionListener(this);
		jrd3 = new JRadioButton("three");
		jrd3.setFocusable(false);
		jrd3.addActionListener(this);
		
		ButtonGroup bg = new ButtonGroup();//chi chon 1 lua chon
		bg.add(jrd1);
		bg.add(jrd2);
		bg.add(jrd3);
		
		this.add(jrd1);
		this.add(jrd2);
		this.add(jrd3);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new View();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jrd1) {
			System.out.println(jrd1.getText());
		}
		if(e.getSource()==jrd2) {
			System.out.println("two");
		}
		if(e.getSource()==jrd3) {
			System.out.println("three");
		}
		
	}
}
