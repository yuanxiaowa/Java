package digui;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Function extends Remote {
	int func(int x) throws RemoteException;
}
