package menuBar;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JmenuBarView extends JFrame implements ActionListener{
	private JMenuBar jmenubar;
	private JMenu file,edit,help;
	private JMenuItem save,load,exit;
	public JmenuBarView() {
		this.Gui();
		this.setVisible(true);
	}
	public void Gui() {
		this.setTitle("Menu");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		jmenubar = new JMenuBar();
		file = new JMenu("file");
		edit = new JMenu("edit");
		help = new JMenu("help");
		
		save = new JMenuItem("save");
		load = new JMenuItem("load");
		exit = new JMenuItem("exit");
		
		file.add(save);
		file.add(load);
		file.add(exit);
		
		exit.addActionListener(this);
		
		file.setMnemonic(KeyEvent.VK_F);//tao phim tat alt+f
		edit.setMnemonic(KeyEvent.VK_E);//tao phim tat alt+e
		help.setMnemonic(KeyEvent.VK_H);//tao phim tat alt+h
		
		jmenubar.add(file);
		jmenubar.add(edit);
		jmenubar.add(help);
		this.setJMenuBar(jmenubar);//CHU Y
	}
	public static void main(String[] args) {
		new JmenuBarView();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit)
			System.exit(0);
		
	}
}
