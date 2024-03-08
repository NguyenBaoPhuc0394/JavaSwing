package miniCal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{
	private View view;
	public Control(View v) {
		// TODO Auto-generated constructor stub
		view = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("+")) {
			view.plus();
		}
		if(e.getActionCommand().equals("-")) {
			view.minus();
		}
		if(e.getActionCommand().equals("*")) {
			view.multiply();
		}
		if(e.getActionCommand().equals("/")) {
			view.divide();
		}
		if(e.getActionCommand().equals("%")) {
			view.mod();
		}
		if(e.getActionCommand().equals("^")) {
			view.power();
		}
		
	}
	
}
