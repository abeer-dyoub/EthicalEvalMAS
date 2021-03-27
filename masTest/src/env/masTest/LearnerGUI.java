// CArtAgO artifact code for project masTest

package masTest;

import cartago.*;
import cartago.tools.GUIArtifact;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LearnerGUI extends GUIArtifact {
	
	private LearnerGUI1 learner;
	public void setup() {
		
	}
	
	@OPERATION void startLearning(String s) {
		System.out.println("s is empty:"+s);
		try {
			learner=new LearnerGUI1();
			//LearnerGUI1 window = new LearnerGUI1();
			learner.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void init(int initialValue) {
		defineObsProperty("count", initialValue);
	}

	@OPERATION
	void inc() {
		ObsProperty prop = getObsProperty("count");
		prop.updateValue(prop.intValue()+1);
		signal("tick");
	}
	
	void doSignal() {
		signal("rievaluate");
	}	
	


class LearnerGUI1 {

	JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public LearnerGUI1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 652, 724);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Learner GUI");
		frame.getContentPane().setLayout(null);
		
		JLabel lblFacts = new JLabel("Case Facts: ");
		lblFacts.setBounds(31, 10, 90, 14);
		lblFacts.setHorizontalAlignment(SwingConstants.LEFT);
		lblFacts.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(lblFacts);
		
		JTextArea txtAreaF = new JTextArea();
		txtAreaF.setColumns(20);
		txtAreaF.setRows(3);
		txtAreaF.setWrapStyleWord(true);
		//txtAreaF.setText("answer(healthyWayToLooseWeight)\r\nclaim(healthyWayToLooseWeight)\r\nnotverifiedcertificate(healthyWayToLooseWeight)");
		//txtAreaF.setBounds(113, 6, 435, 87);
		
		JScrollPane sp1 = new JScrollPane(txtAreaF);
		sp1.setSize(400, 90);
		sp1.setLocation(100, 30);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp1.setPreferredSize(new Dimension(100, 50));
		frame.getContentPane().add(sp1);
		
		
		JButton btnAddFacts = new JButton("Add to BK");
		btnAddFacts.setBounds(401, 125, 110, 23);
		frame.getContentPane().add(btnAddFacts);
		
		btnAddFacts.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
			JFileChooser fc1 = new JFileChooser();
			fc1.setDialogTitle("Specify a file to save");
			int userSelection = fc1.showSaveDialog(frame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File f1 = fc1.getSelectedFile();
			try {
				FileWriter w1 = new FileWriter(f1.getAbsolutePath(),true);
				w1.write(System.lineSeparator());
				w1.write(txtAreaF.getText());
				w1.flush();
				w1.close();
			} catch (IOException ex) {
				System.out.println("problem writting to the file");
			
			}
			}
		}});
		
		JLabel lblEval = new JLabel("Ethical Evaluation: ");
		lblEval.setBounds(31, 139, 135, 14);
		frame.getContentPane().add(lblEval);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 159, 91, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"unethical", "ethical"}));
		frame.getContentPane().add(comboBox);
		
		JLabel lblContext = new JLabel("Context:");
		lblContext.setBounds(31, 206, 60, 14);
		frame.getContentPane().add(lblContext);
		
		JTextArea txtAreaC = new JTextArea();
		txtAreaC.setColumns(20);
		txtAreaC.setRows(3);
		txtAreaC.setWrapStyleWord(true);
		//txtAreaF.setText("answer(healthyWayToLooseWeight)\r\nclaim(healthyWayToLooseWeight)\r\nnotverifiedcertificate(healthyWayToLooseWeight)");
		//txtAreaF.setBounds(113, 6, 435, 87);
		
		JScrollPane sp2 = new JScrollPane(txtAreaC);
		sp2.setSize(400, 90);
		sp2.setLocation(100, 212);
		sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp2.setPreferredSize(new Dimension(100, 50));
		frame.getContentPane().add(sp2);
		
		JButton btnAddContext = new JButton("Add to BK");
		btnAddContext.setBounds(401, 313, 110, 23);
		frame.getContentPane().add(btnAddContext);
		
		btnAddContext.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
			JFileChooser fc2 = new JFileChooser();
			fc2.setDialogTitle("Specify a file to save");
			int userSelection = fc2.showSaveDialog(frame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File f2 = fc2.getSelectedFile();
			try {
				FileWriter w2 = new FileWriter(f2.getAbsolutePath(),true);
				w2.write(System.lineSeparator());
				w2.write(txtAreaC.getText());
				w2.flush();
				w2.close();
			} catch (IOException ex) {
				System.out.println("problem writting to the file");
			
			}
			}
		}});
		
		JLabel lblMode = new JLabel("Mode Declarations:");
		lblMode.setBounds(31, 341, 140, 14);
		frame.getContentPane().add(lblMode);
		
		JTextArea txtAreaM = new JTextArea();
		txtAreaM.setColumns(20);
		txtAreaM.setRows(3);
		txtAreaM.setWrapStyleWord(true);
		
		JScrollPane sp3 = new JScrollPane(txtAreaM);
		sp3.setSize(400, 90);
		sp3.setLocation(100, 368);
		sp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp3.setPreferredSize(new Dimension(100, 50));
		frame.getContentPane().add(sp3);
		
		JButton btnAddMode = new JButton("Add to Modes");
		btnAddMode.setBounds(388, 465, 125, 23);
		frame.getContentPane().add(btnAddMode);
		
		btnAddMode.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
			JFileChooser fc3 = new JFileChooser();
			fc3.setDialogTitle("Specify a file to save");
			int userSelection = fc3.showSaveDialog(frame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File f3 = fc3.getSelectedFile();
			try {
				FileWriter w3 = new FileWriter(f3.getAbsolutePath(),true);
				w3.write(System.lineSeparator());
				w3.write(txtAreaM.getText());
				w3.flush();
				w3.close();
			} catch (IOException ex) {
				System.out.println("problem writting to the file");
			
			}
			}
		}});
		
		JLabel lblExamples = new JLabel("Examples (JSON Format):");
		lblExamples.setBounds(31, 490, 180, 14);
		frame.getContentPane().add(lblExamples);
		
		JTextArea txtAreaE = new JTextArea();
		txtAreaE.setColumns(20);
		txtAreaE.setRows(3);
		txtAreaE.setWrapStyleWord(true);
		
		JScrollPane sp4 = new JScrollPane(txtAreaE);
		sp4.setSize(400, 90);
		sp4.setLocation(100, 518);
		sp4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp4.setPreferredSize(new Dimension(100, 50));
		frame.getContentPane().add(sp4);
		
		JButton btnAddExamples = new JButton("Save To File");
		btnAddExamples.setBounds(388, 619, 120, 23);
		frame.getContentPane().add(btnAddExamples);
		String[] fileName = new String[2];
		btnAddExamples.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
			JFileChooser fc4 = new JFileChooser();
			fc4.setDialogTitle("Specify a file to save");
			int userSelection = fc4.showSaveDialog(frame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File f4 = fc4.getSelectedFile();
				fileName[0] = f4.getAbsolutePath();
			try {
				FileWriter w4 = new FileWriter(f4.getAbsolutePath(),true);
				w4.write(System.lineSeparator());
				w4.write(txtAreaE.getText());
				w4.flush();
				w4.close();
			} catch (IOException ex) {
				System.out.println("problem writting to the file");
			
			}
			}
		}});
		
		
		JButton btnStartLearning = new JButton("Start Learning");
		btnStartLearning.setBounds(241, 651, 140, 23);
		frame.getContentPane().add(btnStartLearning);
		
		btnStartLearning.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {
			System.out.println(fileName[0]);
			try {
			System.out.println(new BufferedReader(
			            new InputStreamReader(Runtime.getRuntime().exec("pwd").getInputStream())).readLine());
			} catch (IOException e) {
			    e.printStackTrace();
			}
			String mongoCommand = "mongoimport -d mydbx -c examples --file " + fileName[0];
			String iledCommand = "python main.py db=mydbx";
			
			
			try {
			    Process process1 = Runtime.getRuntime().exec(mongoCommand);
			    BufferedReader reader = new BufferedReader(
			            new InputStreamReader(process1.getInputStream()));
			    String line;
			    while ((line = reader.readLine()) != null) {
			    	System.out.println(line);
			    	 
			    }
		
			    reader.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
			//process2 of iledCommand
			try {
			    //sleep 10 seconds
				try {
					Thread.sleep(10*1000);
				}catch(InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			    Process process2 = Runtime.getRuntime().exec(iledCommand,null,new File("//home//abeer//pycharmProjects//ILEDtest//src//"));
			    try {
					Thread.sleep(20*1000);
				}catch(InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			    process2.destroy();
			    
			    BufferedReader reader2 = new BufferedReader(
			            new InputStreamReader(process2.getInputStream()));
			    BufferedWriter writer2 = new BufferedWriter(
			    		new FileWriter("/home/abeer/eclipse-workspace/MASnew/asp/iledout.txt"));
			    String line2;
			    while ((line2 = reader2.readLine()) != null) {
			    	writer2.write(System.lineSeparator());
					writer2.write(line2);	 
			    }		
			    reader2.close();
			    writer2.close();
			   
			    
			} catch (IOException e) {
			    e.printStackTrace();
			}
			//copy learned rules to bk
			try {
				BufferedReader br = new BufferedReader(new FileReader("/home/abeer/pycharmProjects/ILEDtest/theory"));
				BufferedWriter wr = new BufferedWriter(new FileWriter("/home/abeer/pycharmProjects/ILEDtest/knowledge/bk.lp",true));
				String line;
				while ((line = br.readLine()) != null) {
					wr.write(System.lineSeparator());
					wr.write(line);
					
				}
				br.close();
				wr.close();
				signal("rievaluate");

			}catch (IOException e) {
			    e.printStackTrace();
			}
		}});
		
		
	}
}
}