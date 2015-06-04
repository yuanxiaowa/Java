package digui;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LookServer extends Remote {
	int lookandfunc(String s, int x) throws RemoteException;
}
