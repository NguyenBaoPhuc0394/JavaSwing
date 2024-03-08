package graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main extends JFrame{
	private View view = new View();
	public Main() {
		this.setLocationRelativeTo(null);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(view,BorderLayout.CENTER);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Main();
	}
}
