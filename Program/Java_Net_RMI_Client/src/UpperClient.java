import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class UpperClient {

	public static void main(String[] args) {
//		System.setSecurityManager(new RMISecurityManager());
		Upper obj = null;
		try {
			obj = (Upper) Naming.lookup("//10.0.0.112:1099/UpperString");
			String results = obj.upperCase("hello world");
			System.out.println("RMI Result: " + results);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

}