package clock;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CounterView extends JFrame{
	private CounterModel ctm;
	private JLabel jlabel;
	private JButton jbutton1,jbutton2,jbutton3;
	
	public CounterView() {
		this.ctm = new CounterModel();
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
		this.setTitle("Counter");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		jbutton1 = new JButton("UP");
		jbutton2 = new JButton("DOWN");
		jbutton3 = new JButton("RESET");
		
		jlabel = new JLabel(this.ctm.getPoint() + "",JLabel.CENTER);
		ActionListener ac = new CounterListener(this);
		jbutton1.addActionListener(ac);
		jbutton2.addActionListener(ac);
		jbutton3.addActionListener(ac);
		jbutton1.setOpaque(false);
		jbutton2.setOpaque(false);
		jbutton1.setFocusable(false);
		jbutton2.setFocusable(false);
		jbutton3.setFocusable(false);
		
		this.add(jbutton1,BorderLayout.WEST);
		this.add(jbutton2,BorderLayout.EAST);
		this.add(jbutton3,BorderLayout.NORTH);
		this.add(jlabel,BorderLayout.CENTER);
	}
	public void increment() {
		this.ctm.increment();
		jlabel.setText(this.ctm.getPoint() + "");
		
	}
	public void decrement() {
		this.ctm.decrement();
		jlabel.setText(this.ctm.getPoint() + "");
	}
	public void reset() {
		this.ctm.reset();
		jlabel.setText(this.ctm.getPoint() + "");
	}
}
