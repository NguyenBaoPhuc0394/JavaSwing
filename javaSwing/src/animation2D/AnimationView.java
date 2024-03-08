package animation2D;

import javax.swing.JFrame;

public class AnimationView extends JFrame{
	MyPanel panel;
	public AnimationView() {
		panel = new MyPanel();
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new AnimationView();
	}
}
