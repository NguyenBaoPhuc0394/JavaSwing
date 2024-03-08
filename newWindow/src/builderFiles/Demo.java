package builderFiles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;

public class Demo extends JFrame {

	JPanel panel;
	Label label;
	JTextArea textArea;
	String content = "",fileName = "";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo frame = new Demo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Demo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 553);
		getContentPane().setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel,BorderLayout.SOUTH);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(75,75));
		
		Controler ac = new Controler(this);
		JButton Save = new JButton("Save");
		Save.setFont(new Font("Tahoma", Font.BOLD, 12));
		Save.setBounds(358, 27, 120, 40);
		panel.add(Save);
		
		JButton open = new JButton("Open");
		open.setFont(new Font("Tahoma", Font.BOLD, 12));
		open.setBounds(490, 27, 120, 40);
		
		Save.addActionListener(ac);
		open.addActionListener(ac);
		
		panel.add(open);
		
		label = new Label("");
		label.setBounds(0, 27, 352, 40);
		panel.add(label);
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane(textArea);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}
}
