package quizGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Quiz extends JFrame implements ActionListener{
	
	String[] questions = {
			"How do you do?",
			"How are thing?",
			"Can I help you?"
	};
	String[][] options = {
			{"yes","no","ok","go out"},{"good","bad","normal","great"},{"yep","yup","oki","kk"}
	};
	char[] answers = {'A','B','C','D'};
	char guess;
	char answer;
	char ans;
	int seconds = 10;
	int total = questions.length;
	int result;
	int index;
	int correct;
	
	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			second.setText(String.valueOf(seconds));
			if(seconds <= 0)
				displayAnswer();
		}
	});
	
	JTextField textfield;
	JTextArea textarea;
	JLabel label;
	JButton button_A,button_B,button_C,button_D;
	JLabel lbA,lbB,lbC,lbD;
	JLabel second,time_label;
	JTextField number_right,percentage;
	
	public Quiz() {
		init();
		addComponent();
		this.setVisible(true);
	}
	
	public void init() {
		this.setSize(500,500);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setType(Type.UTILITY);
	}
	
	public void addComponent() {
		textfield = new JTextField();
		textfield.setBackground(Color.black);
		textfield.setBounds(0, 0, 500, 50);
		textfield.setFont(new Font("Ink Free", Font.ITALIC, 30));
		textfield.setForeground(Color.green);
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea = new JTextArea();
		textarea.setBackground(Color.black);
		textarea.setBounds(0, 50, 500, 50);
		textarea.setFont(new Font("MV Boli", Font.PLAIN, 30));
		textarea.setForeground(Color.green);
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		button_A = new JButton("A");
		button_A.setBackground(Color.orange);
		button_A.setBounds(0, 100, 100, 75);
		button_A.setFont(new Font("MV Boli",Font.PLAIN,28));
		button_A.setFocusable(false);
		button_A.addActionListener(this);
		
		button_B = new JButton("B");
		button_B.setBackground(Color.orange);
		button_B.setBounds(0, 175, 100, 75);
		button_B.setFont(new Font("MV Boli",Font.PLAIN,28));
		button_B.setFocusable(false);
		button_B.addActionListener(this);
		
		button_C = new JButton("C");
		button_C.setBackground(Color.orange);
		button_C.setBounds(0, 250, 100, 75);
		button_C.setFont(new Font("MV Boli",Font.PLAIN,28));
		button_C.setFocusable(false);
		button_C.addActionListener(this);
		
		button_D = new JButton("D");
		button_D.setBackground(Color.orange);
		button_D.setBounds(0, 325, 100, 75);
		button_D.setFont(new Font("MV Boli",Font.PLAIN,28));
		button_D.setFocusable(false);
		button_D.addActionListener(this);
		
		lbA = new JLabel();
		lbA.setBounds(100, 100, 400, 75);
		lbA.setBackground(this.getBackground());
		lbA.setForeground(Color.ORANGE);
		lbA.setFont(new Font("MV Boli",Font.PLAIN,25));
		
		lbB = new JLabel();
		lbB.setBounds(100, 175, 400, 75);
		lbB.setBackground(this.getBackground());
		lbB.setForeground(Color.ORANGE);
		lbB.setFont(new Font("MV Boli",Font.PLAIN,25));
		
		lbC = new JLabel();
		lbC.setBounds(100, 250, 400, 75);
		lbC.setBackground(this.getBackground());
		lbC.setForeground(Color.ORANGE);
		lbC.setFont(new Font("MV Boli",Font.PLAIN,25));
		
		lbD = new JLabel();
		lbD.setBounds(100, 325, 400, 75);
		lbD.setBackground(this.getBackground());
		lbD.setForeground(Color.ORANGE);
		lbD.setFont(new Font("MV Boli",Font.PLAIN,25));
		
		second = new JLabel();
		second.setBounds(375, 400, 110, 70);
		second.setBackground(new Color(0,0,0));
		second.setForeground(Color.green);
		second.setFont(new Font("Ink Free",Font.PLAIN,25));
		second.setBorder(BorderFactory.createBevelBorder(1));
		second.setOpaque(true);
		second.setHorizontalAlignment(JLabel.CENTER);
		second.setText(String.valueOf(seconds));
		
		time_label = new JLabel();
		time_label.setBounds(300, 400, 75, 70);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(Color.green);
		time_label.setOpaque(true);
		time_label.setFont(new Font("Ink Free",Font.PLAIN,20));
		time_label.setHorizontalAlignment(JLabel.LEFT);
		time_label.setText("Time:>D");
		
		number_right = new JTextField();
		number_right.setBounds(150, 175, 200, 100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setOpaque(true);
		number_right.setEditable(false);
		number_right.setHorizontalAlignment(JTextField.CENTER);
		
		percentage = new JTextField();
		percentage.setBounds(150, 275, 200, 100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setOpaque(true);
		percentage.setEditable(false);
		percentage.setHorizontalAlignment(JTextField.CENTER);
		
		this.add(time_label);
		this.add(second);
		this.add(textfield);
		this.add(textarea);
		this.add(button_A);
		this.add(button_B);
		this.add(button_C);
		this.add(button_D);
		this.add(lbA);
		this.add(lbB);
		this.add(lbC);
		this.add(lbD);
		
		nextQuestion();
	}
	
	public void nextQuestion() {
		if(index >= total) {
			results();
		}
		else {
			textfield.setText("Question " + (index + 1));
			textarea.setText(questions[index]);
			lbA.setText(options[index][0]);
			lbB.setText(options[index][1]);
			lbC.setText(options[index][2]);
			lbD.setText(options[index][3]);
			timer.start();
		}
	}
	
	public void displayAnswer() {
		timer.stop();
		
		button_A.setEnabled(false);
		button_B.setEnabled(false);
		button_C.setEnabled(false);
		button_D.setEnabled(false);
		
		if(answers[index] != 'A') {
			lbA.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'B') {
			lbB.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'C') {
			lbC.setForeground(new Color(255,0,0));
		}
		if(answers[index] != 'D') {
			lbD.setForeground(new Color(255,0,0));
		}
		
		Timer pause = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbA.setForeground(Color.ORANGE);
				lbB.setForeground(Color.ORANGE);
				lbC.setForeground(Color.ORANGE);
				lbD.setForeground(Color.ORANGE);
				
				answer = ' ';
				seconds=10;
				second.setText(String.valueOf(seconds));
				button_A.setEnabled(true);
				button_B.setEnabled(true);
				button_C.setEnabled(true);
				button_D.setEnabled(true);
				index++;
				nextQuestion();
				
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	
	public void results() {
		button_A.setEnabled(false);
		button_B.setEnabled(false);
		button_C.setEnabled(false);
		button_D.setEnabled(false);
		
		result = (int)((correct/(double)total)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		lbA.setText("");
		lbB.setText("");
		lbC.setText("");
		lbD.setText("");
		
		number_right.setText("("+correct+"/"+total+")");
		percentage.setText(result+"%");
		
		this.add(number_right);
		this.add(percentage);
	}
	
	public void actionPerformed(ActionEvent e) {
		button_A.setEnabled(false);
		button_B.setEnabled(false);
		button_C.setEnabled(false);
		button_D.setEnabled(false);
		
		if(e.getSource() == button_A) {
			answer = 'A';
			if(answer == answers[index])
				correct++;
		}
		if(e.getSource() == button_B) {
			answer = 'B';
			if(answer == answers[index])
				correct++;
		}
		if(e.getSource() == button_C) {
			answer = 'C';
			if(answer == answers[index])
				correct++;
		}
		if(e.getSource() == button_D) {
			answer = 'D';
			if(answer == answers[index])
				correct++;
		}
		displayAnswer();
	}
	
	public static void main(String[] args) {
		new Quiz();
	}
	
}
