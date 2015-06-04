package UpperModule;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class UpperServer {
	public static void main(String[] args) {
		try {
			String[] _args = { "-ORBInitialPort", "2500" };
			// ��ʼ��ORB����
			ORB orb = ORB.init(_args, null);
			// �����ӿ�ʵ����UpperImpl���󣬲���ORB����
			UpperImpl upperImpl = new UpperImpl();
			// ȡ��RootPOA���ã�������POAManager
			POA rootpoa = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			// ȡ�ö����Ǹ�����
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(upperImpl);
			Upper href = UpperHelper.narrow(ref);
			// ȡ�����������ĵĸ�
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			// Use NamingContextExt which is part of the Interoperable
			// Naming Service(INS) specification
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			// �󶨶�������
			String name = "Upper";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, href);
			System.out.println("UpperServer ready ...");
			// �ȴ��ͻ��˵���
			orb.run();
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AdapterInactive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotProceed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
