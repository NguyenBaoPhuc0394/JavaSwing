package jprogressbar;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class View extends JFrame{
	private JProgressBar jpro;
	public View() {
		this.Gui();
		this.setVisible(true);
	}
	public void Gui() {
		jpro = new JProgressBar();
		jpro.setValue(0);
		jpro.setBounds(0,0,400,40);
		jpro.setStringPainted(true);
		jpro.setForeground(Color.CYAN);
		jpro.setBackground(Color.black);
		
		this.setTitle("Jprogressbar");
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.add(jpro);
		fill();
	}
	public void fill() {
		int count = 0;
		while(count <= 100) {
			jpro.setValue(count);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count += 5;
		}
		jpro.setString("finish");
	}
	public static void main(String[] args) {
		View view = new View();
	}
}
