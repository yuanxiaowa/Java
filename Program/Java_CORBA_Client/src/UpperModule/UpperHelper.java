package UpperModule;


/**
* UpperModule/UpperHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从UpperModule.idl
* 2015年6月2日 星期二 下午03时59分39秒 CST
*/

abstract public class UpperHelper
{
  private static String  _id = "IDL:UpperModule/Upper:1.0";

  public static void insert (org.omg.CORBA.Any a, UpperModule.Upper that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static UpperModule.Upper extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (UpperModule.UpperHelper.id (), "Upper");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static UpperModule.Upper read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_UpperStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, UpperModule.Upper value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static UpperModule.Upper narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof UpperModule.Upper)
      return (UpperModule.Upper)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      UpperModule._UpperStub stub = new UpperModule._UpperStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static UpperModule.Upper unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof UpperModule.Upper)
      return (UpperModule.Upper)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      UpperModule._UpperStub stub = new UpperModule._UpperStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
