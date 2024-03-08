package font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{
	View view;
	public Control(View v) {
		view = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("1")) {
			view.change1();
		}
		if(src.equals("2")) {
			view.change2();
		}
		if(src.equals("3")) {
			view.change3();
		}
		if(src.equals("4")) {
			view.change4();
		}
	}

}
