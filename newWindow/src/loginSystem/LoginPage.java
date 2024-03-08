package loginSystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener{
	private Passwords pass = new Passwords();
	private JPanel jp1,jp2;
	private JLabel jlb1,jlb2,jlb3;
	private JButton jb1,jb2;
	private JTextField jt;
	private JPasswordField jpw;
	
	public LoginPage() {
		pass = new Passwords();
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
		
		jt = new JTextField();
		jt.setBounds(150, 50, 100, 25);
		jpw = new JPasswordField();
		jpw.setBounds(150, 100, 100, 25);
		
		jb1 = new JButton("Enter");
		jb1.setBounds(90, 25, 100, 25);
		jb1.setFocusable(false);
		jb1.addActionListener(this);
		jb2 = new JButton("Reset");
		jb2.setBounds(210, 25, 100, 25);
		jb2.setFocusable(false);
		jb2.addActionListener(this);
		
		jlb1 = new JLabel("Username");
		jlb1.setBounds(50, 50, 100, 25);
		jlb2 = new JLabel("Password");
		jlb2.setBounds(50, 100, 100, 25);
		jlb3 = new JLabel();
		jlb3.setBounds(90, 150, 200, 50);
		
		jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.add(jlb1);
		jp1.add(jlb2);
		jp1.add(jt);
		jp1.add(jpw);
		jp1.add(jlb3);
		
		jp2 = new JPanel();
		jp2.setLayout(null);
		jp2.add(jb1);
		jp2.add(jb2);
		
		jp1.setBounds(0, 0, 400, 200);
		jp2.setBounds(0, 200, 400, 200);
		
		this.add(jp1);
		this.add(jp2);
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		this.setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jb2) {
			jt.setText("");
			jpw.setText("");
		}
		if(e.getSource() == jb1) {
			String user = jt.getText();
			String pw = "";
			if(pass.getData().containsKey(user)) {
				pw = String.valueOf(jpw.getPassword());//quan trong
				if(pass.getData().get(user).equals(pw)) {
					jlb3.setText("Login successful");
					jlb3.setForeground(Color.green);
					jlb3.setFont(new Font("Arial",Font.BOLD | Font.ITALIC,20));
					Page page = new Page();
				}
				else {
					jlb3.setText("Wrong Password");
					jlb3.setForeground(Color.red);
					jlb3.setFont(new Font("Arial",Font.BOLD | Font.ITALIC,20));
				}
			}
			else {
				jlb3.setText("Username not found");
				jlb3.setForeground(Color.red);
				jlb3.setFont(new Font("Arial",Font.BOLD | Font.ITALIC,20));
			}
		}
	}

}
