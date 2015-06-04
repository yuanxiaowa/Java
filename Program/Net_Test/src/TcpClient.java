import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TcpClient {

	public static void main(String[] args) throws IOException {
		Socket socket = null;
		InputStream is = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		String strin = null;
		try {
			socket = new Socket("10.0.0.112", 8000);
			System.out.println("Connect to the Server...");
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			System.out.println("\nServer said: ");
			if ((strin = br.readLine()) != null) {
				System.out.println(strin);
			}
			System.out.println("please input:");
			
			byte[] bmsg = new byte[1024];
			Scanner sc = new Scanner(System.in);
			String msg = sc.next();
			while (!msg.equals("quit")) {
				pw.println(msg.trim());
				pw.flush();
				if ((strin = br.readLine()) != null) {
					System.out.println(strin);
					msg = sc.next();
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			socket.close();
			is.close();
			os.close();
		}
	}

}
