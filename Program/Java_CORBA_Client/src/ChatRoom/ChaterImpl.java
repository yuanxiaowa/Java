package ChatRoom;

import org.omg.CORBA.ORB;

public class ChaterImpl extends ChaterPOA {
	
	private String name;
	private String othername;
	private String whattosay;
	private Room room = null;
	private boolean received = false;
	private boolean shown = true;
	private ORB orb;
	
	public void setORB(ORB orb_val) {
		this.orb = orb_val;
	}
	
	public ChaterImpl(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public String chaterName() {
		return this.name;
	}

	@Override
	public void chaterName(String name) {
		this.name = name;
	}

	@Override
	public synchronized void strReceived(String str, String name) {
		// TODO Auto-generated method stub
		while (this.Received()) {
		}
		this.othername = name;
		this.whattosay = str;
		this.Received(true);
	}
	
	public void Received(boolean b) {
		// TODO Auto-generated method stub
		this.received = b;
	}

	public String strReceived() {
		return this.whattosay;
	}
	
	public String otherName() {
		return this.othername;
	}


	public boolean Received() {
		// TODO Auto-generated method stub
		return this.received;
	}

}
