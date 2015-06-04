package ChatRoom;


/**
* ChatRoom/ChaterPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从ChatRoom.idl
* 2015年6月3日 星期三 上午10时50分17秒 CST
*/

public abstract class ChaterPOA extends org.omg.PortableServer.Servant
 implements ChatRoom.ChaterOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_chaterName", new java.lang.Integer (0));
    _methods.put ("_set_chaterName", new java.lang.Integer (1));
    _methods.put ("strReceived", new java.lang.Integer (2));
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
       case 0:  // ChatRoom/Chater/_get_chaterName
       {
         String $result = null;
         $result = this.chaterName ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // ChatRoom/Chater/_set_chaterName
       {
         String newChaterName = in.read_string ();
         this.chaterName (newChaterName);
         out = $rh.createReply();
         break;
       }

       case 2:  // ChatRoom/Chater/strReceived
       {
         String str = in.read_string ();
         String name = in.read_string ();
         this.strReceived (str, name);
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
    "IDL:ChatRoom/Chater:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Chater _this() 
  {
    return ChaterHelper.narrow(
    super._this_object());
  }

  public Chater _this(org.omg.CORBA.ORB orb) 
  {
    return ChaterHelper.narrow(
    super._this_object(orb));
  }


} // class ChaterPOA
