package MultiCast;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GuiReceiver1 {

	private JFrame frmReceiver;
    static JTextArea ta1;
    static MulticastSocket multicastsocket;
    static InetAddress ia ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiReceiver1 window = new GuiReceiver1();
					window.frmReceiver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	try
	{
		InetAddress ia = InetAddress.getByName("225.4.5.6");
		MulticastSocket multicastsocket = new MulticastSocket(3322);
		
		multicastsocket.joinGroup(ia);
		
		byte[]  b = new byte[1024];
		
		DatagramPacket packet = new DatagramPacket(b,b.length);
		
		multicastsocket.receive(packet);
	     String str = new String(packet.getData(),0,packet.getLength());
		ta1.setText(str);
	     System.out.println(str);
	     str="";
	     
	     
	}
	catch(Exception ec)
	{
		ec.printStackTrace();
	}
	///	multicastsocket.close();
	}

	/**
	 * Create the application.
	 */
	public GuiReceiver1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReceiver = new JFrame();
		frmReceiver.setTitle("Receiver 1");
		frmReceiver.setBounds(100, 100, 450, 300);
		frmReceiver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReceiver.getContentPane().setLayout(null);
		
	     ta1 = new JTextArea();
		ta1.setBounds(10, 11, 414, 226);
		frmReceiver.getContentPane().add(ta1);
	}
}
