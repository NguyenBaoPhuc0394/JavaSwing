package thucDonNhaHang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Control implements ActionListener{
	MenuView mnv;
	public Control(MenuView m) {
		mnv = m;
	}
	public void actionPerformed(ActionEvent e) {
		//String monChinh,monPhu;
		Enumeration<AbstractButton> button_ch =  mnv.bg.getElements();
		while(button_ch.hasMoreElements()) {
			AbstractButton b = button_ch.nextElement();
			if(b.isSelected()) {
				mnv.setTextList_ch(b.getText());
				mnv.name_ch = b.getText();
				mnv.setMoney();
			}
		}
		String s = "";
		for (JCheckBox jc : mnv.list) {
			if(jc.isSelected()) {
				s += jc.getText();
				s += ",";
			}
		}
		mnv.setTextList_ph(s);
		mnv.setMoney();
		
		if(e.getSource() == mnv.button) {
			if(s.equals("") && mnv.name_ch.equals("")) {
				JOptionPane.showMessageDialog(mnv, "Ban chua chon mon","Wait",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				String soTien = JOptionPane.showInputDialog(mnv,"Nhap so tien","Thanh toan",JOptionPane.PLAIN_MESSAGE);
				try {
					double d = Double.parseDouble(soTien);
					double tienthoi = 0;
					double money = Double.parseDouble(mnv.money.getText());
					if(d == money) {
						JOptionPane.showMessageDialog(mnv, "Ban da thanh toan thanh cong","confirm",JOptionPane.PLAIN_MESSAGE);
						
					}
					else if(d > money) {
						tienthoi = d - money;
						JOptionPane.showMessageDialog(mnv, "tien thua : " + tienthoi,"Tien thua",JOptionPane.PLAIN_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(mnv, "Ban chua tra du tien","khong thanh cong",JOptionPane.WARNING_MESSAGE);
				}catch(Exception err) {
					JOptionPane.showMessageDialog(mnv, "Nhap sai du lieu","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
