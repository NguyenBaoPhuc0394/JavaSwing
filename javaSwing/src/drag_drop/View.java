package drag_drop;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class View extends JFrame{
	
	DragPanel dragPanel = new DragPanel();
	
	public View() {
		this.Gui();
		this.setVisible(true);
	}

	private void Gui() {
		
		this.add(dragPanel);
		this.setTitle("Drag & Drop");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(null);
		
		
	}
	
	public static void main(String[] args) {
		new View();
	}
}
