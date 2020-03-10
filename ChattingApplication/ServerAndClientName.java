package ChattingApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerAndClientName {

	private JFrame frame;
	private JTextField tff1;
	private JTextField tff2;
    public String str1,str2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerAndClientName window = new ServerAndClientName();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerAndClientName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel ll1 = new JLabel("Enter Server name");
		ll1.setHorizontalAlignment(SwingConstants.CENTER);
		ll1.setBounds(26, 25, 126, 46);
		frame.getContentPane().add(ll1);
		
		JLabel ll2 = new JLabel("Enter Client name");
		ll2.setHorizontalAlignment(SwingConstants.CENTER);
		ll2.setBounds(33, 104, 119, 46);
		frame.getContentPane().add(ll2);
		
		tff1 = new JTextField();
		tff1.setBounds(162, 25, 179, 46);
		frame.getContentPane().add(tff1);
		tff1.setColumns(10);
		
		tff2 = new JTextField();
		tff2.setColumns(10);
		tff2.setBounds(162, 104, 179, 46);
		frame.getContentPane().add(tff2);
		
		JButton btnn = new JButton("Set");
		btnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				str1=tff1.getText();
				str2=tff2.getText();
				JOptionPane.showMessageDialog(null, "successfull");
				System.out.println(str1);
				System.out.println(str2);

			}
		});
		btnn.setBounds(187, 186, 126, 40);
		frame.getContentPane().add(btnn);
	}
}
