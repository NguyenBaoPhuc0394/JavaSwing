package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterListener implements ActionListener{
	private CounterView ctv;
	public CounterListener(CounterView ctv) {
		this.ctv = ctv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("UP")) {
			this.ctv.increment();
		}
		else if(e.getActionCommand().equals("DOWN"))
			this.ctv.decrement();
		else
			this.ctv.reset();
	}

}
