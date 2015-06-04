package digui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class FSCClient {

	public static void main(String[] args) {
		Function obj = null;
		try {
			LookServer obj1 = new LookServerImpl("client");
			LocateRegistry.createRegistry(1099);
			Naming.rebind("lxb", obj1);
//			obj = (Function) Naming.lookup("//10.0.0.112:1099/functionsc");
			int results = obj1.lookandfunc("//10.0.0.112:1099/functionsc", 3);
			System.out.println("RMI Result: " + results);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
