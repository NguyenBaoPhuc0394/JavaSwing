package mouseE;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
	private JPanel jp_top,jp_bot;
	private JLabel jl_pos;
	private JLabel jl_x;
	private JLabel jl_y;
	private JLabel jl_num;
	private JLabel jl_getNum;
	private JLabel jl_inClick;
	private JLabel jl_result;
	private JLabel jl_empty1;
	private JLabel jl_empty2;
	private Model model;
	
	public View() {
		this.Gui();
		this.setVisible(true);
	}

	private void Gui() {
		this.setTitle("Pain");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Control mouse = new Control(this);
		
		model = new Model();
		
		jl_pos = new JLabel("position: ");
		jl_x = new JLabel("x = ");
		jl_y = new JLabel("y = ");
		jl_num = new JLabel("number of click: ");
		jl_getNum = new JLabel("");
		jl_inClick = new JLabel("mouse is in component: ");
		jl_result = new JLabel("");
		jl_empty1 = new JLabel("");
		jl_empty2 = new JLabel("");
		
		jp_top = new JPanel();
		jp_top.setLayout(null);
		jp_top.addMouseListener(mouse);
		jp_top.addMouseMotionListener(mouse);
		
		jp_bot = new JPanel();
		jp_bot.setLayout(new GridLayout(3,3));
		jp_bot.add(jl_pos);
		jp_bot.add(jl_x);
		jp_bot.add(jl_y);
		jp_bot.add(jl_num);
		jp_bot.add(jl_getNum);
		jp_bot.add(jl_empty1);
		jp_bot.add(jl_inClick);
		jp_bot.add(jl_result);
		jp_bot.add(jl_empty2);
		
		this.add(jp_top, BorderLayout.CENTER);
		this.add(jp_bot,BorderLayout.SOUTH);
	}
	public void click() {
		this.model.addClick();
		this.jl_getNum.setText(this.model.getCount() + "");
	}
	
	public void enter() {
		this.model.enter();
		this.jl_result.setText(this.model.isCheck() + "");
	}
	
	public void exit() {
		this.model.exit();
		this.jl_result.setText(this.model.isCheck() + "");
	}

	public void update(int x, int y) {
		this.model.setX(x);
		this.model.setY(y);
		jl_x.setText("x = " + this.model.getX());
		jl_y.setText("y = " + this.model.getY());
		
	}
}
