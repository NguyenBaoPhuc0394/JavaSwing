package jCheckBoxMenuItem;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.AWTKeyStroke;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class View extends JFrame {
	JToolBar jtool;
	JPopupMenu jpop;
    JMenuBar jmenubar;
    JLabel label;
    JMenu jmenu_file,jmenu_help,jmenu_view;
    JMenuItem save,new_file,delete;
    JCheckBoxMenuItem hide;
    JMenuItem run,project,debug;
    JButton a,b,c;
    public View(){
        this.Gui();
        this.setVisible(true);
    }
    private void Gui() {
        Control control = new Control(this);
        this.setTitle("Menubar");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        label = new JLabel();
        label.setBounds(50,50,150,30);
        label.setFont(new Font("Arial",Font.BOLD,25));

        jmenubar = new JMenuBar();

        jmenu_file = new JMenu("file");
        jmenu_help = new JMenu("help");
        jmenu_view = new JMenu("view");

        save = new JMenuItem("save",KeyEvent.VK_S);//phim tat alt+s, KeyEvent.VK_ chi dung trong menuitem
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
        save.addActionListener(control);
        new_file = new JMenuItem("new",KeyEvent.VK_N);
        new_file.addActionListener(control);
        delete = new JMenuItem("delete",KeyEvent.VK_D);
        delete.addActionListener(control);
        hide = new JCheckBoxMenuItem("hide toolBar");
        hide.addActionListener(control);

        jmenu_file.add(save);
        jmenu_file.addSeparator();
        jmenu_file.add(new_file);
        jmenu_file.addSeparator();
        jmenu_file.add(delete);
        jmenu_file.addSeparator();
        jmenu_view.add(hide);

        jmenubar.add(jmenu_file);
        jmenubar.add(jmenu_help);
        jmenubar.add(jmenu_view);
        
        jpop = new JPopupMenu();
        run = new JMenuItem("run");
        project = new JMenuItem("project");
        debug = new JMenuItem("debug");
        jpop.add(run);
        jpop.add(project);
        jpop.add(debug);
        this.add(jpop);
        
        jtool = new JToolBar();
        a = new JButton("a");
        b = new JButton("b");
        c = new JButton("c");
        jtool.add(a);
        jtool.add(b);
        jtool.add(c);
        
        JcheckboxMenuItemMouse jpm = new JcheckboxMenuItemMouse(this);
        this.addMouseListener(jpm);
        
        this.setJMenuBar(jmenubar);
        this.add(label);
        this.add(jtool);
        jtool.setVisible(false);
    }
    public void setTextLabel(String s){
        label.setText(s);
    }
    public void showToolBar() {
    	this.add(jtool);
    	jtool.setVisible(true);
    }
    public void hideToolBar() {
    	jtool.setVisible(false);
    }
}
