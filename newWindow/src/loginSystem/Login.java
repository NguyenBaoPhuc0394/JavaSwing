package loginSystem;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame{
	private Passwords pass;
	private JLabel jlb1,jlb2;
	private JButton jb1,jb2;
	private JTextField jt1,jt2;
	
	public Login() {
		pass = new Passwords();
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
		
		jt1 = new JTextField();
		jt1.setBounds(150, 50, 100, 25);
		jt2 = new JTextField();
		jt2.setBounds(150, 100, 100, 25);
		
		jb1 = new JButton("Enter");
		jb1.setBounds(50, 100, 50, 25);
		jb2 = new JButton("Reset");
		jb2.setBounds(100, 100, 50, 25);
		
		jlb1 = new JLabel("Username");
		jlb1.setBounds(50, 50, 100, 25);
		jlb2 = new JLabel("Password");
		jlb2.setBounds(50, 100, 100, 25);
	
		this.add(jlb1);
		this.add(jlb2);
		this.add(jt1);
		this.add(jt2);
		
		//this.setLayout(new FlowLayout());
		this.add(jb1);
		this.add(jb2);
		
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		this.setLayout(null);
		
	}
	public static void main(String[] args) {
		Login login = new Login();
	}

}
