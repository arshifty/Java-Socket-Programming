package GroupChat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.*;
import java.net.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client_2 {

	private JFrame frame;
	static JTextArea ta1,ta2;
	static JButton btn1;
	
	
	static ServerSocket server1;
	static ServerSocket server2;
	static ServerSocket server3;
	
	
	static Socket s1;
	static Socket s2;
	static Socket s3;
	
	
	
	static DataInputStream dinput1;
	static DataInputStream dinput2;
	static DataInputStream dinput3;
	
	
	static DataOutputStream doutput1;
	static DataOutputStream doutput2;
	static DataOutputStream doutput3;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
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
		
		
		Display();
		
		
		
	}
	
	public static void Display()
	{
		try
		{
			
			s2 = new Socket("localhost",1871);		
			
			dinput2 = new DataInputStream(s2.getInputStream());		
			doutput2 = new DataOutputStream(s2.getOutputStream());
		
		
			String msg2 = "";			
			while(!msg2.equals("bye"))
			{			
				msg2 = dinput2.readUTF();			
				ta1.setText(ta1.getText()+"\n****Server     :\t"+msg2);	                                                
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
		frame.setBounds(100, 100, 450, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 ta1 = new JTextArea();
		 ta1.getLineWrap();
		 JScrollPane jsp1 = new JScrollPane(ta1);
		 jsp1.setBounds(10, 43, 414, 168);
		 frame.getContentPane().add(jsp1);
		
		ta2 = new JTextArea();
		ta2.setBounds(10, 233, 322, 51);
		frame.getContentPane().add(ta2);
	 	
	    btn1 = new JButton("Send");
	    btn1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		
	    		try
				{	
					 String messageOutput = "";
					 messageOutput = ta2.getText().trim();
					 ta1.setText(ta1.getText()+"\n"+"Client 2 : "+"   :\t"+messageOutput);
				     doutput2.writeUTF(messageOutput);	
				     ta2.setText("");
			    }				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
	    	}
	    });
		btn1.setBounds(342, 234, 82, 50);
		frame.getContentPane().add(btn1);
		
		JLabel lblNewLabel = new JLabel("Client 2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 3, 167, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 3, 414, 38);
		frame.getContentPane().add(panel);
	}
}
