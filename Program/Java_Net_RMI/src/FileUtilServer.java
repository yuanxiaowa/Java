
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class FileUtilServer {

	public static void main(String[] args) {
		IFileUtil file;
		try {
			file = new FileUtilImpl();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("FileUtilServer", file);
			System.out.println("Ready...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
