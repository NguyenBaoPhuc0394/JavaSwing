package jToolBar;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.AWTKeyStroke;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class View extends JFrame {
	JToolBar jtool;
    JMenuBar jmenubar;
    JLabel label;
    JMenu jmenu_file,jmenu_help;
    JMenuItem save,new_file,delete;
    JButton run,project,debug;
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

        save = new JMenuItem("save",KeyEvent.VK_S);//phim tat alt+s, KeyEvent.VK_ chi dung trong menuitem
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
        save.addActionListener(control);
        new_file = new JMenuItem("new",KeyEvent.VK_N);
        new_file.addActionListener(control);
        delete = new JMenuItem("delete",KeyEvent.VK_D);
        delete.addActionListener(control);

        jmenu_file.add(save);
        jmenu_file.addSeparator();
        jmenu_file.add(new_file);
        jmenu_file.addSeparator();
        jmenu_file.add(delete);
        jmenu_file.addSeparator();

        jmenubar.add(jmenu_file);
        jmenubar.add(jmenu_help);
        
        jtool = new JToolBar();
        run = new JButton("run");
        run.setToolTipText("enter to run");
        run.setFocusable(false);
        project = new JButton("project");
        project.setToolTipText("enter to create a new project");
        project.setFocusable(false);
        debug = new JButton("debug");
        debug.setToolTipText("enter to debug");
        debug.setFocusable(false);
        jtool.add(run);
        jtool.add(project);
        jtool.add(debug);
        
        this.setJMenuBar(jmenubar);
        this.add(jtool);
        this.add(label);
    }
    public void setTextLabel(String s){
        label.setText(s);
    }

}
