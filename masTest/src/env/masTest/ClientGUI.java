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

public class ClientGUI extends GUIArtifact {
	private Client client;
	public void setup() {
		client=new Client();
		linkActionEventToOp(client.send1,"send");
		defineObsProperty("textVal", "");
		client.setVisible(true);
		
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
	return client.getText();
}

static class Client extends JFrame {
	static String username1;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Client() {
		setTitle("ClientGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 display1 = new JTextArea();
		display1.setBounds(17, 42, 370, 186);
		contentPane.add(display1);
		
		 text1 = new JTextArea();
		text1.setBounds(17, 241, 300, 35);
		contentPane.add(text1);
		
		send1 = new JButton("Send");
		send1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s= text1.getText();
			
				if (s.equals("")) {
					return;
				}
				display1.append(username1+":"+s+"\n");
				EmpGUI.Employee.sendText();
				//text1.setText("");
			}
		});
		send1.setBounds(320, 241, 75, 35);
		contentPane.add(send1);
		
		label1 = new JLabel("Chat window for client: "+ username1);
		label1.setBounds(10, 11, 190, 14);
		contentPane.add(label1);
		
		JButton clear1 = new JButton("Clear");
		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display1.setText("");
			}
		});
		clear1.setBounds(310, 7, 75, 23);
		contentPane.add(clear1);
	}

	public static void sendText() {
	String s= EmpGUI.Employee.text2.getText();
	if (s.equals("")) {
		return;
	}
	display1.append(EmpGUI.Employee.username2+":"+s+"\n");
	}
	
	public String getText() {
		return text1.getText();
	}

	private  javax.swing.JLabel label1;
	private  static javax.swing.JTextArea display1;
	private javax.swing.JButton send1;
	public  static javax.swing.JTextArea text1;


}
}
