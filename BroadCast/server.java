package BroadCast;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;



public class server {

	private JFrame frame;
    static JTextArea ta1;
	static JTextArea ta2;
	
	static ServerSocket server1;
	 static ServerSocket server2;
	 static ServerSocket server3;
	
     static	Socket s1;
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
					server window = new server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		try
		{
		///	sERVERsOCKET1();

		///	sERVERsOCKET2();

			broadCasting();
			
			
			
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void broadCasting() 
	{
		try
		{
		
			server1 = new ServerSocket(1971);
			server2 = new ServerSocket(1972);

			s1 = server1.accept();
			s2 = server2.accept();
			
			dinput1 = new DataInputStream(s1.getInputStream());
			doutput1 = new DataOutputStream(s1.getOutputStream());
			dinput2 = new DataInputStream(s2.getInputStream());
			doutput2 = new DataOutputStream(s2.getOutputStream());			
	
			
			String msgin1 = "";	
			String msgin2 = "";			

			while(!(msgin1.equals("bye") || msgin2.equals("bye")))
			{
				msgin1 = dinput1.readUTF();		
				msgin2 = dinput2.readUTF();
				ta1.setText(ta1.getText()+"\n****Client 1     :\t"+msgin1);
				ta1.setText(ta1.getText()+"\n****Client 2     :\t"+msgin2);	
				
				
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	/*
	//// client 1
	public static void sERVERsOCKET1()
	{
		try {
			server1 = new ServerSocket(1971);
			s1 = server1.accept();
			
			dinput1 = new DataInputStream(s1.getInputStream());
			doutput1 = new DataOutputStream(s1.getOutputStream());			
			String msgin1 = "";			
			while(!msgin1.equals("bye"))
			{
				msgin1 = dinput1.readUTF();
				
				ta1.setText(ta1.getText()+"\n****Client 1     :\t"+msgin1);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

////client 2
	public static void sERVERsOCKET2()
	{
		try {
			server2 = new ServerSocket(1972);
			s2 = server2.accept();
			
			dinput2 = new DataInputStream(s2.getInputStream());
			doutput2 = new DataOutputStream(s2.getOutputStream());			
			String msgin2 = "";			
			while(!msgin2.equals("bye"))
			{
				msgin2 = dinput2.readUTF();
				
				ta1.setText(ta1.getText()+"\n****Client 2     :\t"+msgin2);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
*/
	/**
	 * Create the application.
	 */
	public server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 450, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Server");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblNewLabel.setBounds(93, 11, 235, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 434, 58);
		frame.getContentPane().add(panel);
		
		ta1 = new JTextArea();
		ta1.setEditable(false);
		ta1.setLineWrap(true);
		JScrollPane jsp1 = new JScrollPane(ta1);
		jsp1.setBounds(0, 65, 434, 141);	
     	frame.getContentPane().add(jsp1);
		
		
		
		ta2 = new JTextArea();
		ta2.setText("");
		 ta2.setLineWrap(true);
			JScrollPane jsp2 = new JScrollPane(ta2);
			jsp2.setBounds(10, 217, 317, 44);		
		frame.getContentPane().add(jsp2);
		
		
		
		JButton btn = new JButton("Send");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try
				{	
				///Output2();
			    ///	Output1();
					
				 String messageOutput1 = "";
				 messageOutput1 = ta2.getText().trim();
				 String messageOutput2 = "";
				 messageOutput2 = ta2.getText().trim();
               
				 
				 
				 
				 if(messageOutput1!="")
	                {
	   				 doutput1.writeUTF(messageOutput1);	
					
	                }
			    
				 if(messageOutput2 != "")
				 {
					    doutput2.writeUTF(messageOutput2);	
						 
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
		btn.setBounds(337, 217, 89, 37);
		frame.getContentPane().add(btn);
	}
	/*
	///client 1
	public static void Output1()
	{
		try
		{	
			String messageOutput1 = "";
			 messageOutput1 = ta2.getText().trim();
			ta1.setText(ta1.getText()+"\nServer    :\t"+ta2.getText());
		     doutput1.writeUTF(messageOutput1);	
		     ta2.setText("");
	    }				
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	///client 2
	public static void Output2()
	{
		try
		{	
			String messageOutput2 = "";
			 messageOutput2 = ta2.getText().trim();
			ta1.setText(ta1.getText()+"\nServer    :\t"+ta2.getText());
		     doutput2.writeUTF(messageOutput2);	
		     ta2.setText("");
	    }				
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	*/

}
