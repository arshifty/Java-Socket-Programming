package MultiCast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Sender1 {

	public static void main(String[] args) {
    
		try
		{
		InetAddress ia = InetAddress.getByName("225.4.5.6");
		MulticastSocket multicastsocket = new MulticastSocket();
		String msg = "hello from client";
		DatagramPacket packet = new DatagramPacket(msg.getBytes(),msg.length(),ia,3322);;
		
		multicastsocket.send(packet);
		multicastsocket.close();
		
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
