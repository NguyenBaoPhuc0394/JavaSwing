package jCheckBoxMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

public class Control implements ActionListener {
    private View view;
    public Control(View v){
        this.view = v;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("save"))
            view.setTextLabel("Your select is SAVE");
        if(e.getActionCommand().equals("delete"))
            view.setTextLabel("Your select is DELETE");
        if(e.getActionCommand().equals("new"))
            view.setTextLabel("Your select is NEW");
        if(e.getSource() == view.hide) {
        	//AbstractButton check = (AbstractButton) view.hide;
        	if(view.hide.isSelected()) {
        		System.out.println("toolBar");
        		view.showToolBar();
        		
        	}
        	else
        		view.hideToolBar();
        }
    }
}
