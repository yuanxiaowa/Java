import java.io.*;
import java.net.Socket;
import java.util.Vector;


public class ServerThread implements Runnable {

	Vector<ServerThread> m_threads;
	Socket m_socket = null;
	BufferedReader br = null;
	PrintWriter bw = null;
	int m_nid;
	
	public ServerThread(Socket s, Vector<ServerThread> m_threads) {
		m_socket = s;
		this.m_threads = m_threads;
		try {
			br = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
			bw = new PrintWriter(m_socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("thread is running");
		try {
			while (true) {
				String s = br.readLine();
				if (null == s) {
					break;
				}
				if (s.trim().equals("leave")) {
					for (int i = 0; i < m_threads.size(); i++) {
						ServerThread st = m_threads.elementAt(i);
						st.write("*** " + getID() + "leave... ***");
					}
				} else {
					for (int i = 0; i < m_threads.size(); i++) {
						ServerThread st = m_threads.elementAt(i);
						st.write("<" + getID() + ">" + s);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		m_threads.removeElement(this);
		try {
			br.close();
			bw.close();
			m_socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setID(int i) {
		m_nid = i;
	}

	public void write(String msg) {
		synchronized (bw) {
			bw.println(msg);
			bw.flush();
		}
	}

	public int getID() {
		return m_nid;
	}

}
