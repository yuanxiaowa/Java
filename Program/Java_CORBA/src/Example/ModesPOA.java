package Example;


/**
* Example/ModesPOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Example.idl
* 2015年6月2日 星期二 下午02时23分19秒 CST
*/

public abstract class ModesPOA extends org.omg.PortableServer.Servant
 implements Example.ModesOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("operation", new java.lang.Integer (0));
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
       case 0:  // Example/Modes/operation
       {
         int inArg = in.read_long ();
         org.omg.CORBA.IntHolder outArg = new org.omg.CORBA.IntHolder ();
         org.omg.CORBA.IntHolder inoutArg = new org.omg.CORBA.IntHolder ();
         inoutArg.value = in.read_long ();
         int $result = (int)0;
         $result = this.operation (inArg, outArg, inoutArg);
         out = $rh.createReply();
         out.write_long ($result);
         out.write_long (outArg.value);
         out.write_long (inoutArg.value);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Example/Modes:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Modes _this() 
  {
    return ModesHelper.narrow(
    super._this_object());
  }

  public Modes _this(org.omg.CORBA.ORB orb) 
  {
    return ModesHelper.narrow(
    super._this_object(orb));
  }


} // class ModesPOA
