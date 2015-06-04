import java.rmi.RemoteException;

import javax.rmi.PortableRemoteObject;


public class UpperImpls extends PortableRemoteObject implements Upper {

	protected UpperImpls() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String upperCase(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}
}
