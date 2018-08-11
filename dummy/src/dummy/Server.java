package dummy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	void doGet() {
		ServerSocket socket = null;
		try {
			while(true) {
			socket = new ServerSocket(9001);
			Socket accept = socket.accept();
			java.io.InputStream inputStream = accept.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			byte[] ary = new byte[1024];
			bis.read(ary);
			String clientMsg = new String(ary);
			StartApp obj = new StartApp("clientMsg");
			obj.start();
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
