package jCombobox_jList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

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
		String chose_ch = mnv.jcb_ch.getSelectedItem().toString();
		mnv.setTextList_ch(chose_ch);
		mnv.name_ch = chose_ch;
		
		String s = "";
		List<String> lc = mnv.jlist.getSelectedValuesList();
		for (String jc : lc) {
			s += jc;
			s += ",";
		}
		mnv.setTextList_ph(s);
		mnv.name_ph = s;
		if(e.getSource() == mnv.button) {
			mnv.setMoney();
		}
	}

}
