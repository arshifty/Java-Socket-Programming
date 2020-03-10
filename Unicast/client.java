package Unicast;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ChattingApplication.Client_1;

public class client {

	 JFrame frame;
		private JTextField tf2;
		
		static JTextArea ta1;
	    static Socket s;
	    static DataInputStream dinput;
	    static DataOutputStream doutput;
	    private JLabel lblNewLabel_1;
	    private JPanel panel;
	     public  String str2;
		/**
		 * Launch the application.
		 */
		
		public static void main(String[] args) 
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						client window = new client();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			  
			     try
			     {
			    	s = new Socket("localhost", 2323);		    	
			    	dinput = new DataInputStream(s.getInputStream());
			    	doutput = new DataOutputStream(s.getOutputStream());	
			    	String messageInput="";
			    	while(!messageInput.equals("bye"))
			    	{		    				    		
			    		messageInput = dinput.readUTF();
			    		ta1.setText(ta1.getText().trim()+"\n****   :\t"+ messageInput);
			    		
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
		public client() {
		
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
		
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(204, 204, 153));
			frame.setBounds(100, 100, 476, 350);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			
		
		    str2 = JOptionPane.showInputDialog("Enter Client name : ");

			JLabel lblNewLabel = new JLabel(str2);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(164, 11, 221, 33);
			frame.getContentPane().add(lblNewLabel);
			
			tf2 = new JTextField();
			tf2.setBounds(0, 259, 357, 41);
			frame.getContentPane().add(tf2);
			tf2.setColumns(10);
			
			JButton btn2 = new JButton("Send");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try
					{
					String	messageOutput ="";
					messageOutput= tf2.getText().trim();
					ta1.setText(ta1.getText()+"\n"+str2+"   :\t"+tf2.getText());
					doutput.writeUTF(messageOutput);
					tf2.setText("");
					
					}				
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			});
			btn2.setBounds(364, 259, 89, 41);
			frame.getContentPane().add(btn2);
			
		    ta1 = new JTextArea();
		    ta1.setLineWrap(true);
		    
			JScrollPane jsp = new JScrollPane(ta1);
			jsp.setBounds(0, 72, 460, 171);
			frame.getContentPane().add(jsp);
			
			ImageIcon i=new ImageIcon("G:\\1 project\\src\\ChattingApplication\\a.jpg");
			lblNewLabel_1 = new JLabel(i);
			lblNewLabel_1.setBounds(10, 0, 128, 65);
			frame.getContentPane().add(lblNewLabel_1);
			
			panel = new JPanel();
			panel.setBackground(new Color(102, 204, 204));
			panel.setBounds(0, 0, 460, 65);
			frame.getContentPane().add(panel);
		}
}
