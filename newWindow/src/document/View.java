package document;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame implements ActionListener{
	//JPanel jp1;
	Model md = new Model();
	JTextArea jta;
	JLabel jl1,jl2,jl3;
	JTextField jtf;
	JButton jb;
	JScrollPane jsc;
	
	public View() {
		this.init();
		this.setVisible(true);
		
	}
	public void init() {
		
		jl1 = new JLabel("VanBan");
		jl1.setBounds(25, 0, 100, 25);
		jl2 = new JLabel("TuKhoa");
		jl2.setBounds(25, 200, 100, 25);
		jl3 = new JLabel();
		jl3.setBounds(275, 260, 100, 25);
		
		jtf = new JTextField();
		jtf.setBounds(25, 225, 350, 25);
		
		jta = new JTextArea();
		jta.setBounds(25, 25, 350, 175);
		
		jb = new JButton();
		jb.setText("Ket qua");
		jb.setFocusable(false);
		jb.setBounds(25, 260, 100, 25);
		jb.addActionListener(this);
		
		this.setLayout(null);
		this.setTitle("Document");
		this.setSize(425,350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jsc = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsc.setBounds(25, 25, 350, 175);
		
		this.add(jl1);
		this.add(jsc);
		this.add(jl2);
		this.add(jtf);
		this.add(jb);
		this.add(jl3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(jta.getText().equals("")) {
			jl3.setText("Khong co du lieu");
		}
		else if(jtf.getText().equals("")) {
			jl3.setText("Chua nhap tu khoa");
		}
		else {
			md.setVanBan(jta.getText());
			md.setKey(jtf.getText());
			md.count();
			jl3.setText(md.getNum());
		}
	}
}
