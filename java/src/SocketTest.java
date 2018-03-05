import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SocketTest {

	public static void main(String[] args) throws IOException {
		String str = "<ticket pos=\"1\" fecha=\"20050929\" hora=\"104450\" ticket=\"1\" cajero=\"55\" idCliente=\"\" suc=\"236\" empleado=\"0\" vnp=\"0\" CantidadArticulos=\"1\" montototal=\"1000.00\"><plu codigo=\"8508124376\" estructura=\"111111111\" cantidad=\"1\" precio=\"1000\"></plu></ticket>";
		 InputStream is = null;
		    OutputStream os = null;
		    Socket s = null;
		    try {
		        s = new Socket("102.15.230.251", 4003);
		        os = s.getOutputStream();
		        os.write(str.getBytes());
		        os.flush();
		        is = s.getInputStream();
		        byte[] buffer = new byte[1024];
		        int read;
		        while((read = is.read(buffer)) != -1) {
		            String output = new String(buffer, 0, read);
		            System.out.print(output);
		            System.out.flush();
		        };
		        
//		       
		    } finally {
		        if (s != null) s.close();
		    }

	}

}
