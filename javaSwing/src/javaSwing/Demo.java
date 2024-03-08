package javaSwing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
public class Demo{
	public static void main(String[] args) {
        ImageIcon image = new ImageIcon("icons8-java-48.png");
        Border boder = BorderFactory.createLineBorder(Color.yellow, 2);
        
        JLabel label = new JLabel();
        label.setText("this is java");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.red);
        label.setFont(new Font("MV Boli",Font.PLAIN,21));
        label.setIconTextGap(-25);
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setBorder(boder);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        //label.setBounds(0, 0, 250, 250);
    
        JFrame frame = new JFrame();
        //frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        //frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.getContentPane().setBackground(Color.green);
        frame.pack();
        frame.setVisible(true);
    }
}
