package mouseE;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseCoordinates extends JFrame implements MouseListener {
    JLabel label;

    public MouseCoordinates() {
        super("Mouse Coordinates");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        label = new JLabel();
        addMouseListener(this);
        add(label);
    }

    public void mouseClicked(MouseEvent e) {
        label.setText("X: " + e.getX() + " Y: " + e.getY());
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args) {
        new MouseCoordinates().setVisible(true);
    }
}
