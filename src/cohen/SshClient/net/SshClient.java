package cohen.SshClient.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SshClient {
	
	public static void main(String args[]) {
		
		try {

			Socket socket = new Socket("google.com", 80);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			out.print("GET / HTTP/1.0\n\n");

			out.flush();
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}
			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
