package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame implements ActionListener{
	
	Random random = new Random();
	boolean turn = true;
	JPanel panel_title,panel_button;
	JButton[] button;
	JLabel label;
	
	public View() {
		this.init();
		this.setVisible(true);
	}
	private void init() {
		this.setTitle("Tic tac toe");
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		
		label = new JLabel("Tic Tac Toe");
		label.setFont(new Font("Ink Free", Font.BOLD, 50));
		label.setBackground(new Color(25,25,25));
		label.setForeground(Color.green);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		
		panel_title = new JPanel();
		panel_title.setBackground(new Color(25,25,25));
		panel_title.add(label);
		
		panel_button = new JPanel();
		panel_button.setLayout(new GridLayout(3,3));
		
		button = new JButton[9];
		for(int i = 0;i < 9;i++) {
			button[i] = new JButton();
			button[i].setFocusable(false);
			button[i].setFont(new Font("MV Boli", Font.BOLD, 100));
			button[i].addActionListener(this);
			panel_button.add(button[i]);
		}
		
		this.add(panel_button,BorderLayout.CENTER);
		this.add(panel_title,BorderLayout.NORTH);
		
		firstTurn();
	}
	private void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2) == 0) {
			turn = true;
			label.setText("X turn");
		}
		else {
			turn = false;
			label.setText("O turn");
		}
	}
	public void check() {
		//X win
		if(button[0].getText().equals("X") && button[1].getText().equals("X") && button[2].getText().equals("X"))
			xWins(0, 1, 2);
		if(button[3].getText().equals("X") && button[4].getText().equals("X") && button[5].getText().equals("X"))
			xWins(3, 4, 5);
		if(button[6].getText().equals("X") && button[7].getText().equals("X") && button[8].getText().equals("X"))
			xWins(6,7,8);
		if(button[0].getText().equals("X") && button[3].getText().equals("X") && button[6].getText().equals("X"))
			xWins(0, 3, 6);
		if(button[1].getText().equals("X") && button[4].getText().equals("X") && button[7].getText().equals("X"))
			xWins(1,4,7);
		if(button[2].getText().equals("X") && button[5].getText().equals("X") && button[8].getText().equals("X"))
			xWins(2,5,8);
		if(button[0].getText().equals("X") && button[4].getText().equals("X") && button[8].getText().equals("X"))
			xWins(0, 4, 8);
		if(button[2].getText().equals("X") && button[4].getText().equals("X") && button[6].getText().equals("X"))
			xWins(2,4,6);
		//O win
		if(button[0].getText().equals("O") && button[1].getText().equals("O") && button[2].getText().equals("O"))
			oWins(0, 1, 2);
		if(button[3].getText().equals("O") && button[4].getText().equals("O") && button[5].getText().equals("O"))
			oWins(3, 4, 5);
		if(button[6].getText().equals("O") && button[7].getText().equals("O") && button[8].getText().equals("O"))
			oWins(6,7,8);
		if(button[0].getText().equals("O") && button[3].getText().equals("O") && button[6].getText().equals("O"))
			oWins(0, 3, 6);
		if(button[1].getText().equals("O") && button[4].getText().equals("O") && button[7].getText().equals("O"))
			oWins(1,4,7);
		if(button[2].getText().equals("O") && button[5].getText().equals("O") && button[8].getText().equals("O"))
			oWins(2,5,8);
		if(button[0].getText().equals("O") && button[4].getText().equals("O") && button[8].getText().equals("O"))
			oWins(0, 4, 8);
		if(button[2].getText().equals("O") && button[4].getText().equals("O") && button[6].getText().equals("O"))
			oWins(2,4,6);
	}
	public void xWins(int a,int b,int c) {
		for(int i = 0;i < 9;i++) {
			button[i].setEnabled(false);
		}
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		label.setText("X win!!!");
	}
	public void oWins(int a,int b,int c) {
		for(int i = 0;i < 9;i++) {
			button[i].setEnabled(false);
		}
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		label.setText("O win!!!");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i < 9;i++) {
			if(e.getSource() == button[i]) {
				if(turn) {
					if(button[i].getText().equals("")) {
						button[i].setForeground(new Color(255,0,0));
						button[i].setText("X");
						turn = false;
						label.setText("O turn");
						check();
					}
				}	
				else {
					if(button[i].getText().equals("")) {
						button[i].setForeground(new Color(0,0,255));
						button[i].setText("O");
						turn = true;
						label.setText("X turn");
						check();
					}
				}
			}
		}
	}
	
}
