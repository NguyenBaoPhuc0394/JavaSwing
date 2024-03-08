package miniCal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame{
	private Model md;
	private JPanel jp1,jp2;
	private JLabel jl1,jl2,jl3;
	private JButton jb1,jb2,jb3,jb4,jb5,jb6;
	private JTextField jt1,jt2,jt3;
	public View() {
		md = new Model();
		this.init();
		this.setVisible(true);
	}
	public void init() {
		this.setSize(450,450);
		this.setLocationRelativeTo(null);
		this.setTitle("Calculator");
		this.setLayout(new GridLayout(2,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Arial", Font.BOLD, 20);
		
		ActionListener ac = new Control(this);
		
		jb1 = new JButton("+");
		jb2 = new JButton("-");
		jb3 = new JButton("*");
		jb4 = new JButton("/");
		jb5 = new JButton("%");
		jb6 = new JButton("^");
		jb1.setFont(font);
		jb2.setFont(font);
		jb3.setFont(font);
		jb4.setFont(font);
		jb5.setFont(font);
		jb6.setFont(font);
		jb1.setFocusable(false);
		jb2.setFocusable(false);
		jb3.setFocusable(false);
		jb4.setFocusable(false);
		jb5.setFocusable(false);
		jb6.setFocusable(false);
		jb1.addActionListener(ac);
		jb2.addActionListener(ac);
		jb3.addActionListener(ac);
		jb4.addActionListener(ac);
		jb5.addActionListener(ac);
		jb6.addActionListener(ac);
		
		
		jl1 = new JLabel("First number",JLabel.CENTER);
		jl2 = new JLabel("Second number",JLabel.CENTER);
		jl3 = new JLabel("Result",JLabel.CENTER);
		jl1.setFont(font);
		jl2.setFont(font);
		jl3.setFont(font);
		
		jt1 = new JTextField(50);
		jt2 = new JTextField(50);
		jt3 = new JTextField(50);
		jt1.setFont(font);
		jt2.setFont(font);
		jt3.setFont(font);
		
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3,2,10,10));
		jp1.add(jl1);
		jp1.add(jt1);
		jp1.add(jl2);
		jp1.add(jt2);
		jp1.add(jl3);
		jp1.add(jt3);
		
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(2,3,10,10));
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb6);
		
		this.add(jp1);
		this.add(jp2);
		
	}
	
	public static void main(String[] args) {
		View view = new View();
	}
	public void plus() {
		String first = jt1.getText();
		String second = jt2.getText();
		md.setFirst(Double.parseDouble(first));
		md.setSecond(Double.parseDouble(second));
		md.plus();
		this.jt3.setText(md.getResult() + "");
	}
	public void minus() {
		String first = jt1.getText();
		String second = jt2.getText();
		md.setFirst(Double.parseDouble(first));
		md.setSecond(Double.parseDouble(second));
		md.minus();
		this.jt3.setText(md.getResult() + "");
	}
	public void multiply() {
		String first = jt1.getText();
		String second = jt2.getText();
		md.setFirst(Double.parseDouble(first));
		md.setSecond(Double.parseDouble(second));
		md.multiply();
		this.jt3.setText(md.getResult() + "");
	}
	public void divide() {
		String first = jt1.getText();
		String second = jt2.getText();
		md.setFirst(Double.parseDouble(first));
		md.setSecond(Double.parseDouble(second));
		md.divide();
		this.jt3.setText(md.getResult() + "");
	}
	public void mod() {
		String first = jt1.getText();
		String second = jt2.getText();
		md.setFirst(Double.parseDouble(first));
		md.setSecond(Double.parseDouble(second));
		md.mod();
		this.jt3.setText(md.getResult() + "");
	}
	public void power() {
		String first = jt1.getText();
		String second = jt2.getText();
		md.setFirst(Double.parseDouble(first));
		md.setSecond(Double.parseDouble(second));
		md.power();
		this.jt3.setText(md.getResult() + "");
	}
}
