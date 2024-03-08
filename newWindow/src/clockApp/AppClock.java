package clockApp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppClock extends JFrame{
	JLabel timeLabel,dayLabel,dateLabel;
	Calendar calendar;
	SimpleDateFormat timeFormat,dayFormat,dateFormat;
	String time,day,date;
	public AppClock() {
		this.setSize(350,220);
		this.setTitle("Clock");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("dd / MM,yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setBackground(Color.black);
		timeLabel.setForeground(Color.green);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,40));
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,40));
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		setTime();
	}
	public static void main(String[] args) {
		new AppClock();
	}
	public void setTime() {
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
