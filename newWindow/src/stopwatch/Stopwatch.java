package stopwatch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Stopwatch extends JFrame implements ActionListener{
	JLabel label;
	JButton start,restart;
	boolean started = false;
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	String str_s = String.format("%02d", seconds);
	String str_m = String.format("%02d", minutes);
	String str_h = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			elapsedTime += 1000;
			hours = elapsedTime / 3600000;
			minutes = (elapsedTime / 60000) % 60;
			seconds = (elapsedTime / 1000) % 60;
			str_s = String.format("%02d", seconds);
			str_m = String.format("%02d", minutes);
			str_h = String.format("%02d", hours);
			label.setText(str_h + ":" + str_m + ":" + str_s);
		}
	});
	
	public Stopwatch() {
		initFrame();
		addComponent();
		this.setVisible(true);
	}
	
	public void initFrame() {
		this.setTitle("Stopwatch");
		this.setSize(420,420);
		this.setType(Type.UTILITY);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
	}
	
	public void addComponent() {
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBackground(Color.black);
		label.setForeground(Color.green);
		label.setBounds(50, 0, 300, 150);
		label.setFont(new Font("Verdana", Font.PLAIN, 50));
		label.setOpaque(true);
		
		start = new JButton("Start");
		start.setBackground(Color.ORANGE);
		start.setFont(new Font("Ink Free", Font.PLAIN, 25));
		start.setBounds(50, 150, 150, 40);
		start.setFocusable(false);
		start.addActionListener(this);
		
		restart = new JButton("Restart");
		restart.setBackground(Color.ORANGE);
		restart.setFont(new Font("Ink Free", Font.PLAIN, 25));
		restart.setBounds(200, 150, 150, 40);
		restart.setFocusable(false);
		restart.addActionListener(this);
		
		this.add(label);
		this.add(restart);
		this.add(start);
	}
	
	public static void main(String[] args) {
		new Stopwatch();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			if(!started) {
				started = true;
				start();
				start.setText("Stop");
			}
			else {
				started = false;
				stop();
				start.setText("Start");
			}
		}
		if(e.getSource() == restart) {
			started = false;
			restart();
			start.setText("Start");
		}
	}
	
	public void start() {
		timer.start();
	}
	public void stop() {
		timer.stop();
	}
	public void restart() {
		elapsedTime = 0;
		hours = elapsedTime / 3600000;
		minutes = (elapsedTime / 60000) % 60;
		seconds = (elapsedTime / 1000) % 60;
		str_s = String.format("%02d", seconds);
		str_m = String.format("%02d", minutes);
		str_h = String.format("%02d", hours);
		label.setText(str_h + ":" + str_m + ":" + str_s);
	}
}
