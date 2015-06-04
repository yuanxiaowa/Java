

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class UpperImpl extends UnicastRemoteObject implements Upper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpperImpl() throws RemoteException {
		super();
	}

	@Override
	public String upperCase(String s) throws RemoteException {
		return s.toUpperCase() + ";";
	}
	
	public static void main(String[] args) {
//		System.setSecurityManager(new RMISecurityManager());
		try {
			Upper upper = new UpperImpl();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("UpperString", upper);
			System.out.println("Service Start!");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
