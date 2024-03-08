package jcolorChooser;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JcolorChooser extends JFrame implements ActionListener{
	private JLabel jlabel;
	private JButton jbutton;
	public JcolorChooser() {
		this.Gui();
		this.setVisible(true);
	}

	private void Gui() {
		this.setTitle("Menu");
		//this.setSize(400,200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		jlabel = new JLabel("Select Color ");
		//jlabel.setSize(500,500);
		jlabel.setFont(new Font("Mv Boli",Font.PLAIN,75));
		jlabel.setOpaque(true);
		jlabel.setBackground(Color.white);
		
		jbutton = new JButton("choose");
		jbutton.setSize(25,100);
		jbutton.setFocusable(false);
		jbutton.addActionListener(this);
		
		this.add(jbutton);
		this.add(jlabel);
		this.pack();
		
	}
	public static void main(String[] args) {
		new JcolorChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbutton) {
			JColorChooser jcolor = new JColorChooser();
			Color color = jcolor.showDialog(null, "COLOR", Color.black);
			jlabel.setForeground(color);
		}
		
	}
}
