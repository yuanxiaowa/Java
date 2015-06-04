package digui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FunctionImpl extends UnicastRemoteObject implements Function {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3094824966694348059L;
	private String name;
	
	protected FunctionImpl(String s) throws RemoteException {
		super();
		name = s;
	}

	@Override
	public int func(int x) throws RemoteException {
		LookServer obj = null;
		if (x == 1) {
			return 1;
		}
		try {
			obj = (LookServer) Naming.lookup("//10.0.0.99:1099/lxb");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		System.out.println("This calls x is: " + x);
		return x * obj.lookandfunc("//10.0.0.112:1099/functionsc", x - 1);
	}

}
