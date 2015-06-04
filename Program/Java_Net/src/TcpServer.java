import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws IOException {
		ServerSocket srv;
		Socket socket = null;
		InputStream is = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			srv = new ServerSocket(8000);
			socket = srv.accept();
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			os = socket.getOutputStream();
			pw = new PrintWriter(os);

			InetAddress clientIP = socket.getInetAddress();
			System.out.println("Client's IP address: " + clientIP);
			int port = socket.getPort();
			System.out.println("Client's port: " + port);
			pw.println("Welcome!...");
			pw.flush();
			String str;
			while (!(str = br.readLine()).equals("quit")) {
				System.out.println("Client said: " + str);
				pw.println("---");
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			is.close();
			os.close();
			socket.close();
		}
	}
}
