package UpperModule;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class UpperClientApplet {

	public static void main(String[] args) {

		String str;
		// ��ʼ��ORB�˿�
		String[] _args = { "-ORBInitialPort", "2500", "-ORBInitialHost", "10.0.0.112" };
		try {
			// ��ʼ��ORB����
			ORB orb = ORB.init(_args, null);
			// ʹ������������NamingContext��NameService������ORB�������ܳ�
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			// ʹ��NamingContextExt����NamingContext
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			String name = "Upper";
			Upper upper = UpperHelper.narrow(ncRef.resolve_str(name));
			System.out.println("Obtained a handle on server object: " + upper);
			System.out.println();
			str = upper.upperCase("abc");
			System.out.println(str);
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotProceed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
