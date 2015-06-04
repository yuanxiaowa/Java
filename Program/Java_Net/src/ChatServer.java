import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

	public static void main(String[] args) {
		ServerSocket socket = null;
		 Vector<ServerThread> m_threads = new Vector<ServerThread>();
		System.out.println("listen ...");
		try {
			socket = new ServerSocket(8000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int nid = 0;
		try {
			while (true) {
				Socket s = socket.accept();
				System.out.println("accepted");
				ServerThread st = new ServerThread(s, m_threads);
				st.setID(nid++);
				m_threads.addElement(st);
				new Thread(st).start();
				for (int i = 0; i < m_threads.size(); i++) {
					ServerThread st1 = m_threads.elementAt(i);
					st1.write("<#>welcome " + st.getID() + " to enter chatroom.");
				}
				System.out.println("Listen again.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
