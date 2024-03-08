package jcheckbox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class JcheckBox extends JFrame implements ActionListener{
	private JCheckBox jch;
	private JButton jbutton;
	private ImageIcon ima1,ima2;
	
	public JcheckBox() {
		this.setTitle("CheckBoxes");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		ima1 = new ImageIcon("icons8-java-48.png");
		ima2 = new ImageIcon("icons8-java-64.png");
		
		jch = new JCheckBox();
		jch.setText("Selected");
		jch.setFocusable(false);
		jch.setIcon(ima1);
		jch.setSelectedIcon(ima2);;
		
		jbutton = new JButton("Submit");
		jbutton.setFocusable(false);
		jbutton.setLocation(50,50);
		jbutton.addActionListener(this);
		
		this.add(jbutton);
		this.add(jch);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JcheckBox();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(jch.isSelected());
		
	}
}
