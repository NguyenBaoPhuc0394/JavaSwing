package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Try {
	public static void main(String[] args) {
		double kq = 0.0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap chuoi : ");
		String s = sc.nextLine();
		String[] data = new String[s.length()];
		String[] ope = new String[s.length()];
		int j = 0,c=0;
		Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        while(m.find()) {
            data[c] = m.group();
            c++;
        }
        for(int i = 0;i < s.length();i++) {
        	if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
        		ope[j++] = s.charAt(i) + "";
        	}
        }
        for(int i = 0;i < j;i++) {
        	if(i == 0) {
	        	if(ope[i].equals("*")) {
	        		kq = kq + Double.parseDouble(data[i])*Double.parseDouble(data[i+1]);
	        	}
	        	else if(ope[i].equals("/")) {
	        		kq = kq + Double.parseDouble(data[i])/Double.parseDouble(data[i+1]);
	        	}
	        	else if(ope[i].equals("+")) {
	        		kq = kq + Double.parseDouble(data[i])+Double.parseDouble(data[i+1]);
	        	}
	        	else if(ope[i].equals("-")) {
	        		kq = kq + Double.parseDouble(data[i])-Double.parseDouble(data[i+1]);
	        	}
        	}
        	else {
        		if(ope[i].equals("*")) {
	        		kq = kq*Double.parseDouble(data[i+1]);
	        	}
	        	else if(ope[i].equals("/")) {
	        		kq = kq/Double.parseDouble(data[i+1]);
	        	}
	        	else if(ope[i].equals("+")) {
	        		kq = kq+Double.parseDouble(data[i+1]);
	        	}
	        	else if(ope[i].equals("-")) {
	        		kq = kq-Double.parseDouble(data[i+1]);
	        	}
        	}
        }
        System.out.println(kq);
	}
}
