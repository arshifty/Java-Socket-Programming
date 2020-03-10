package MultiCast;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiSender1 {

	private JFrame frame;
	static MulticastSocket multicastsocket;
    static InetAddress ia ;
    static JButton btn;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiSender1 window = new GuiSender1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		ia = InetAddress.getByName("225.4.5.6");
		 multicastsocket = new MulticastSocket();
		
	}

	/**
	 * Create the application.
	 */
	public GuiSender1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea ta1 = new JTextArea();
		ta1.setBounds(10, 11, 414, 177);
		frame.getContentPane().add(ta1);
		
		JTextArea ta2 = new JTextArea();
		ta2.setText("");
		ta2.setBounds(10, 199, 304, 51);
		frame.getContentPane().add(ta2);
		
		btn = new JButton("New button");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				
				String msg =ta2.getText();
				ta1.setText("Server is sending message : "+msg);
				DatagramPacket packet = new DatagramPacket(msg.getBytes(),msg.length(),ia,3322);;
				
				multicastsocket.send(packet);
				///multicastsocket.close();
				
				
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btn.setBounds(335, 199, 89, 51);
		frame.getContentPane().add(btn);
	}
}
