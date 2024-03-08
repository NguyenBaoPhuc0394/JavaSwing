package newWindow;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindow {
	JFrame jf = new JFrame();
	JLabel jl = new JLabel("new window");
	public NewWindow() {
		jl.setBounds(0,0,100,50);
		jf.add(jl);
		jf.setSize(400,400);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
