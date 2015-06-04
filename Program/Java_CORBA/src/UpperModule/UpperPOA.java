package UpperModule;


/**
* UpperModule/UpperPOA.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��UpperModule.idl
* 2015��5��29�� ������ ����05ʱ05��57�� CST
*/

public abstract class UpperPOA extends org.omg.PortableServer.Servant
 implements UpperModule.UpperOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("upperCase", new java.lang.Integer (0));
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
       case 0:  // UpperModule/Upper/upperCase
       {
         String str = in.read_string ();
         String $result = null;
         $result = this.upperCase (str);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:UpperModule/Upper:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Upper _this() 
  {
    return UpperHelper.narrow(
    super._this_object());
  }

  public Upper _this(org.omg.CORBA.ORB orb) 
  {
    return UpperHelper.narrow(
    super._this_object(orb));
  }


} // class UpperPOA
