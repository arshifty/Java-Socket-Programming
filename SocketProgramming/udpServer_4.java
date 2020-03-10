package SocketProgramming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class udpServer_4 {

	public static void main(String[] args)throws Exception 
	{
		DatagramSocket ds = new DatagramSocket(2999);
		while(true)
		{
			
			
			byte[]  b =new byte[100];		
			DatagramPacket dp = new DatagramPacket(b,b.length);
			ds.receive(dp);
		    String msg = new String(dp.getData() , 0 , dp.getLength()); 
			System.out.println(" ****Client   : " + msg);
			
			System.out.println("Send sms to client : ");

			Scanner input = new Scanner(System.in);
		    String ss=input.nextLine();
		
			byte[]  c=String.valueOf(ss).getBytes();
			InetAddress ia1 = InetAddress.getLocalHost();
			DatagramPacket dp1 = new DatagramPacket(c , c.length, ia1 , dp.getPort());
			ds.send(dp1);
		}
		
		
		/*
		     DatagramSocket ds1 = new DatagramSocket();
		     byte[]  c = "i am Musfiq from server".getBytes();
		     InetAddress iaa =InetAddress.getLocalHost();
		     int port = 2990;
		     DatagramPacket dp1=new DatagramPacket(c , c.length , iaa , port);
		     ds1.send(dp1);
	*/
	}

}
