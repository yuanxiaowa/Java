import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import ChatRoom.Chater;
import ChatRoom.ChaterHelper;
import ChatRoom.ChaterHolder;
import ChatRoom.ChaterImpl;
import ChatRoom.Room;
import ChatRoom.RoomHelper;


public class ChatClient {

	static Room roomImpl;
	static ChaterImpl chaterImpl;
	static ChaterHolder chl;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*if (args.length < 1) {
			System.out.println("Your name is missing.");
			System.exit(1);
		}*/
		String _name = args[0];
		try {
			java.util.Properties p = new java.util.Properties();  
			p.setProperty("com.sun.CORBA.codeset.charsets", "0x05010001, 0x00010109"); // UTF-8, UTF-16  
			p.setProperty("com.sun.CORBA.codeset.wcharsets", "0x00010109, 0x05010001"); // UTF-16, UTF-8 
			/*p.put("com.org.CORBA.ORBInitialHost", "10.0.0.112");
			p.put("com.org.CORBA.ORBInitialPort", 2500);*/
			String[] _args = {"-ORBInitialHost", "10.0.0.112", "-ORBInitialPort", "2500"};
			ORB orb = ORB.init(_args, p);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			chaterImpl = new ChaterImpl(_name);
			chaterImpl.setORB(orb);
			Chater href = ChaterHelper.narrow(rootpoa.servant_to_reference(chaterImpl));
			org.omg.CORBA.Object ref = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(ref);
			NameComponent[] path = ncRef.to_name(_name);
			ncRef.rebind(path, href);
			
			String servername = "ChatRoom";
			roomImpl = RoomHelper.narrow(ncRef.resolve_str(servername));
			chl = new ChaterHolder(href);
			try {
				roomImpl.register(chl);
			} catch(Exception e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
			
			new Chat_Room(roomImpl, chaterImpl, chl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
