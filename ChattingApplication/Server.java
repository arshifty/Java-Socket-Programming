package ChattingApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.*;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server {

	JFrame frame;
	private JTextField tf2;
	
	static ServerSocket server;
	static Socket s;
	static DataInputStream dinput;
	static DataOutputStream doutput;
	private static JTextArea ta2;
	private JButton btn1;

	String str1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
		try
		{
			 server = new ServerSocket(2323);
			 s = server.accept();
        	 dinput = new DataInputStream(s.getInputStream());
			 doutput = new DataOutputStream(s.getOutputStream());
			 String messageInput = "";
			 while(!messageInput.equals("bye"))
			 {
				 messageInput = dinput.readUTF();
		         ta2.setText(ta2.getText().trim()+"\n****   :\t"+ messageInput);
		
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
	public Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	    private void initialize() 
	    {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 153, 153));
		frame.setBounds(100, 100, 482, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	     str1 = JOptionPane.showInputDialog("Enter server name : ");
		JLabel lblNewLabel = new JLabel(str1);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 11, 237, 39);
		frame.getContentPane().add(lblNewLabel);
		
		tf2 = new JTextField();
		tf2.setBounds(0, 261, 360, 39);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		
		btn1 = new JButton("Send");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						try
						{	
							 String messageOutput = "";
							 messageOutput = tf2.getText().trim();
							ta2.setText(ta2.getText()+"\n"+str1+"   :\t"+tf2.getText());
						     doutput.writeUTF(messageOutput);	
						     tf2.setText("");
					    }				
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
				
				
			}
		});
		btn1.setBounds(370, 261, 89, 39);
		frame.getContentPane().add(btn1);
		
		ta2 = new JTextArea();
	    ta2.setLineWrap(true);
		ta2.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(ta2);
		jsp.setBounds(0, 69, 466, 178);
		frame.getContentPane().add(jsp);
		
		
		ImageIcon i=new ImageIcon("G:\\1 project\\src\\ChattingApplication\\c.jpg");
		JLabel lblNewLabel_1 = new JLabel(i);
		lblNewLabel_1.setBounds(10, 0, 128, 61);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		panel.setBounds(0, 0, 466, 61);
		frame.getContentPane().add(panel);
		
	
		
		
	}
}
