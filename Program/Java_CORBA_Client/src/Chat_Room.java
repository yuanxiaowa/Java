import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ChatRoom.ChaterHolder;
import ChatRoom.ChaterImpl;
import ChatRoom.Room;


public class Chat_Room extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2725505080699147987L;
	private Room roomImpl = null;
	private ChaterImpl chaterImpl = null;
	private ChaterHolder chl = null;
	private JTextArea ChatArea;
	private JTextField ChatField;
	
	public ChaterHolder chk() {
		return this.chl;
	}
	
//	构造ChaterImpl对象，它为聊天服务器调用客户远程方法服务
	public ChaterImpl chaterImpl() {
		return this.chaterImpl;
	}
	
	public Room roomImpl() {
		return this.roomImpl;
	}
	
	public Chat_Room(Room roomImpl, ChaterImpl chaterImpl, ChaterHolder chl) {
		// TODO Auto-generated constructor stub
		this.roomImpl = roomImpl;
		this.chaterImpl = chaterImpl;
		this.chl = chl;
		setTitle("Chat Room - " + chaterImpl.chaterName());
		setSize(640, 480);
		Container contentPane = getContentPane();
		ChatArea = new JTextArea();
		ChatArea.setEditable(false);
		ChatArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(ChatArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		ChatField = new JTextField();
		ChatField.addActionListener(this);
		contentPane.add(ChatField, BorderLayout.SOUTH);
		TextAreaController tac = new TextAreaController();
		
		ChatRoomWindowAdapter adapter = new ChatRoomWindowAdapter();
		this.addWindowListener(adapter);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		tac.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if (source == ChatField) {
			this.roomImpl().StrReceived(this.chaterImpl().chaterName(), ChatField.getText());
			ChatField.setText("");
			ChatField.requestFocus();
		}
	}
	
	private class TextAreaController extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					while (!chaterImpl().Received()) {
						this.yield();
					}
					ChatArea.append("[" + chaterImpl().otherName() + "]");
					ChatArea.append(chaterImpl.strReceived() + "\n");
					chaterImpl().Received(false);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
	class ChatRoomWindowAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			roomImpl.unregister(chl);
			System.exit(0);
		}
	}

}
