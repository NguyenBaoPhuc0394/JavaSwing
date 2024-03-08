package jFileChooser;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class JfileChooser extends JFrame implements ActionListener{
	private JButton select;
	public JfileChooser() {
		this.Gui();
		this.setVisible(true);
	}
	public void Gui() {
		this.setTitle("Menu");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		select = new JButton("Select file");
		select.setFocusable(false);
		select.addActionListener(this);
		this.add(select);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == select) {
			JFileChooser jfile = new JFileChooser();
			//jfile.showOpenDialog(null);
			jfile.setCurrentDirectory(new File("D:\\VSCODE"));
			int j = jfile.showOpenDialog(null);
			if(j == jfile.APPROVE_OPTION) {
				File file = new File(jfile.getSelectedFile().getAbsolutePath());
				System.out.println(jfile);
			}
		}
	}
	public static void main(String[] args) {
		new JfileChooser();
	}
}
