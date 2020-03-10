package MultiCast;
import java.net.*;

public class ChatServer {

public static void main(String args[]) throws Exception {

 MulticastSocket server = new MulticastSocket(8885);
 InetAddress group = InetAddress.getByName("224.2.2.5");
 //getByName - returns IP address of the given host
 server.joinGroup(group);

 boolean infinite = true;
 /* Server continually receives data and prints them */

 while(infinite) {

  byte buf[] = new byte[1024];
  DatagramPacket data = new DatagramPacket(buf, buf.length);
  server.receive(data);
  String msg = new String(data.getData()).trim();
  System.out.println(msg);
 }
 server.close();
 }
}