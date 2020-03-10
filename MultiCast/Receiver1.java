package MultiCast;

import java.net.InetAddress;
import java.io.IOException;
import java.net.*;

public class Receiver1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress ia = InetAddress.getByName("225.4.5.6");
		MulticastSocket multicastsocket = new MulticastSocket(3322);
		
		multicastsocket.joinGroup(ia);
		
		byte[]  b = new byte[1024];
		
		DatagramPacket packet = new DatagramPacket(b,b.length);
		
		multicastsocket.receive(packet);
	     String str = new String(packet.getData(),0,packet.getLength());
		System.out.println(str);
		multicastsocket.close();

	}

}
