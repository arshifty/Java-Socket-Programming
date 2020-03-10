package SocketProgramming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class udpClient_4 {

	public static void main(String[] args) throws Exception
	{
	    DatagramSocket ds = new DatagramSocket();

		while(true)
		{

			System.out.println("Send sms to server : ");

			Scanner input = new Scanner(System.in);
		     String ss=input.nextLine();
		     

			// TODO Auto-generated method stub
	     byte[]  b = String.valueOf(ss).getBytes();
	     InetAddress ia =InetAddress.getLocalHost();
	     int port = 2999;
	     DatagramPacket dp=new DatagramPacket(b , b.length , ia , port);
	     ds.send(dp);
	     
	     
	     byte[]  c = new byte[1024];
	     DatagramPacket dp1 = new DatagramPacket(c,c.length);
	     ds.receive(dp1);
	     String str = new String(dp1.getData(),0,dp1.getLength());
	     System.out.println(" ****Server   : " + str);

		}
     
     
     
	}

}
