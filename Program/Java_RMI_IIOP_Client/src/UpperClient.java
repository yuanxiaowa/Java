import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class UpperClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Context initialContext = new InitialContext();
			Upper upper = (Upper) initialContext.lookup("iiop://10.0.0.112:900/UpperString");
			System.out.println(upper.upperCase("hello"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
