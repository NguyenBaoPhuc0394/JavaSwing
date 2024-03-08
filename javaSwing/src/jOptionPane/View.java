package jOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class View {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(null, "Hello","title",JOptionPane.PLAIN_MESSAGE);
		//jop.showMessageDialog(null, "Hello","title",JOptionPane.CANCEL_OPTION);
		//jop.showMessageDialog(null, "Hello","title",JOptionPane.DEFAULT_OPTION);
		//jop.showMessageDialog(null, "Hello","title",JOptionPane.CLOSED_OPTION);
		//jop.showMessageDialog(null, "Hello","title",JOptionPane.WARNING_MESSAGE);
		//jop.showMessageDialog(null, "Hello","title",JOptionPane.INFORMATION_MESSAGE);\
		
//		jop.showConfirmDialog(null, "Are you human??","Check",JOptionPane.WARNING_MESSAGE);
//		int a = jop.showConfirmDialog(null, "Are you human??","Check",JOptionPane.YES_NO_CANCEL_OPTION);
//		System.out.println(a);
//		jop.showInputDialog("What's your name : ");
//		String s = jop.showInputDialog("What's your name : ");
//		System.out.println(s);
		String[] s = {"one","two","three","four"};
		ImageIcon ima = new ImageIcon("icons8-java-64.png");
		jop.showOptionDialog(null, "java", "swing", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, ima, s, 0);
	}
}
