package jCheckBoxMenuItem;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JcheckboxMenuItemMouse implements MouseListener{
	View view;
	
	public JcheckboxMenuItemMouse(View v) {
		view = v;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isPopupTrigger()) {
			this.view.jpop.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
