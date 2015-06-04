package ChatRoom;

import org.omg.CORBA.ORB;

import ChatRoom.RoomPackage.invalid_name;
import ChatRoom.RoomPackage.room_is_full;

public class RoomImpl extends RoomPOA {
//	最多客户数16
	public static final int NUMCHATER = 16;
//	客户数
	private int numChater = 0;
//	客户数据结构
	private Chater chat_client[] = new Chater[NUMCHATER];
	private ORB orb;
	private static RoomImpl theRoom = null;
	private String name;
	private String whattosay;
	
	public RoomImpl() {
		for (int i = 0; i < NUMCHATER; i++) {
			chat_client[i] = null;
		}
	}
	
//	建立服务对象
	private static RoomImpl instance() {
		if (theRoom == null) {
			theRoom = new RoomImpl();
		}
		return theRoom;
	}
	
	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

	@Override
	public void register(ChaterHolder aChater) throws room_is_full,
			invalid_name {
		boolean valid_name = true;
		for (int i = 0; i < NUMCHATER; i++) {
			if ((chat_client[i] != null) && (chat_client[i].chaterName().equals(aChater.value.chaterName()))) {
				valid_name = false;
				break;
			}
		}
		
		if (valid_name) {
			if (numChater < NUMCHATER) {
				if (numChater == 0) {
					chat_client[numChater++] = aChater.value;
//					chat_client[0].chaterName(aChater.value.chaterName());
					this.chat_index(0).strReceived("Welcome to the chat room. You are the first one.", "SYSTEM");
				} else {
					for (int i = 0; i < NUMCHATER; i++) {
						if (this.chat_index(i) != null) {
							this.chat_index(i).strReceived(aChater.value.chaterName() + " enter chat room.", "SYSTEM");
						}
					}
					for (int i = 0; i < NUMCHATER; i++) {
						if (chat_client[i] == null) {
							chat_client[i] = aChater.value;
//							chat_client[i].chaterName(aChater.value.chaterName());
							this.chat_index(i).strReceived("Welcome to the chat room. You are the No." + (++numChater) + ".", "SYSTEM");
							break;
						}
					}
				}
			} else {
				room_is_full rfEx = new room_is_full("Sorry. There already are " + NUMCHATER + " (MAX) chater.");
				throw rfEx;
			}
		} else {
			invalid_name inEx = new invalid_name("Sorry. The name " + aChater.value.chaterName() + " has been registered. \n please try another one.");
			throw inEx;
		}
	}

	private Chater chat_index(int i) {
		return chat_client[i];
	}

	@Override
	public synchronized void unregister(ChaterHolder aChater) {
		for (int i = 0; i < NUMCHATER; i++) {
			if ((chat_client[i] != null) && (chat_client[i].chaterName().equals(aChater.value.chaterName()))) {
				chat_client[i] = null;
				if ((--numChater) == 0) {
//					shutdown();
				} else {
					for (int j = 0; j < NUMCHATER; j++) {
						if (this.chat_index(j) != null) {
							this.chat_index(j).strReceived(aChater.value.chaterName() + " leaves the room.", "SYSTEM");
						}
					}
				}
				break;
			}
		}
	}

	@Override
	public synchronized void StrReceived(String name, String sentence) {
		this.whattosay = sentence;
		this.name = name;
		for (int i = 0; i < NUMCHATER; i++) {
			if (this.chat_index(i) != null) {
				this.chat_index(i).strReceived(this.whattosay, this.name);
			}
		}
	}
	
	protected synchronized String chater_name() {
		return this.name;
	}
	
	protected synchronized String whattosay() {
		return this.whattosay;
	}

	@Override
	public void shutdown() {
		System.out.println("exiting........................");
		orb.shutdown(false);
		System.out.println("RoomServer Exiting");
	}

}
