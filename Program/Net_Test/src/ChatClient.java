import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedReader m_in;
	PrintWriter m_out;
	Socket m_socket;

	JTextArea ta;
	JTextField tf;
	JButton btn;

	public ChatClient() {
		setSize(500, 400);
		setTitle("聊天窗口");
		setResizable(false);

		setLayout(null);

		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		sp.setAutoscrolls(true);
		ta.setBounds(0, 10, this.getSize().width, 300);
		// ta.setEnabled(false);
		ta.setBackground(Color.WHITE);
		ta.setForeground(Color.RED);
		sp.setSize(this.getSize().width, 300);
		add(sp);

		tf = new JTextField();
		tf.setBounds(10, 330, 400, 30);
		add(tf);

		btn = new JButton("发送");
		btn.setBounds(420, 330, 60, 30);
		add(btn);
		btn.addActionListener(this);

		setLocationRelativeTo(null);
		setVisible(true);
		init();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	// 初始化
	private void init() {
		try {
			m_socket = new Socket("10.0.0.112", 8000);
			m_in = new BufferedReader(new InputStreamReader(
					m_socket.getInputStream()));
			m_out = new PrintWriter(m_socket.getOutputStream());
			new Thread(this).start();
			ta.append("已经进入聊天室！！！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatClient();
	}

	@Override
	public void run() {
		System.out.println("listen...");
		String s;
		while (true) {
			try {
				System.out.println("enter............");
				// 接收消息
				if ((s = m_in.readLine()) != null) {
					ta.append("\r\n" + s);
					ta.setCaretPosition(ta.getText().length());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	/**
	 * 发送消息
	 */
	public void actionPerformed(ActionEvent e) {
		m_out.println(tf.getText());
		m_out.flush();
		tf.setText("");
	}

}
