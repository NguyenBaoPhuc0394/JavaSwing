package textEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.ScrollPane;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextEditor extends JFrame implements ActionListener{

	JTextArea area;
	JLabel label;
	JButton buttonColor;
	JScrollPane pane;
	JSpinner spinner;
	JComboBox fontBox;
	JMenuBar menubar;
	JMenu file;
	JMenuItem open,save,exit;
	
	public TextEditor() {
		initFrame();
		addComponent();
		this.setVisible(true);
	}
	
	public void initFrame() {
		this.setSize(500,550);
		this.setTitle("Text Editor");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());//
		this.setType(Type.UTILITY);
	}
	
	public void addComponent() {
		area = new JTextArea();
		area.setLineWrap(true);//tu dong xuong hang khi het dong
		area.setWrapStyleWord(true);//
		area.setFont(new Font("Arial", Font.PLAIN, 20));
		
		pane = new JScrollPane(area);
		pane.setPreferredSize(new Dimension(450,450));//su dung thay setSize trong flowLayout
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//luon luon chi keo xuong
		
		label = new JLabel("Font:");
		
		spinner = new JSpinner();//thay doi kich co chu
		spinner.setPreferredSize(new Dimension(50,25));//
		spinner.setValue(20);
		spinner.addChangeListener(new ChangeListener() {//tang giam kich co theo chi so
			
			@Override
			public void stateChanged(ChangeEvent e) {
				area.setFont(new Font(area.getFont().getFamily(),Font.PLAIN,(int)spinner.getValue()));
				
			}
		});	
		
		buttonColor = new JButton("Color");
		buttonColor.setPreferredSize(new Dimension(65,25));
		buttonColor.setFocusable(false);
		buttonColor.addActionListener(this);
		
		
		String[] listFont = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontBox = new JComboBox(listFont);
		fontBox.setSelectedItem("Arial");
		fontBox.addActionListener(this);
		
		menubar = new JMenuBar();
		file = new JMenu("File");
		save = new JMenuItem("save");
		open = new JMenuItem("open");
		exit = new JMenuItem("exit");
		
		save.addActionListener(this);
		open.addActionListener(this);
		exit.addActionListener(this);
		
		file.add(save);
		file.add(open);
		file.add(exit);
		menubar.add(file);
		
		
		this.setJMenuBar(menubar);//su dung setJMenubar
		this.add(label);
		this.add(spinner);//add vao truoc area
		this.add(buttonColor);
		this.add(fontBox);
		this.add(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonColor) {
			JColorChooser color = new JColorChooser();
			Color c = color.showDialog(this, "Choose a color", Color.black);
			area.setForeground(c);
		}
		if(e.getSource() == fontBox) {
			//thay doi kieu chu sao cho dam bao kich thuoc 
			area.setFont(new Font((String) fontBox.getSelectedItem(), Font.PLAIN, area.getFont().getSize()));
		}
		if(e.getSource() == exit) {
			System.exit(0);
		}
		if(e.getSource() == save) {
			JFileChooser jfc = new JFileChooser();
			jfc.setCurrentDirectory(new File("."));//cua so hien thi file tai ngay thu muc chua file nay(newWindow)
			int j = jfc.showSaveDialog(null);
			if(j == JFileChooser.APPROVE_OPTION) {
				File f = new File(jfc.getSelectedFile().getAbsolutePath());
				try {
					PrintWriter pw = new PrintWriter(f);
					pw.println(area.getText());
					
					pw.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		if(e.getSource() == open) {
			JFileChooser jfc = new JFileChooser();
			jfc.setCurrentDirectory(new File("."));
			int j = jfc.showOpenDialog(null);
			if(j == jfc.APPROVE_OPTION) {
				File f = new File(jfc.getSelectedFile().getAbsolutePath());
				try {
					Scanner sc = new Scanner(f);
					String s = "";
					while(sc.hasNextLine()) {
						s = s + sc.nextLine();
						s += "\n";
					}
					area.setText(s);
					sc.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new TextEditor();
	}
}
