package digui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LookServerImpl extends UnicastRemoteObject implements LookServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	protected LookServerImpl(String s) throws RemoteException {
		super();
		name = s;
	}

	@Override
	public int lookandfunc(String s, int x) throws RemoteException {
		Function obj = null;
		try {
			obj = (Function) Naming.lookup(s);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		System.out.println("This time calls x is: " + x);
		return obj.func(x);
	}

}
