package builderFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;

public class Controler implements ActionListener{
	Demo demo;
	public Controler(Demo d) {
		demo = d;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		JFileChooser jfile = new JFileChooser();
		if(s.equals("Open")) {
			int n = jfile.showOpenDialog(this.demo);
			if(n == JFileChooser.APPROVE_OPTION) {
				File file = jfile.getSelectedFile();
				demo.label.setText(file.getAbsolutePath());
				demo.fileName = file.getAbsolutePath();
				String name = file.getName();
				if(name.endsWith(".txt")) {
					try {
						List<String> allText = Files.readAllLines(file.toPath(),StandardCharsets.UTF_8);
						String strArea="";
						for (String lnText:allText) {
							if (lnText.trim().equals("") == false) {
								strArea += lnText.trim();
								strArea +="\n";
							}	
						}
						this.demo.textArea.setText(strArea);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		else if(s.equals("Save")) {
			if(demo.fileName.length() > 0) {
				try {
					PrintWriter pw = new PrintWriter(demo.fileName);
					String data = demo.textArea.getText();
					pw.write(data);
					pw.flush();
					pw.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			else {
				int n = jfile.showSaveDialog(this.demo);
				if(n == JFileChooser.APPROVE_OPTION) {
					try {
						File file = jfile.getSelectedFile();
						PrintWriter pw = new PrintWriter(file.getAbsolutePath());
						String data = demo.textArea.getText();
						pw.write(data);
						pw.flush();
						pw.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}	
//					}catch(UnsupportedEncodingException e2) {
//						e2.printStackTrace();
//					}
				}
			}
		}
		
	}

}
