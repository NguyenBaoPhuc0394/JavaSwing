package jPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
}
