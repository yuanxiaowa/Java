package ChatRoom;


/**
* ChatRoom/RoomPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午09时32分04秒 CST
*/

public abstract class RoomPOA extends org.omg.PortableServer.Servant
 implements ChatRoom.RoomOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("register", new java.lang.Integer (0));
    _methods.put ("unregister", new java.lang.Integer (1));
    _methods.put ("StrReceived", new java.lang.Integer (2));
    _methods.put ("shutdown", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // ChatRoom/Room/register
       {
         try {
           ChatRoom.ChaterHolder aChater = new ChatRoom.ChaterHolder ();
           aChater.value = ChatRoom.ChaterHelper.read (in);
           this.register (aChater);
           out = $rh.createReply();
           ChatRoom.ChaterHelper.write (out, aChater.value);
         } catch (ChatRoom.RoomPackage.room_is_full $ex) {
           out = $rh.createExceptionReply ();
           ChatRoom.RoomPackage.room_is_fullHelper.write (out, $ex);
         } catch (ChatRoom.RoomPackage.invalid_name $ex) {
           out = $rh.createExceptionReply ();
           ChatRoom.RoomPackage.invalid_nameHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // ChatRoom/Room/unregister
       {
         ChatRoom.ChaterHolder aChater = new ChatRoom.ChaterHolder ();
         aChater.value = ChatRoom.ChaterHelper.read (in);
         this.unregister (aChater);
         out = $rh.createReply();
         ChatRoom.ChaterHelper.write (out, aChater.value);
         break;
       }

       case 2:  // ChatRoom/Room/StrReceived
       {
         String name = in.read_string ();
         String sentence = in.read_string ();
         this.StrReceived (name, sentence);
         out = $rh.createReply();
         break;
       }

       case 3:  // ChatRoom/Room/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ChatRoom/Room:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Room _this() 
  {
    return RoomHelper.narrow(
    super._this_object());
  }

  public Room _this(org.omg.CORBA.ORB orb) 
  {
    return RoomHelper.narrow(
    super._this_object(orb));
  }


} // class RoomPOA
