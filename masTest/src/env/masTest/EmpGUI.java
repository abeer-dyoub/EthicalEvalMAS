// CArtAgO artifact code for project masTest

package masTest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import cartago.*;
import cartago.tools.GUIArtifact;

public class EmpGUI extends GUIArtifact {
	private Employee emp;
	public void setup() {
		emp=new Employee();
		linkActionEventToOp(emp.send2, "send");
		defineObsProperty("textVal", "");
		emp.setVisible(true);
	}

	@INTERNAL_OPERATION void send(ActionEvent ev) {
		updateText(ev);
		signal("send");
	
	}
	@INTERNAL_OPERATION void updateText(ActionEvent ev) {
		getObsProperty("textVal").updateValue(getValue());
	
	}
	@OPERATION void printValue(String s) {
		ObsProperty prop = this.getObsProperty("textVal");
		System.out.println(s+":"+prop.stringValue());
	}

private String getValue() {
	return emp.getText();
}


static class Employee extends JFrame {
	static String username2;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Employee() {
		setTitle("EmpGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    display2 = new JTextArea();
		display2.setBounds(17, 42, 370, 186);
		contentPane.add(display2);
		
	    text2 = new JTextArea();
		text2.setBounds(17, 241, 300, 35);
		contentPane.add(text2);
		
	    send2 = new JButton("Send");
		send2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s= text2.getText();
				if (s.equals("")) {
					return;
				}
				display2.append(username2+":"+s+"\n");
				ClientGUI.Client.sendText();
				text2.setText("");
			}
		});
		send2.setBounds(320, 241, 75, 35);
		contentPane.add(send2);
		
		JButton clear2 = new JButton("Clear");
		clear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display2.setText("");
			}
		});
		clear2.setBounds(310, 11, 75, 23);
		contentPane.add(clear2);
		
		label2 = new JLabel("Chat Window for Emp: "+username2);
		label2.setBounds(17, 17, 190, 14);
		contentPane.add(label2);
	}

	public static void sendText() {
	String s= ClientGUI.Client.text1.getText();
	if (s.equals("")) {
		return;
	}
	display2.append(ClientGUI.Client.username1+":"+s+"\n");
	}
	
	public String getText() {
		return text2.getText();
	}
	private  javax.swing.JLabel label2;
	private  static javax.swing.JTextArea display2;
	public javax.swing.JButton send2;
	public  static javax.swing.JTextArea text2;

}
}


