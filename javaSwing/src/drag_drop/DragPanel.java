package drag_drop;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class DragPanel extends JPanel{
	ImageIcon icon = new ImageIcon("one.png");
	final int WIDTH = icon.getIconWidth();
	final int HEIGHT = icon.getIconHeight();
	Point imageCorner;
	Point prevPt;
	public DragPanel() {
		
		imageCorner = new Point(0,0);
		ClickedListener click = new ClickedListener();
		DragListener drag = new DragListener();
		this.addMouseListener(click);
		this.addMouseMotionListener(drag);
	}
	public void painComponent(Graphics g) {
		super.paintComponent(g);
		icon.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
	}
	private class ClickedListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			prevPt = e.getPoint();
		}
	}
	private class DragListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e) {
			Point currentPt = e.getPoint();
			imageCorner.translate((int)(currentPt.getX() - prevPt.getX()), (int)(currentPt.getY() - prevPt.getY()));
			prevPt = currentPt;
			repaint();
		}
	}
}
