package BroadCast;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class Client_1 {


	private JFrame frame;
	 static JTextArea ta1, ta2;

	    static Socket s1;
	    static DataInputStream dinput1;
	    static DataOutputStream doutput1;
	
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
		
		
		try
		{
			s1 = new Socket("localhost",1971);
			
			dinput1 = new DataInputStream(s1.getInputStream());
			doutput1 = new DataOutputStream(s1.getOutputStream());
			
			String msg1 = "";
			while(!msg1.equals("bye"))
			{
				msg1 = dinput1.readUTF();
				ta1.setText(ta1.getText()+"\n****Server   :\t"+msg1);
			}
			
			
		}
		
		catch(Exception ex)
		{
			
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
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblNewLabel.setBounds(89, 11, 227, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 434, 46);
		frame.getContentPane().add(panel);
		
	    ta1 = new JTextArea();
	    ta1.setEditable(false);
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
				String	messageOutput ="";
				messageOutput= ta2.getText().trim();
				ta1.setText(ta1.getText()+"\nClient 1     :\t"+messageOutput);
				doutput1.writeUTF(messageOutput);
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
