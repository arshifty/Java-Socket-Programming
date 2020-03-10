package ClientServerNetwork;

import java.awt.EventQueue;

import javax.swing.JFrame;



import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client_2 {

	private JFrame frame;
	 static JTextArea ta1, ta2;

	    static Socket s2;
	    static DataInputStream dinput2;
	    static DataOutputStream doutput2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_2 window = new Client_2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		try
		{
			s2 = new Socket("localhost",1972);
			
			dinput2 = new DataInputStream(s2.getInputStream());
			doutput2 = new DataOutputStream(s2.getOutputStream());
			
			String msg2 = "";
			while(!msg2.equals("bye"))
			{
				msg2 = dinput2.readUTF();
				ta1.setText(ta1.getText()+"\n****Server   :\t"+msg2);
			}
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}

	/**
	 * Create the application.
	 */
	public Client_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client 2");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblNewLabel.setBounds(89, 11, 227, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 434, 46);
		frame.getContentPane().add(panel);
		
	    ta1 = new JTextArea();
	    ta1.setLineWrap(true);
		JScrollPane jsp1 = new JScrollPane(ta1);
		jsp1.setBounds(0, 58, 434, 150);
		frame.getContentPane().add(jsp1);
		
		ta2 = new JTextArea();
		 ta2.setLineWrap(true);
			JScrollPane jsp2 = new JScrollPane(ta2);
			jsp2.setBounds(10, 215, 317, 35);
		
		frame.getContentPane().add(jsp2);
		
		JButton btn = new JButton("Send");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 			
			{
				try
				{
				String	messageOutput2 ="";
				messageOutput2= ta2.getText().trim();
				ta1.setText(ta1.getText()+"\nClient 2     :\t"+messageOutput2);
				doutput2.writeUTF(messageOutput2);
				ta2.setText("");
				
				}				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
			}
		});
		btn.setBounds(335, 215, 89, 35);
		frame.getContentPane().add(btn);
	}
}
