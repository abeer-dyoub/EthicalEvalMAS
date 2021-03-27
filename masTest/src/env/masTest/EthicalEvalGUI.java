// CArtAgO artifact code for project masTest

package masTest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import cartago.*;
import cartago.tools.GUIArtifact;

public class EthicalEvalGUI extends GUIArtifact {
	private Eval eval;
	public void setup() {
		eval=new Eval();
		eval.setVisible(true);
	}
	
		
	@OPERATION void reasoner(String s) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/abeer/eclipse-workspace/MASnew/asp/fact.lp"));
				writer.write("answer("+s+").");
				writer.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/abeer/pycharmProjects/ILEDtest/knowledge/bk.lp"));
			BufferedWriter wr = new BufferedWriter(new FileWriter("/home/abeer/eclipse-workspace/MASnew/asp/fact.lp",true));
			String line;
			while ((line = br.readLine()) != null) {
				wr.write(System.lineSeparator());
				wr.write(line);
				
			}
			br.close();
			wr.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
		
		String command = "clingo /home/abeer/eclipse-workspace/MASnew/asp/fact.lp";
		 
		try {
		    Process process = Runtime.getRuntime().exec(command);
		    
		    BufferedReader reader = new BufferedReader(
		            new InputStreamReader(process.getInputStream()));
		    BufferedWriter writer = new BufferedWriter(new FileWriter("/home/abeer/eclipse-workspace/MASnew/asp/answer.txt",false));
		    String line;
		    Scanner scanner;
		    while ((line = reader.readLine()) != null) {
		    	writer.write(line);
		    	writer.write(System.lineSeparator());
				
		    	scanner = new Scanner(line);
		    	String found1 = scanner.findInLine("unethical");
		    	String found2 = scanner.findInLine("ethical");
		    	//System.out.println("Output: " + found);
		    	
		    	 //System.out.println("Left String: " + rest);
		    	 if (found1 != null) {
		    		 String rest = scanner.nextLine();
		    		 eval.setText(found1 + rest);
		    		 scanner.close();
		    		 break;
		    	 }else if (found2 != null) {
		    		 String rest = scanner.nextLine();
		    		 eval.setText(found2 + rest);
		    		 scanner.close();
		    		 break;
		    	 }
		    	 
		    }
	
		    reader.close();
		    writer.close();
		 
		} catch (IOException e) {
		    e.printStackTrace();
		}
		File f=new File("/home/abeer/eclipse-workspace/MASnew/asp/answer.txt");
		ArrayList<String> arraylist = new ArrayList<>();
		try {
		Scanner scan = new Scanner(f);
			while (scan.hasNextLine()){
				arraylist.add(scan.nextLine());
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("file not found:"+ e);
		}
		for(int i=0;i<arraylist.size();i++) {
			String element = arraylist.get(i);
			if (element.contains("Answer")) {
				System.out.println(i+ " : " + element);
				String answer = arraylist.get(i+1);
				String[] just = answer.split("\\s+");
				eval.setJust("Because: \n");
				for(int j=0;j<just.length-1;j++) {
					eval.appendJust(j+ " : " + just[j] +"\n");
					
				}
			}
		}
		
		defineObsProperty("textVal",getValue());
			signal("learn", getValue());
				
			
	}

private String getValue() {
	return eval.getText();
}


static class Eval extends JFrame {
	static String username2;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Eval() {
		setTitle("Ethical Evaluation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		label = new JLabel("Evaluation");
		label.setBounds(15, 17, 177, 14);
		contentPane.add(label);
		
	    text = new JTextField();
		text.setBounds(17, 42, 400, 35);
		contentPane.add(text);
		
		JLabel lbljust = new JLabel("Justification:");
		lbljust.setBounds(17, 100, 123, 14);
		contentPane.add(lbljust);
		
		txtjust = new JTextArea();
		txtjust.setColumns(20);
		txtjust.setRows(3);
		txtjust.setWrapStyleWord(true);
		
		JScrollPane sp = new JScrollPane(txtjust);
		sp.setSize(400, 90);
		sp.setLocation(17, 130);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(100, 50));
		contentPane.add(sp);

		
	}


	public void setText(String s) {
		text.setText(s);
	}
	public String getText() {
		return text.getText();
	}
	
	public String getJust() {
		return txtjust.getText();
	}
	
	public void setJust(String s) {
		txtjust.setText(s);
	}
	
	public void appendJust(String s) {
		txtjust.append(s);;
	}
	
	
	private  javax.swing.JLabel label;

	public  static javax.swing.JTextField text;
	public static javax.swing.JTextArea txtjust;

}
}


