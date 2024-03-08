package loginSystem;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Page extends JFrame{
	private JLabel jlb = new JLabel("Wellcome to Page",JLabel.CENTER);
	public Page() {
		this.setFont(new Font("Tahoma",Font.BOLD,24));
		this.add(jlb);
		this.setSize(300,300);
		this.setTitle("Page");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
