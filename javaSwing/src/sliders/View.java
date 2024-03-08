package sliders;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame implements ChangeListener{
	private JPanel jpanel;
	private JLabel jlabel;
	private JSlider jslider;
	public View() {
		this.Gui();
		this.setVisible(true);
	}
	public void Gui() {
		jlabel = new JLabel();
		jslider = new JSlider(0, 100, 50);//min/max/value
		jslider.setPreferredSize(new Dimension(400,200));
		jslider.setPaintTicks(true);
		jslider.setMinorTickSpacing(10);
		jslider.setPaintTrack(true);
		jslider.setMajorTickSpacing(25);//
		jslider.setPaintLabels(true);//hien cac gia tri
		jslider.setOrientation(SwingConstants.VERTICAL);//theo chieu dung
		jlabel.setText(jslider.getValue() + "");
		jslider.addChangeListener(this);
		
		jpanel = new JPanel();
		jpanel.add(jslider);
		jpanel.add(jlabel);
		this.add(jpanel);
		this.setSize(400,400);
		this.setTitle("Slider");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(null);
		this.setLocationRelativeTo(null);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==jslider) {
			jlabel.setText(jslider.getValue() + "");
		}
		
	}
	public static void main(String[] args) {
		new View();
	}
}
