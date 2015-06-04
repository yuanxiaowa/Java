import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class UpperServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Context initialNamingContext = new InitialContext();
			Upper obj = new UpperImpls();
			initialNamingContext.rebind("iiop://10.0.0.112:900/UpperString", obj);
			System.out.println("Server ready....");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
