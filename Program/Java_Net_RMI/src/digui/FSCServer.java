package digui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class FSCServer {
	public static void main(String[] args) {
		try {
			Function obj = new FunctionImpl("Functionsc");
			LocateRegistry.createRegistry(1099);
			Naming.rebind("functionsc", obj);
			System.out.println("functionsc bound in registry");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
