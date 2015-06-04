import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Upper extends Remote {
	String upperCase(String s) throws RemoteException;
}
