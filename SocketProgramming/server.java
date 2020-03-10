package SocketProgramming;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) {
	     try {
			ServerSocket server = new ServerSocket(3000);			
			Socket s = server.accept();			
			/*
			
			System.out.println("server Connected");
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("This is server socket in server class");
			
			
			*/
			DataInputStream dInput = new DataInputStream(s.getInputStream());
			DataOutputStream dOutput = new DataOutputStream(s.getOutputStream());

			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String messageInput="";
			String messageOutput="";
			
			while(!messageInput.equals("end"))
			{
				messageInput  =  dInput.readUTF();
				System.out.println(messageInput);
				
				messageOutput = br.readLine();
				dOutput.writeUTF(" Printing Client mesage  : "+messageOutput);
				
				dOutput.flush();
				
			}
			
			s.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     

	}

}
