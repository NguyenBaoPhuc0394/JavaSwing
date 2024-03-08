package comboBox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class View extends JFrame implements ActionListener{
	private JComboBox jcombo;
	
	public View() {
		this.setSize(300,300);
		this.setTitle("ComboBox");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		String[] programs = {"java","c++","python"};
		jcombo = new JComboBox(programs);
		jcombo.addActionListener(this);
		jcombo.setEditable(true);
		jcombo.addItem("php");
		//jcombo.removeItem("java");
		jcombo.insertItemAt("c#", 2);
		//jcombo.setSelectedIndex(0);
//		jcombo.removeAllItems();
//		jcombo.removeItem(0);
		
		this.add(jcombo);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new View();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jcombo)
			System.out.println(jcombo.getSelectedItem());
		
	}
}
