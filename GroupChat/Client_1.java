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

public class Client_1 {

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
					Client_1 window = new Client_1();
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
			server1 = new ServerSocket(1871);  
			server3 = new ServerSocket(1872);  
			
									s1 = server1.accept();	
									s3 = server3.accept();	
			
			dinput1 = new DataInputStream(s1.getInputStream());              
			doutput1 = new DataOutputStream(s1.getOutputStream());
			
									dinput3 = new DataInputStream(s3.getInputStream());              
									doutput3 = new DataOutputStream(s3.getOutputStream());		
			
			String msg1 = "";	
			String msg3 = "";
			
			while( !(msg1.equals("bye")   || msg3.equals("bye") ) )
			{
				
				msg1 = dinput1.readUTF();	
					ta1.setText(ta1.getText()+"\n****Client 2     :\t"+msg1);	
				
					
			  
			    msg3 = dinput3.readUTF();	
			    	ta1.setText(ta1.getText()+"\n****Client 3     :\t"+msg3);
			    
						

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
	public Client_1() {
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
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		try
				{	
	    			String messageOutput1 = "";
					 messageOutput1 = ta2.getText().trim();
					
					 String messageOutput3 = "";
					 messageOutput3 = ta2.getText().trim();
	               
					 
					 
					 
					 if(messageOutput1!="")
		                {
		   				 doutput1.writeUTF(messageOutput1);	
						
		                }
				    
					 if(messageOutput3 != "")
					 {
						    doutput3.writeUTF(messageOutput3);	
							 
					 }
					 ta1.setText(ta1.getText()+"\nServer    :\t"+ta2.getText());
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
		
		JLabel lblNewLabel = new JLabel("Server Client 1");
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
