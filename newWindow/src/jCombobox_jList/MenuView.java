package jCombobox_jList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ImageUrl.View;

public class MenuView extends JFrame{
	JLabel label,money,list_ch,list_ph;
	JPanel panel,panel_chinh,panel_phu,panel_total;
	String name_ch = "",name_ph = "";
	JComboBox<String>jcb_ch,jcb_ph;
	JList<String>jlist;
	JButton button;
	
	public MenuView() {
		this.Gui();
		this.setVisible(true);
	}

	private void Gui() {
		this.setTitle("Menu");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		ActionListener ac = new Control(this);
		label = new JLabel("Thuc don nha hang",JLabel.CENTER);
		money = new JLabel();
		list_ch = new JLabel("Mon chinh : ");
		list_ph = new JLabel("Mon phu : ");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		String []monchinh = {"com","pho","bun"};
		jcb_ch = new JComboBox<String>(monchinh);
		jcb_ch.addActionListener(ac);
		
		panel_chinh = new JPanel();
		panel_chinh.setLayout(new FlowLayout());
		panel_chinh.add(jcb_ch);
		
		String []monphu = {"milk","tea","coca","cream","lemon","candy"};
		jlist = new JList<String>(monphu);
		
		panel_phu = new JPanel();
		panel_phu.setLayout(new FlowLayout());
		panel_phu.add(jlist);
		
		button = new JButton("Thanh toan");
		button.setFocusable(false);
		button.addActionListener(ac);
		
		panel_total = new JPanel();
		panel_total.setLayout(new GridLayout(2,1));
		panel_total.add(list_ch);
		panel_total.add(money);
		panel_total.add(list_ph);
		panel_total.add(button);
		
		panel.add(panel_chinh);
		panel.add(panel_phu);
		
		this.add(label,BorderLayout.NORTH);
		this.add(panel,BorderLayout.CENTER);
		this.add(panel_total,BorderLayout.SOUTH);
		
	}
	public static void main(String[] args) {
		try {
            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	        new MenuView();
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
	}
	public void setTextList_ch(String s) {
		this.list_ch.setText("Mon chinh : " + s);
	}
	public void setTextList_ph(String s) {
		this.list_ph.setText("Mon phu : " + s);
		name_ph = s;
	}
	public void setMoney() {
		int x = 0;
		if(name_ch.equals("bun"))
			x += 20;
		else if(name_ch.equals("com"))
			x += 25;
		else if(name_ch.equals("pho"))
			x += 15;
		
		String []str = name_ph.split(",");
		for(int i = 0;i < str.length;i++) {
			String s = str[i];
			if(s.equals("candy"))
				x += 5;
			if(s.equals("coca"))
				x += 5;
			if(s.equals("lemon"))
				x += 5;
			if(s.equals("tea"))
				x += 5;
			if(s.equals("milk"))
				x += 5;
			if(s.equals("cream"))
				x += 5;
		}
		this.money.setText(x + "");
	}
}
