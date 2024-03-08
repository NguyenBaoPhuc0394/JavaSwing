package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator extends JFrame implements ActionListener{
	JPanel panel;
	JTextField textfield;
	JButton[] number;
	JButton[] function;
	JButton addButton,subButton,mulButton,divButton,dotButton,equaButton,clrButton,delButton;
	double num = 0,num1 = 0,result = 0;
	char operator;
	public Calculator() {
		this.Gui();
		this.setVisible(true);
	}
	private void Gui() {
		this.setTitle("Calculator");
		this.setSize(420,550);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(50,50,50));
		
		textfield = new JTextField();
		textfield.setFont(new Font("Arial",Font.PLAIN,25));
		textfield.setBounds(25, 25, 360, 40);
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		
		panel = new JPanel();
		panel.setBounds(25, 90, 360, 350);
		panel.setBackground(Color.gray);
		panel.setLayout(new GridLayout(4,4));
		
		function = new JButton[8];
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		dotButton = new JButton(".");
		equaButton = new JButton("=");
		clrButton = new JButton("clear");
		delButton = new JButton("delete");
		
		function[0] = addButton;
		function[1] = subButton;
		function[2] = mulButton;
		function[3] = divButton;
		function[4] = dotButton;
		function[5] = equaButton;
		function[6] = clrButton;
		function[7] = delButton;
		
		number = new JButton[10];
		for(int i = 0;i < 10;i++) {
			number[i] = new JButton(i + "");
			number[i].setFont(new Font("Arial",Font.PLAIN,25));
			number[i].setFocusable(false);
			number[i].addActionListener(this);
		}
		for(int i = 0;i < 8;i++) {
			function[i].setFocusable(false);
			function[i].setFont(new Font("Arial",Font.PLAIN,25));
			function[i].addActionListener(this);
		}
		
		clrButton.setBounds(75, 460, 125, 35);
		delButton.setBounds(200, 460, 125, 35);
		
		panel.add(number[9]);
		panel.add(number[8]);
		panel.add(number[7]);
		panel.add(equaButton);
		panel.add(number[4]);
		panel.add(number[5]);
		panel.add(number[6]);
		panel.add(addButton);
		panel.add(number[1]);
		panel.add(number[2]);
		panel.add(number[3]);
		panel.add(subButton);
		panel.add(number[0]);
		panel.add(dotButton);
		panel.add(divButton);
		panel.add(mulButton);
		
		this.add(textfield);
		this.add(panel);
		this.add(clrButton);
		this.add(delButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i < 10;i++) {
			if(e.getSource() == number[i]) {
				textfield.setText(textfield.getText() + i);
			}
		}
		if(e.getSource() == addButton) {
			num = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource() == dotButton) {
			textfield.setText(textfield.getText() + ".");
		}
		if(e.getSource() == equaButton) {
			num1 = Double.parseDouble(textfield.getText());
			double result = 0;
			switch(operator) {
				case '+':
					result = num + num1;
					break;
				case '-':
					result = num - num1;
					break;
				case '*':
					result = num * num1;
					break;
				case '/':
					result = num / num1;
					break;	
			}
			textfield.setText(result + "");
			num = result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
	}

}
