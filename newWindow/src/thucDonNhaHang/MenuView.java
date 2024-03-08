package thucDonNhaHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ImageUrl.View;

public class MenuView extends JFrame{
	JLabel label,money,list_ch,list_ph;
	JRadioButton com,pho,bun;
	ArrayList<JCheckBox> list;
	JPanel panel,panel_chinh,panel_phu,panel_total;
	String name_ch = "",name_ph = "";
	ButtonGroup bg;
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
		panel.setLayout(new GridLayout(2,1));
		
		panel_chinh = new JPanel();
		panel_chinh.setLayout(new GridLayout(1,3));
		com = new JRadioButton("com");
		pho = new JRadioButton("pho");
		bun = new JRadioButton("bun");
		bg = new ButtonGroup();
		pho.addActionListener(ac);
		bun.addActionListener(ac);
		com.addActionListener(ac);
		bg.add(bun);
		bg.add(pho);
		bg.add(com);
		panel_chinh.add(com);
		panel_chinh.add(pho);
		panel_chinh.add(bun);
		panel_chinh.setBackground(Color.green);
		
		list = new ArrayList<JCheckBox>();
		
		panel_phu = new JPanel();
		panel_phu.setLayout(new GridLayout(2,3));
		list.add(new JCheckBox("milk"));
		list.add(new  JCheckBox("tea"));
		list.add(new JCheckBox("coca"));
		list.add(new JCheckBox("lemon"));
		list.add(new JCheckBox("cream"));
		list.add(new JCheckBox("candy"));
		panel_phu.add(list.get(0));
		panel_phu.add(list.get(1));
		panel_phu.add(list.get(2));
		panel_phu.add(list.get(3));
		panel_phu.add(list.get(4));
		panel_phu.add(list.get(5));
		for(JCheckBox jc : list) {
			jc.addActionListener(ac);
		}
		
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
