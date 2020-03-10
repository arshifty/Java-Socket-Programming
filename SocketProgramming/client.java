package SocketProgramming;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

	public static void main(String[] args) {
		try 
		{	
			/*
			System.out.println("Client Connected");

			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = dis.readUTF();
			System.out.println("Client : " + str);
			
			*/
			Socket s = new Socket("localhost",3000);
			
			DataInputStream dInput = new DataInputStream(s.getInputStream());
			DataOutputStream dOutput = new DataOutputStream(s.getOutputStream());

			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String messageInput="";
			String messageOutput="";
			
			while(!messageInput.equals("end"))
			{
				messageOutput = br.readLine();
				dOutput.writeUTF(messageOutput);
				
				messageInput  =  dInput.readUTF();
				System.out.println("  server   : " +messageInput);  ///printing server message
				
				
				
				dOutput.flush();
				
			}

			
		
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
