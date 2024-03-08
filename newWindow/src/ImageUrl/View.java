package ImageUrl;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.Toolkit;
import java.net.URI;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class View extends JFrame{
	JButton button;
	JLabel label;
	JMenuBar menubar;
	JMenu chose;
	JMenuItem save,delete,project;
	public View() {
		this.Gui();
		this.setVisible(true);
	}

	private void Gui() {
		// TODO Auto-generated method stub
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ImageUrl");
		this.setLayout(new BorderLayout());
		
		button = new JButton("TEST BUTTON");
		button.setFocusable(false);
		this.add(button,BorderLayout.SOUTH);
		label = new JLabel();
		this.add(label,BorderLayout.CENTER);
		menubar = new JMenuBar();
		chose = new JMenu("chose");
		save = new JMenuItem("save");
		delete = new JMenuItem("delete");
		project = new JMenuItem("project");
		chose.add(save);
		chose.add(delete);
		chose.add(project);
		menubar.add(chose);
		this.setJMenuBar(menubar);
		
		java.net.URL UrlIcon = View.class.getResource("Tatice-Cristal-Intense-Notepad-Bloc-notes-2.256.png");
		Image img = Toolkit.getDefaultToolkit().createImage(UrlIcon);
		this.setIconImage(img);
		
		ImageIcon icon = new ImageIcon("Martz90-Circle-Addon2-Notepad.48.png");
		button.setIcon(icon);
		
		chose.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("Martz90-Circle-Addon2-Notepad.48.png"))));
		save.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("Social-Media-Icons-Glossy-Social-Android.48.png"))));
	}
	public static void main(String[] args) {
	    try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	        new View();
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
	        
	    //new SwingApplication(); //Create and show the GUI.
	}
}
