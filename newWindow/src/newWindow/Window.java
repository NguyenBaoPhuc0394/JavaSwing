package newWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Window implements ActionListener{
	JFrame jf = new JFrame();
	JButton jb = new JButton();
	public Window() {
		jb.setText("Let's click");
		jb.setBounds(150, 150, 50, 70);
		jb.setFocusable(false);
		jb.addActionListener(this);
		
		jf.add(jb);
		jf.setSize(400,400);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == jb) {
			jf.dispose();
			NewWindow nw = new NewWindow();
		}
		
	}
}
