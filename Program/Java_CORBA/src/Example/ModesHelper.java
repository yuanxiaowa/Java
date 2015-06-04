package Example;


/**
* Example/ModesHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Example.idl
* 2015年6月2日 星期二 下午02时23分19秒 CST
*/

abstract public class ModesHelper
{
  private static String  _id = "IDL:Example/Modes:1.0";

  public static void insert (org.omg.CORBA.Any a, Example.Modes that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Example.Modes extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Example.ModesHelper.id (), "Modes");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Example.Modes read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ModesStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Example.Modes value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Example.Modes narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Example.Modes)
      return (Example.Modes)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Example._ModesStub stub = new Example._ModesStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Example.Modes unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Example.Modes)
      return (Example.Modes)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Example._ModesStub stub = new Example._ModesStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
